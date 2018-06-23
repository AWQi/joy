package com.controller;

import java.util.List;

import com.common.JoyResult;
import com.pojo.Dynamic;

public interface CollectController {
	public JoyResult addDynamicCollect(int dynamicId,int userId);
	public JoyResult deleteDynamicCollect(int dynamicId,int userId);
	public JoyResult  queryDynamicCollect(int userId);
}
