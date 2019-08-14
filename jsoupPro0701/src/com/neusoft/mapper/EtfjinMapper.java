package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Etfjin;

public interface EtfjinMapper {
	public int add(Etfjin e) throws SQLException;
	public Etfjin findNew() throws SQLException;
	public List<Etfjin> findAll() throws SQLException;
}
