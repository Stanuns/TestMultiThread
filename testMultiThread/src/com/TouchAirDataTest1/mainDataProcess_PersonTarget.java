package com.TouchAirDataTest1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//多线程处理数据

public class mainDataProcess_PersonTarget {
	public static void main(String[] args) {
	      ApplicationContext context = 
		             new ClassPathXmlApplicationContext("Beans_JDBC_TouchairTest.xml");

		      com.TouchAirDataTest1.PersonInfoJDBCTemplate personInfoJDBCTemplate =
		    		  (com.TouchAirDataTest1.PersonInfoJDBCTemplate)context.getBean("PersonInfoJDBCTemplate");
		      com.TouchAirDataTest1.AnswersJDBCTemplate answersJDBCTemplate =
		    	      (com.TouchAirDataTest1.AnswersJDBCTemplate)context.getBean("AnswersJDBCTemplate");
		      com.TouchAirDataTest1.PersonTargetJDBCTemplate personTargetJDBCTemplate =
		    	      (com.TouchAirDataTest1.PersonTargetJDBCTemplate)context.getBean("PersonTargetJDBCTemplate");
		      System.out.println("----producing PersonTarget -----" );
		      
			  //先从PersonInfo表取出各个psnid
		      List<com.TouchAirDataTest1.PersonInfo> personInfos =personInfoJDBCTemplate.listPersonInfos();

		      for (com.TouchAirDataTest1.PersonInfo personInfo : personInfos) {
			         String psnid=personInfo.getPsnid();
			         List<com.TouchAirDataTest1.Answers> answers=answersJDBCTemplate.listAnswer(psnid,"517"); //多选题
			         
			         for(int i=1;i<=7;i++){
			        	 String j=String.valueOf(i);
			        	 boolean flag = true;
			        		 for(com.TouchAirDataTest1.Answers answer:answers){
			        			 String anstitle=answer.getAnstitle();
			        			 if(j.equals(anstitle.substring(0,anstitle.indexOf(".")))){			        	 
			        				 personTargetJDBCTemplate.insertPersonTarget(psnid, j, "1");
			        				 flag = false;
			        			 }
			        		 }
			        		 if(flag){
			        			 personTargetJDBCTemplate.insertPersonTarget(psnid, j, "-1");
			        		 }
			         }   
		      		      
		      }
	}
}
