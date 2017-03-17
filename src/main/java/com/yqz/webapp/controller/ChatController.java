package com.yqz.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yqz.webapp.dto.ChatMessageDetailVO;
import com.yqz.webapp.service.ChatService;

@RestController
@RequestMapping(path = "chat")
public class ChatController {

	@Autowired
	ChatService chat;

	@RequestMapping(path = "list")
	public List<ChatMessageDetailVO> getReceivedChatMessage(@RequestParam int userId) {
		return chat.getReceivedChatMessage(userId);
	}
}
