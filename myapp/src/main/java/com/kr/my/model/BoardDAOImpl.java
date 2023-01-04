package com.kr.my.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kr.my.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardDTO> boardList() throws Exception {
		return sqlSession.selectList("board.boardList");
	}

	@Override
	public BoardDTO boardDetail(int seq) throws Exception {
		sqlSession.update("board.countUp", seq);
		return sqlSession.selectOne("board.boardDetail", seq);
	}
	
	

	@Override
	public void boardInsert(BoardDTO board) throws Exception {
		sqlSession.insert("board.boardInsert", board);
	}

	@Override
	public void boardDelete(int seq) throws Exception {
		sqlSession.delete("board.boardDelete", seq);		
	}

	@Override
	public void boardEdit(BoardDTO board) throws Exception {
		sqlSession.update("board.boardEdit", board);
	}
}