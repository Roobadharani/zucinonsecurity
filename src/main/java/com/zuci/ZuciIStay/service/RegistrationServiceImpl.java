package com.zuci.ZuciIStay.service;

import com.zuci.ZuciIStay.exception.NoBookingRecordsFoundException;
import com.zuci.ZuciIStay.model.Registration;
import com.zuci.ZuciIStay.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    private RegistrationRepository registrationRepository;
    @Override
    public Registration addDetails(Registration registration) {

        return registrationRepository.save(registration);
    }
    @Override
    public List<Registration> findBookingByUserId(int userId) {
        Optional<Registration> optionalHotel = registrationRepository.findById(userId);
        if(optionalHotel.isPresent()){
            List<Registration> hotelList = optionalHotel
                    .map(Collections::singletonList) // Converts to List
                    .orElse(Collections.emptyList());
            return hotelList;}
        else{
            throw new NoBookingRecordsFoundException();
        }
    }
}
