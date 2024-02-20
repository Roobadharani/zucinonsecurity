package com.zuci.ZuciIStay.controller;
import com.zuci.ZuciIStay.model.BookingData;
import com.zuci.ZuciIStay.model.Hotel;
import com.zuci.ZuciIStay.model.PlaceHotel;
import com.zuci.ZuciIStay.model.Room;
import com.zuci.ZuciIStay.service.ZuciIStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ZuciIStayController {
    @Autowired
    private ZuciIStayService zuciIStayService;

    @GetMapping("/hotel/allHotel")
    public List<PlaceHotel> findAllData(){
        return zuciIStayService.findAllData();
    }
    @PostMapping("/hotel/placeAdd")
    public PlaceHotel addPlace(@RequestBody PlaceHotel placeHotel){
        return zuciIStayService.addPlace(placeHotel);
    }
    @PostMapping("/hotel/hotelAdd")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return zuciIStayService.addHotel(hotel);
    }
    @PostMapping("/hotel/roomAdd")
    public Room addRoom(@RequestBody Room room){
        return zuciIStayService.addRoom(room);
    }
    @GetMapping("/hotel/{placeId}")
    public List<PlaceHotel> getHotelsByPlaceId(@PathVariable int placeId) {
        return zuciIStayService.findHotelsByPlaceId(placeId);
    }
    @GetMapping("/room/{hotelId}")
    public List<Hotel> getRoomByHotelId(@PathVariable int hotelId) {
        return zuciIStayService.findRoomByHotelId(hotelId);
    }

}
