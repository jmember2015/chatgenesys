package com.genesys.chat.controllers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import static java.util.concurrent.TimeUnit.SECONDS;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-servlet.xml"})
@WebAppConfiguration
@TestPropertySource("classpath:chat.properties")
public class WebSocketTest {

    @Autowired
    private Environment env;

    private BlockingQueue<String> blockingQueue;
    private WebSocketStompClient stompClient;

    @Ignore
    @Before
    public void setup() {

        blockingQueue = new LinkedBlockingDeque<String>();

        List<Transport> transports = new ArrayList<Transport>(1);
        transports.add(new RestTemplateXhrTransport());

        stompClient = new WebSocketStompClient(new SockJsClient(transports));
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

    }

    @Ignore
    @Test
    public void testConnectionWebSocket() throws Exception {

        String webSocketUri = env.getProperty("chat.websocket");
        String webSocketTopic = env.getProperty("chat.topic");

        StompSession session = stompClient.connect(webSocketUri, new StompSessionHandlerAdapter() {
        }).get(1, SECONDS);

        session.subscribe(webSocketTopic, new DefaultStompFrameHandler());

        String message = "{\"sender\":\"vo\",\"content\":\"dshfjsd\",\"type\":\"CHAT\"}";
        //String message = "{\"sender\":\"vo\",\"type\":\"JOIN\"}";

        session.send("/app/push", message.getBytes());

        //Assert.assertEquals(message, blockingQueue.poll(1, SECONDS));

    }

    class DefaultStompFrameHandler implements StompFrameHandler {
        @Override
        public Type getPayloadType(StompHeaders stompHeaders) {
            return byte[].class;
        }

        @Override
        public void handleFrame(StompHeaders stompHeaders, Object o) {
            blockingQueue.offer(new String((byte[]) o));
        }
    }

}