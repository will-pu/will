package com.neusoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Etfjin;

public interface EtfDao {
	public void addBatch(List<Etfjin> list) throws SQLException;
}
