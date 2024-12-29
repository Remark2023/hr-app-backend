package utils;

import java.util.List;

import com.remark_herlan.hr_app.model.Roles;

/**
 * author: Naimul Hassan
 * 
 * date: 12/29/2024
 */

public class CheckAuthorization {

	public static Boolean checkHrAuth(List<Roles> roles) {
		boolean isHR = roles != null && roles.stream().anyMatch(role -> "HR".equals(role.getTitle()));

		return isHR;
	}

}
