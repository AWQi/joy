package com.service;
import java.util.List;

import com.pojo.User;
import com.bean.UserInfo;;
public interface UserInfoService {
public User UserInfo(String tel,String pwd) ;
public void Register(User user);
public List<UserInfo> myFans(int userId);
public List<UserInfo> myAttention(int userId);
}
