package com.kh.spring.board.modle.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.kh.spring.board.modle.dao.BoardDao;
import com.kh.spring.member.model.vo.Board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardDao boardDao;
	
	@Override
	public Map<String, String> getBoardTypeMap() {
		// TODO Auto-generated method stub
		return boardDao.getBoardTypeMap();
	}

	@Override
	public List<Board> selectList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return boardDao.selectList(paramMap);
	}
	
}
