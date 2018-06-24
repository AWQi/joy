package com.controller;

import java.util.List;

import com.common.JoyResult;
import com.pojo.Dynamic;

public interface DynamicController {
	public JoyResult addDynamicCollect(int dynamicId,int userId);
	public JoyResult deleteDynamicCollect(int dynamicId,int userId);
	public JoyResult queryDynamicCollect(int userId);
	public  JoyResult RelevantRecom(String kind);
	public JoyResult CommendDynamics(int page); //推荐
}
