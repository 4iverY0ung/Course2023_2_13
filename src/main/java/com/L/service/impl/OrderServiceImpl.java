package com.L.service.impl;

import com.L.mapper.OrderMapper;
import com.L.pojo.Orders;
import com.L.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrdersService {
    @Autowired
    OrderMapper orderMapper;

    public int InsertOrder(Orders order) {

        List<Orders> byRoomID=orderMapper.selectOrderByRoomID(order.getRoomID());

        if (byRoomID.size()!=0){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Room Has Been Ordered");
            return 999;
        }

        int rows=orderMapper.insertOrder(order);
        if (rows!=0) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Room Ordered Success!");
            return 1;
        }
        else {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Room Ordered Failed!");
            return 0;
        }
    }

    public int DeleteOrder(int OrderID) {
        int rows=orderMapper.deleteOrder(OrderID);
        if (rows!=0) return 1;
        else return 0;
    }

    public int UpdateOrder(Orders order) {
        int rows=orderMapper.updateOrder(order);
        if (rows!=0) return 1;
        else return 0;
    }

    public Orders SelectOrderByOrderID(int OrderID) {
        List<Orders> orders=orderMapper.selectOrderByID(OrderID);
        if (orders.size()!=0){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Order:"+orders.get(0));
            return orders.get(0);
        }
        else return null;
    }

    public List<Orders> SelectOrderByUserID(int UserID) {
        List<Orders> orders=orderMapper.selectOrderByUserID(UserID);
        if (orders.size()!=0){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Order:"+orders);
            return orders;
        }
        else return null;
    }

    public Orders SelectOrderByRoomID(int RoomID) {
        List<Orders> orders=orderMapper.selectOrderByRoomID(RoomID);
        if (orders.size()!=0){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Order:"+orders.get(0));
            return orders.get(0);
        }
        else return null;
    }
}
