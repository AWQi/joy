package com.controller;

import java.util.List;

import com.common.JoyResult;
import com.pojo.Dynamic;

public interface DynamicController {
	public JoyResult addDynamicCollect(int dynamicId,int userId);
	public JoyResult deleteDynamicCollect(int dynamicId,int userId);
	public JoyResult queryDynamicCollect(int userId);
	public JoyResult relevantRecom(String kind);
	public JoyResult commendDynamics(int page); //推荐
	public JoyResult queryAttentDynamic(int userId); // 查询所关注的用户动态
}
