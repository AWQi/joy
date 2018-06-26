package com.service;

import java.util.List;

import com.bean.DynamicInfo;
import com.pojo.Dynamic;
 
public interface DynamicService {
	
public void addDynamicCollect(int dynamicId,int userId);
public void deleteDynamicCollect(int dynamicId,int userId);
public List<Dynamic>  queryDynamicCollect(int userId);
public List<DynamicInfo> CommendDynamics(int page, int row);//  推荐
public List<Dynamic> RelevantRecom(String kind); // 相关
public List<DynamicInfo> queryAttentDynamic(int userId);
}
