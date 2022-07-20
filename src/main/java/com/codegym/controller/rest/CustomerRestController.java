package com.codegym.controller.rest;


import com.codegym.exception.EmailExistsException;
import com.codegym.exception.ResourceNotFoundException;
import com.codegym.model.Customer;
import com.codegym.model.Deposit;
import com.codegym.model.dto.CustomerDTO;
import com.codegym.model.dto.DepositDTO;
import com.codegym.model.dto.LocationRegionDTO;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;



@RestController
@RequestMapping("/api/customers")

public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {

        Optional<Customer> customerOptional = customerService.findById(id);

        if (!customerOptional.isPresent()) {
            throw new ResourceNotFoundException("ID không tồn tại");
        }

        return new ResponseEntity<>(customerOptional.get().toCustomerDTO(),   HttpStatus.OK);

    }


    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@RequestBody CustomerDTO customerDTO) {

        /*Mỗi lần thêm mới ta sét tất cả giá trị lại về 0*/
        customerDTO.setId(0L);
        customerDTO.setBalance(new BigDecimal(0L));
        customerDTO.getLocationRegion().setId(0L);

        Boolean exisEmail = customerService.existsByEmail(customerDTO.getEmail());

        if (exisEmail) {
            throw new EmailExistsException("Email đã tồn tại");
        }

        /*Trả về kiểu dữ liệu CustomerDTO để bảo mật, chỉ hiện thị thông tin của DTO, dấu thông tất cả thông tin Customer*/
        Customer newCustomer = customerService.save(customerDTO.toCustomer());

        return new ResponseEntity<>(newCustomer.toCustomerDTO(),  HttpStatus.CREATED);

    }

    @PostMapping("/deposit")
    public ResponseEntity<?> doDeposit(@RequestBody DepositDTO depositDTO){

        Optional<Customer> customerOptional = customerService.findById(Long.parseLong(depositDTO.getCustomerId()));

        if (!customerOptional.isPresent()){
            throw new EmailExistsException("Id không tồn tại");
        }

        Customer customer = customerOptional.get();

        Deposit deposit = depositDTO.toDeposit(customer);

        customerService.deposit(customer, deposit);

        return new ResponseEntity<>("Deposit sucsess",  HttpStatus.CREATED);

    }









}













