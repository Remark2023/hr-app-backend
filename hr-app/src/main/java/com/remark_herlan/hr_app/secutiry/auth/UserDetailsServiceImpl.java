package com.remark_herlan.hr_app.secutiry.auth;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.UsersDao;
import com.remark_herlan.hr_app.model.Users;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersDao.findByUsername(username);
		if (user == null || !"APPROVED".equals(user.getStatus())) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

		// Map the user's roles into a list of SimpleGrantedAuthority
		List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getTitle())).collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);
	}

}
