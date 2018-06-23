package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.DynamicDetails;
import com.common.JoyResult;
import com.pojo.Dynamic;
import com.service.DyanmicDetailsService;
import com.service.RelevantRecomService;

@Controller
public class DynamicDetialsControllerImpl implements DynamicDetialsController{
@Autowired
private DyanmicDetailsService dyanmicDetailsService;
@RequestMapping("getDynamicDetials")
@ResponseBody
@Override
public JoyResult getDynamicDetials(@RequestParam(value="dynamicId",defaultValue="1") int dynamicId, @RequestParam("authorId") int authorId) {
	DynamicDetails dynamicDetails = dyanmicDetailsService.getDynamicDetials(dynamicId, authorId);
	
	return new JoyResult(dynamicDetails);
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
