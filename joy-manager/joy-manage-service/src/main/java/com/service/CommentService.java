package com.service;

import java.util.List;

import com.bean.CommentInfo;
import com.pojo.Comment;

public interface CommentService {
public List<CommentInfo> queryComment(int dynamicId);
public void addComment(Comment comment);
public void deleteComment(int commentId);
}
