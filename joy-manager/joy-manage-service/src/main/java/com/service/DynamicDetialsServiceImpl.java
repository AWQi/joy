package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.DynamicDetails;
import com.bean.UserInfo;
import com.mapper.CommentMapper;
import com.mapper.DynamicMapper;
import com.mapper.UserMapper;
import com.pojo.Comment;
import com.pojo.CommentExample;
import com.pojo.DynamicExample;
import com.pojo.User;
import com.pojo.UserExample;
import com.pojo.UserExample.Criteria;
@Service
public class DynamicDetialsServiceImpl implements DyanmicAuthorService {

@Autowired
private UserMapper userMapper;
	@Override
	public UserInfo getDynamicAuthor(int authorId) {
		 /**
		  * 
		  *  查询作者信息
		  */
		 UserExample userExample = new UserExample();  //
		 com.pojo.UserExample.Criteria userCriteria = userExample.createCriteria();
		 userCriteria.andIdEqualTo(authorId);
		 List<User> userList  = userMapper.selectByExample(userExample);
		 User user = userList.get(0);
		 UserInfo userInfo = new UserInfo(authorId,user.getName(), user.getTel(), user.getHeadurl(), user.getGender());
		 return userInfo;
	}

}
