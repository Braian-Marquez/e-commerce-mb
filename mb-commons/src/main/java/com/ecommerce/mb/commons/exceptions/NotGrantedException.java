package com.ecommerce.mb.commons.exceptions;

public class NotGrantedException extends RuntimeException{

    private static final long serialVersionUID = 1L;

	public NotGrantedException(String message) {
        super(message);
    }
}
