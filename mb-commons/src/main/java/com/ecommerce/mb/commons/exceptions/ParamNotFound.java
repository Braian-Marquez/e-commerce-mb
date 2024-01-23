package com.ecommerce.mb.commons.exceptions;

public class ParamNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public ParamNotFound(String error){
        super(error);
    }
}
