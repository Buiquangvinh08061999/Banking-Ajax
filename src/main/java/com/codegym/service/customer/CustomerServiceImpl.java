package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.model.Deposit;
import com.codegym.model.LocationRegion;
import com.codegym.model.Withdraw;
import com.codegym.repository.CustomerRepository;
import com.codegym.repository.DepositRepository;
import com.codegym.repository.LocationRegionRepository;
import com.codegym.repository.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private WithdrawRepository withdrawRepository;

    @Autowired
    private LocationRegionRepository locationRegionRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public Customer save(Customer customer) {
        LocationRegion locationRegion = locationRegionRepository.save(customer.getLocationRegion());
        customer.setLocationRegion(locationRegion);
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void deposit(Customer customer, Deposit deposit) {
        customerRepository.incrementBalance(customer.getId(), deposit.getTransactionAmount());
        depositRepository.save(deposit);
    }

    @Override
    public void withdraw(Customer customer, Withdraw withdraw) {
        customerRepository.withdrawBalance(customer.getId(), withdraw.getTransactionAmount());

        withdrawRepository.save(withdraw);


    }
}
