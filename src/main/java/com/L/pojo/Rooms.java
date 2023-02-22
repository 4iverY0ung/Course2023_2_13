package com.L.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rooms {
    int RoomID;
    int Storey;
    String RoomCategory;
    String RoomInfo;
    String RoomClass;
    float Price;
}
