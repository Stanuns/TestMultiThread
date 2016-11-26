package com.TouchAirDataTest1.MultiTest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonTarget_MultiThMapper {
	   public PersonTarget_MultiTh mapRow(ResultSet rs, int rowNum) throws SQLException {
		   PersonTarget_MultiTh personTarget_MultiTh = new PersonTarget_MultiTh();
		   personTarget_MultiTh.setPsnid(rs.getString("psnid"));
		   personTarget_MultiTh.setTargetnumber(rs.getString("targetnumber"));
		   personTarget_MultiTh.setIfchosen(rs.getString("ifchosen"));
		   return personTarget_MultiTh;
		   }
}
