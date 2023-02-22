package com.L.controller;

import cn.hutool.json.JSONObject;
import com.L.pojo.Users;
import com.L.service.UsersService;
import com.L.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {








    @PostMapping (value = "/login6",produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public Map login6(@RequestParam(required = false,value = "name") String name,
                      @RequestParam(required = false,value = "password")String password){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Parameter--UserName: "+name);
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService us=ac.getBean(UsersService.class);
        Users u=us.Login(name, password);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>User: "+u);
        Map map=new HashMap();
        if (u!=null){
            map.put("code",200);
            map.put("name",u.getUserName());
            map.put("password",u.getUserPassword());
            map.put("identify",u.getUserIdentify());
            map.put("info",u.getUserInfo());
            map.put("id",u.getUserId());
            map.put("isLogIn",1);

        }
        else{

            map.put("code",-1);
            map.put("isLogIn",-1);
        }
        return map;

    }


    /*
    @RequestBody Map map
    Failed to complete request: java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer

     */
    @PostMapping(value = "/reset")
    @ResponseBody
    public Map Reset(@RequestParam(required = false,value = "id")Integer id,
                     @RequestParam(required = false,value = "name")String name,
                     @RequestParam(required = false,value = "password")String password,
                     @RequestParam(required = false,value = "identify")String identify,
                     @RequestParam(required = false,value = "info")String info){

        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService us=ac.getBean(UsersService.class);
        System.out.println("++++++++++++++++++++++++++++++++"+id.intValue());
        Users u=us.Reset(id, name, password, identify, info);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>User: "+u);
        Map map2=new HashMap();
        if (u!=null){
            map2.put("code",200);
            map2.put("name",u.getUserName());
            map2.put("password",u.getUserPassword());
            map2.put("identify",u.getUserIdentify());
            map2.put("info",u.getUserInfo());
            map2.put("id",u.getUserId());
        }
        else{
            map2.put("code",-1);
        }
        return map2;

    }


    @PostMapping("/register")
    @ResponseBody
    public Map Register(@RequestParam(required = false,value = "name") String name,
                        @RequestParam(required = false,value = "password")String password,
                        @RequestParam(required = false,value = "identify")String identify){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService us=ac.getBean(UsersService.class);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Parameter--UserName: "+name);

        Users u=us.Register(name,password,identify);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>User: "+u);
        Map map=new HashMap();
        if (u!=null){
            map.put("code",HttpStatus.OK);
            map.put("userID",u.getUserId());
        }
        else map.put("code",-1);

        return map;

    }

























    /**
     *
     *  @PostMapping (value = " / login ", produces = { " application / json ; charset = UTF - 8 " })
     *     @ResponseBody
     *     //@RequestParam("name") String name,@RequestParam("password") String password  这样在postman中只可以使用param链接上带参数传输
     *     //与不加注释一样
     *     //@RequestBody Map<String,String> map 在postman中只可以使用raw响应 不可接受application/x-www-form-urlcoded类型，请看
     *     //https://blog.csdn.net/yaovirus/article/details/117408180
     *
     *     public Users login(@RequestBody Map<String,String> map){
     *         String name = "",password ="";
     *         if (map.containsKey("name")) {
     *             name= map.get("name");
     *         }
     *         if (map.containsKey("password")) {
     *             password= map.get("password");
     *         }
     *         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Parameter--UserName: "+name);
     *         ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
     *         UsersService us=ac.getBean(UsersService.class);
     *         Users u=us.Login(name, password);
     *         if (u!=null){
     *             return u;
     *         }
     *         else{
     *             System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>User: "+u);
     *             return null;
     *         }
     *
     *     }
     */








/*


 // @PostMapping (value = "/login5",produces={"application/json; charset=UTF-8"})
    @RequestMapping(value = "/login5.do", method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<Object> login5(HttpEntity<Users> user){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+user);
        JSONObject jsonObject=new JSONObject();
        String name=user.getBody().getUserName();
        String password= user.getBody().getUserPassword();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Parameter--UserName: "+name);
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService us=ac.getBean(UsersService.class);
        Users u=us.Login(name, password);

        jsonObject.put("username",u.getUserName());
        jsonObject.put("password",u.getUserPassword());
        jsonObject.put("id",u.getUserId());
        jsonObject.put("identify",u.getUserIdentify());
        jsonObject.put("info",u.getUserInfo());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+jsonObject);
        ResponseEntity<Object> responseResult = new ResponseEntity<Object>(jsonObject, HttpStatus.OK);
        return responseResult;
    }

 */





/*
@SneakyThrows
    @PostMapping (value = "/login4",produces={"application/json; charset=UTF-8"})
//    @ResponseBody
    public void login4(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+request.getRequestURL());
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Parameter--UserName: " + name);
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService us = ac.getBean(UsersService.class);
        Users u = us.Login(name, password);

        ObjectMapper om=new ObjectMapper();
        String json = om.writeValueAsString(u);


        if (u != null) {
            response.getWriter().write(json);

           // return u;
        } else {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>User: " + u);
            response.getWriter().print("");
          //  return null;
        }
    }
 */







    /**
     @PostMapping (" / login2 ")
     @ResponseBody

     public boolean login2(@RequestParam("name") String name,@RequestParam("password") String password){

     System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Parameter--UserName: "+name);
     ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
     UsersService us=ac.getBean(UsersService.class);
     Users u=us.Login(name, password);
     if (u!=null){
     return true;
     }
     else{
     System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>User: "+u);
     return false;
     }

     }
     *
     *
     @PostMapping ("/login3")
     @ResponseBody

     public boolean login2(@RequestBody Users users){

     String name= users.getUserName();
     String password=users.getUserPassword();
     System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Parameter--UserName: "+name);
     ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
     UsersService us=ac.getBean(UsersService.class);
     Users u=us.Login(name, password);
     if (u!=null){
     return true;
     }
     else{
     System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>User: "+u);
     return false;
     }

     }
     */










}
