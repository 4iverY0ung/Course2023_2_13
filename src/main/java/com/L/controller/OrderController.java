package com.L.controller;

import com.L.pojo.Orders;
import com.L.service.OrdersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @RequestMapping(value = "/insertOrder",method = RequestMethod.POST)
    @ResponseBody
    public Map InsertOrder(@RequestParam(required = false,value = "userID")Integer userID,
                           @RequestParam(required = false,value = "roomID")Integer roomID,
                           @RequestParam(required = false,value = "days")Integer days){
        System.out.println("+++++++++++++++++++++++++++++++++++++++"+userID);
        Orders order=new Orders(userID,roomID,days);
        ApplicationContext apc=new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersService oS=apc.getBean(OrdersService.class);

        int rows=oS.InsertOrder(order);
        System.out.println("+++++++++++++++++++++++++++++++++Rows:"+rows);

        Map jsonMap=new HashMap();
        if (rows==1){
            jsonMap.put("code","Success");
            jsonMap.put("rows",rows);
            return jsonMap;
        }
        if (rows==999){
            jsonMap.put("code","Ordered");
            return jsonMap;
        }
        else{
            jsonMap.put("code","Error");
            return jsonMap;
        }

    }

    @PostMapping("/deleteOrder")
    @ResponseBody
    public Map DeleteOrder(@RequestParam(required = false,value = "OrderID") Integer OrderID){
        System.out.println("+++++++++++++++++++++++++++++++++++++++Delete Order ID:"+OrderID);
        ApplicationContext apc=new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersService oS=apc.getBean(OrdersService.class);
        int rows =oS.DeleteOrder(OrderID);
        Map jsonMap=new HashMap();
        if (rows!=0){
            jsonMap.put("code",200);
            jsonMap.put("rows",rows);
        }
        else jsonMap.put("code",-1);
        return jsonMap;

    }

    @PostMapping("/upO")
    @ResponseBody
    public Map UpdateOrder(@RequestParam(required = false,value = "id") Integer id,
                           @RequestParam(required = false,value = "nO")Integer oid,
                           @RequestParam(required = false,value = "nR") Integer rid,
                           @RequestParam(required = false,value = "nD")Integer days){
        Map jsonMap=new HashMap();
        ApplicationContext apc=new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersService oS=apc.getBean(OrdersService.class);


        Orders orders=new Orders(oid,id,rid,days);
        int rows=oS.UpdateOrder(orders);

        if (rows!=0){
            jsonMap.put("code",200);
            jsonMap.put("rows",rows);
        }

        else jsonMap.put("code",-1);

        return jsonMap;

    }

    @PostMapping("/sbUID")
    @ResponseBody
    public Map SelectOrderByUserID(@RequestParam(required = false,value = "id") int UserID){
        Map jsonMap=new HashMap();
        ApplicationContext apc=new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersService oS=apc.getBean(OrdersService.class);
        System.out.println("+++++++++++++++++++++++++++++++++++++++Select Orders By User ID:"+UserID);

        List<Orders> byUserID= oS.SelectOrderByUserID(UserID);

        if (byUserID!=null){
            jsonMap.put("code",200);
            jsonMap.put("rooms",byUserID);
        }
        else {
            jsonMap.put("code",-1);
        }



        return jsonMap;
    }
}
