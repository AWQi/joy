package com.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.AttentionMapper;
import com.mapper.DynamicMapper;
import com.mapper.UserMapper;
import com.pojo.Attention;
import com.pojo.AttentionExample;
import com.pojo.Dynamic;
import com.pojo.DynamicExample;
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
	@Autowired
	private DynamicMapper dynamicMapper;
	/**
	 * 查用户信息
	 */
	@Override
	public UserInfo login(String tel, String pwd) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andTelEqualTo(tel);
		criteria.andPasswordEqualTo(pwd);
		List<User> userList = userMapper.selectByExample(userExample);
		System.out.println(userList.size());
		if (userList.size() > 0) {
			
			User user = userList.get(0);
			/**  
			 * 
			 *   粉丝数
			 */
			AttentionExample ae1 = new AttentionExample();
			com.pojo.AttentionExample.Criteria attentionCriteria = ae1.createCriteria();
			attentionCriteria.andUser2IdEqualTo(user.getId());
			List<Attention> a1 = attentionMapper.selectByExample(ae1);
			
			int i1 = a1.size();
		
			/**
			 *   关注 数
			 * 
			 */
			AttentionExample ae2 = new AttentionExample();
			com.pojo.AttentionExample.Criteria ac1 = ae2.createCriteria();
			ac1.andUser2IdEqualTo(user.getId());
			List<Attention> a2 = attentionMapper.selectByExample(ae1);
			
			int i2 = a2.size();
		
			/**
			 * 
			 *  我的动态  数
			 */
			DynamicExample dynamicExample = new DynamicExample();
			com.pojo.DynamicExample.Criteria dynamicCriteria = dynamicExample.createCriteria();
			dynamicCriteria.andAuthorIdEqualTo(user.getId());
			List<Dynamic> dynamicList = dynamicMapper.selectByExample(dynamicExample);
			
			int i3 = dynamicList.size();
			
			
			UserInfo userInfo = new UserInfo(user.getId(), user.getName(),
					tel,user.getHeadUrl(), user.getGender(), i2, 
					i1, i3)	;		
			return  userInfo;
			
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
	public void register(User user) {
		if (user.getHeadUrl()==null) {
			user.setHeadUrl("http://140.143.16.51/image/head/a.jpg");
		}
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
			UserInfo userInfo = new UserInfo(user.getId(), user.getName(), user.getTel(), user.getHeadUrl(),
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
			UserInfo userInfo = new UserInfo(user.getId(), user.getName(), user.getTel(), user.getHeadUrl(),
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
	public UserInfo queryUserInfo(int userId) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andIdEqualTo(userId);
		List<User> userList = userMapper.selectByExample(userExample);
		System.out.println(userList.size());
		if (userList.size() > 0) {
			User user = userList.get(0);
			UserInfo userInfo = new UserInfo(user.getId(), user.getName(), user.getTel(), user.getHeadUrl(),
					user.getGender());
			return userInfo;
		} else {
			return null;
		}
	}

}
