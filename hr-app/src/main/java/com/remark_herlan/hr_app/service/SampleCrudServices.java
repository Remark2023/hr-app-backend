package com.remark_herlan.hr_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.remark_herlan.hr_app.dao.SampleCrudDao;
import com.remark_herlan.hr_app.model.ResponseInfo;
import com.remark_herlan.hr_app.model.SampleCrud;


/**
 * author: Naimul Hassan
 * date: 11/26/2024
 */
/**
 * this is the service class for the API to perform crud operation for
 * sample_crud table all the data processing according to request will be
 * performed in this class is responsible for return response this service class
 * will act like template for all APIs
 */

@Service
public class SampleCrudServices {

	@Autowired
	SampleCrudDao sampleCrudDao;

	public ResponseInfo<List<SampleCrud>> getAllInfos() {
		ResponseInfo<List<SampleCrud>> responseInfo = new ResponseInfo<>();

		try {
			List<SampleCrud> response = sampleCrudDao.findAll();

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

	public ResponseInfo<Optional<SampleCrud>> getInfo(Integer id) {
		ResponseInfo<Optional<SampleCrud>> responseInfo = new ResponseInfo<>();

		try {
			Optional<SampleCrud> response = sampleCrudDao.findById(id);

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

	public ResponseInfo<List<SampleCrud>> getInfoByName(String name) {
		ResponseInfo<List<SampleCrud>> responseInfo = new ResponseInfo<>();

		try {
			List<SampleCrud> response = sampleCrudDao.findByName(name);

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

	public ResponseInfo<List<SampleCrud>> getInfoByDescription(String description) {
		ResponseInfo<List<SampleCrud>> responseInfo = new ResponseInfo<>();

		try {
			List<SampleCrud> response = sampleCrudDao.findByDescription(description);

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

	public ResponseInfo<String> saveInfo(SampleCrud sampleCrud) {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			sampleCrudDao.save(sampleCrud);

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
			sampleCrudDao.deleteById(id);

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
			sampleCrudDao.deleteAll();

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

	/**
	 * using @Transactional annotation Spring will automatically start and manage a
	 * transaction for the duration of the method execution. This will resolve the
	 * TransactionRequiredException when executing modifying queries.
	 */
	@Transactional
	public ResponseInfo<String> updateInfo(SampleCrud sampleCrud) {
		ResponseInfo<String> responseInfo = new ResponseInfo<>();

		try {
			sampleCrudDao.updateInfoById(sampleCrud.getName(), sampleCrud.getDescription(),
					sampleCrud.getCreationDate(), sampleCrud.getId());

			responseInfo.setStatusCode(HttpStatus.OK.value());
			responseInfo.setMessage("Successfully updated");
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
