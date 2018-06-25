package com.controller;

import java.util.List;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.CommentInfo;
import com.common.JoyResult;
import com.common.JsonUtils;
import com.pojo.Comment;
import com.service.CommentService;
@Controller
public class CommentControllerImpl implements CommentController{
	@Autowired
	private CommentService commentService;
	@RequestMapping("queryComment")
	@ResponseBody
	@Override
	public JoyResult queryComment(@RequestParam(value="dynamicId",defaultValue="0")int dynamicId) {
		List<CommentInfo> commentInfoList = commentService.queryComment(dynamicId);
		return new JoyResult(commentInfoList);
	}

	@RequestMapping("addComment")
	@ResponseBody
	@Override
	public JoyResult addComment(@RequestBody String CommentInfo) {
		Comment comment = JsonUtils.jsonToPojo(CommentInfo, Comment.class);
		commentService.addComment(comment);
		return JoyResult.build(200,"评论成功");
	}
	@RequestMapping("deleteComment")
	@ResponseBody
	@Override
	public JoyResult deleteComment(@RequestParam("commentId")int commentId) {
		commentService.deleteComment(commentId);
		return JoyResult.build(200, "删除评论成功");
	}
	
	@RequestMapping("test")
	@ResponseBody
	public JoyResult test(@RequestBody String s
			,@RequestParam("key")String key,@RequestParam("key2")String key2
			,@RequestHeader("head")String head,@RequestHeader("head2")String head2) {
		System.out.println(s);
		System.out.println("key "+key);
		System.out.println("key2"+key2);
		System.out.println("head  "+head);
		System.out.println("head2 "+head2);
		return new JoyResult("ok test");
	}
}
