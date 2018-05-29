package com.project.mq;

/**
 * 
 * @author 赵子墨
 *
 */
public interface IMqSenderService {
	/**
	 * 发送消息
	 * 
	 * @param message
	 *            消息
	 */
	public void sendMsgQueue(String message);

	/**
	 * 订阅发布
	 * 
	 * @param message
	 *            消息
	 */
	public void sendMsgTopic(String message);
}
