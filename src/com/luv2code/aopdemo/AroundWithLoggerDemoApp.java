package com.luv2code.aopdemo;

import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
									//Hey context give me the bean from AccountDAO class
		
		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune(false);
		
		myLogger.info("\nMy fortune is: " + data);
		
		myLogger.info("Finished");
		
		//close the context
		context.close();
	}

}
