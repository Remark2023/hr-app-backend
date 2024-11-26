package com.remark_herlan.hr_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.RolesDao;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.Roles;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@Service
public class RolesService {

	@Autowired
	RolesDao dao;

	public ResponseInfo<List<Roles>> getAllInfos() {
		ResponseInfo<List<Roles>> responseInfo = new ResponseInfo<>();

		try {
			List<Roles> response = dao.findAll();

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(new ArrayList<>());

		return null;
	}

	public ResponseInfo<Optional<Roles>> getInfo(Integer id) {
		ResponseInfo<Optional<Roles>> responseInfo = new ResponseInfo<>();

		try {
			Optional<Roles> response = dao.findById(id);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(Optional.empty());

		return null;
	}

	public ResponseInfo<String> saveInfo(Roles Roles) {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			dao.save(Roles);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}

	public ResponseInfo<String> deleteInfo(Integer id) {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			dao.deleteById(id);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully deleted id: " + id);
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}

	public ResponseInfo<String> deleteAllInfos() {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			dao.deleteAll();

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully truncated");
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseInfo.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseInfo.setMessage("BAD REQUEST");
		responseInfo.setData(HttpStatus.BAD_REQUEST.name());

		return null;
	}

}
