package com.kh.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class AfterThrowingTest {
	// 이거는 확인하고 싶으면 일부러 오류를 내야함
	@AfterThrowing(pointcut="CommonPointcut.commonPoint()"
			, throwing = "exceptionObj")
	public void returnException(JoinPoint jp, Exception exceptionObj) {
		StringBuilder sb = new StringBuilder();
		sb.append("Exception : "+exceptionObj.getStackTrace()[0]+"\n");
		sb.append("에러메시지 : "+exceptionObj.getMessage()+"\n");
		log.debug(sb.toString());
		
	}
	
}
