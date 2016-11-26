package com.TouchAirDataTest1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AnswersMapper implements RowMapper<Answers>{
	   public Answers mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Answers answers = new Answers();
		   
		   	answers.setAnsid(rs.getString("ansid"));
		   	answers.setAnstitle(rs.getString("anstitle"));
		   	answers.setQusid(rs.getString("qusid"));
		      return answers;
		   }
}
