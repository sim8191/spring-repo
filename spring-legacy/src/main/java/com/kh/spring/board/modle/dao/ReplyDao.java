package com.kh.spring.board.modle.dao;

import java.util.List;

import com.kh.spring.board.model.vo.Reply;

public interface ReplyDao {

	int insertReply(Reply r);

	List<Reply> selectList(int boardNo);

	int deleteReply(Reply r);

}
