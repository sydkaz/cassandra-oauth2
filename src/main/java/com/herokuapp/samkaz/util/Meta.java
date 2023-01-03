package com.herokuapp.samkaz.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/*
Created by Syed Kazmi(Sam Kazmi) on 3/1/23
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meta {
	private int status;
	private String message;


	public Meta(HttpStatus httpStatus) {
		this.status = httpStatus.value();
		this.message = httpStatus.getReasonPhrase();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
