package com.dvdrental.rental.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PaymentDto {

    private Long payment;
    private Long customer;
    private Long staff;
    private Long rental;
    private Long amount;




}
