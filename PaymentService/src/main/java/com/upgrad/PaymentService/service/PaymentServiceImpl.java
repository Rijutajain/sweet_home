package com.upgrad.PaymentService.service;

import com.upgrad.PaymentService.dao.PaymentDAO;
import com.upgrad.PaymentService.entity.TransactionDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//PaymentServiceImpl extends the interface paymentService and provides its
// method implementation
@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentDAO paymentDAO;

    //AccpetTransactionDetails method saves an entity in payment service
    // database
    @Override
    public TransactionDetailsEntity acceptTransactionDetails(TransactionDetailsEntity transactionDetailsEntity){

        return paymentDAO.save(transactionDetailsEntity);
    }
    //getTransactionDetails gives a TransactionDetailsEntity based on
    // transactionID
    public TransactionDetailsEntity getTransactionDetails(int transactionId){
        return paymentDAO.findById(transactionId).get();
    }
}
