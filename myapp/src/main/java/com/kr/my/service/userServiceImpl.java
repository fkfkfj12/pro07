package com.kr.my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kr.my.dto.userDTO;
import com.kr.my.model.userDAO;

@Service
public class userServiceImpl implements userService {
	@Autowired
	userDAO user;

	@Override
	public List<userDTO> userList() throws Exception {
		return user.userList();
	}

	@Override
	public userDTO getuser(String id) throws Exception {
		return user.getuser(id);
	}

	@Override
	public void adduser(userDTO dto) throws Exception {
		user.adduser(dto);
	}

	

	



}
