package com.kr.my.model;

import java.util.List;

import com.kr.my.dto.userDTO;

public interface userDAO {
	public List<userDTO> userList() throws Exception;
	public userDTO getuser(String id) throws Exception;

}
