package com.upgrad.PaymentService.entity;

import javax.persistence.*;

//TransactionDetailsEntity is a row which will be saved in payment Service
// database
@Entity
public class TransactionDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="transaction_id", nullable = false)
    private int transactionId;
    @Column(name="payment_mode")
    private String paymentMode;
    @Column(name="booking_id",nullable = false)
    private int bookingId;
    @Column(name="upi_id")
    private String upiId;
    @Column(name="card_number")
    private String cardNumber;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public TransactionDetailsEntity(int transactionId, String paymentMode, int bookingId, String upiId, String cardNumber) {
        this.transactionId = transactionId;
        this.paymentMode = paymentMode;
        this.bookingId = bookingId;
        this.upiId = upiId;
        this.cardNumber = cardNumber;
    }
    public TransactionDetailsEntity(){

    }
    @Override
    public String toString() {
        return "TransactionDetailsEntity{" +
                "transactionId=" + transactionId +
                ", paymentMode='" + paymentMode + '\'' +
                ", bookingId=" + bookingId +
                ", upiId='" + upiId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
