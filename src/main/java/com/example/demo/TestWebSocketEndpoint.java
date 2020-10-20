package com.example.demo;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;

public class TestWebSocketEndpoint extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        System.out.println("TEST");
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                System.out.println(message);
                try {
                    session.getBasicRemote().sendText("HIHIHI" + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }


}
