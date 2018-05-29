package com.project.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class WebSocketInterceptor implements HandshakeInterceptor {

	/**
	 * 当客户端与服务器端握手之前之前执行的方法 取出当前存在session的用户信息将dunId，封装到WebSocket对象中的map中；
	 * 由Handler处理器中获取id
	 * 
	 * @return
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
			Map<String, Object> attribute) throws Exception {
		ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;  
        HttpSession session = serverHttpRequest.getServletRequest().getSession();  
        if (session != null) { 
            attribute.put("dunId", 12345); 
        }
		// 放行
		return true;
	}

	/**
	 * 与服务器websoket建立握手之后执行的方法
	 */
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
			Exception exception) {

	}

}
