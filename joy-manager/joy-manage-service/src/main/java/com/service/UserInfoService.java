package com.service;
import java.util.List;

import com.pojo.User;
public interface UserInfoService {
public User UserInfo(String tel,String pwd) ;
public void Register(User user) ;
}
