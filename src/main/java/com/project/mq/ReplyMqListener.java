package com.project.mq;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.FeedBackEntity;
import com.project.entity.SchedulingEntity;
import com.project.service.IFeedbackService;
import com.project.service.ISchedulingService;
import com.project.util.DateUtil;
import com.project.vo.ReplyQueueVO;
import com.project.websocket.MyHandler;

/**
 * 
 * @author 赵子墨
 *
 */
@Service("replyMqListener")
public class ReplyMqListener implements MessageListener {
	@Autowired
	private IFeedbackService feedBackService;
	@Autowired
	private ISchedulingService schedulingService;
	
	private MyHandler myHander = new MyHandler();
	@Override
	public void onMessage(Message msg) {
		if (msg instanceof TextMessage) {
			try {
				TextMessage txtMsg = (TextMessage) msg;
				String message = txtMsg.getText();
				myHander.sendMessageToAllUsers(new org.springframework.web.socket.TextMessage(message));
				System.out.println("收到反馈===" + message);
				ObjectMapper objectMapper = new ObjectMapper();
				ReplyQueueVO reply = objectMapper.readValue(message, ReplyQueueVO.class);
				String sign = reply.getSign();
				String orgCode = reply.getOrgCode();
				String rCode = reply.getrCode();
				SchedulingEntity sch = schedulingService.findSchedulingByCode(orgCode, rCode).get(0);
				if ("1".equals(sign)) {
					schedulingService.updateStatus(sch.getSchId(), 1);
				} else if ("2".equals(sign)) {
					FeedBackEntity feedBack = new FeedBackEntity(sch.getReportEntity(), sch.getInformationEntity(),
							reply.getOrgUser(), reply.getOrgTel(), DateUtil.getTime(), reply.getMessage());
					feedBackService.addFeedBack(feedBack);
					schedulingService.updateStatus(sch.getSchId(), 2);
				} else if("3".equals(sign)) {
					schedulingService.updateStatus(sch.getSchId(), 3);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new IllegalArgumentException("Message must be of type TextMessage");
		}
	}

}
