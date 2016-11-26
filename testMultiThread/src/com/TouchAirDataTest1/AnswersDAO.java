package com.TouchAirDataTest1;

import java.util.List;

import javax.sql.DataSource;

public interface AnswersDAO {
	   public void setDataSource(DataSource ds);

	   public List<Answers> listAnswer(String psnId);
}
