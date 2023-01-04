package com.kr.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.my.dto.BoardDTO;
import com.kr.my.model.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardDTO> boardList() throws Exception {
		return boardDAO.boardList();
	}

	@Override
	public BoardDTO boardDetail(int seq) throws Exception {
		return boardDAO.boardDetail(seq);
	}

	@Override
	public void boardInsert(BoardDTO board) throws Exception {
		boardDAO.boardInsert(board);
	}

	@Override
	public void boardDelete(int seq) throws Exception {
		boardDAO.boardDelete(seq);
	}

	@Override
	public void boardEdit(BoardDTO board) throws Exception {
		boardDAO.boardEdit(board);
	}

}