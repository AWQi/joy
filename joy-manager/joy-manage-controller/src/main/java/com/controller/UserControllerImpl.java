package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.UserInfo;
import com.common.JoyResult;
import com.common.JsonUtils;
import com.pojo.Attention;
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
public JoyResult register(@RequestBody String userInfo) {
	User user = JsonUtils.jsonToPojo(userInfo, User.class);
	userInfoServic.Register(user);
	return JoyResult.build(200,"注册成功！");
}
@RequestMapping("myFans")
@ResponseBody
@Override
public JoyResult myFans(@RequestParam("userId")int userId) {
	List<UserInfo> userInfoList = userInfoServic.myFans(userId);
	return new JoyResult(userInfoList);
}
@RequestMapping("myAttention")
@ResponseBody
@Override
public JoyResult myAttention(@RequestParam("userId")int userId) {
	List<UserInfo> userInfoList = userInfoServic.myAttention(userId);
	return new JoyResult(userInfoServic);
}
@RequestMapping("addAttention")
@ResponseBody
@Override
public JoyResult addAttention(@RequestParam("user1Id")int user1Id,@RequestParam("user2Id") int user2Id) {
	Attention attention = new Attention();
	attention.setUser1Id(user1Id);
	attention.setUser2Id(user2Id);
	userInfoServic.addAttention(attention);
	return JoyResult.build(200," 添加成功");
}
@RequestMapping("deleteAttention")
@ResponseBody
@Override
public JoyResult deleteAttention(@RequestParam("user1Id")int user1Id,@RequestParam("user2Id") int user2Id) {
	Attention attention = new Attention();
	attention.setUser1Id(user1Id);
	attention.setUser2Id(user2Id);
	userInfoServic.deleteAttention(attention);
	return JoyResult.build(200," 删除成功");
}
}
