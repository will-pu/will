package com.neusoft.mapper;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Etfjin;
import com.neusoft.bean.Etfyin;

public interface EtfyinMapper {
	public int add(Etfyin e) throws SQLException;
	public Etfyin findNew() throws SQLException;
	public List<Etfyin> findAll() throws SQLException;
}
