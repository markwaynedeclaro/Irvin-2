package org.irvin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserGroupNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5063509332802725526L;

	public UserGroupNotFoundException(String exception)
	{
		super(exception);
	}
}
