package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Boolean existsByEmail(String email);


    @Modifying
    @Query("UPDATE Customer AS c SET c.balance = c.balance + :transactionAmount WHERE c.id = :id")

    void incrementBalance(@Param("id") Long id, @Param("transactionAmount") BigDecimal transactionAmount);


    @Modifying
    @Query("UPDATE Customer AS c SET c.balance = c.balance - :transactionAmount WHERE c.id = :id")

    void withdrawBalance(@Param("id") Long id, @Param("transactionAmount") BigDecimal transactionAmount);
}
