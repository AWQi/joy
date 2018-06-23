package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.UserInfo;
import com.common.JoyResult;
import com.common.JsonUtils;
import com.pojo.User;
import com.service.UserInfoService;
@Controller
public class UserControllerImpl implements UserController{
@Autowired
private UserInfoService userInfoServic;
@RequestMapping("login")
@ResponseBody
	@Override
	public JoyResult login(@RequestParam("tel")String tel,@RequestParam("password")String password) {
	System.out.println("login服务 进入");
		User user = userInfoServic.UserInfo(tel, password);
	System.out.println("查询结束");
	UserInfo userInfo = new UserInfo(user.getId(), user.getName(), user.getTel(), user.getHeadurl(), user.getGender());
		return new JoyResult(userInfo);
	}
@RequestMapping("register")
@ResponseBody
@Override
public JoyResult register(@RequestParam("userInfo")String userInfo) {
	User user = JsonUtils.jsonToPojo(userInfo, User.class);
	userInfoServic.Register(user);
	return JoyResult.build(200,"注册成功！");
}

}
