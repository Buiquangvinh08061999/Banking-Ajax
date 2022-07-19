package com.codegym.controller;


import com.codegym.model.Customer;
import com.codegym.model.Deposit;
import com.codegym.model.Withdraw;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.deposit.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DepositService depositService;

    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/list");


        return modelAndView;
    }

//
//    @GetMapping("/create")
//    public ModelAndView showCreatePage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/customer/create");
//
//        modelAndView.addObject("customer", new Customer());
//
//        return modelAndView;
//    }
//
//
//    @PostMapping("/create")
//    public ModelAndView doCreate(@ModelAttribute Customer customer) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/customer/create");
//
//        try {
//            customer.setBalance(BigDecimal.ZERO);
//            customerService.save(customer);
//
//            modelAndView.addObject("success", "Them moi thanh cong");
//        } catch (Exception e) {
//            e.printStackTrace();
//            modelAndView.addObject("error", "That bai them moi");
//        }
//
//        modelAndView.addObject("customer", new Customer());
//
//        return modelAndView;
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditPage(@PathVariable Long id) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/customer/update");
//
//        Optional<Customer> customer = customerService.findById(id);
//
//        if(customer.isPresent()){
//            modelAndView.addObject("customer", customer);
//        }else {
//            modelAndView.addObject("customer", new Customer());
//        }
//
//        return modelAndView;
//    }
//
//    @PostMapping("/edit/{id}")
//    public ModelAndView doUpdate(@PathVariable Long id, @ModelAttribute Customer customer) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/customer/update");
//
//        try {
//            customer.setId(id);
//            customerService.save(customer);
//
//            modelAndView.addObject("customer", customer);
//            modelAndView.addObject("success", "Cap nhat thanh cong");
//        } catch (Exception e) {
//            e.printStackTrace();
//            modelAndView.addObject("error", "Cap nhat that bai");
//            modelAndView.addObject("customer", new Customer());
//        }
//
//        return modelAndView;
//    }
//
//    @GetMapping("/deposit/{id}")
//    public ModelAndView showDepositPage(@PathVariable Long id) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/customer/deposit");
//
//        Optional<Customer> customer = customerService.findById(id);
//
//        if(customer.isPresent()){
//            modelAndView.addObject("customer", customer);
//        }else {
//            modelAndView.addObject("customer", new Customer());
//        }
//
//        modelAndView.addObject("deposit" ,new Deposit());
//
//        return modelAndView;
//    }
//
//    @PostMapping("/deposit/{id}")
//    public ModelAndView doDeposit(@PathVariable Long id,@ModelAttribute Customer customer, @ModelAttribute Deposit deposit) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/customer/deposit");
//
//        Optional<Customer> optionalCustomer = customerService.findById(id);
//
//
//        if (optionalCustomer.isPresent()) {
//            try {
//                customerService.deposit(optionalCustomer.get(), deposit);
//
//                modelAndView.addObject("customer", optionalCustomer.get());
//                modelAndView.addObject("success", "Nap tien thanh cong");
//            } catch (Exception e) {
//                e.printStackTrace();
//                modelAndView.addObject("error", "Nap tien that bai");
//                modelAndView.addObject("customer", new Customer());
//            }
//        }
//        else {
//            modelAndView.addObject("error", "Khong tim thay nay Id");
//            modelAndView.addObject("customer", new Customer());
//        }
//
//        modelAndView.addObject("deposit", new Deposit());
//
//        return modelAndView;
//    }
//
//    @GetMapping("/withdraw/{id}")
//    public ModelAndView showWithdrawPage(@PathVariable Long id) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/customer/withdraw");
//
//        Optional<Customer> customer = customerService.findById(id);
//
//        if(customer.isPresent()){
//            modelAndView.addObject("customer", customer);
//        }else {
//            modelAndView.addObject("customer", new Customer());
//        }
//
//        modelAndView.addObject("withdraw" ,new Withdraw());
//
//        return modelAndView;
//    }
//
//    @PostMapping("/withdraw/{id}")
//    public ModelAndView doWithdraw(@PathVariable Long id, @ModelAttribute Customer customer, @ModelAttribute Withdraw withdraw) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/customer/withdraw");
//
//        Optional<Customer> optionalCustomer = customerService.findById(id);
//
//        if(withdraw.getTransactionAmount().compareTo(customer.getBalance())<= 0){
//            if (optionalCustomer.isPresent()) {
//
//                    customerService.withdraw(optionalCustomer.get(), withdraw);
//
//                    modelAndView.addObject("customer", optionalCustomer.get());
//                    modelAndView.addObject("success", "Rut tien thanh cong");
//            }
//        }else {
//                modelAndView.addObject("error", "So tien qua trong tai khoan");
//        }
//
//
//        modelAndView.addObject("withdraw" ,new Withdraw());
//
//
//
//        return modelAndView;
//    }


}
