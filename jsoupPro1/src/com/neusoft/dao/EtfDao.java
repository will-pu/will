package com.neusoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Etfjin;
import com.neusoft.bean.Etfyin;

public interface EtfDao {
	public void addBatch(List<Etfjin> list) throws SQLException;
	public void addBatch2(List<Etfyin> list) throws SQLException;
}
