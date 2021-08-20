package com.spring_rest_LevelUno.tienda.exceptions;

public class ResourceNotFound extends RuntimeException {

   public ResourceNotFound(String message) {
      super(message);
   }
}
