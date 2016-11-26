package com.TouchAirDataTest1;

import javax.sql.DataSource;
import java.util.List;

public interface PersonInfoDAO {
	   public void setDataSource(DataSource ds);
	   public List<PersonInfo> listPersonInfos();
	   public void updatePersonInfo(String ColumnName, String ColumnValue , String psnId);
}
