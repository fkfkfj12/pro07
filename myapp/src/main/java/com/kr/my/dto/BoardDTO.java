package com.kr.my.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int seq;
	private String title;
	private String content;
	private String nickname;
	private String regdate;
	private int visited;
}