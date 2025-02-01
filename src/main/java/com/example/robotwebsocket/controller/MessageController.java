package com.example.robotwebsocket.controller;



import com.example.robotwebsocket.model.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class MessageController {

    @MessageMapping("/chat/{robotName}")
    @SendTo("/topic/{robotName}")
    public Message sendMsg(@DestinationVariable String robotName, Message msg) {
        System.out.println("robot : " + robotName);
        System.out.println("direction: " + msg.getDirection());
        return new Message(msg.getDirection());
    }


}
