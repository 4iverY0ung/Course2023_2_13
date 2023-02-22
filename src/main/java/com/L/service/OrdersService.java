package com.L.service;

import com.L.pojo.Orders;

import java.util.List;

public interface OrdersService {
    public int InsertOrder(Orders order);
    public int DeleteOrder(int OrderID);
    public int UpdateOrder(Orders order);
    public Orders SelectOrderByOrderID(int OrderID);
    public List<Orders> SelectOrderByUserID(int UserID);
    public Orders SelectOrderByRoomID(int RoomID);
}
