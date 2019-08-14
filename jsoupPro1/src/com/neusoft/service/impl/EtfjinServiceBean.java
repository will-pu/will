package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Etfjin;
import com.neusoft.dao.EtfDao;
import com.neusoft.jdbc.JDBCutil;
import com.neusoft.mapper.EtfjinMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.service.EtfjinService;
import com.neusoft.tools.FilteTools;

@Service
public class EtfjinServiceBean implements EtfjinService {
	@Autowired
	private EtfDao etfDao;

	@Override
	public boolean add(Etfjin e) {
		System.out.println("...Eft_jinServiceBean....add().......");
		boolean isOK = false;
		SqlSession session = SqlSessionUtil.openSession();
		EtfjinMapper mapper = session.getMapper(EtfjinMapper.class);
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
	public boolean addList(List<Etfjin> list) {
		System.out.println("...Eft_jinServiceBean....addList().......");
		boolean isOK = false;
		SqlSession session = SqlSessionUtil.openSession();
		EtfjinMapper mapper = session.getMapper(EtfjinMapper.class);
		try {
			for (Etfjin e : list) {
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
	public boolean addBatch(List<Etfjin> list) {
		System.out.println("....EtfjinServiceBean.....addBatch().......");
		boolean isOK = false;
		JDBCutil db = new JDBCutil();
		db.getConnection();
		try {
			etfDao.addBatch(list);
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
	public boolean setEtid(List<Etfjin> listTop10) {
		System.out.println("....EtfjinServiceBean.....setEtid().......");
		boolean isOK = false;
		SqlSession session = SqlSessionUtil.openSession();
		EtfjinMapper mapper = session.getMapper(EtfjinMapper.class);
		try {
			Etfjin e = mapper.findNew();
			System.out.println("====新爬下数据=====");
			for (Etfjin j : listTop10) {
				System.out.println(j.getId() + "\t" + j.getTime() + "\t" + j.getJingChiCangLiang() + "\t"
						+ j.getMeiYuan() + "\t" + j.getZengJian() + "\t" + j.getYingXiang() + "\t" + j.getPrice() + "\t"
						+ j.getTime2());
			}
			System.out.println("====数据库数据=====");
			System.out.println(e.getId() + "\t" + e.getTime() + "\t" + e.getJingChiCangLiang() + "\t" + e.getMeiYuan()
					+ "\t" + e.getZengJian() + "\t" + e.getYingXiang() + "\t" + e.getPrice() + "\t" + e.getTime2());
			System.out.println("==========需要更新数据=========");
			for (Etfjin etfTop10 : listTop10) {
				if (!etfTop10.getTime().equals(e.getTime())) {
					System.out.println(etfTop10.getId() + "\t" + etfTop10.getTime() + "\t"
							+ etfTop10.getJingChiCangLiang() + "\t" + etfTop10.getMeiYuan() + "\t"
							+ etfTop10.getZengJian() + "\t" + etfTop10.getYingXiang() + "\t" + etfTop10.getPrice()
							+ "\t" + etfTop10.getTime2());
					int count = mapper.add(etfTop10);
				} else {
					break;
				}
			}
			session.commit();
			isOK = true;
		} catch (SQLException e) {
			session.rollback();
			e.printStackTrace();
			isOK = false;
		} finally {
			session.close();
		}
		return isOK;
	}

	@Override
	public boolean setEtid2(List<Etfjin> listTop10) {
		System.out.println("....EtfjinServiceBean.....setEtid2().......");
		boolean isOK = false;

		FilteTools f = new FilteTools();
		String path = "E:/ETF/ETF_newTime.txt";
		// Etfjin e = mapper.findNew();
		String time = f.getEtfTime(path);
		System.out.println("====新爬下数据=====");
		for (Etfjin j : listTop10) {
			System.out.println(j.getId() + "\t" + j.getTime() + "\t" + j.getJingChiCangLiang() + "\t" + j.getMeiYuan()
					+ "\t" + j.getZengJian() + "\t" + j.getYingXiang() + "\t" + j.getPrice() + "\t" + j.getTime2());
		}
		System.out.println("====数据库数据=====");
		System.out.println("文件中time=" + time);
		System.out.println("==========需要更新数据=========");
		for (Etfjin etfTop10 : listTop10) {
			if (!etfTop10.getTime().equals(time)) {
				System.out.println(etfTop10.getId() + "\t" + etfTop10.getTime() + "\t" + etfTop10.getJingChiCangLiang()
						+ "\t" + etfTop10.getMeiYuan() + "\t" + etfTop10.getZengJian() + "\t" + etfTop10.getYingXiang()
						+ "\t" + etfTop10.getPrice() + "\t" + etfTop10.getTime2());
				SqlSession session = SqlSessionUtil.openSession();
				EtfjinMapper mapper = session.getMapper(EtfjinMapper.class);
				try {
					int count = mapper.add(etfTop10);
					session.commit();
					isOK = true;
				} catch (Exception e) {
					session.rollback();
					e.printStackTrace();
					isOK = false;
				} finally {
					session.close();
				}
			} else {
				break;
			}
			String newTime = (listTop10.get(0)).getTime();
			boolean isOK_time = f.setEtfTime(path, newTime);
			System.out.println("更新ETF_time文件=" + isOK_time);
		}
		return isOK;
	}

	@Override
	public List<Etfjin> findAll() {
		System.out.println("....EtfjinServiceBean.....findAll().......");
		List<Etfjin> list=new ArrayList<>();
		SqlSession session=SqlSessionUtil.openSession();
		EtfjinMapper mapper=session.getMapper(EtfjinMapper.class);
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
