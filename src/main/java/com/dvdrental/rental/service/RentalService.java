package com.dvdrental.rental.service;



import com.dvdrental.rental.client.FilmClient;
import com.dvdrental.rental.client.PaymentClient;
import com.dvdrental.rental.dto.RentalDto;
import com.dvdrental.rental.model.Rental;
import com.dvdrental.rental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private PaymentClient paymentClient;

    @Autowired
    private FilmClient filmClient;

    public List<Rental> getFilms() {
        List<Rental> list = rentalRepository.findAll();//.stream().map(FilmDto::create).collect(Collectors.toList());
        return list;
    }

    public Optional<Rental> getFilmbyId(Long id) {
        Optional<Rental> film = rentalRepository.findById(id);
        return film;
    }

    public void setRentalPre(RentalDto rental) {
        Integer rental_id = rentalRepository.setRentalPre(rental.getInventory_id(), rental.getCustomer_id(), rental.getStaff_id()); //inventory_id, customer_id, staff_id//.stream().map(FilmDto::create).collect(Collectors.toList());
        //System.out.print(rental_id);
        //Object film = filmClient.filmCost(film_id);
        //System.out.print(film);
        //paymentClient.payment(rental_id.longValue());
        //paymentClient.payment(rental_id::longValue);
    }

    public void setRentalSucces(Long inventory_id, String status) {
        rentalRepository.setRentalSucces(inventory_id, status);//.stream().map(FilmDto::create).collect(Collectors.toList());
    }

    public void setRentalReturn(Long rental_id) {
        rentalRepository.setRentalReturn(rental_id);//.stream().map(FilmDto::create).collect(Collectors.toList());
    }
}
