package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.model.Deposit;
import com.codegym.model.Withdraw;
import com.codegym.service.IGeneralService;

public interface CustomerService extends IGeneralService<Customer> {


    Boolean existsByEmail(String email);

    void deposit(Customer customer, Deposit deposit);

    void withdraw(Customer customer, Withdraw withdraw);
}
