package com.dvdrental.rental.repository;



import com.dvdrental.rental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findAll();

    Optional<Rental> findById(Long id);


    @Query(value = "INSERT INTO public.rental (rental_date, inventory_id, customer_id, staff_id, last_update, status) VALUES (now(), ?1, ?2, ?3, now(), 'processando') returning rental_id", nativeQuery = true)
    Integer setRentalPre(Long inventory_id, Long customer_id, Long staff_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE rental SET status = ?2 WHERE rental_id = ?1 AND status = 'processando'", nativeQuery = true)
    void setRentalSucces(Long inventory_id, String status);

    @Modifying
    @Transactional
    @Query(value = "UPDATE rental SET return_date = now() WHERE rental_id = ?1 AND status = 'aprovado' and return_date is null", nativeQuery = true)
    void setRentalReturn(Long rental_id);


}