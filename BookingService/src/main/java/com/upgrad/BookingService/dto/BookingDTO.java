package com.upgrad.BookingService.dto;
import java.util.Date;

public class BookingDTO {
    private int bookingId;
    private Date fromDate;
    private Date toDate;
    private String aadharNumber;
    private int numOfRooms;
    private String roomNumbers;
    private int roomPrice;
    private int transactionId;
    private Date bookedOn;
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
}
