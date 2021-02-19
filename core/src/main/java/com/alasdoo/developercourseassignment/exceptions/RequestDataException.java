package com.alasdoo.developercourseassignment.exceptions;

/**
 * It models the exception created because the data passed within the request is
 * incorrect.
 *
 */
public class RequestDataException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1089168873062622440L;

	/**
	 * Creates a new exception.
	 * 
	 * @param message - a message describing the exception.
	 */
	public RequestDataException(String message) {
		super(message);
	}
}
