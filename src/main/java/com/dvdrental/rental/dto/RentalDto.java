package com.dvdrental.rental.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class RentalDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventory_id;
    private Long customer_id;
    private Long staff_id;
    private Long film_id;

    public Long getInventory_id() {
        return inventory_id;
    }

    public Long getCustomer_id() { return customer_id; }

    public Long getStaff_id() { return staff_id; }

    public Long getFilm_id() {
        return film_id;
    }

    //public void setInventory_id(Long inventory_id) {
    //    this.inventory_id = inventory_id;
    //}



    //public void setCustomer_id(Long customer_id) {
    //    this.customer_id = customer_id;
    //}



    //public void setStaff_id(Long staff_id) {
    //    this.staff_id = staff_id;
    //}



    //public void setFilm_id(Long film_id) {
    //    this.film_id = film_id;
    //}
}
