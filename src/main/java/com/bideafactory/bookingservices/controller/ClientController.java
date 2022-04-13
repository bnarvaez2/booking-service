package com.bideafactory.bookingservices.controller;

import javax.servlet.http.HttpServletRequest;

import com.bideafactory.bookingservices.config.exception.ConflictException;
import com.bideafactory.bookingservices.entity.Client;
import com.bideafactory.bookingservices.model.request.DiscountRequest;
import com.bideafactory.bookingservices.model.response.DiscountResponse;
import com.bideafactory.bookingservices.model.response.OkResponse;
import com.bideafactory.bookingservices.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("bideafactory/")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "book", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postMethodName(@RequestBody Client cRequest, HttpServletRequest request) {

        cRequest.validateUserProperties();
        if (cRequest.getDiscountCode() == null || cRequest.getDiscountCode().isEmpty()) {
        } else {
            DiscountRequest discountRequest = new DiscountRequest(cRequest.getId(),
                    Long.toString(cRequest.getHouseId()), cRequest.getDiscountCode());

            DiscountResponse discountResponse = clientService.newDiscount(discountRequest);
            if (!discountResponse.isStatus()) {
                throw new ConflictException("Invalid discount");
            }
            log.info("Discount response", discountResponse);

        }
        clientService.createUser(cRequest);
        return ResponseEntity.ok(new OkResponse("Book Accepted"));
    }

}
