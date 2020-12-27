package com.dvdrental.rental.controller;


import com.dvdrental.rental.model.Film;
import com.dvdrental.rental.model.Rental;
import com.dvdrental.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    private Rental rental;

    @GetMapping("/rentalpre/{inventory}/{customer}/{staff}/{film}")
    public void setRentalPre(@PathVariable("inventory") Long inventory,
                                           @PathVariable("customer") Long customer,
                                           @PathVariable("staff") Long staff,
                                           @PathVariable("film") Long film) {
        rentalService.setRentalPre(inventory, customer, staff, film);
        /*return  film.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(film);*/
    }

    @GetMapping("/rentalsucces/{inventory}")
    public void setRentalSucces(@PathVariable("inventory") Long inventory) {
        Rental rental = new Rental(222L);
        System.out.print(rental);
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
