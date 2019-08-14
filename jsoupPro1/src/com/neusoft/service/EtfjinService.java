package com.neusoft.service;


import java.util.List;

import com.neusoft.bean.Etfjin;

public interface EtfjinService {
	public boolean add(Etfjin e);
	public boolean addList(List<Etfjin> list);
	public boolean addBatch(List<Etfjin> list);
//	public Etfjin findNew();
	public boolean setEtid(List<Etfjin> listTop10);
	public boolean setEtid2(List<Etfjin> listTop10);
	public List<Etfjin> findAll();
}
