package com.TouchAirDataTest1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonTargetMapper implements RowMapper<PersonTarget>{
	   public PersonTarget mapRow(ResultSet rs, int rowNum) throws SQLException {
		   PersonTarget personTarget = new PersonTarget();
		   personTarget.setPsnid(rs.getString("psnid"));
		   personTarget.setTargetnumber(rs.getString("targetnumber"));
		   personTarget.setIfchosen(rs.getString("ifchosen"));
		   return personTarget;
		   }
}
