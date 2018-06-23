package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class DynamicCollectServiceImpl implements DynamicCollectService {
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
@Autowired
private DynamicMapper dynamicMapper;	
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

}
