package com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mapper.CollectionMapper;
import com.mapper.DynamicMapper;
import com.pojo.Collection;
import com.pojo.CollectionExample;
import com.pojo.CollectionExample.Criteria;
import com.pojo.Dynamic;
import com.pojo.DynamicExample;
/**
 *   收藏动态
 * @author Dell
 *
 */
@Service
public class DynamicServiceImpl implements DynamicService {
@Autowired
private DynamicMapper dynamicMapper;		
@Autowired	
private CollectionMapper collectionMapper;
	@Override
	public void addDynamicCollect(int dynamicId, int userId) {
		Collection collection = new Collection(dynamicId,userId); 
		collectionMapper.insert(collection);
	}
	@Override
	public void deleteDynamicCollect(int dynamicId, int userId) {
		CollectionExample collectionExample = new CollectionExample();
		Criteria criteria = collectionExample.createCriteria();
		criteria.andDyidEqualTo(dynamicId);
		criteria.andUseridEqualTo(userId);
		collectionMapper.deleteByExample(collectionExample);
	}

	@Override
	public List<Dynamic> queryDynamicCollect(int userId) {
		CollectionExample collectionExample = new CollectionExample();
		Criteria criteria = collectionExample.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<Collection> collectionList = collectionMapper.selectByExample(collectionExample);
		List<Dynamic> dynamicList = new ArrayList();
		for(Collection c: collectionList) {
			DynamicExample dynamicExample = new DynamicExample();
			com.pojo.DynamicExample.Criteria dynamicCriteria = dynamicExample.createCriteria();
			dynamicCriteria.andIdEqualTo(c.getDyid());
			List<Dynamic> dynamics =dynamicMapper.selectByExample(dynamicExample);
			dynamicList.add(dynamics.get(0));	
		}
		return dynamicList;
	}

		@Override
		public List<Dynamic> CommendDynamics(int page ,int row) {
		
			 DynamicExample dynamicExample= new DynamicExample();
			 com.pojo.DynamicExample.Criteria criteria = dynamicExample.createCriteria();
			 PageHelper.startPage(page, row);
			 criteria.getAllCriteria();
			 dynamicExample.setOrderByClause("viewNum");
			 List<Dynamic> dynamicList = dynamicMapper.selectByExample(dynamicExample);
			return dynamicList;
		}

	@Override
	public List<Dynamic> RelevantRecom(String kind) {
		DynamicExample dynamicExample = new DynamicExample();
		com.pojo.DynamicExample.Criteria criteria = dynamicExample.createCriteria();
		criteria.andKindEqualTo(kind);
		List<Dynamic> dynamicList = dynamicMapper.selectByExample(dynamicExample);
		List<Dynamic> relevantRecomList ;
		if (dynamicList.size()>5) {  //数量大于五  就 随机取五个
			relevantRecomList =  new ArrayList();
		//  取同类随机数
			Set<Integer> dySet = new HashSet();
			
			while(dySet.size()<5) {
				Random ran = new Random();
				int i =ran.nextInt(dynamicList.size());
				dySet.add(i);
			}
			for (int i:dySet) {
				relevantRecomList.add(dynamicList.get(i));
				
			}
		}else {  // 数量不足五  就是 全部取
			relevantRecomList  = dynamicList;
		}
		
		return relevantRecomList;
}
	}


