package com.TouchAirDataTest1;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class PersonInfoJDBCTemplate implements com.TouchAirDataTest1.PersonInfoDAO {
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   private String ColumnName;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   
	   public List<com.TouchAirDataTest1.PersonInfo> listPersonInfos() {
		      String SQL = "select psnid from PersonInfo";
		      List <com.TouchAirDataTest1.PersonInfo> personInfos = jdbcTemplateObject.query(SQL,
		                                new com.TouchAirDataTest1.PersonInfoMapper());
		      return personInfos;
		   }
	   
	   //多线程时  实施接口新增了一个方法
	   public List<com.TouchAirDataTest1.PersonInfo> listPersonInfos(int numberOfThread, int threadId) {
		      String SQL = "select psnid from PersonInfo where mod(psnid,?)=?";  //多线程分配哪条数据由哪一个线程读取
		      List <com.TouchAirDataTest1.PersonInfo> personInfos = jdbcTemplateObject.query(SQL,
		    		  new Object[]{numberOfThread,threadId},new com.TouchAirDataTest1.PersonInfoMapper());
		      return personInfos;
		   }
	   
	   
	   public void updatePersonInfo(String ColumnName, String ColumnValue , String psnId) {
		      String SQL = "update PersonInfo set "+ColumnName+" = ? where psnId = ?";		      
		      jdbcTemplateObject.update( SQL, ColumnValue, psnId);
		      return;
		   }
	
	   
}
