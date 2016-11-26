package com.TouchAirDataTest1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class mainDataProcess_PersonInfo {
	public static void main(String[] args) {
	      ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans_JDBC_TouchairTest.xml");

	      com.TouchAirDataTest1.PersonInfoJDBCTemplate personInfoJDBCTemplate =
	      (com.TouchAirDataTest1.PersonInfoJDBCTemplate)context.getBean("PersonInfoJDBCTemplate");
	      
	      com.TouchAirDataTest1.AnswersJDBCTemplate answersJDBCTemplate =
	    	      (com.TouchAirDataTest1.AnswersJDBCTemplate)context.getBean("AnswersJDBCTemplate");

	      System.out.println("----Updating PersonInfo -----" );
	      
	    //先从PersonInfo表取出各个psnid
	      List<com.TouchAirDataTest1.PersonInfo> personInfos =personInfoJDBCTemplate.listPersonInfos();

	      for (com.TouchAirDataTest1.PersonInfo personInfo : personInfos) {
		         String psnid=personInfo.getPsnid();
//		         System.out.println("psnid : " + psnid );
		         //对每个psnid找出所需要对应的answers表中的anstitle字段
		         List<com.TouchAirDataTest1.Answers> answers=answersJDBCTemplate.listAnswer(psnid);
		         for(com.TouchAirDataTest1.Answers answer:answers){
		        	 String anstitle=answer.getAnstitle();
		        	 String qusid=answer.getQusid();
//		        	 System.out.println("anstitle : " + anstitle +". qusid:" +qusid);
		        	 
		        	 if(qusid.equals("515")){
		        		 String ColumnName="industry_category"+anstitle.substring(0,anstitle.indexOf(".") );
		        		 personInfoJDBCTemplate.updatePersonInfo(ColumnName, "1",psnid);
		        	 }else if(qusid.equals("516")){
		        		 String ColumnName="job_category"+anstitle.substring(0,anstitle.indexOf(".") );
		        		 personInfoJDBCTemplate.updatePersonInfo(ColumnName, "1",psnid);
		        	 }else if(qusid.equals("518")){
		        		 String ColumnName="channel_known"+anstitle.substring(0,anstitle.indexOf(".") );
		        		 personInfoJDBCTemplate.updatePersonInfo(ColumnName, "1",psnid);
		        	 }		        	 		        	 
		         }
		         		         
	      } 
		         
		         
		      
		  
	   }
}
