package com.zuci.ZuciIStay.repository;

import com.zuci.ZuciIStay.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelBookingRepository extends JpaRepository<Booking,Integer> {
}
