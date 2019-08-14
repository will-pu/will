package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Etfjin;
import com.neusoft.bean.Etfyin;
import com.neusoft.dao.EtfDao;
import com.neusoft.jdbc.JDBCutil;
import com.neusoft.mapper.EtfjinMapper;
import com.neusoft.mapper.EtfyinMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.service.EtfyinService;

@Service
public class EtfyinServiceBean implements EtfyinService {
	@Autowired
	private EtfDao etfDao;

	@Override
	public boolean add(Etfyin e) {
		System.out.println("...Eft_yinServiceBean....add().......");
		boolean isOK = false;
		SqlSession session = SqlSessionUtil.openSession();
		EtfyinMapper mapper = session.getMapper(EtfyinMapper.class);
		try {
			int count = mapper.add(e);
			if (count > 0) {
				session.commit();
				isOK = true;
				System.out.println("添加操作成功,数据提交");
			} else {
				session.rollback();
				isOK = false;
				System.out.println("添加操作失败,数据回滚1");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			session.rollback();
			isOK = false;
			System.out.println("添加操作失败,数据回滚2");
		} finally {
			session.close();
		}
		return isOK;
	}

	@Override
	public boolean addList(List<Etfyin> list) {
		System.out.println("...Eft_yinServiceBean....addList().......");
		boolean isOK = false;
		SqlSession session = SqlSessionUtil.openSession();
		EtfyinMapper mapper = session.getMapper(EtfyinMapper.class);
		try {
			for (Etfyin e : list) {
				mapper.add(e);
			}
			session.commit();
			isOK = true;
		} catch (Exception e) {
			session.rollback();
			isOK = false;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isOK;
	}

	@Override
	public boolean addBatch(List<Etfyin> list) {
		System.out.println("....EtfyinServiceBean.....addBatch().......");
		boolean isOK = false;
		JDBCutil db = new JDBCutil();
		db.getConnection();
		try {
			etfDao.addBatch2(list);
			System.out.println("批处理成功");
			isOK = true;
		} catch (SQLException e) {
			System.out.println("批处理失败");
			e.printStackTrace();
			isOK = false;
		} finally {
			db.close();
		}
		return isOK;
	}

	@Override
	public boolean setEtid(List<Etfyin> listTop10) {
		System.out.println("....EtfyinServiceBean.....setEtid().......");
		boolean isOK=false;
		SqlSession session = SqlSessionUtil.openSession();
		EtfyinMapper mapper = session.getMapper(EtfyinMapper.class);
		try {
			Etfyin e = mapper.findNew();
			System.out.println("====新爬下数据=====");
			for (Etfyin j : listTop10) {
				System.out.println(j.getId() + "\t" + j.getTime() + "\t" + j.getJingChiCangLiang() + "\t"
						+ j.getMeiYuan() + "\t" + j.getZengJian() + "\t" + j.getYingXiang() + "\t" + j.getPrice() + "\t"
						+ j.getTime2());
			}
			System.out.println("====数据库数据=====");
			System.out.println(e.getId() + "\t" + e.getTime() + "\t" + e.getJingChiCangLiang() + "\t" + e.getMeiYuan()
					+ "\t" + e.getZengJian() + "\t" + e.getYingXiang() + "\t" + e.getPrice() + "\t" + e.getTime2());
			System.out.println("==========需要更新数据=========");
			for (Etfyin etfTop10 : listTop10) {
				if (!etfTop10.getTime().equals(e.getTime())) {
					System.out.println(etfTop10.getId() + "\t" + etfTop10.getTime() + "\t" + etfTop10.getJingChiCangLiang() + "\t"
							+ etfTop10.getMeiYuan() + "\t" + etfTop10.getZengJian() + "\t" + etfTop10.getYingXiang() + "\t" + etfTop10.getPrice()
							+ "\t" + etfTop10.getTime2());
					int count=mapper.add(etfTop10);
				}else{
					break;
				}
			}
			session.commit();
			isOK=true;
		} catch (SQLException e) {
			session.rollback();
			e.printStackTrace();
			isOK=false;
		} finally {
			session.close();
		}
		return isOK;
	}
	
	@Override
	public List<Etfyin> findAll() {
		System.out.println("....EtfyinServiceBean.....findAll().......");
		List<Etfyin> list=new ArrayList<>();
		SqlSession session=SqlSessionUtil.openSession();
		EtfyinMapper mapper=session.getMapper(EtfyinMapper.class);
		try {
			list=mapper.findAll();
		} catch (SQLException e) {
			list=null;
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("list.size="+list.size());
		return list;
	}

}
