package com.neusoft.mapper;

import java.sql.SQLException;

import com.neusoft.bean.Message;

public interface MessageMapper {
	public int add(Message m) throws SQLException;
	public Message findNewMessage() throws SQLException;
}
