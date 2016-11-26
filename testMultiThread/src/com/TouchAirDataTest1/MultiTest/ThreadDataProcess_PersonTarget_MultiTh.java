package com.TouchAirDataTest1.MultiTest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.TouchAirDataTest1.Answers;
import com.TouchAirDataTest1.AnswersJDBCTemplate;
import com.TouchAirDataTest1.PersonInfo;
import com.TouchAirDataTest1.PersonInfoJDBCTemplate;
import com.TouchAirDataTest1.PersonTargetJDBCTemplate;

public class ThreadDataProcess_PersonTarget_MultiTh implements Runnable{
	
	private int numberOfThread;
	private int threadId;
	public ThreadDataProcess_PersonTarget_MultiTh(int numberOfThread,int threadId) {
		this.numberOfThread = numberOfThread;
		this.threadId = threadId;		
	   }
	
	@Override
	public  void run() {
		synchronized(this) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans_JDBC_TouchairTest.xml");

	      PersonInfoJDBCTemplate personInfoJDBCTemplate = 
	    		  (PersonInfoJDBCTemplate)context.getBean("PersonInfoJDBCTemplate");		      
	      AnswersJDBCTemplate answersJDBCTemplate = 
	    	      (AnswersJDBCTemplate)context.getBean("AnswersJDBCTemplate");
	      com.TouchAirDataTest1.MultiTest.PersonTarget_MultiThJDBCTemplate personTarget_MultiThJDBCTemplate =
	    	      (com.TouchAirDataTest1.MultiTest.PersonTarget_MultiThJDBCTemplate)context.getBean("PersonTarget_MultiThJDBCTemplate");
	      System.out.println("----producing PersonTarget_MultiTh -----" );
	      
		  //先从PersonInfo表取出各个psnid
	      List<PersonInfo> personInfos =personInfoJDBCTemplate.listPersonInfos(numberOfThread,threadId);
	      
	      
	      for (PersonInfo personInfo : personInfos) {
		         String psnid=personInfo.getPsnid();
		         List<Answers> answers=answersJDBCTemplate.listAnswer(psnid,"517"); //多选题
		         
		         for(int i=1;i<=7;i++){
		        	 String j=String.valueOf(i);
		        	 boolean flag = true;
		        	 try{
		        		 for(Answers answer:answers){
		        			 String anstitle=answer.getAnstitle();
		        			 if(j.equals(anstitle.substring(0,anstitle.indexOf(".")))){			        	 
		        				 personTarget_MultiThJDBCTemplate.insertPersonTarget_MultiTh(psnid, j, "1");
		        				 flag = false;
		        			 }
		        		 }
		        		 if(flag){
		        			 personTarget_MultiThJDBCTemplate.insertPersonTarget_MultiTh(psnid, j, "-1");
		        		 }
		      	      }catch(Exception e){	 
		      	    	  
		    	      }
		         	}   	      		      
	      	}

	      
	   }
	}
}
