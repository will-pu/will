package com.neusoft.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.bean.Etfyin;
import com.neusoft.jsoup.JsoupTools;
import com.neusoft.service.EtfyinService;
import com.neusoft.thread.EtfThread;

@Controller
public class EtfyinHandler {
	@Autowired
	private EtfyinService etf_yinService;
	
	@RequestMapping(value="test/Etf_yinHandler_add.action")
	public String add(){
		System.out.println("...Etf_yinHandler.....add().......");
		Etfyin e=new Etfyin();
		e.setJingChiCangLiang(1000);
		e.setMeiYuan(6000);
		e.setPrice(1412.5);
		e.setTime("2019-06-24");
		e.setYingXiang("利多金银");
		e.setZengJian(2.8);
		boolean isOK=etf_yinService.add(e);
		System.out.println("isOK="+isOK);
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Etf_yinHandler_addList.action")
	public String addList(String urlpath,String charset,String path){
		System.out.println("...Etf_yinHandler.....addList().......");
		JsoupTools t=new JsoupTools();
		String html=t.getHtml(urlpath, charset);
		List<Etfyin> list=t.getEtf_yinList(html);
		t.saveETF_yinFile(list, path);
		boolean isOK=etf_yinService.addList(list);
		System.out.println("isOK="+isOK);
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Etf_yinHandler_addBatch.action")
	public String addBatch(String urlpath,String charset,String path){
		System.out.println("...Etf_jinHandler.....addBatch().......");
		JsoupTools t=new JsoupTools();	
		String html=t.getHtml(urlpath, charset);
		List<Etfyin> list=t.getEtf_yinList(html);	
		t.saveETF_yinFile(list, path);
		boolean isOK=etf_yinService.addBatch(list);
		System.out.println("isOK="+isOK);
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Etf_yinHandler_getEdit.action")
	public String getEdit(HttpServletRequest request){
		System.out.println("....Etf_yinHandler........getEdit().....");
		JsoupTools t=new JsoupTools();
		String urlpath="http://www.dyhjw.com/dyhjw/slv_etf.html";
		String charset="utf-8";
		String html=t.getHtml(urlpath, charset);
		List<Etfyin> list=t.getEtf_yinListTop10(html);
		boolean isOK=etf_yinService.setEtid(list);
		if(isOK){
			request.setAttribute("msg", "更新数据成功");
		}else{
			request.setAttribute("msg", "更新数据失败");
		}
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="test/Etf_yinHandler_autoEdit.action")
	public String autoEdit(HttpServletRequest request){
		System.out.println("....Etf_yinHandler.....autoEdit.........");
		EtfThread t=new EtfThread();
		t.start();
		request.setAttribute("msg", "开始自动爬取更新数据");
		return "forward:/msg.jsp";
	}
	
	@RequestMapping(value="test/Etf_yinHandler_findAll.action")
	public String findAll(HttpServletRequest request){
		System.out.println("....Etf_yinHandler.....findAll.........");
		List<Etfyin> list=etf_yinService.findAll();
		request.setAttribute("list", list);
		return "forward:/showEtf.jsp";
	}
	//结束
	@RequestMapping(value="test/Etf_yinHandler_closeEdit.action")						
		   public static String main(HttpServletRequest request) throws Exception  
		    {  
		        EtfThread t=new EtfThread();  
		        EtfThread.exit = false;
		        t.start();		        
		        
		        System.out.println("!");  		         		          
		        t.join();  
		        request.setAttribute("msg","停止自动爬取更新数据");
				return "forward:/msg.jsp";
		    }


}
