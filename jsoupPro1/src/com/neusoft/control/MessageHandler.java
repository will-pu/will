package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.bean.Message;
import com.neusoft.service.MessageService;

@Controller
public class MessageHandler {
	
	//@Resource(name="MessageService")
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value="test/Messagehandler_add.action")
	public String add(HttpServletRequest request,Message m){
		System.out.println("...MessageHandler......add().......");
		System.out.println("username="+m.getUsername());
		System.out.println("title="+m.getTitle());
		System.out.println("message="+m.getMessage());
		boolean isOK=messageService.add(m);
		request.setAttribute("msg", isOK);
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Messagehandler_findAll.action")
	public String findAll(HttpServletRequest request){
		System.out.println("...MessageHandler......findAll().......");

		return "forward:/showMessage.jsp";
	}
	@RequestMapping(value="test/Messagehandler_findNewMessage.action")
	public void findNewMessage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("...MessageHandler......findNewMessage().......");
		Message m=messageService.findNewMessage();
		//========ajax回写函数中的XML格式的数据==================================
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<msgs>");
		out.println("<id>"+m.getId()+"</id>");
		out.println("<userName>"+m.getUsername()+"</userName>");
		out.println("<title>"+m.getTitle()+"</title>");
		out.println("<message>"+m.getMessage()+"</message>");
		out.println("<time>"+m.getTime()+"</time>");
		out.println("</msgs>");
		out.close();
	}
}
