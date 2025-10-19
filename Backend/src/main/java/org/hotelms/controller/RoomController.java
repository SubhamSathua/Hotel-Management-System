package org.hotelms.controller;

import java.util.*;
import org.hotelms.entity.Room;
import org.hotelms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public Map<String, String> addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAllRooms(); // Since we removed status, return all rooms
    }

    @GetMapping("/{id}")
    public Map<String, Object> getRoomById(@PathVariable int id) {
        return roomService.getRoomById(id);
    }

}
