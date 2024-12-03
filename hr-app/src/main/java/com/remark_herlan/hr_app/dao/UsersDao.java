package com.remark_herlan.hr_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.Users;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {

	Users findByUsername(String username);

	@Query(value = "SELECT fn_new_seq_id(:primaryKey, :tableName)", nativeQuery = true)
	Long getNewSequenceId(@Param("primaryKey") String primaryKey, @Param("tableName") String tableName);

}
