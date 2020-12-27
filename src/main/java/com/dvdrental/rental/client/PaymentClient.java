package com.dvdrental.rental.client;

import com.dvdrental.rental.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "payment", url = "localhost:8004", path = "/payment")
public interface PaymentClient {

    @PostMapping()
    PaymentDto payment (@RequestParam Long rental_id);


}
