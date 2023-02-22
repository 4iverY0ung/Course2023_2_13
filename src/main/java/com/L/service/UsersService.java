package com.L.service;

import com.L.pojo.Users;

public interface UsersService {
    public Users Login(String name,String password);
    public Users Register(String name,String password,String identify);
    public Users Register1(String name,String password,String identify,String info);
    public Users Reset(Integer id,String name,String password,String identify,String info);
}
