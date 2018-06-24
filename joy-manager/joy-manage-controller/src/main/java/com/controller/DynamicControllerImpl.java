package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.JoyResult;
import com.pojo.Dynamic;
import com.service.DynamicService;
@Controller
public class DynamicControllerImpl implements DynamicController {
@Autowired	
private DynamicService dynamicService;
/**
 * 
 *    添加收藏
 */
@RequestMapping("addDynamicCollect")
@ResponseBody
	@Override
	public JoyResult addDynamicCollect(@RequestParam(value="dynamicId",defaultValue="0") int dynamicId,@RequestParam(value="userId",defaultValue="0") int userId) {
		dynamicService.addDynamicCollect(dynamicId, userId);	
		return  JoyResult.build(200,"添加成功");
	}
/**
 * 
 *  删除  收藏
 */
@RequestMapping("deleteDynamicCollect")
@ResponseBody
	@Override
	public JoyResult deleteDynamicCollect(@RequestParam(value="dynamicId",defaultValue="0") int dynamicId,@RequestParam(value="userId",defaultValue="0") int userId) {
		dynamicService.deleteDynamicCollect(dynamicId, userId);
		return JoyResult.build(200,"删除成功");
	}
/**
 * 
 *   查询  收藏
 */
@RequestMapping("queryDynamicCollect")
@ResponseBody
	@Override
	public JoyResult queryDynamicCollect(@RequestParam(value="userId",defaultValue="0") int userId) {
		List<Dynamic> dynamicList = dynamicService.queryDynamicCollect(userId);
		return new JoyResult(dynamicList);
	}
/**
 * 
 *   相关推荐
 */
@RequestMapping("RelevantRecom")
@ResponseBody
@Override
public JoyResult RelevantRecom(@RequestParam("kind")String kind) {
	System.out.println("kind   " + kind);
	List<Dynamic> dynamicList = dynamicService.RelevantRecom(kind);
	return new JoyResult(dynamicList);
}
/**
 * 
 *    排行推荐
 */
@RequestMapping("CommendDynamics")
@ResponseBody
	@Override
	public JoyResult CommendDynamics(@RequestParam("page")int page) {
		List<Dynamic> dynamicList = dynamicService.CommendDynamics(page, 4);
		return new JoyResult(dynamicList);
	}
	
}
