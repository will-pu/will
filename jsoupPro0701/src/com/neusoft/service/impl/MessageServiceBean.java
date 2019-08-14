package com.neusoft.service.impl;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Message;
import com.neusoft.mapper.MessageMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.service.MessageService;


//@Service(value="MessageService")
@Service
public class MessageServiceBean implements MessageService {

	@Override
	public boolean add(Message m) {
		System.out.println("...MessageServiceBean.....add().......");
		boolean isOK=false;
		SqlSession session=SqlSessionUtil.openSession();
		MessageMapper mapper=session.getMapper(MessageMapper.class);
		try {
			int count=mapper.add(m);
			if(count>0){
				session.commit();
				isOK=true;
			}else{
			//	throw new SQLException();
				session.rollback();
				isOK=false;
			}
		} catch (SQLException e) {
			session.rollback();
			isOK=false;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return isOK;
	}
	
	@Override
	public Message findNewMessage() {
		System.out.println("....MessageServiceBean....findNewMessage().....");
		SqlSession session=SqlSessionUtil.openSession();
		MessageMapper mapper=session.getMapper(MessageMapper.class);
		Message m=null;
		try {
			m=mapper.findNewMessage();
		} catch (SQLException e) {
			m=null;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return m;
	}

}
