package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.DynamicDetails;
import com.common.JoyResult;
import com.pojo.Dynamic;
import com.service.DyanmicDetailsService;

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
}
