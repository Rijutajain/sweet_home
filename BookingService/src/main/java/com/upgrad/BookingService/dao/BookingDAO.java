package com.upgrad.BookingService.dao;

import com.upgrad.BookingService.entity.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//This interface extends JPA repository which directly provides
// implementation of some basic methods.
public interface BookingDAO extends JpaRepository<BookingInfoEntity, Integer> {

}
