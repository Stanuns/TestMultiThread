package com.TouchAirDataTest1;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonInfoMapper implements RowMapper<PersonInfo> {
	   public PersonInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		   PersonInfo personInfo = new PersonInfo();
		   personInfo.setPnsid(rs.getString("psnid"));
		   return personInfo;
		   }
}