package com.TouchAirDataTest1;

import java.util.List;

import javax.sql.DataSource;

public interface PersonTargetDAO {
	   public void setDataSource(DataSource ds);
	   public void insertPersonTarget(String psnid,String targetnumber, String ifchosen);
}
