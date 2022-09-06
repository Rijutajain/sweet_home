package com.upgrad.BookingService.service;

import com.upgrad.BookingService.dao.BookingDAO;
import com.upgrad.BookingService.dto.PaymentDTO;
import com.upgrad.BookingService.entity.BookingInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

//BookingServiceImpl extends the interface bookingService and provides its
// method implementation
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingDAO bookingDAO;
    @Autowired
    RestTemplate restTemplate;

    //AcceptBookingDetails method saves a booking entity into bookingService
    // database
    @Override
    public BookingInfoEntity acceptBookingDetails(BookingInfoEntity bookingInfoEntity){
        //Getting total rooms from booking entity
        int totalRooms=bookingInfoEntity.getNumOfRooms();
        //Getting total days between fromdate and to date
        long totalDays=
                Duration.between(bookingInfoEntity.getFromDate().toInstant(),
                        bookingInfoEntity.getToDate().toInstant()).toDays();
        //Setting room price
        bookingInfoEntity.setRoomPrice(1000*totalRooms*(int)totalDays);
        bookingInfoEntity.setBookedOn(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        //calling randomRoomNumbers method to provde a string of random room
        // numbers
        bookingInfoEntity.setRoomNumbers(RandomRoomNumbers(totalRooms));
        //using inbuilt method od JPA repository to save an entity
        return bookingDAO.save(bookingInfoEntity);
    }
    //This method generates a string of random room numbers between 0 and 100
    public String RandomRoomNumbers(int numOfRooms){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String>numberList = new ArrayList<String>();

        for (int i=0; i<numOfRooms; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }

        String roomNumbers = String.join(",", numberList);
        return roomNumbers;
    }
    //AcceptTransactionDetails saves an booking entity into booking service
    // database after receiving transaction Id
    public BookingInfoEntity acceptTransactionDetails(int bookingId,
                                                      PaymentDTO paymentDTO){
        Optional<BookingInfoEntity> bookingInfoEntity=
                bookingDAO.findById(bookingId);
        if(!bookingInfoEntity.isPresent()){
            return null;
        }
        //URL from where transaction id is coming
        String paymentServiceUri="http://localhost:8083/payment/transaction";
        //using rest template to call API from payment service
        Integer savedTransactionId=restTemplate.postForObject(paymentServiceUri,
                paymentDTO, Integer.class);
        bookingInfoEntity.get().setTransactionId(savedTransactionId);
        BookingInfoEntity bookingDetailsWithTransactionId=
                bookingDAO.save(bookingInfoEntity.get());
        return bookingDetailsWithTransactionId;
    }
}
