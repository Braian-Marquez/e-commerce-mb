package com.ecommerce.mb.commons.exceptions;

public class UserAlreadyExistException extends RuntimeException {

  private static final long serialVersionUID = 1L;

public UserAlreadyExistException(String s) {
    super(s);
  }

}
