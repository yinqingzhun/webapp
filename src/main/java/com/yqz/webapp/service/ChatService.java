package com.yqz.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yqz.webapp.dto.ChatMessageDetailVO;
import com.yqz.webapp.mapper.ChatMessageMapper;

@Service
public class ChatService {
	@Autowired
	ChatMessageMapper chatMessageMapper;
	 
	public List<ChatMessageDetailVO> getReceivedChatMessage(int userId) {
		return chatMessageMapper.getReceivedChatMessage(userId);
	}
}
