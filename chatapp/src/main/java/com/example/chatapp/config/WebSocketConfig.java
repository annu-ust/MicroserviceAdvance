package com.example.chatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//First, we enable the WebSocket capabilities. In order to do this, we need to add a 
//configuration to our application and annotate this class with
@Configuration
@EnableWebSocketMessageBroker// enables WebSocket message handling, backed by a message broker.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").withSockJS();
        //registerStompEndpoints method is used to register
        //a websocket endpoint that the clients will use to connect to the server.
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
    	/*
         * This enables a simple (in-memory) message broker for our application.
         * The `/topic` designates that any destination prefixed with `/topic`
         * will be routed back to the client.
         * It's important to keep in mind, this will not work with more than one
         * application instance, and it does not support all of the features a
         * full message broker like RabbitMQ, ActiveMQ, etc... provide.
         */
        registry.enableSimpleBroker("/topic");
        /*
         * The application destination prefix `/app` designates the broker to send
         * messages prefixed with `/app` to our `@MessageMapping`s.
         */
        registry.setApplicationDestinationPrefixes("/app");
    }
}
/*
 * First, we enable an in-memory message broker to carry the messages back to
 * the client on destinations prefixed with “/topic”.
 * 
 * We complete our simple configuration by designating the “/app” prefix to
 * filter destinations targeting application annotated methods
 * (via @MessageMapping).
 * 
 * The registerStompEndpoints method registers the “/websocket” endpoint, enabling
 * Spring’s STOMP support. Keep in mind that we are also adding an endpoint here
 * that works without the SockJS for the sake of elasticity.
 * 
 * This endpoint, when prefixed with “/app”, is the endpoint that the
 * ChatController.send() method is mapped to handle.
 * 
 * It also enables the SockJS fallback options so that alternative messaging
 * options may be used if WebSockets are not available. This is useful since
 * WebSocket is not supported in all browsers yet and may be precluded by
 * restrictive network proxies.
 * https://www.baeldung.com/websockets-spring
 */