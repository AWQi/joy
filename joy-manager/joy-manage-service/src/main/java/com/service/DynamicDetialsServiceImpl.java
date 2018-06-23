package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.DynamicDetails;
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
public class DynamicDetialsServiceImpl implements DyanmicDetailsService {
@Autowired
private DynamicMapper dynamicMapper;
@Autowired
private UserMapper userMapper;
@Autowired
private CommentMapper comentMapper;
	@Override
	public DynamicDetails getDynamicDetials(int dynamicId,int authorId) {
//		 DynamicExample dynamicExample= new DynamicExample();
//		 com.pojo.DynamicExample.Criteria dynamicCriteria = dynamicExample.createCriteria();
//		 dynamicCriteria.andIdEqualTo(dynamicId);
//		 dynamicMapper.selectByExample(dynamicExample);
		 
		 /**
		  * 
		  *  查询作者信息
		  */
		 UserExample userExample = new UserExample();  //
		 com.pojo.UserExample.Criteria userCriteria = userExample.createCriteria();
		 userCriteria.andIdEqualTo(authorId);
		 List<User> userList  = userMapper.selectByExample(userExample);
		 User user = userList.get(0);
		 
		
		 /**
		  *  查询 评论
		  * 
		  */
		 CommentExample commentExample = new CommentExample();
		 com.pojo.CommentExample.Criteria commentCriteria = commentExample.createCriteria();
		 commentCriteria.andDynamicIdEqualTo(dynamicId);
		 List<Comment> commentList =  comentMapper.selectByExample(commentExample);
		 List<String> commentAuthorHeadList = new ArrayList();
		 List<Integer> commentAuthorIdList = new ArrayList();

		 for(Comment comment: commentList) {
			 UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo( comment.getUserId());
			List<User> commUser = userMapper.selectByExample(example);	
			commentAuthorHeadList.add(commUser.get(0).getHeadurl());
			commentAuthorIdList.add(commUser.get(0).getId());
		 }
		 
		 
		 DynamicDetails dynamicDetails = new DynamicDetails(
				 dynamicId,authorId, user.getName(),
				 user.getHeadurl(), commentList,commentAuthorHeadList,commentAuthorIdList);
		 		return dynamicDetails;
	}

}
