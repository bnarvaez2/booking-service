package com.bideafactory.bookingservices.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OkResponse {
    
    private int statusCode;
    private String message;

    public OkResponse(String message){
        this.statusCode = 200;
        this.message = message;
    }
}
