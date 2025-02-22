package com.remark_herlan.hr_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.remark_herlan.hr_app.dao.UsersDao;
import com.remark_herlan.hr_app.exceptions.DataNotFoundException;
import com.remark_herlan.hr_app.exceptions.InternalServerException;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.Users;

/**
 * author: Naimul Hassan
 * 
 * date: 11/26/2024
 */

@Service
public class UsersService {

	@Autowired
	UsersDao dao;

	@Autowired
	GetSequenceService sequenceService;

	public ResponseInfo<List<Users>> getAllInfos() throws DataNotFoundException, InternalServerException {
		ResponseInfo<List<Users>> responseInfo = new ResponseInfo<>();

		try {
			List<Users> response = dao.findAll();

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

	public ResponseInfo<Optional<Users>> getInfo(Long id) throws DataNotFoundException, InternalServerException {
		ResponseInfo<Optional<Users>> responseInfo = new ResponseInfo<>();

		try {
			Optional<Users> response = dao.findById(id);

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

	public ResponseInfo<Users> getInfoByUsername(String username)
			throws DataNotFoundException, InternalServerException {
		ResponseInfo<Users> responseInfo = new ResponseInfo<>();

		try {
			Users response = dao.findByUsername(username);

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

	public ResponseInfo<List<Users>> getInfoByStatus(String status)
			throws DataNotFoundException, InternalServerException {
		ResponseInfo<List<Users>> responseInfo = new ResponseInfo<>();

		try {
			List<Users> response = dao.findByStatus(status);

			if (response.isEmpty()) {
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
	}

	public ResponseInfo<List<Users>> getInfoByRole(String role) throws DataNotFoundException, InternalServerException {
		ResponseInfo<List<Users>> responseInfo = new ResponseInfo<>();

		try {
			List<Users> response = dao.findByRoleTitle(role);

			if (response.isEmpty()) {
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
	}

	public ResponseInfo<List<String>> getRoles(List<String> userRoles)
			throws DataNotFoundException, InternalServerException {
		ResponseInfo<List<String>> responseInfo = new ResponseInfo<>();

		try {
			if (userRoles.isEmpty()) {
				throw new DataNotFoundException("No data found!");
			}

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully fetched!");
			responseInfo.setData(userRoles);

			return responseInfo;
		} catch (DataNotFoundException e) {
			// Explicitly handle known exception
			throw e; // Re-throw to let a higher-level handler manage it
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public ResponseInfo<Users> saveInfo(Users user) throws InternalServerException {
		ResponseInfo<Users> responseInfo = new ResponseInfo<>();

		try {
			if (user.getId() == null) {
				Long sequence = sequenceService.getSequenceId("id", "users");
				user.setId(sequence);
			}

			Users response = dao.save(user);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully added!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public ResponseInfo<Integer> updateSignupStatus(Users user) throws InternalServerException {
		ResponseInfo<Integer> responseInfo = new ResponseInfo<>();

		try {
			int response = dao.updateStatusById(user.getStatus(), user.getId());

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Status updated!");
			responseInfo.setData(response);

			return responseInfo;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public ResponseInfo<String> deleteInfo(Long id) throws InternalServerException {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			dao.deleteById(id);

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully deleted id: " + id);
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public ResponseInfo<String> deleteAllInfos() throws InternalServerException {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			dao.deleteAll();

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully truncated");
			responseInfo.setData(HttpStatus.OK.name());

			return responseInfo;
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

}
