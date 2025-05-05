package com.grazielleanaia.bff_schedulingtask_api.business;

import com.grazielleanaia.bff_schedulingtask_api.business.dto.CustomerDTO;
import com.grazielleanaia.bff_schedulingtask_api.business.dto.PhoneDTO;
import com.grazielleanaia.bff_schedulingtask_api.business.dto.ResidenceDTO;
import com.grazielleanaia.bff_schedulingtask_api.infrastructure.client.CustomerClient;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerService {
    private final CustomerClient customerClient;


    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return customerClient.createCustomer(customerDTO);
    }

    public String login(CustomerDTO customerDTO) {
        return customerClient.login(customerDTO);
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerClient.findAllCustomer();

    }

    public CustomerDTO getCustomerByEmail(String email, String token) {
        return customerClient.findCustomerByEmail(email, token);
    }

    public void deleteCustomer(String email, String token) {
        customerClient.deleteCustomer(email, token);
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO, String token) {
        return customerClient.updateCustomer(customerDTO, token);
    }

    public ResidenceDTO updateResidence(ResidenceDTO residenceDTO, Long id, String token) {
        return customerClient.updateResidence(residenceDTO, id, token);
    }

    public PhoneDTO updatePhone(PhoneDTO phoneDTO, Long id, String token) {
        return customerClient.updatePhone(phoneDTO, id, token);
    }

    public ResidenceDTO addResidence(ResidenceDTO residenceDTO, String token) {
        return customerClient.addResidence(residenceDTO, token);
    }

    public PhoneDTO addPhone(PhoneDTO phoneDTO, String token) {
        return customerClient.addPhone(phoneDTO, token);
    }

}
