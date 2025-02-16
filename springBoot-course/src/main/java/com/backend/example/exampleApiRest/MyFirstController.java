package com.backend.example.exampleApiRest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyFirstController {
    //get method
    @GetMapping("/get-2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello(){
        return "hello from controler";
    }

    //post method
    @PostMapping("/post/order-2")
    public String post(@RequestBody Order order){//converts the body from the http request into the java object needed
        return "Reques accepted, order is: "+order.toString();
    }

    //post with order
    @PostMapping("/post/order-record")
    public String postRecord(@RequestBody OrderRecord order){//converts the body from the http request into the java object needed
        return "Reques accepted, order is: "+order.toString();
    }

    //passing parameter to a method
    @GetMapping("/get/{user}")//the branches make spring know that is a path variable and concatena it to the user
    public String pathVar( @PathVariable("user") String user){
        return "my value:"+user;
    }//always specify pathVariable

    //passing multiple variables http://localhost:8080/get-params?user=elliot&lastname=alderson
    @GetMapping("/get-params")//the branches make spring know that is a path variable and concatena it to the user
    public String paramVar( @RequestParam("user") String user,@RequestParam("lastname") String lastName){
        return "my value:"+user + " " + lastName ;
    }//always specify pathVariable

}
