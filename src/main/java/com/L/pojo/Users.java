package com.L.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    int UserId;
    String UserName;
    String UserPassword;
    String UserIdentify;
    String UserInfo;

    /**
     *
     *  public Users(String userName, String userPassword) {
     *         UserName = userName;
     *         UserPassword = userPassword;
     *     }
     */


    public Users(String userName, String userPassword, String userIdentify, String userInfo) {
        UserName = userName;
        UserPassword = userPassword;
        UserIdentify = userIdentify;
        UserInfo = userInfo;
    }
}
