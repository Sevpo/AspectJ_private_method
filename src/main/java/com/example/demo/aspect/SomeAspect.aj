package com.example.demo.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.annotation.MyException;
import com.example.demo.annotation.PrivateException;

public aspect SomeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	 void around (PrivateException annotationPrivateException): @annotation(annotationPrivateException){
		 logger.info(thisJoinPoint + " -> " + annotationPrivateException);
		try {
			proceed(annotationPrivateException);
		}catch (RuntimeException e) {
			logger.info("Exception handled by aspect in private method -> {}", e.getMessage());
			try {
				throw new MyException("MyException was thrown");
			}
			catch (MyException e1) {
				logger.debug(e1.getLocalizedMessage());
			}
		}
	}
}
