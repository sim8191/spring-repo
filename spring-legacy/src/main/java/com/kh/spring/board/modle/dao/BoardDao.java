package com.kh.spring.board.modle.dao;

import java.util.List;
import java.util.Map;

import com.kh.spring.board.model.vo.BoardImg;
import com.kh.spring.member.model.vo.Board;

public interface BoardDao {

	Map<String, String> getBoardTypeMap();

	List<Board> selectList(Map<String, Object> paramMap);

	int selectListCount(Map<String, Object> paramMap);

	int insertBoard(Board b);

	int insertBoardImg(BoardImg bi);

	int insertBoardImgList(List<BoardImg> imgList);

}
