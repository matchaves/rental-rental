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

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.rental (rental_date, inventory_id, customer_id, staff_id, last_update, status) VALUES (now(), ?1, ?2, ?3, now(), 'processando')", nativeQuery = true)
    void setRentalPre(Long inventory_id, Long customer_id, Long staff_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE rental SET status = 'aprovado' WHERE inventory_id = ?1 AND status = 'processando'", nativeQuery = true)
    void setRentalSucces(Long inventory_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE rental SET return_date = now() WHERE inventory_id = ?1 AND status = 'aprovado' and return_date is null and customer_id = ?2 ", nativeQuery = true)
    void setRentalReturn(Long inventory_id, Long customer_id);


}