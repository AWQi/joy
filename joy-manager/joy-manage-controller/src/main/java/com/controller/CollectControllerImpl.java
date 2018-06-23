package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.JoyResult;
import com.pojo.Dynamic;
import com.service.DynamicCollectService;
@Controller
public class CollectControllerImpl implements CollectController {
@Autowired	
private DynamicCollectService dynamicCollectService;
@RequestMapping("addDynamicCollect")
@ResponseBody
	@Override
	public JoyResult addDynamicCollect(@RequestParam(value="dynamicId",defaultValue="0") int dynamicId,@RequestParam(value="userId",defaultValue="0") int userId) {
		dynamicCollectService.addDynamicCollect(dynamicId, userId);	
		return  JoyResult.build(200,"添加成功");
	}
@RequestMapping("deleteDynamicCollect")
@ResponseBody
	@Override
	public JoyResult deleteDynamicCollect(@RequestParam(value="dynamicId",defaultValue="0") int dynamicId,@RequestParam(value="userId",defaultValue="0") int userId) {
		dynamicCollectService.deleteDynamicCollect(dynamicId, userId);
		return JoyResult.build(200,"删除成功");
	}
@RequestMapping("queryDynamicCollect")
@ResponseBody
	@Override
	public JoyResult queryDynamicCollect(@RequestParam(value="userId",defaultValue="0") int userId) {
		List<Dynamic> dynamicList = dynamicCollectService.queryDynamicCollect(userId);
		return new JoyResult(dynamicList);
	}

}
