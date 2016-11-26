package com.TouchAirDataTest1;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonTargetJDBCTemplate implements PersonTargetDAO {
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		   }

		   public void insertPersonTarget(String psnid,String targetnumber, String ifchosen){
		      String SQL = "insert into PersonTarget (psnid, targetNumber, ifchosen) values (?, ?,?)";
		      
		      jdbcTemplateObject.update( SQL, psnid, targetnumber,ifchosen);
		      return;
		   }
}
