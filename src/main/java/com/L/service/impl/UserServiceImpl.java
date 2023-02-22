package com.L.service.impl;

import com.L.mapper.UserMapper;
import com.L.pojo.Users;
import com.L.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UsersService {
    @Autowired
    UserMapper userMapper;
    public Users Login(String name, String password) {
        List<Users> users=userMapper.selectUser(name,password);
        if (users.size()!=0) return users.get(0);
        int id=0;
        try {
            id=Integer.parseInt(name);
            List<Users> user2=userMapper.selectUserID(id);
            if (user2.size()!=0) return user2.get(0);
            else return null;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+name);
            return null;
        }


    }



    public Users Register(String name, String password, String identify) {
        List users=userMapper.selectUserByNI(name,identify);
        if (users.size()!=0) return null;
        Random random=new Random(new Date().getTime());
        int id=random.nextInt(100000000);

        while (userMapper.selectUserID(id).size()!=0){
            id=random.nextInt(100000000);
        }


        Users user=new Users();
        user.setUserId(id);
        user.setUserName(name);
        user.setUserIdentify(identify);
        user.setUserPassword(password);

        int rows=userMapper.insertUser2(user);
        if (rows==1)
        return user;
        else return null;
    }

    public Users Register1(String name,String password,String identify,String info){
        Users u1=Login(name, password);
        if (u1!=null) return null;
        Users users=new Users(name,password,identify,info);
        try {
            userMapper.insertUser(users);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return users;
    }

    public Users Reset(Integer id,String name,String password,String identify,String info){
        int rows=userMapper.resetUser(id, name, password, identify, info);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id);
        //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>users.size()"+users.size());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Updated Rows"+rows);
        if (rows!=0){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>User has Reset");
            return new Users(id,name,password,identify,info);
        }
        else return null;
    }
}
