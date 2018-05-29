package com.project.controller;

import java.util.Map;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author 赵子墨
 *
 */
@RestController
public class GreetingController {
	/**
	 * 表示服务端可以接收客户端通过主题“/app/stomp”发送过来的消息，客户端需要在主题"/topic/stomp"上监听并接收服务端发回的消息
	 * 
	 * @param topic
	 * @param headers
	 */
	@MessageMapping("/stomp") // "/stomp"为WebSocketConfig类中registerStompEndpoints()方法配置的
	@SendTo("/topic/stomp")
	public Boolean greeting(@Header("atytopic") String topic, @Headers Map<String, Object> headers) {
		System.out.println("connected successfully....");
		System.out.println(topic);
		System.out.println(headers);
		return new Boolean(true);
	}
}
