package com.neusoft.service;

import java.util.List;

import com.neusoft.bean.Etfyin;

public interface EtfyinService {
	public boolean add(Etfyin e);
	public boolean addList(List<Etfyin> list);
	public boolean addBatch(List<Etfyin> list);
	public boolean setEtid(List<Etfyin> listTop10);
	public List<Etfyin> findAll();
}
