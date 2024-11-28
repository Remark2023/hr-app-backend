package com.remark_herlan.hr_app.secutiry.auth.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.remark_herlan.hr_app.dao.UsersViewDao;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtTokenUtil jwtTokenUtil;

	@Autowired
	UsersViewDao dao;

	public JwtAuthenticationFilter(@Lazy JwtTokenUtil jwtTokenUtil) {
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = getTokenFromRequest(request);
		if (token != null && jwtTokenUtil.validateToken(token)) {
			String username = jwtTokenUtil.extractUsername(token);
			request.setAttribute("username", username);

			String userRole = dao.findByUsername(username).getUserRole();
			request.setAttribute("role", userRole);

			SecurityContextHolder.getContext().setAuthentication(jwtTokenUtil.getAuthentication(token));
		}

		filterChain.doFilter(request, response);
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}
}
