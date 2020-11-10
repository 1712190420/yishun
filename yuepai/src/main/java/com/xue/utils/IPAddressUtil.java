package com.xue.utils;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressUtil{


    public static String getLocalIp(){
        try {
            InetAddress addr = InetAddress.getLocalHost();
            return  "http://"+ "39.107.138.166" +":8080/";
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "null";
    }


}
