package com.grazielleanaia.bff_schedulingtask_api.controller;


import com.grazielleanaia.bff_schedulingtask_api.business.CustomerService;
import com.grazielleanaia.bff_schedulingtask_api.business.dto.CustomerDTO;
import com.grazielleanaia.bff_schedulingtask_api.business.dto.PhoneDTO;
import com.grazielleanaia.bff_schedulingtask_api.business.dto.ResidenceDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Tag(name = "Customer", description = "Customer Registration")

public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    @Operation(summary = "Save customer", description = "create a new customer")
    @ApiResponse(responseCode = "200", description = "Customer successfully saved")
    @ApiResponse(responseCode = "409", description = "Customer already registered")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @PostMapping("/login")
    @Operation(summary = "Login customer", description = "Customer logged in")
    @ApiResponse(responseCode = "200", description = "Customer successfully logged in")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    @ApiResponse(responseCode = "500", description = "Server error")
    public String login(@RequestBody CustomerDTO customerDTO) {
        return customerService.login(customerDTO);
    }

    @GetMapping
    @Operation(summary = "Find customer by email", description = "Find customer by email")
    @ApiResponse(responseCode = "200", description = "Customer successfully found")
    @ApiResponse(responseCode = "403", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    public ResponseEntity<CustomerDTO> findCustomerByEmail(@RequestParam("email") String email,
                                                           @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(customerService.getCustomerByEmail(email, token));
    }

    @GetMapping("/all")
    @Operation(summary = "Find all customer", description = "Find all customer")
    @ApiResponse(responseCode = "200", description = "Customer successfully found")
    @ApiResponse(responseCode = "403", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    public List<CustomerDTO> findAllCustomer(@RequestHeader("Authorization") String token) {
        return customerService.getAllCustomers(token);
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Delete customer by email", description = "Delete customer by email")
    @ApiResponse(responseCode = "200", description = "Customer successfully deleted")
    @ApiResponse(responseCode = "403", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String email,
                                               @RequestHeader("Authorization") String token) {
        customerService.deleteCustomer(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Update customer data", description = "Update customer data")
    @ApiResponse(responseCode = "200", description = "Customer successfully updated")
    @ApiResponse(responseCode = "403", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO,
                                                      @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(customerService.updateCustomer(customerDTO, token));
    }

    @PutMapping("/residence")
    @Operation(summary = "Update customer address", description = "Update customer address")
    @ApiResponse(responseCode = "200", description = "Customer address successfully updated")
    @ApiResponse(responseCode = "403", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    public ResponseEntity<ResidenceDTO> updateResidence(@RequestBody ResidenceDTO residenceDTO,
                                                        @RequestParam("id") Long id,
                                                        @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(customerService.updateResidence(residenceDTO, id, token));
    }

    @PutMapping("/phone")
    @Operation(summary = "Update customer phone", description = "Update customer phone")
    @ApiResponse(responseCode = "200", description = "Customer phone successfully updated")
    @ApiResponse(responseCode = "403", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    public ResponseEntity<PhoneDTO> updatePhone(@RequestBody PhoneDTO phoneDTO,
                                                @RequestParam("id") Long id,
                                                @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(customerService.updatePhone(phoneDTO, id, token));
    }

    @PostMapping("/residence")
    @Operation(summary = "Add other customer address", description = "Add other customer address")
    @ApiResponse(responseCode = "200", description = "Customer address successfully added")
    @ApiResponse(responseCode = "403", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    public ResponseEntity<ResidenceDTO> addResidence(@RequestBody ResidenceDTO residenceDTO,
                                                     @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(customerService.addResidence(residenceDTO, token));
    }

    @PostMapping("/phone")
    @Operation(summary = "Add other customer phone", description = "Add other customer phone")
    @ApiResponse(responseCode = "200", description = "Customer phone successfully added")
    @ApiResponse(responseCode = "403", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Server error")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    public ResponseEntity<PhoneDTO> addPhone(@RequestBody PhoneDTO phoneDTO,
                                             @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(customerService.addPhone(phoneDTO, token));
    }


}
