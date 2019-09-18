package com.offcn.springbootdemo001.controller;

import com.offcn.springbootdemo001.pro.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/car")
public class CarController {

    @Value("${offcn_ip}")
    private String offcn_ip;
    @Value("${offcn_port}")
    private String offcn_port; 

    @GetMapping("/getvalue")
    public String getValue() {
        return "ip:"+offcn_ip+" port:"+offcn_port;
    }


    @RequestMapping("/findOneCar")
    public Car findOneCar(){
        Car car = new Car(1, "toyo", 1999.99F,new Date());
        return car;
    }


    //演示？传递参数
    @RequestMapping("/findCarById")
    public Car findCarById(Integer id){
        Car car = new Car(id, "mazida", 12343.99F,new Date());
        return car;
    }

    //演示/ 传递参数
    //演示使用json传递参数  在（）中添加注解@RequestBody


    //演示自动封装传递
    @RequestMapping("/getCar")
    public Car getCar(Car car){
        return car;
    }

    //声明自动封装处理日期时间类型转化器
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
}
