package com.dvdrental.rental.controller;


import com.dvdrental.rental.model.Rental;
import com.dvdrental.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/rentalpre/{inventory}/{customer}/{staff}")
    public void setRentalPre(@PathVariable("inventory") Long inventory,
                                  @PathVariable("customer") Long customer,
                                  @PathVariable("staff") Long staff) {
        rentalService.setRentalPre(inventory, customer, staff);
        /*return  film.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(film);*/
    }

    @GetMapping("/rentalsucces/{inventory}")
    public void setRentalSucces(@PathVariable("inventory") Long inventory) {
        rentalService.setRentalSucces(inventory);
        /*return  film.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(film);*/
    }

    @GetMapping("/rentalreturn/{inventory}/{customer}")
    public void setRentalReturn(@PathVariable("inventory") Long inventory,
                                @PathVariable("customer") Long customer) {
        rentalService.setRentalReturn(inventory, customer);
        /*return  film.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(film);*/
    }

}
