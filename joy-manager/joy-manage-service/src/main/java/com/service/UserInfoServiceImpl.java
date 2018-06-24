package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.AttentionMapper;
import com.mapper.UserMapper;
import com.pojo.Attention;
import com.pojo.AttentionExample;
import com.pojo.User;
import com.bean.UserInfo;
import com.pojo.UserExample;
import com.pojo.UserExample.Criteria;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AttentionMapper attentionMapper;

	/**
	 * 查用户信息
	 */
	@Override
	public User login(String tel, String pwd) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andTelEqualTo(tel);
		criteria.andPasswordEqualTo(pwd);
		List<User> userList = userMapper.selectByExample(userExample);
		System.out.println(userList.size());
		if (userList.size() > 0) {
			return userList.get(0);
		} else {
			return null;
		}

	}

	/**
	 * 预注册 主要检测 手机号是否被用 以及发送短信
	 */
	@Override
	public int preRegister(String tel) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andTelEqualTo(tel);
		int n = userMapper.countByExample(userExample);
		return n;
	}

	/**
	 * 
	 * 注册
	 */
	@Override
	public void Register(User user) {
		userMapper.insert(user);
	}

	/**
	 * 
	 * 查询 粉丝
	 */
	@Override
	public List<UserInfo> myFans(int userId) {
		AttentionExample attentionExample = new AttentionExample();
		com.pojo.AttentionExample.Criteria attentionCriteria = attentionExample.createCriteria();
		attentionCriteria.andUser2IdEqualTo(userId);
		List<Attention> attentionList = attentionMapper.selectByExample(attentionExample);
		List<UserInfo> fansList = new ArrayList();
		for (Attention a : attentionList) {
			UserExample userExample = new UserExample();
			Criteria userCriteria = userExample.createCriteria();
			userCriteria.andIdEqualTo(a.getUser1Id());
			List<User> userList = userMapper.selectByExample(userExample);
			User user = userList.get(0);
			UserInfo userInfo = new UserInfo(user.getId(), user.getName(), user.getTel(), user.getHeadurl(),
					user.getGender());
			fansList.add(userInfo);
		}
		return fansList;
	}

	/**
	 * 
	 * 查 我的关注
	 * 
	 */
	@Override
	public List<UserInfo> myAttention(int userId) {
		AttentionExample attentionExample = new AttentionExample();
		com.pojo.AttentionExample.Criteria attentionCriteria = attentionExample.createCriteria();
		attentionCriteria.andUser1IdEqualTo(userId);
		List<Attention> attentionList = attentionMapper.selectByExample(attentionExample);
		List<UserInfo> myAttentList = new ArrayList();
		for (Attention a : attentionList) {
			UserExample userExample = new UserExample();
			Criteria userCriteria = userExample.createCriteria();
			userCriteria.andIdEqualTo(a.getUser2Id());
			List<User> userList = userMapper.selectByExample(userExample);
			User user = userList.get(0);
			UserInfo userInfo = new UserInfo(user.getId(), user.getName(), user.getTel(), user.getHeadurl(),
					user.getGender());
			myAttentList.add(userInfo);
		}
		return myAttentList;
	}

	/**
	 * 
	 * 关注
	 */
	@Override
	public void addAttention(Attention attention) {
		attentionMapper.insert(attention);
	}

	/**
	 * 
	 * 取消关注
	 */

	@Override
	public void deleteAttention(Attention attention) {
		AttentionExample attentionExample = new AttentionExample();
		com.pojo.AttentionExample.Criteria criteria = attentionExample.createCriteria();
		criteria.andUser1IdEqualTo(attention.getUser1Id());
		criteria.andUser2IdEqualTo(attention.getUser2Id());
		attentionMapper.deleteByExample(attentionExample);
	}

	/**
	 * 
	 * 查询作者信息
	 */
	@Override
	public UserInfo getUserInfo(int userId) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andIdEqualTo(userId);
		List<User> userList = userMapper.selectByExample(userExample);
		System.out.println(userList.size());
		if (userList.size() > 0) {
			User user = userList.get(0);
			UserInfo userInfo = new UserInfo(user.getId(), user.getName(), user.getTel(), user.getHeadurl(),
					user.getGender());
			return userInfo;
		} else {
			return null;
		}
	}

}
