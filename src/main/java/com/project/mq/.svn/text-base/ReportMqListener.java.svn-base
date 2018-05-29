package com.project.mq;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.RenewalEntity;
import com.project.entity.ReportEntity;
import com.project.service.IRenewalService;
import com.project.service.IReportService;
import com.project.util.ReportBean;
import com.project.vo.RenewalVO;
import com.project.vo.ReportVO;
import com.project.websocket.MyHandler;

/**
 * 
 * @author 赵子墨
 *
 */
@Service("reportMqListener")
public class ReportMqListener implements MessageListener {
	@Autowired
	private IReportService reportService;
	@Autowired
	private IRenewalService renewalService;

	private MyHandler myHander = new MyHandler();
	@Override
	public void onMessage(Message msg) {
		if (msg instanceof TextMessage) {
			try {
				TextMessage txtMsg = (TextMessage) msg;
				String message = txtMsg.getText();
				System.out.println("收到上报===" + message);
				myHander.sendMessageToAllUsers(new org.springframework.web.socket.TextMessage(message));
				ObjectMapper objectMapper = new ObjectMapper();
				ReportBean<?> mes = objectMapper.readValue(message, ReportBean.class);
				String jsonStr = objectMapper.writeValueAsString(mes.getData());

				if (mes.getSign().equals("1")) {
					ReportVO rv = objectMapper.readValue(jsonStr, ReportVO.class);
					ReportEntity re = new ReportEntity(null, rv.getRcode(), rv.getRname(), rv.getRregion(),
							rv.getRaddress(), rv.getRgrade(), rv.getRtype(), rv.getRdate(), rv.getUserName(),
							rv.getUserTel(), "100万", null, rv.getRnum(), null, rv.getRarea(), rv.getRimage(),
							rv.getRdesc(), 1, null, null, null);
					reportService.saveReport(re);
				} else {
					RenewalVO renewalVO = objectMapper.readValue(jsonStr, RenewalVO.class);
					ReportEntity report = reportService.getReportByCode(renewalVO.getRcode());
					RenewalEntity renewal = new RenewalEntity(report, renewalVO.getUserName(), renewalVO.getUserTel(),
							renewalVO.getRsGrade(), renewalVO.getRsArea(), renewalVO.getRsDate(), renewalVO.getRsDesc(),
							renewalVO.getRsNum());
					renewalService.saveRenewal(renewal);
				}
			} catch (JMSException | IOException e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new IllegalArgumentException("Message must be of type TextMessage");
		}
	}

}
