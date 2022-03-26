/**
 * Author       : Ramesh Gouru 
 * Created date : 26/3/2022
 * Description  : its for OrderNotFound
 */
package com.hcl.hackaton.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
