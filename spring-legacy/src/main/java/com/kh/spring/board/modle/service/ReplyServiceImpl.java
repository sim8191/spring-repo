package com.kh.spring.board.modle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.board.modle.dao.ReplyDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
	
	private final ReplyDao rDao;
	
	@Override
	public int insertReply(Reply r) {
		// TODO Auto-generated method stub
		return rDao.insertReply(r);
	}

	@Override
	public List<Reply> selectList(int boardNo) {
		
		return rDao.selectList(boardNo);
	}

	@Override
	public int deleteReply(Reply r) {
		// TODO Auto-generated method stub
		return rDao.deleteReply(r);
	}
	
}
