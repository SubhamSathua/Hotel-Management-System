package org.hotelms.service;

import org.hotelms.entity.Booking;
import org.hotelms.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
    
    public Optional<Booking> getBookingById(Integer id) {
        return bookingRepository.findById(id);
    }
    
    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }
    
}
