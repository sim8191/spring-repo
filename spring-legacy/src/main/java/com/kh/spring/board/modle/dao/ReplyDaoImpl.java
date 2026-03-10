package com.kh.spring.board.modle.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Reply;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReplyDaoImpl implements ReplyDao {
	
	private final SqlSessionTemplate session;
	
	@Override
	public int insertReply(Reply r) {
		
		return session.insert("board.insertReply",r);
	}

	@Override
	public List<Reply> selectList(int boardNo) {
		// TODO Auto-generated method stub
		return session.selectList("board.selectReplyList",boardNo);
	}

	@Override
	public int deleteReply(Reply r) {
		// TODO Auto-generated method stub
		return session.delete("board.deleteReply",r);
	}

}
