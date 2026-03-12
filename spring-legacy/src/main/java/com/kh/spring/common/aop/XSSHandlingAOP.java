package com.kh.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.kh.spring.board.model.vo.BoardExt;
import com.kh.spring.common.util.Utils;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class XSSHandlingAOP {
	
	@AfterReturning(pointcut="CommonPointcut.boardPoint()", returning = "returnObj")
	public void XssHandle(JoinPoint jp, Object returnObj ) {
		// 반환형이 boardExt인 경우(게시판 상세보기, 게시판 수정하기)
		// boardExt내부의 값중 제목과, 내용을 꺼내서 XSS방어처리
		if(returnObj instanceof BoardExt) {
			BoardExt b = (BoardExt) returnObj;
			b.setBoardContent(Utils.XSSHandling(b.getBoardContent())); //보드 안에 내용 방어처리
			b.setBoardTitle(Utils.XSSHandling(b.getBoardTitle())); //보드 타이틀 방어처리
			b.setBoardContent(Utils.newLineHandling(b.getBoardContent()));// 보드 내용 계행처리
		}
	}
	
}
