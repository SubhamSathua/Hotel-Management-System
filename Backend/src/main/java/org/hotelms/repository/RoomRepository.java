package org.hotelms.repository;

import java.util.List;
import org.hotelms.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    // Find rooms by type
    List<Room> findByRoomType(String roomType);

    // Find rooms by price range
    List<Room> findByRoomPriceBetween(double minPrice, double maxPrice);

    // Find rooms with AC
    List<Room> findByAirConditioned(boolean airConditioned);

    // Custom query to find rooms by type and AC
    @Query("SELECT r FROM Room r WHERE r.roomType = :roomType AND r.airConditioned = :airConditioned")
    List<Room> findByRoomTypeAndAirConditioned(
            @Param("roomType") String roomType,
            @Param("airConditioned") boolean airConditioned
    );
}
