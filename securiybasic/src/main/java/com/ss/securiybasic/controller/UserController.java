package com.ss.securiybasic.controller;

import com.ss.securiybasic.model.Customer;
import com.ss.securiybasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer newCustomer = null;
        ResponseEntity response = null;

        try {
            String hashPassword = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPassword);
            newCustomer = customerRepository.save(customer);
            if(newCustomer.getId() > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("User Registered Successfully");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + e.getMessage());
        }

        return response;
    }
}
