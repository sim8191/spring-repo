package com.kh.spring.board.modle.service;

import java.util.List;

import com.kh.spring.board.model.vo.Reply;

public interface ReplyService {

	int insertReply(Reply r);

	List<Reply> selectList(int boardNo);

	int deleteReply(Reply r);

}
