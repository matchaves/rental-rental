package com.dvdrental.rental.dto;


import lombok.Data;


@Data
public class RentalDto {


    private Long inventory_id;
    private Long customer_id;
    private Long staff_id;
    private Long film_id;

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long setStaff_id() {
        return staff_id;
    }

    public void gesttaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    public Long setFilm_id() {
        return film_id;
    }

    public void getFilm_id(Long film_id) {
        this.film_id = film_id;
    }
}
