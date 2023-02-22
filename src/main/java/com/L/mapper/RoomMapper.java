package com.L.mapper;

import com.L.pojo.Rooms;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper {
    public int insertRoom(Rooms rooms);
    public List<Rooms> selectRoomsByRoomID(@Param("RoomID") int RoomID);
    public int deleteRoom(@Param("RoomID") int RoomID);
    public int updateRoom(Rooms rooms);
    public List<Rooms> selectAllRooms();
    public List<Rooms> selectRoomsByStorey(@Param("Storey") int storeyID);
    public List<Rooms> selectRoomsByRoomClass(@Param("RoomClass") String RoomClass);
    public List<Rooms>  selectRoomsByPrice(@Param("lowPrice") float lowPrice,@Param("highPrice")float highPrice);
    public List<Rooms>  selectRoomsByCategory(@Param("RomeCategory") String RomeCategory);
    public List<Rooms>  selectRoomsByCC(@Param("RomeCategory")String category,@Param("RoomClass") String rclass);
}
