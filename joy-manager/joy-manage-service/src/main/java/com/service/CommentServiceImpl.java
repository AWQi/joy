package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.CommentInfo;
import com.bean.UserInfo;
import com.mapper.CommentMapper;
import com.mapper.UserMapper;
import com.pojo.Comment;
import com.pojo.CommentExample;
import com.pojo.User;
import com.pojo.UserExample;
import com.pojo.UserExample.Criteria;
@Service
public class CommentServiceImpl implements CommentService {
@Autowired
private CommentMapper commentMapper;
@Autowired
private UserMapper userMapper;
/** 
 * 
 *    查询评论
 * 
 */
	@Override
	public List<CommentInfo> queryComment(int dynamicId) {
		 /**
		  *  查询 评论
		  * 
		  */
		 CommentExample commentExample = new CommentExample();
		 com.pojo.CommentExample.Criteria commentCriteria = commentExample.createCriteria();
		 commentCriteria.andDynamicIdEqualTo(dynamicId);
		 List<Comment> commentList =  commentMapper.selectByExample(commentExample);
		 List<CommentInfo> commentInfoList = new ArrayList();
		 /**
		  *  查询评论作者
		  */	
		 for(Comment comment: commentList) {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo( comment.getUserId());
			List<User> userList = userMapper.selectByExample(example);
			User user = userList.get(0);
			CommentInfo commentInfo = new CommentInfo(
					comment.getId(),dynamicId,user.getId(), user.getHeadUrl(),
					user.getName(), comment.getContent(), comment.getDate());
			commentInfoList.add(commentInfo);
		 }	 	
		return commentInfoList;
	}
	/**
	 * 
	 *   添加评论
	 */
	@Override
	public int addComment(Comment comment) {
		commentMapper.insert(comment);
		int id = comment.getId();
		return id;
	}
	/**
	 *   删除评论
	 * 
	 */
	@Override
	public void deleteComment(int commentId) {
		commentMapper.deleteByPrimaryKey(commentId);
	}
	
}
