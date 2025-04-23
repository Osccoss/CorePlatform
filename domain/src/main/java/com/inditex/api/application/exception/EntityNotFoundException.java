package com.inditex.api.application.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityNotFoundException extends RuntimeException {
    
  public EntityNotFoundException(final String detail) {
    super(detail);
  }
}
