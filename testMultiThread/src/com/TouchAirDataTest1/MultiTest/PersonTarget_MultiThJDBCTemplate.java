package com.TouchAirDataTest1.MultiTest;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonTarget_MultiThJDBCTemplate implements PersonTarget_MultiThDAO{
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		   }

		   public void insertPersonTarget_MultiTh(String psnid,String targetnumber, String ifchosen){
		      String SQL = "insert into PersonTarget_MultiTh (psnid, targetNumber, ifchosen) values (?, ?,?)";
		      
		      jdbcTemplateObject.update( SQL, psnid, targetnumber,ifchosen);
		      return;
		   }
}
