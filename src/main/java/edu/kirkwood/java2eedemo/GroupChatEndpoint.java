package edu.kirkwood.java2eedemo;

import edu.kirkwood.shared.MyDecoder;
import edu.kirkwood.shared.MyEncoder;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

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
}
