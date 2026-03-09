package com.kh.spring.board.modle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.BoardExt;
import com.kh.spring.board.model.vo.BoardImg;
import com.kh.spring.common.model.vo.PageInfo;
import com.kh.spring.member.model.vo.Board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao {
	
	public final SqlSessionTemplate session;
	
	@Override
	public Map<String, String> getBoardTypeMap() {
		/*
		 * selectMap
		 *  - Map<KEY, VALUE> 형태의 값을 반환하는 메서드
		 *  - 두번째 매개변수로는 어떤 칼럼을 KEY값으로 사용하지를 자성한다.
		 *  - SELECT KEY, VALUE FROM TABLE
		 * 
		 * */
		return session.selectMap("board.getBoardTypeMap", "boardCd");
	}

	@Override
	public List<Board> selectList(Map<String, Object> paramMap) {
		/*
		 * 특정 페이지의 데이터를 가져오는 방법들(페이징 처리)
		 * 1. ROWNUM, ROW_NUMBER()로 페이징 처리된 쿼리 조회하기.
		 * SELECT * FROM(
		 * 		SELECT ROWNUM AS RNUM, T.*
		 * 		FROM(SELECT ...)T)
		 * WHERE RNUM BETWEEN A AND B;
		 * 
		 * 2. OFFSET FETCH 사용하여 쿼리 조회(오라클 12이상 사용가능)
		 *  - 코드의 복잡성을 줄이고 가독성을 크게 확보한 페이징 방식
		 * SELECT 조회할 컬럼
		 * FROM 테이블
		 * ... 조건절
		 * ORDER BY 절
		 * OFFSET 시작행 ROWS FETCH NEXT 조회할 개수 ROWS ONLY
		 * 
		 * 3. RowBounds를 활용한 방식
		 *  - myBatis에서 쿼리 결과에 대해 페이징 처리를 적용해주는 도구
		 *  - 전체 쿼리결과를 자바어플리케이션으로 가져온 후, 지정한 위치(offset)에서
		 *    특정 개수(limit)를 잘라내는 방식으로 페이징 처릴르 진행한다.
		 *  - 오라클 offset fetch문법과 비슷하여, 어플리케이션으로 가져올 데이터가
		 *  수만건 이상인 경우, 심긱한 메모리낭비 및 성능저하가 발생할 수 있다. 
		 *  - "소규모 데이터 쿼리"시 사용하는 것을 권장.
		 * */ 
		// 1. Rowbounds를 활용한 페이징처리(데이터가 많은 환경에서는 쓰는것을 비권장)
		// 몇 번째 행부터 몇개를 가져올지를 지정.
		PageInfo pi = (PageInfo) paramMap.get("pi");
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
//		RowBounds rowBounds = new RowBounds(offset, limit);
//		
//		return session.selectList("board.selectList", paramMap, rowBounds);
		// 2. Rownum을 활용한 페이징 처리
		paramMap.put("offset",offset + 1); // 10, 20
		paramMap.put("limit",limit+offset); // 20, 30
		
		return session.selectList("board.selectList",paramMap);
		
	}

	@Override
	public int selectListCount(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectListCount", paramMap);
	}

	@Override
	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		return session.insert("board.insertBoard", b);
	}

	@Override
	public int insertBoardImg(BoardImg bi) {
		// TODO Auto-generated method stub
		return session.insert("board.insertBoardImg", bi);
	}

	@Override
	public int insertBoardImgList(List<BoardImg> imgList) {
		// TODO Auto-generated method stub
		return session.insert("board.insertBoardImgList", imgList);
	}

	@Override
	public BoardExt selectBoard(int boardNo) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectBoard",boardNo);
	}

	@Override
	public int increaseCount(int boardNo) {
		// TODO Auto-generated method stub
		return session.update("board.increaseCount",boardNo);
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return session.update("board.updateBoard",board);
	}

	@Override
	public int updateBoardImg(BoardImg bi) {
		// TODO Auto-generated method stub
		return session.update("board.updateBoardImg",bi);
	}

	@Override
	public int deleteBoardImg(String deleteList) {
		// TODO Auto-generated method stub
		return session.delete("board.deleteBoardImg",deleteList);
	}

	

}
