package com.TouchAirDataTest1.MultiTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class mainMulThDataProc_PersonTarget {
	public static void main(String[] args) {
//		ExecutorService pool=Executors.newCachedThreadPool();//创建一个固定大小为5的线程池  
//		for(int i=0;i<1;i++){  
//			pool.submit(new ThreadDataProcess_PersonTarget());  
//		}  
//		pool.shutdown(); 
		
		int NumberOfThread=7;
		ApplicationContext ctx =  new ClassPathXmlApplicationContext("Beans_JDBC_TouchairTest.xml");
		ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor)ctx.getBean("taskExecutor");
		for(int i=0;i<NumberOfThread;i++){  
			taskExecutor.execute(new com.TouchAirDataTest1.MultiTest.ThreadDataProcess_PersonTarget_MultiTh(NumberOfThread,i));
		}
	}	
}
