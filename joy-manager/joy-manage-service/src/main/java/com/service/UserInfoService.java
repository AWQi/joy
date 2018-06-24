package com.service;
import java.util.List;

import com.pojo.Attention;
import com.pojo.User;
import com.bean.UserInfo;
import com.common.JoyResult;;
public interface UserInfoService {
public User login(String tel,String pwd) ;
public int preRegister(String tel);
public void Register(User user);
public UserInfo getUserInfo(int userId);
public List<UserInfo> myFans(int userId);
public List<UserInfo> myAttention(int userId);
public void addAttention(Attention attention);
public void deleteAttention(Attention attention);

}
