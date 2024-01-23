package com.ecommerce.mb.commons.exceptions;

public class InsufficientPermissionsException extends Exception {

  private static final long serialVersionUID = 1L;

public InsufficientPermissionsException(String message) {
    super(message);
  }
}
