package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.JoyResult;
import com.pojo.User;
import com.service.LoginService;
@Controller
public class LoginControllerImpl implements LoginController{
@Autowired
private LoginService loginServic;
@RequestMapping("login")
@ResponseBody
	@Override
	public JoyResult login(@RequestParam("tel")String tel,@RequestParam("password")String password) {
	System.out.println("login服务 进入");
		User user = loginServic.login(tel, password);
	System.out.println("查询结束");	
	System.out.println(user);
		return new JoyResult(user);
	}


}
