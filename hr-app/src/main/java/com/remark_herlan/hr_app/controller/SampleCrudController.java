package com.remark_herlan.hr_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.SampleCrud;
import com.remark_herlan.hr_app.service.SampleCrudServices;

/**
 * author: Naimul Hassan
 * date: 11/26/2024
 */
/**
 * this is the entry point for the API to perform crud operation for sample_crud
 * table this controller will act like template for all APIs
 */

@RestController
@RequestMapping("sampleCrud")
public class SampleCrudController {

	@Autowired
	SampleCrudServices sampleCrudServices;

	@GetMapping("all")
	public ResponseInfo<List<SampleCrud>> getAllMethod() {
		return sampleCrudServices.getAllInfos();
	}

	@GetMapping("/{id}")
	public ResponseInfo<Optional<SampleCrud>> getMethod(@PathVariable Integer id) {
		return sampleCrudServices.getInfo(id);
	}

	@GetMapping("/byName/{name}")
	public ResponseInfo<List<SampleCrud>> getByNameMethod(@PathVariable String name) {
		return sampleCrudServices.getInfoByName(name);
	}

	@GetMapping("/byDescription/{description}")
	public ResponseInfo<List<SampleCrud>> getByDescriptionMethod(@PathVariable String description) {
		return sampleCrudServices.getInfoByDescription(description);
	}

	@PostMapping("add")
	public ResponseInfo<String> postMethod(@RequestBody SampleCrud sampleCrud) {
		return sampleCrudServices.saveInfo(sampleCrud);
	}

	@DeleteMapping("delete/{id}")
	public ResponseInfo<String> deleteMethod(@PathVariable Integer id) {
		return sampleCrudServices.deleteInfo(id);
	}

	@DeleteMapping("delete/all")
	public ResponseInfo<String> deleteAllMethod() {
		return sampleCrudServices.deleteAllInfos();
	}

	@PutMapping("update")
	public ResponseInfo<String> updateMethod(@RequestBody SampleCrud sampleCrud) {
		return sampleCrudServices.updateInfo(sampleCrud);
	}

}
