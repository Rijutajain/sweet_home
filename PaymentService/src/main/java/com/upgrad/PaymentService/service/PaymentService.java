package com.upgrad.PaymentService.service;

import com.upgrad.PaymentService.entity.TransactionDetailsEntity;

public interface PaymentService {
    public TransactionDetailsEntity acceptTransactionDetails(TransactionDetailsEntity transactionDetailsEntity);
    public TransactionDetailsEntity getTransactionDetails(int transactionId);
}
