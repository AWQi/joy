package com.service;

import java.util.List;

import com.pojo.Dynamic;
 
public interface DynamicCollectService {
public void addDynamicCollect(int dynamicId,int userId);
public void deleteDynamicCollect(int dynamicId,int userId);
public List<Dynamic>  queryDynamicCollect(int userId);
}
