package com.remark_herlan.hr_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.Users;

import jakarta.transaction.Transactional;
import java.util.List;


/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@Repository
public interface UsersDao extends JpaRepository<Users, Long> {

	Users findByUsername(String username);
	List<Users> findByStatus(String status);

	@Query(value = "SELECT fn_new_seq_id(:primaryKey, :tableName)", nativeQuery = true)
	Long getNewSequenceId(@Param("primaryKey") String primaryKey, @Param("tableName") String tableName);
	
	@Query("SELECT u FROM Users u JOIN u.roles r WHERE r.title = :roleTitle")
    List<Users> findByRoleTitle(@Param("roleTitle") String roleTitle);
	
	@Modifying
	@Transactional
	@Query("UPDATE Users user SET user.status = :status WHERE user.id = :id")
	int updateStatusById(@Param("status") String status, @Param("id") Long id);

}
