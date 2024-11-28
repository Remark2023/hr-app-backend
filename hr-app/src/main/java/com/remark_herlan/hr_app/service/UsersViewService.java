package com.remark_herlan.hr_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.UsersViewDao;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
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

	public ResponseInfo<List<UsersView>> getAllInfos() throws InternalServerException, DataNotFoundException {
		ResponseInfo<List<UsersView>> responseInfo = new ResponseInfo<>();

		try {
			List<UsersView> response = dao.findAll();

			if (response.isEmpty()) {
				throw new DataNotFoundException("No data found!");
			}

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (DataNotFoundException e) {
			// Explicitly handle known exception
			throw e; // Re-throw to let a higher-level handler manage it
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public ResponseInfo<Optional<UsersView>> getInfo(Long id) throws DataNotFoundException, InternalServerException {
		ResponseInfo<Optional<UsersView>> responseInfo = new ResponseInfo<>();

		try {
			Optional<UsersView> response = dao.findById(id);

			if (response.isEmpty()) {
				throw new DataNotFoundException("No data found!");
			}

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (DataNotFoundException e) {
			// Explicitly handle known exception
			throw e; // Re-throw to let a higher-level handler manage it
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public ResponseInfo<UsersView> getInfoByUsername(String username)
			throws InternalServerException, DataNotFoundException {
		ResponseInfo<UsersView> responseInfo = new ResponseInfo<>();

		try {
			UsersView response = dao.findByUsername(username);

			if (response == null) {
				throw new DataNotFoundException("No data found!");
			}

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (DataNotFoundException e) {
			// Explicitly handle known exception
			throw e; // Re-throw to let a higher-level handler manage it
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

}
