package com.L.mapper;

import com.L.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public int insertUser(Users users);
    public int insertUser2(Users users);
    public void deleteUserById(int id);
    public List<Users> selectUserID(@Param("userID") Integer userId);
    public List<Users> selectUserByNI(@Param("userName") String userName,@Param("userIdentify")String userIdentify);
    public List<Users> selectUser(@Param("userName") String userName, @Param("userPassword")String password);
    public int resetUser(@Param("userId") Integer userId,@Param("userName")String userName,@Param("userPassword")String password,@Param("userIdentify")String identify,@Param("userInfo")String info);
}
