package com.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;

import com.bean.UserInfo;
import com.common.JoyResult;
import com.pojo.Attention;

public interface UserController {

public JoyResult login(String tel, String password);
public JoyResult getDynamicAuthor(int userId);
public JoyResult myFans(int userId);
public JoyResult myAttention(int userId);
public JoyResult addAttention(int user1Id,int user2Id);
public JoyResult deleteAttention(int user1Id,int user2Id);
public JoyResult preRegister(String tel,HttpServletResponse response);
public JoyResult register(String userInfo,String verificationCode);

}
