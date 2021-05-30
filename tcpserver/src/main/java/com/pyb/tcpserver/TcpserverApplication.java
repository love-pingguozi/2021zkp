package com.pyb.tcpserver;

import com.pyb.tcpserver.utils.startAccept;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcpserverApplication {

    public static void main(String[] args) {
        try {
            startAccept sa = new startAccept();
        } catch (Exception e) {
        }
        SpringApplication.run(TcpserverApplication.class, args);
    }

}
