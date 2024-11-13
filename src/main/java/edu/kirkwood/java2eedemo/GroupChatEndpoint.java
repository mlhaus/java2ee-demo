package edu.kirkwood.java2eedemo;

import edu.kirkwood.shared.MyDecoder;
import edu.kirkwood.shared.MyEncoder;
import edu.kirkwood.shared.MyJson;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(
        // value must start with the servlet path, then include an endpoint path
        value ="/group-chat/endpoint",
        encoders={MyEncoder.class},
        decoders={MyDecoder.class}
)
public class GroupChatEndpoint {
    private static final Set<Session> subscribers = Collections.synchronizedSet(new HashSet<>());
    @OnOpen
    public void onOpen(Session session) {
        subscribers.add(session);
        System.out.println("Subscriber count: " + subscribers.size());
    }

    @OnClose
    public void onClose(Session session) {
        subscribers.remove(session);
        System.out.println("Subscriber count: " + subscribers.size());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.err.println("ERROR: " + error.getMessage());
    }

    @OnMessage
    public void onMessage(Session sessionIn, MyJson message) throws EncodeException, IOException {
        System.out.println(message); // Displays the incoming message
        for(Session s : subscribers) {
            // Send the message to all subscribers except the one who sent it
            if(!s.equals(sessionIn)) {
                s.getBasicRemote().sendObject(message);
            }
        }
    }
}
