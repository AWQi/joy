package com.service;

import java.util.List;

import com.pojo.Dynamic;
 
public interface DynamicService {
	
public void addDynamicCollect(int dynamicId,int userId);
public void deleteDynamicCollect(int dynamicId,int userId);
public List<Dynamic>  queryDynamicCollect(int userId);
public List<Dynamic> CommendDynamics(int page, int row);//  推荐
public List<Dynamic> RelevantRecom(String kind); // 相关
public List<Dynamic> queryAttentDynamic(int userId);
}
