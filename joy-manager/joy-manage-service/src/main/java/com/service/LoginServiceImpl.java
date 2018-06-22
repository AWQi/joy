package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import com.pojo.UserExample.Criteria;
@Service
public class LoginServiceImpl implements LoginService{
@Autowired	
private UserMapper userMapper;
	@Override
	public User login(String tel, String pwd) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andTelEqualTo(tel);
		criteria.andPasswordEqualTo(pwd);
		List<User> userList = userMapper.selectByExample(userExample);	
		System.out.println("tel"+tel);
		System.out.println("pwd"+pwd);
		System.out.println(userList.size());
		if (userList.size()>0) {
			return userList.get(0);
		}else {
			return null;
		}

	}

}
