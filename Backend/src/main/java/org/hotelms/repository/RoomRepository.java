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

}
