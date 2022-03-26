/**
 * Author       : Ramesh Gouru 
 * Created date : 26/3/2022
 * Description  : create the ErrorResponse message
 */
package com.hcl.hackaton.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class ErrorResponse {
    public ErrorResponse(String message, List<String> details, Date timestamp) {
        super();
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    private String message;
    private List<String> details;
    private Date timestamp;
}