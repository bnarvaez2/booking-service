package com.bideafactory.bookingservices.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountRequest {
    private String userId;
    private String houseId;
    private String discountCode;

    public DiscountRequest(String userId, String houseId, String discountCode){
        this.userId = userId;
        this.houseId = houseId;
        this.discountCode = discountCode;
    }
}
