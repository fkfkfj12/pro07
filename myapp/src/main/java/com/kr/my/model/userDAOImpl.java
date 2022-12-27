package com.kr.my.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kr.my.dto.SampleDTO;
import com.kr.my.dto.userDTO;

@Repository
public class userDAOImpl implements userDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<userDTO> userList() throws Exception {
		return sqlSession.selectList("user.userList");
	}

	@Override
	public userDTO getuser(String id) throws Exception {
		return sqlSession.selectOne("user.getuser", id);
		
	}
	
	
	

}
