package com.L.mapper;

import com.L.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    public int insertOrder(Orders order);
    public int deleteOrder(@Param("OrderID") int OrderID);
    public int updateOrder(Orders order);
    public List<Orders> selectOrderByID(@Param("OrderID") int OrderID);

    public List<Orders> selectOrderByUserID(@Param("UserID") int UserID);
    public List<Orders> selectOrderByRoomID(@Param("RoomID") int RoomID);

}
