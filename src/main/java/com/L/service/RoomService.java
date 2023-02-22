package com.L.service;

import com.L.pojo.Rooms;

import java.util.List;

public interface RoomService {
    public List<Rooms> showAllRooms();
    public List<Rooms> selectRoomsByStorey(int Storey);
    public List<Rooms> selectRoomsByCategory(String category);
    public List<Rooms> selectRoomByClass(String Rclass);
    public List<Rooms> selectRoomByPrice(int lowPrice,int highPrice);
    public List<Rooms> selectRoomByCC(String category,String rclass);
}
