package com.TouchAirDataTest1.MultiTest;

import javax.sql.DataSource;

public interface PersonTarget_MultiThDAO {
	   public void setDataSource(DataSource ds);
	   public void insertPersonTarget_MultiTh(String psnid,String targetnumber, String ifchosen);
}
