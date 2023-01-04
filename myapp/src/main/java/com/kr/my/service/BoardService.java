package com.kr.my.service;

import java.util.List;

import com.kr.my.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> boardList() throws Exception;
	public BoardDTO boardDetail(int seq) throws Exception;
	public void boardInsert(BoardDTO board) throws Exception;
	public void boardDelete(int seq) throws Exception;
	public void boardEdit(BoardDTO board) throws Exception;
}