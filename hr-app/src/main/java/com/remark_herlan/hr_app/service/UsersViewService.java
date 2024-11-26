package com.remark_herlan.hr_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.UsersViewDao;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.UsersView;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@Service
public class UsersViewService {

	@Autowired
	UsersViewDao dao;

	public ResponseInfo<List<UsersView>> getAllInfos() {
		ResponseInfo<List<UsersView>> responseInfo = new ResponseInfo<>();

		try {
			List<UsersView> response = dao.findAll();

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

	public ResponseInfo<Optional<UsersView>> getInfo(Long id) {
		ResponseInfo<Optional<UsersView>> responseInfo = new ResponseInfo<>();

		try {
			Optional<UsersView> response = dao.findById(id);

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

	public ResponseInfo<Optional<UsersView>> getInfoByUsername(String username) {
		ResponseInfo<Optional<UsersView>> responseInfo = new ResponseInfo<>();

		try {
			Optional<UsersView> response = dao.findByUsername(username);

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

}
