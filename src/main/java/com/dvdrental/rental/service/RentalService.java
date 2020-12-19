package com.dvdrental.rental.service;



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

    public List<Rental> getFilms() {
        List<Rental> list = rentalRepository.findAll();//.stream().map(FilmDto::create).collect(Collectors.toList());
        return list;
    }

    public Optional<Rental> getFilmbyId(Long id) {
        Optional<Rental> film = rentalRepository.findById(id);
        return film;
    }

    public void setRentalPre(Long inventory_id, Long customer_id, Long staff_id) {
        rentalRepository.setRentalPre(inventory_id, customer_id, staff_id);//.stream().map(FilmDto::create).collect(Collectors.toList());

    }

    public void setRentalSucces(Long inventory_id) {
        rentalRepository.setRentalSucces(inventory_id);//.stream().map(FilmDto::create).collect(Collectors.toList());
    }

    public void setRentalReturn(Long inventory_id, Long customer) {
        rentalRepository.setRentalReturn(inventory_id, customer);//.stream().map(FilmDto::create).collect(Collectors.toList());
    }
}
