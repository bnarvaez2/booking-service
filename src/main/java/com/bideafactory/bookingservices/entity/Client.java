package com.bideafactory.bookingservices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bideafactory.bookingservices.config.exception.BadRequestException;

import lombok.Data;

@Entity
@Data
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int IdUser;

    @Column(name = "user_code", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phonenumber", nullable = false)
    private String phoneNumber;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "house_id", nullable = false)
    private long houseId;

    @Column(name = "discount_code", nullable = true)
    private String discountCode;

    public void validateUserProperties() {

        if (this.id == null) {
            throw new NullPointerException("Required property 'ID'");
        }
        if (this.id.isEmpty()) {
            throw new BadRequestException("Required property 'ID'");
        }
        if (this.name == null) {
            throw new NullPointerException("Required property 'name'");
        }
        if (this.name.isEmpty()){
            throw new BadRequestException("Required property 'name'");
        }
        if (this.lastname == null) {
            throw new NullPointerException("Required property 'lastname'");
        }
        if (this.lastname.isEmpty()) {
            throw new BadRequestException("Required property 'lastname'");
        }
        if (this.age == 0) {
            throw new BadRequestException("Required property 'age'");
        } else {
            if (this.age <= 0) {
                throw new BadRequestException("User age cannot be less than or equal to zero");
            }
        }
        if (this.phoneNumber == null) {
            throw new NullPointerException("Required property 'phoneNumber'");
        }
        if (this.phoneNumber.isEmpty()) {
            throw new BadRequestException("Required property 'phoneNumber'");
        }
        if (this.startDate == null) {
            throw new NullPointerException("Required property 'startDate'");
        }
        if (this.startDate.toString().isEmpty()) {
            throw new BadRequestException("Required property 'startDate'");
        }
        if (this.startDate == null) {
            throw new NullPointerException("Required property 'endDate'");
        }
        if (this.endDate.toString().isEmpty()) {
            throw new BadRequestException("Required property 'endDate'");
        }
        if (this.houseId == 0) {
            throw new BadRequestException("Required property 'houseId'");
        } else {
            if (this.houseId < 0) {
                throw new BadRequestException("House ID cannot be less than or equal to zero");
            }
        }
    }
}
