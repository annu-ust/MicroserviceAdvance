package com.example.chatapp.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.chatapp.model.ChatMessage;
// Spring's approach to working with STOMP messaging is to associate a controller method to the 
//configured endpoint. We can do this through the @MessageMapping annotation.
//After handling our message, we send it to the appropriate destination defined with the @SendTo annotation. 
//All subscribers to the “/topic/public” destination will receive the message.
@Controller
public class ChatController {

    @MessageMapping("/chat.register")
    //Annotation for mapping a Message onto a message-handling method by matching the 
    //declared patterns to a destination extracted from the message. 
    //`The annotation is supported at the type-level too, as a way of 
    //declaring a pattern prefix (or prefixes) across all class methods.
    //A more powerful and flexible way to map Messages to method arguments
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        // SimpMessageHeaderAccessor-simple messaging protocols that support basic 
        //messaging patterns. Provides uniform access to specific values 
        //common across protocols such as a destination,
        //message type (e.g. publish, subscribe, etc), session id, and others.
        //getSessionAttributes()-Get session attributes for the current state in the current session.
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    //that allows us to send a message to a user destination 
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    	//@Payload Annotation A parameter injection 
    	//annotation that can be used on component entry points 
        return chatMessage;
    }
}
//STOMP over WebSocket -- the value is turned into a message and sent to a default response destination
//or to a custom destination specified with an @SendTo or @SendToUser annotation.
//RSocket -- the response is used to reply to the stream request.