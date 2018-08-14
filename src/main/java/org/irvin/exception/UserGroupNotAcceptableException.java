package org.irvin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UserGroupNotAcceptableException extends RuntimeException {

	private static final long serialVersionUID = -6972943305791713470L;

	public UserGroupNotAcceptableException(String exception)
	{
		super(exception);
	}	
}
