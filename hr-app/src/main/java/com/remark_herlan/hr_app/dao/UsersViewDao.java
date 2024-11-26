package com.remark_herlan.hr_app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.UsersView;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@Repository
public interface UsersViewDao extends JpaRepository<UsersView, Long> {

	Optional<UsersView> findByUsername(String username);

}
