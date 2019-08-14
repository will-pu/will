package com.neusoft.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.bean.Etfjin;
import com.neusoft.jsoup.JsoupTools;
import com.neusoft.service.EtfjinService;
import com.neusoft.thread.EtfThread;
import com.neusoft.thread.EtfThread2;

@Controller
public class EtfjinHandler {
	@Autowired
	private EtfjinService etf_jinService;
	
	@RequestMapping(value="test/Etf_jinHandler_add.action")
	public String add(){
		System.out.println("...Etf_jinHandler.....add().......");
		Etfjin e=new Etfjin();
		e.setJingChiCangLiang(1000);
		e.setMeiYuan(6000);
		e.setPrice(1412.5);
		e.setTime("2019-06-24");
		e.setYingXiang("利多金银");
		e.setZengJian(2.8);
		boolean isOK=etf_jinService.add(e);
		System.out.println("isOK="+isOK);
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Etf_jinHandler_addList.action")
	public String addList(String urlpath,String charset,String path){
		System.out.println("...Etf_jinHandler.....addList().......");
		JsoupTools t=new JsoupTools();
	//	String urlpath="http://www.dyhjw.com/dyhjw/etf.html";
	//	String charset="utf-8";
		String html=t.getHtml(urlpath, charset);
		List<Etfjin> list=t.getEtf_jinList(html);
	//	String path="e:/ETF_jin.txt";
		t.saveETF_jinFile(list, path);
	//	t.showListETF_jin(list);
		boolean isOK=etf_jinService.addList(list);
		System.out.println("isOK="+isOK);
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Etf_jinHandler_addBatch.action")
	public String addBatch(String urlpath,String charset,String path){
		System.out.println("...Etf_jinHandler.....addBatch().......");
		JsoupTools t=new JsoupTools();
	//	String urlpath="http://www.dyhjw.com/dyhjw/etf.html";
	//	String charset="utf-8";
		String html=t.getHtml(urlpath, charset);
		List<Etfjin> list=t.getEtf_jinList(html);
	//	String path="e:/ETF_jin.txt";
		t.saveETF_jinFile(list, path);
	//	t.showListETF_jin(list);
	//	boolean isOK=etf_jinService.addList(list);
		boolean isOK=etf_jinService.addBatch(list);
		System.out.println("isOK="+isOK);
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Etf_jinHandler_getEdit.action")
	public String getEdit(HttpServletRequest request){
		System.out.println("....Etf_jinHandler........getEdit().....");
		JsoupTools t=new JsoupTools();
		String urlpath="http://www.dyhjw.com/dyhjw/etf.html";
		String charset="utf-8";
		String html=t.getHtml(urlpath, charset);
		List<Etfjin> list=t.getEtf_jinListTop10(html);
		boolean isOK=etf_jinService.setEtid(list);
		if(isOK){
			request.setAttribute("msg", "更新数据成功");
		}else{
			request.setAttribute("msg", "更新数据失败");
		}
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Etf_jinHandler_autoEdit.action")
	public String autoEdit(HttpServletRequest request){
		System.out.println("....Etf_jinHandler.....autoEdit.........");
		EtfThread t=new EtfThread();
		t.start();
		request.setAttribute("msg", "开始自动爬取更新数据");
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Etf_jinHandler_autoEdit2.action")
	public String autoEdit2(HttpServletRequest request){
		System.out.println("....Etf_jinHandler.....autoEdit2.........");
		EtfThread2 t=new EtfThread2();
		t.start();
		request.setAttribute("msg", "开始自动爬取更新数据");
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Etf_jinHandler_findAll.action")
	public String findAll(HttpServletRequest request){
		System.out.println("....Etf_jinHandler.....findAll.........");
		List<Etfjin> list=etf_jinService.findAll();
		request.setAttribute("list", list);
		return "forward:/showEtf.jsp";
	}
}
