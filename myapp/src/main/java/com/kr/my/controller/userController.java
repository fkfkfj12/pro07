package com.kr.my.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kr.my.dto.userDTO;
import com.kr.my.service.userService;

	@Controller
	@RequestMapping("/user/*")
	public class userController {
	
	@Autowired
	userService userService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("userList")
	public String userList(Model model) throws Exception {
		List<userDTO> userList = userService.userList();
		model.addAttribute("userList",userList);
		return "user/userList";
	}
	
	/* 관리자 회원정보 보기 */
	@GetMapping("userGet")
	public String userGet(@RequestParam("id") String id, Model model) throws Exception {
	userDTO user = userService.getuser(id);
	model.addAttribute("user", user);
	return "user/userGet";
	}
	
	
	
	@GetMapping("userAdd")
	public String userAdd(Model model) throws Exception {
		return "user/userAdd";
	}
}
