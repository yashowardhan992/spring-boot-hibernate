package com.demoApp.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//Use dev tools dependency to for live reload of the server
@RestController
public class FunRestController {
   // inject properties for user.name and org.name

    @Value("${user.name}")
    private String userName;

    @Value("${org.name}")
    private String orgName;

    @GetMapping("/orgInfo")
    public String getOrgInfo() {
        return " Emp : " +userName+" , Org Name : "+orgName;
    }



    // expose "/" that return "Hello World"

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }


    //expose a new endpoint for workout
    @GetMapping("/workout")
    public String getWorkout(){
        return "Run 5k";
    }

    @GetMapping("/date")
    public String getDate(){
        return "26th May 2023";
    }

    @GetMapping("/sum")
    public String getSum(){
        return "2+2=4";
    }
}

