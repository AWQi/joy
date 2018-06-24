package com.controller;

import com.common.JoyResult;
import com.pojo.Comment;

public interface CommentController {
public  JoyResult getComment(int dynamicId);
public 	JoyResult addComment(String CommentInfo);
public  JoyResult deleteComment(int commentId);
}
