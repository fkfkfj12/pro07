package com.kr.my.service;

import java.util.List;

import com.kr.my.dto.userDTO;

public interface userService {
	public List<userDTO> userList() throws Exception;
	public userDTO getuser(String id) throws Exception;
	public void adduser(userDTO dto) throws Exception;
	
}
