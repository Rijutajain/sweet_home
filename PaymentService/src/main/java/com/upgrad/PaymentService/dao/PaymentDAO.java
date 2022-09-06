package com.upgrad.PaymentService.dao;
import com.upgrad.PaymentService.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//This interface extends JPA repository which directly provides
// implementation of some basic methods.
public interface PaymentDAO extends JpaRepository<TransactionDetailsEntity, Integer> {
}
