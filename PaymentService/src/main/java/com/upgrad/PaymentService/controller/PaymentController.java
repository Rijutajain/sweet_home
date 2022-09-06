package com.upgrad.PaymentService.controller;

import com.upgrad.PaymentService.dto.PaymentDTO;
import com.upgrad.PaymentService.entity.TransactionDetailsEntity;
import com.upgrad.PaymentService.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Autowired
    ModelMapper modelMapper;
    //This post mapping api endpoint is designed to save a paymentDTO in
    // paymentService Database and provide a response entity containing
    // transactionId
    @PostMapping(value = "/transaction",  consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBooking(@RequestBody PaymentDTO paymentDTO){
        TransactionDetailsEntity newTransaction=modelMapper.map(paymentDTO,
                TransactionDetailsEntity.class);
        TransactionDetailsEntity savedTransaction=
                paymentService.acceptTransactionDetails(newTransaction);
        PaymentDTO savedTransactionDTO=modelMapper.map(savedTransaction,
                PaymentDTO.class);
        return new ResponseEntity(savedTransactionDTO.getTransactionId(), HttpStatus.CREATED);
    }
    //This get api endpoint is designed to get a paymentDTO based on
    // transactionId
    @GetMapping(value="transaction/{transactionId}")
    public ResponseEntity getTransactionDetailsBasedOnId(@PathVariable(
            "transactionId") int transactionId){
        TransactionDetailsEntity responseTransaction=
                paymentService.getTransactionDetails(transactionId);
        PaymentDTO fetchedTransaction = modelMapper.map(responseTransaction,
                PaymentDTO.class);
        return new ResponseEntity(fetchedTransaction,HttpStatus.OK);
    }
}
