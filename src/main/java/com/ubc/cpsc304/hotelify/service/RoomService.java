package com.ubc.cpsc304.hotelify.service;

import com.ubc.cpsc304.hotelify.controller.dto.RoomDto;
import com.ubc.cpsc304.hotelify.entity.Room;
import com.ubc.cpsc304.hotelify.entity.compositeIdClass.RoomId;
import com.ubc.cpsc304.hotelify.repository.RoomRepository;
import com.ubc.cpsc304.hotelify.repository.RoomTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service layer for {@link RoomService}
 * Created by Rex on 2018-11-07
 */
@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomTypeRepository roomTypeRepository) {
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
    }

    public Room getRoom(Long roomNumber, Long hotelId) {

        RoomId roomId = new RoomId(roomNumber, hotelId);

        return this.roomRepository.findById(roomId).orElse(null);
    }

    public List<Room> getAllRoomsForHotel(Long hotelId) {
        return this.roomRepository.findByHotelId(hotelId);
    }

    public Room createRoom(Long hotelId, RoomDto roomdto) {

        Room room = new Room();

        room.setHotelId(hotelId);
        room.setRoomNumber(roomdto.getRoomNumber());
        room.setAvailable(roomdto.isAvailable());
        room.setType(this.roomTypeRepository.findById(roomdto.getTypeId()).orElse(null));

        return this.roomRepository.save(room);
    }

    public Room modifyRoom(Room existingRoom, RoomDto roomDto) {

        existingRoom.setAvailable(roomDto.isAvailable());
        existingRoom.setType(this.roomTypeRepository.findById(roomDto.getTypeId()).orElse(null));

        return this.roomRepository.save(existingRoom);
    }

    public void deleteRoom(Long roomNumber, Long hotelId) {
        this.roomRepository.delete(this.getRoom(roomNumber, hotelId));
    }
}
