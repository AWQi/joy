package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.CommentInfo;
import com.bean.DynamicDetails;
import com.bean.UserInfo;
import com.common.JoyResult;
import com.pojo.Dynamic;
import com.pojo.User;
import com.service.CommentService;
import com.service.DyanmicAuthorService;
import com.service.RelevantRecomService;

@Controller
public class DynamicDetialsControllerImpl implements DynamicDetialsController{
	
	
	
@Autowired
private DyanmicAuthorService dyanmicAuthorService;
@RequestMapping("getDynamicAuthor")
@ResponseBody
@Override
public JoyResult getDynamicAuthor( @RequestParam(value="authorId",defaultValue="0") int authorId) {
	UserInfo author= dyanmicAuthorService.getDynamicAuthor(authorId);
	
	return new JoyResult(author);
}





@Autowired
private CommentService commentService;
@RequestMapping("getComment")
@ResponseBody
@Override
public JoyResult getComment(@RequestParam(value="dynamicId",defaultValue="0")int dynamicId) {
	List<CommentInfo> commentInfoList = commentService.getComment(dynamicId);
	return new JoyResult(commentInfoList);
}




@Autowired
private RelevantRecomService relevantRecomService;
@RequestMapping("RelevantRecom")
@ResponseBody
@Override
public JoyResult RelevantRecom(@RequestParam("kind")String kind) {
	System.out.println("kind   " + kind);
	List<Dynamic> dynamicList = relevantRecomService.RelevantRecom(kind);
	return new JoyResult(dynamicList);
}
	
}
