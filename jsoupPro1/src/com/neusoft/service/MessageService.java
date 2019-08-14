package com.neusoft.service;

import com.neusoft.bean.Message;

public interface MessageService {
	public boolean add(Message m);
	public Message findNewMessage();
}
