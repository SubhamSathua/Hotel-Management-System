package org.hotelms.service;

import java.util.*;
import org.hotelms.entity.Room;
import org.hotelms.entity.Booking;
import org.hotelms.repository.RoomRepository;
import org.hotelms.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Map<String, String> addRoom(Room room) {
        Map<String, String> response = new HashMap<>();

        // Save the room to the DB
        roomRepository.save(room);

        response.put("status", "success");
        response.put("message", "Room added successfully");
        response.put("room_id", String.valueOf(room.getId()));
        return response;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Map<String, Object> getRoomById(int roomId) {
        Map<String, Object> response = new HashMap<>();

        Optional<Room> roomOpt = roomRepository.findById(roomId);

        if (roomOpt.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Room not found");
            return response;
        }

        Room room = roomOpt.get();
        response.put("status", "success");
        response.put("room", room);
        return response;
    }

}
