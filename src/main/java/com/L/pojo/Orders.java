package com.L.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    int OrderID;
    int UserID;
    int RoomID;
    int Days;

    public Orders(int userID, int roomID, int days) {
        UserID = userID;
        RoomID = roomID;
        Days = days;
    }
}
