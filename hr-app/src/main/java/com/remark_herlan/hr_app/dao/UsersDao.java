package com.remark_herlan.hr_app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.Users;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {

	Optional<Users> findByUsername(String username);

}
