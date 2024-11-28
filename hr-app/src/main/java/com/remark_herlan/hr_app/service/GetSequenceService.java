package com.remark_herlan.hr_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.UsersViewDao;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.ResponseInfo;

/**
 * author: Naimul Hassan
 * 
 * date: 11/28/2024
 */

@Service
public class GetSequenceService {

	@Autowired
	private UsersViewDao dao;

	public ResponseInfo<Long> generateNewSequenceId(String primaryKey, String tableName)
			throws InternalServerException, DataNotFoundException {
		ResponseInfo<Long> responseInfo = new ResponseInfo<>();

		try {
			Long response = dao.getNewSequenceId(primaryKey, tableName);

			if (response == -1) {
				throw new DataNotFoundException("No data found!");
			}

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (DataNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
//		return dao.getNewSequenceId(primaryKey, tableName);
	}

}
