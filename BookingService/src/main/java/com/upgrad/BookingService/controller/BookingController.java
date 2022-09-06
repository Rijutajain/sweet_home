package com.upgrad.BookingService.controller;

import com.upgrad.BookingService.dto.BookingDTO;
import com.upgrad.BookingService.dto.PaymentDTO;
import com.upgrad.BookingService.entity.BookingInfoEntity;
import com.upgrad.BookingService.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hotel")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @Autowired
    ModelMapper modelMapper;
    //This post mapping api call is designed to save a bookingDTO into database
    @PostMapping(value = "/booking",  consumes= MediaType.APPLICATION_JSON_VALUE
            , produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBooking(@RequestBody BookingDTO bookingDTO){
        BookingInfoEntity newBooking=modelMapper.map(bookingDTO,BookingInfoEntity.class);
         BookingInfoEntity savedBooking=
                 bookingService.acceptBookingDetails(newBooking);
        BookingDTO savedBookingDTO=modelMapper.map(savedBooking,
                BookingDTO.class);
        return new ResponseEntity(savedBookingDTO, HttpStatus.CREATED);
    }
    //This  post mapping api call is designed to save a bookingDTO in
    // database after it receives transactionId
    @PostMapping(value="booking/{bookingId}/transaction",  consumes=
            MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTransaction(@PathVariable(name="bookingId") int bookingId, @RequestBody PaymentDTO paymentDTO){
        BookingInfoEntity savedBookingWithTransactionId=
                bookingService.acceptTransactionDetails(bookingId,paymentDTO);
        //if there is no booking with this bookingId
        if(savedBookingWithTransactionId==null){
            return new ResponseEntity("Invalid  Booking Id",
                    HttpStatus.BAD_REQUEST);
        }
        //If payment method entered is neither "CARD" not "UPI"
        if(!(paymentDTO.getPaymentMode().equals("CARD") || paymentDTO.getPaymentMode().equals("UPI"))){
            return new ResponseEntity("Invalid mode of payment",
                    HttpStatus.BAD_REQUEST);
        }
        //Booking message printed on console
        System.out.println("Booking confirmed for user with aadhaar number: "+ savedBookingWithTransactionId.getAadharNumber()+"  |  "+"Here are the booking details:    "+ savedBookingWithTransactionId.toString());
        BookingDTO savedBookingDTOWithTransactionId=modelMapper.map(savedBookingWithTransactionId, BookingDTO.class);
        return new ResponseEntity(savedBookingDTOWithTransactionId, HttpStatus.CREATED);
    }

}
