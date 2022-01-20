package com.dvdrental.rental.controller;


import com.dvdrental.rental.dto.RentalDto;
import com.dvdrental.rental.model.Film;
import com.dvdrental.rental.model.Rental;
import com.dvdrental.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    private Rental rental;

    @PostMapping("/rentalpre")
    public void setRentalPre(@RequestBody RentalDto rental)  {
        rentalService.setRentalPre(rental);
        /*return  film.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(film);*/
    }

    @PatchMapping("/rentalstatus")
    public void setRentalSucces(@RequestParam String status,
                                @RequestParam Long rental_id) {
        Rental rental = new Rental(222L);
        System.out.println(status);
        System.out.print(rental_id);
        rentalService.setRentalSucces(rental_id, status);
        /*return  film.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(film);*/
    }

    @PatchMapping("/rentalreturn")
    public void setRentalReturn(@RequestParam Long rental_id) {
        rentalService.setRentalReturn(rental_id);
        /*return  film.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(film);*/
    }

}
