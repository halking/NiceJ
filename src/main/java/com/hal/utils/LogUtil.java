package com.hal.utils;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil{
		
	public static Logger initLog(Class clazz){
		Logger logger = LoggerFactory.getLogger(clazz);
		
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		return logger;
	}
}
