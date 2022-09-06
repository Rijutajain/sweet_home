package com.upgrad.BookingService.service;

import com.upgrad.BookingService.dto.PaymentDTO;
import com.upgrad.BookingService.entity.BookingInfoEntity;

public interface BookingService {
    public BookingInfoEntity acceptBookingDetails(BookingInfoEntity bookingInfoEntity);
    public BookingInfoEntity acceptTransactionDetails(int bookingId,
                                                      PaymentDTO paymentDTO);
}
