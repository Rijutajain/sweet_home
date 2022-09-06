package com.upgrad.BookingService.entity;

import javax.persistence.*;
import java.util.Date;

//BookingInfoEntity is a row which will be saved in Booking Service database
@Entity
public class BookingInfoEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name="booking_id", nullable = false)
    private int bookingId;
    @Column(name="from_date", nullable = true)
    private Date fromDate;
    @Column(name="to_date", nullable = true)
    private Date toDate;
    @Column(name="aadhar_number", nullable = true)
    private String aadharNumber;
    @Column(name="num_of_rooms")
    private int numOfRooms;
    @Column(name="room_numbers")
    private String roomNumbers;
    @Column(name="room_price", nullable = false)
    private int roomPrice;
    @Column(name="transaction_id", columnDefinition = "integer default 0")
    private int transactionId;
    @Column(name="booked_on", nullable = true)
    private Date bookedOn;

    public BookingInfoEntity(int bookingId, Date fromDate,
                             Date toDate,
                             String aadharNumber, int numOfRooms,
                             String roomNumbers, int roomPrice,
                             int transactionId, Date bookedOn) {
        this.bookingId = bookingId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.aadharNumber = aadharNumber;
        this.numOfRooms = numOfRooms;
        this.roomNumbers = roomNumbers;
        this.roomPrice = roomPrice;
        this.transactionId = transactionId;
        this.bookedOn = bookedOn;
    }
    public BookingInfoEntity(){

    }
    public int getBookingId() {
        return bookingId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public String getRoomNumbers() {
        return roomNumbers;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Date getBookedOn() {
        return bookedOn;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setBookedOn(Date bookedOn) {
        this.bookedOn = bookedOn;
    }

    @Override
    public String toString() {
        return "BookingInfoEntity{" +
                "bookingId=" + bookingId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", numOfRooms=" + numOfRooms +
                ", roomNumbers='" + roomNumbers + '\'' +
                ", roomPrice=" + roomPrice +
                ", transactionId=" + transactionId +
                ", bookedOn=" + bookedOn +
                '}';
    }
}
