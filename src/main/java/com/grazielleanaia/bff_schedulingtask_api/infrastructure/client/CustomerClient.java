package com.grazielleanaia.bff_schedulingtask_api.infrastructure.client;


import com.grazielleanaia.bff_schedulingtask_api.business.dto.CustomerDTO;
import com.grazielleanaia.bff_schedulingtask_api.business.dto.PhoneDTO;
import com.grazielleanaia.bff_schedulingtask_api.business.dto.ResidenceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "customer", url = "${customer.url}")

public interface CustomerClient {

    @GetMapping("/customer")
    CustomerDTO findCustomerByEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token);

    @PostMapping
    CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO);

    @PostMapping("/login")
    public String login(@RequestBody CustomerDTO customerDTO);


    @GetMapping("/all")
    List<CustomerDTO> findAllCustomer(@RequestHeader("Authorization") String token);

    @DeleteMapping("/{email}")
    void deleteCustomer(@PathVariable String email,
                        @RequestHeader("Authorization") String token);

    @PutMapping
    CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO,
                               @RequestHeader("Authorization") String token);

    @PutMapping("/residence")
    ResidenceDTO updateResidence(@RequestBody ResidenceDTO residenceDTO,
                                 @RequestParam("id") Long id,
                                 @RequestHeader("Authorization") String token);

    @PutMapping("/phone")
    PhoneDTO updatePhone(@RequestBody PhoneDTO phoneDTO,
                         @RequestParam("id") Long id,
                         @RequestHeader("Authorization") String token);

    @PostMapping("/residence")
    ResidenceDTO addResidence(@RequestBody ResidenceDTO residenceDTO,
                              @RequestHeader("Authorization") String token);

    @PostMapping("/phone")
    PhoneDTO addPhone(@RequestBody PhoneDTO phoneDTO,
                      @RequestHeader("Authorization") String token);


}
