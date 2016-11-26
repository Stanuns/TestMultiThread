package com.TouchAirDataTest1;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class AnswersJDBCTemplate implements AnswersDAO{
	   private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;

	   public void setDataSource(DataSource dataSource) {
		      this.dataSource = dataSource;
		      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		   }
		   
		   
	   public List<Answers> listAnswer(String psnId) {
		      String SQL = "select t.* from testUser_jdbc.Answers t where t.ansid in (select c.ansid from testUser_jdbc.AnswerAndQuestion c where c.pasid in (select b.pasid from testUser_jdbc.PersonAnswers b where b.psnid = ?))";
		      List<Answers> answers = jdbcTemplateObject.query(SQL, 
		                        new Object[]{psnId}, new AnswersMapper());
		      return answers;
		   }
	   
	   public List<Answers> listAnswer(String psnId,String qusid) {
		      String SQL = "select t.* from testUser_jdbc.Answers t where t.ansid in (select c.ansid from testUser_jdbc.AnswerAndQuestion c where c.pasid in (select b.pasid from testUser_jdbc.PersonAnswers b where b.psnid = ?)) and t.qusid= ? ";
		      List<Answers> answers = jdbcTemplateObject.query(SQL, 
		                        new Object[]{psnId,qusid}, new AnswersMapper());
		      return answers;
		   }
}
