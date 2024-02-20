package com.zuci.ZuciIStay.service;
import com.zuci.ZuciIStay.exception.HotelBookingNotFoundException;
import com.zuci.ZuciIStay.model.Booking;
import com.zuci.ZuciIStay.model.BookingData;
import com.zuci.ZuciIStay.repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class HotelBookingServiceImpl implements HotelBookingService
{
    @Autowired
    HotelBookingRepository hotelBookingRepository;
    @Override
    public Booking createBooking(@RequestBody Booking booking) {
        return hotelBookingRepository.save(booking);

    }

    @Override
    public List<Booking> getAllBooking() {
        return hotelBookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(int bookingId) {

        Optional<Booking> optional = hotelBookingRepository.findById(bookingId);
        if(optional.isPresent())
        {
            return optional.get();
        }
        else
        {
            throw new HotelBookingNotFoundException();
        }

    }

    @Override
    public String DeleteBookingById(int bookingId) {
        String status=null;
        Optional<Booking> optional=hotelBookingRepository.findById(bookingId);
        if(optional.isPresent())
        {
            hotelBookingRepository.deleteById(bookingId);
            status="booking deleted";
        }
        else {
            status="booking not deleted,Please check your Booking Id";
        }
        return status;
    }

    @Override
    public boolean roomBookingByCheck(BookingData bookingData) {
        List<Booking> booking = getAllBooking();
        Iterator iterator = booking.listIterator();
        while (iterator.hasNext()) {
            Booking value = (Booking) iterator.next();
            String place = value.getPlace();
            String hotel = value.getHotelName();
            String room = value.getRoomType();
            LocalDate fromDate = value.getFromDate();
            LocalDate toDate = value.getToDate();
            if (place.equals(bookingData.getPlace()) && hotel.equals(bookingData.getHotelName()) && room.equals(bookingData.getRoomType())) {
                if (((bookingData.getFromDate()).isAfter(fromDate) &&
                        (bookingData.getFromDate()).isBefore(toDate))
                        || ((bookingData.getToDate()).isAfter(fromDate) &&
                        (bookingData.getToDate()).isAfter(toDate))) {
                    return false;
                }
            }
        }

        return true;
    }

}