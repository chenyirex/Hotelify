package com.ubc.cpsc304.hotelify.service;

import com.ubc.cpsc304.hotelify.entity.RoomType;
import com.ubc.cpsc304.hotelify.repository.RoomTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Layer for {@link com.ubc.cpsc304.hotelify.entity.RoomType}
 * Created by Rex on 2018-11-07
 */
@Service
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    @Autowired
    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public List<RoomType> getAllRoomTypes() {
        return this.roomTypeRepository.findAll();
    }

    public RoomType addRoomType(RoomType roomType) {
        return this.roomTypeRepository.save(roomType);
    }

    public RoomType modifyRoomType(RoomType existingRoomType, RoomType roomType) {

        existingRoomType.setName(roomType.getName());
        existingRoomType.setOccupancy(roomType.getOccupancy());
        existingRoomType.setDescription(roomType.getDescription());
        existingRoomType.setPrice(roomType.getPrice());

        return this.roomTypeRepository.save(existingRoomType);
    }

    public void deleteRoomType(RoomType roomType) {
        this.roomTypeRepository.delete(roomType);
    }
}
