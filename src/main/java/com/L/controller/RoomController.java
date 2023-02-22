package com.L.controller;


import com.L.pojo.Rooms;
import com.L.service.RoomService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoomController {

    private RoomService getService(){
        ApplicationContext apc=new ClassPathXmlApplicationContext("applicationContext.xml");
        RoomService rS=apc.getBean(RoomService.class);
        return rS;
    }
    @PostMapping("/getAllRooms")
    @ResponseBody
    public Map getAllRooms(){
        RoomService rS=getService();
        List<Rooms> rooms= rS.showAllRooms();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++All Rooms"+rooms);
        Map jsonMap=new HashMap();

        if (rooms.size()!=0){
            jsonMap.put("code",200);
            jsonMap.put("rooms",rooms);
        }
        else {
            jsonMap.put("code",-1);
        }



        return jsonMap;
    }



    @PostMapping("/getRoomsCategory")
    @ResponseBody
    public Map getRoomsCategory(@RequestParam(required = false,value = "category") String category){
        Map jsonMap=new HashMap();

        RoomService rS=getService();
        List<Rooms> byCategory =rS.selectRoomsByCategory(category);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++byCategory Rooms"+byCategory);

        if (byCategory.size()!=0){
            jsonMap.put("code",200);
            jsonMap.put("rooms",byCategory);
        }
        else {
            jsonMap.put("code",-1);
        }

        return jsonMap;
    }


    @PostMapping("/getRoomsClass")
    @ResponseBody
    public Map getRoomsClass(@RequestParam(required = false,value = "rclass") String rclass){
        Map jsonMap=new HashMap();

        RoomService rS=getService();
        List<Rooms> byClass =rS.selectRoomByClass(rclass);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++byClass Rooms"+byClass);

        if (byClass.size()!=0){
            jsonMap.put("code",200);
            jsonMap.put("rooms",byClass);
        }
        else {
            jsonMap.put("code",-1);
        }

        return jsonMap;
    }





    @PostMapping("/getRoomsCC")
    @ResponseBody
    public Map getRoomsCC(@RequestParam(required = false,value = "category") String category,
                          @RequestParam(required = false,value = "rclass") String rclass){
        Map jsonMap=new HashMap();

        RoomService rS=getService();
        List<Rooms> byCC =rS.selectRoomByCC(category, rclass);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++byCategory Rooms"+byCC);

        if (byCC.size()!=0){
            jsonMap.put("code",200);
            jsonMap.put("rooms",byCC);
        }
        else {
            jsonMap.put("code",-1);
        }

        return jsonMap;
    }






    @PostMapping("/getRoomsStorey")
    @ResponseBody
    public Map getRoomsCategory(@RequestParam(required = false,value = "storey") Integer storey){
        Map jsonMap=new HashMap();

        RoomService rS=getService();
        List<Rooms> byCategory =rS.selectRoomsByStorey(storey);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++byCategory Rooms"+byCategory);

        if (byCategory.size()!=0){
            jsonMap.put("code",200);
            jsonMap.put("rooms",byCategory);
        }
        else {
            jsonMap.put("code",-1);
        }

        return jsonMap;
    }

    @PostMapping("/getRoomsPrice")
    @ResponseBody
    public Map getRoomsPrice(@RequestParam(required = false,value = "lowPrice") Integer lP,
                             @RequestParam(required = false,value = "highPrice") Integer hP){
        Map jsonMap=new HashMap();

        RoomService rS=getService();
        List<Rooms> byPrice =rS.selectRoomByPrice(lP,hP);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++byCategory Rooms"+byPrice);

        if (byPrice.size()!=0){
            jsonMap.put("code",200);
            jsonMap.put("rooms",byPrice);
        }
        else {
            jsonMap.put("code",-1);
        }

        return jsonMap;
    }


}
