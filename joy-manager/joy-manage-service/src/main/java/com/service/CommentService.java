package com.service;

import java.util.List;

import com.bean.CommentInfo;

public interface CommentService {
public List<CommentInfo> getComment(int dynamicId);
}
