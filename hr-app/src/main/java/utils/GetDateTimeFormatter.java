package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * author: Naimul Hassan
 * 
 * date: 12/04/2024
 */

@Component
public class GetDateTimeFormatter {

	@Bean
	public LocalDateTime getFormatter(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime formattedDate = LocalDateTime.parse(date, formatter);

		return formattedDate;
	}

}
