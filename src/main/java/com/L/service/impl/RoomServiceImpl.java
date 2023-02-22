package com.L.service.impl;

import com.L.mapper.OrderMapper;
import com.L.mapper.RoomMapper;
import com.L.pojo.Rooms;
import com.L.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomMapper roomMapper;
    public List<Rooms> showAllRooms() {
        return roomMapper.selectAllRooms();
    }

    public List<Rooms> selectRoomsByStorey(int Storey) {
        return roomMapper.selectRoomsByStorey(Storey);
    }

    public List<Rooms> selectRoomsByCategory(String category) {
        return roomMapper.selectRoomsByCategory(category);
    }

    public List<Rooms> selectRoomByClass(String Rclass) {
        return roomMapper.selectRoomsByRoomClass(Rclass);
    }

    public List<Rooms> selectRoomByPrice(int lowPrice, int highPrice) {
        return roomMapper.selectRoomsByPrice(lowPrice,highPrice);
    }

    public List<Rooms> selectRoomByCC(String category, String rclass) {
        return roomMapper.selectRoomsByCC(category, rclass);
    }
}
