package com.remark_herlan.hr_app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.remark_herlan.hr_app.model.SampleCrud;


/**
 * author: Naimul Hassan
 * 
 * date: 11/28/2024
 */
/**
 * this is the dao for sample_crud table this is an interface that inherit
 * JpaRepository<dto, data type of primary key> is responsible to create
 * connection with db automatic this interface will act like template for all
 * APIs
 */

@Repository
public interface SampleCrudDao extends JpaRepository<SampleCrud, Integer> {

	List<SampleCrud> findByName(String name);
	List<SampleCrud> findByDescription(String description);

	@Modifying
	@Query("update SampleCrud sc set sc.name = ?1, sc.description = ?2, sc.creationDate = ?3 where sc.id = ?4")
	void updateInfoById(String name, String description, Date creationDate, Integer id);

}
