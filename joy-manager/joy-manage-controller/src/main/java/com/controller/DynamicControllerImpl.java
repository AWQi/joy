package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.DynamicInfo;
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
@RequestMapping("relevantRecom")
@ResponseBody
@Override
public JoyResult relevantRecom(@RequestParam("kind")String kind) {
	System.out.println("kind   " + kind);
	List<Dynamic> dynamicList = dynamicService.RelevantRecom(kind);
	return new JoyResult(dynamicList);
}
/**
 * 
 *    排行推荐
 */
@RequestMapping("commendDynamics")
@ResponseBody
	@Override
	public JoyResult commendDynamics(@RequestParam("page")int page) {
		List<DynamicInfo> dynamicList = dynamicService.CommendDynamics(page, 8);
		return new JoyResult(dynamicList);
	}
/**
 *    查询所关注的人的动态
 */
@RequestMapping("queryAttentDynamic")
@ResponseBody
@Override
public JoyResult queryAttentDynamic(@RequestParam("userId")int userId) {
List<DynamicInfo> dynamicList = dynamicService.queryAttentDynamic(userId);
	
	return new JoyResult(dynamicList);
}
	
}
