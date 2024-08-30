package de.ait.shop42.exception;

public class CustomerNotFound extends RuntimeException {
   public CustomerNotFound(String message) {
       super(message);
   }
}
