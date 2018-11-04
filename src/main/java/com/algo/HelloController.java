package com.algo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by hd on 8/5/18.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/list")
    public Collection<String> sayHello(){
        return IntStream.range(0,10)
                .mapToObj(i -> "Hello number "+i)
                .collect(Collectors.toList());
    }

    @GetMapping("/hello")
    public String hello() throws UnknownHostException{
        String hostName=null;
        try{
            InetAddress inetAddress=InetAddress.getLocalHost();
            hostName= inetAddress.getHostName()+"["+ inetAddress.getHostAddress()+"]";
        }catch (UnknownHostException e){
            hostName="unknown";
        }
        return "Hello from : "+hostName;

    }
}
