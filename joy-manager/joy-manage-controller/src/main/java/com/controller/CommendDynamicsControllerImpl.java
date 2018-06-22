package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.JoyResult;
import com.pojo.Dynamic;
import com.service.CommendDynamicsService;
@Controller
public class CommendDynamicsControllerImpl implements CommendDynamicsController{
@Autowired
private CommendDynamicsService commendDynamicsService;
@RequestMapping("CommendDynamics")
@ResponseBody
	@Override
	public JoyResult CommendDynamics(@RequestParam("page")int page) {
		List<Dynamic> dynamicList = commendDynamicsService.CommendDynamics(page, 4);
		return new JoyResult(dynamicList);
	}

}
