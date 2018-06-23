package com.controller;

import java.util.List;

import com.bean.UserInfo;
import com.common.JoyResult;
import com.pojo.Attention;

public interface UserController {

public JoyResult login(String tel, String password);
public JoyResult register(String userInfo);
public JoyResult myFans(int userId);
public JoyResult myAttention(int userId);
public JoyResult addAttention(int user1Id,int user2Id);
public JoyResult deleteAttention(int user1Id,int user2Id);

}
