package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.UserInfo;
import com.common.HttpUtil;
import com.common.JoyResult;
import com.common.JsonUtils;
import com.common.URLUtil;
import com.pojo.Attention;
import com.pojo.User;
import com.service.UserInfoService;
@Controller
public class UserControllerImpl implements UserController{
static Map<String,String> code = new HashMap();
static Timer timer = new Timer();
@Autowired
private UserInfoService userInfoServic;
/**
 * 
 *    登录
 */
@RequestMapping("login")
@ResponseBody

	@Override
	public JoyResult login(@RequestParam("tel")String tel,@RequestParam("password")String password) {
	System.out.println("login服务 进入");
	UserInfo userInfo = userInfoServic.login(tel, password);
	System.out.println("查询结束");
	if (userInfo==null) {
		return new JoyResult(300,"账号或密码错误",new UserInfo());
	}else {
	    return new JoyResult(userInfo);
	}	
	}
/**
 * 
 *    预注册   检测手机号是否被占用 及发送短信
 */
@RequestMapping("preRegister")
@ResponseBody
@Override
public JoyResult preRegister(@RequestParam("tel") final String tel,HttpServletResponse response) {
	int n = userInfoServic.preRegister(tel);
	if (n==0) {  // 手机号去重
//		String s = HttpUtil.getSixRandom();// 生成六位 验证码
//		String res = HttpUtil.senSMSWithBmob(tel, "注册模板",s);
		String s = "000000";
		String res = "";
		if (res!=null) {
			code.put(tel,s); // 把验证码放入  map 注册时取出
			//  开启定时任务  验证码失效
		     timer.schedule(new TimerTask() {
			       public void run() {
			         System.out.println("tel "+tel +" 失效");
			         this.cancel();
			         code.remove("tel");
			         if(code.size()==0) {
						timer.cancel();
					}
			      }
			     }, 1000*60);
			return new JoyResult().build(200,"发送成功" );
		}else {
			response.setStatus(300);
			return new JoyResult().build(300,"发送失败" );
		}
	
	}else {
		return JoyResult.build(300,"此手机号已被注册，请直接登录");		
	}	
}
@RequestMapping("register")
@ResponseBody
@Override
public JoyResult register(@RequestBody String userInfo,@RequestParam ("verificationCode")String verificationCode) {
	
	User user = JsonUtils.jsonToPojo(userInfo, User.class);
	String s = code.get(user.getTel());
	if (verificationCode.equals(s)) { //   验证成功
			userInfoServic.Register(user);
			code.remove(s);
			return JoyResult.build(200,"注册成功！");
	}else {
			return JoyResult.build(300, "验证码错误");
	}

	
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
	return new JoyResult(userInfoList);
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
@RequestMapping("queryDynamicAuthor")
@ResponseBody
@Override
public JoyResult queryDynamicAuthor(@RequestParam("userId")int userId) {
	UserInfo userInfo = userInfoServic.queryUserInfo(userId);
	return new JoyResult(userInfo);
}
@RequestMapping("queryUserInfo")
@ResponseBody
public JoyResult queryUserInfo(@RequestParam("userId")int userId) {
	UserInfo userInfo = userInfoServic.queryUserInfo(userId);
	return new JoyResult(userInfo);
}
}
