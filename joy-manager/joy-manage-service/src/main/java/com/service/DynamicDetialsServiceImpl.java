package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.DynamicDetails;
import com.mapper.CommentMapper;
import com.mapper.DynamicMapper;
import com.mapper.UserMapper;
import com.pojo.Comment;
import com.pojo.CommentExample;
import com.pojo.DynamicExample;

import com.pojo.UserExample;
@Service
public class DynamicDetialsServiceImpl implements DyanmicDetailsService {
@Autowired
private DynamicMapper dynamicMapper;
@Autowired
private UserMapper userMapper;
@Autowired
private CommentMapper comentMapper;
	@Override
	public DynamicDetails getDynamicDetials(int id) {
		 DynamicExample dynamicExample= new DynamicExample();
		 com.pojo.DynamicExample.Criteria dynamicCriteria = dynamicExample.createCriteria();
		 dynamicCriteria.andIdEqualTo(id);
		 dynamicMapper.selectByExample(dynamicExample);
		 
		 UserExample userExample = new UserExample();
		 com.pojo.UserExample.Criteria userCriteria = userExample.createCriteria();
		 
		 CommentExample commentExample = new CommentExample();
		 com.pojo.CommentExample.Criteria commentCriteria = commentExample.createCriteria();
		 
		 
		 
		 
		return null;
	}

}
