package com.codegym.model.dto;

import com.codegym.model.Customer;
import com.codegym.model.Deposit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Accessors(chain = true)/*Retunrn lại chính nó, hàm void k cần trả về*/

public class DepositDTO {

    private String id;
    private String transactionAmount;

    private String customerId;


    public Deposit toDeposit(Customer customer) {
        return new Deposit()
                .setId(Long.parseLong(id))
                .setTransactionAmount(new BigDecimal(Long.parseLong(transactionAmount)))
                .setCustomer(customer);
    }
}
