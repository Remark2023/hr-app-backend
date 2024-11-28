package com.remark_herlan.hr_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.UsersView;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@Repository
public interface UsersViewDao extends JpaRepository<UsersView, Long> {

	UsersView findByUsername(String username);

	@Query(value = "SELECT fn_new_seq_id(:primaryKey, :tableName)", nativeQuery = true)
	Long getNewSequenceId(@Param("primaryKey") String primaryKey, @Param("tableName") String tableName);

}
