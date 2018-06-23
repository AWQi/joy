package com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.DynamicMapper;
import com.pojo.Dynamic;
import com.pojo.DynamicExample;
import com.pojo.DynamicExample.Criteria;
@Service
public class RelevantRecomServiceImpl implements RelevantRecomService{
@Autowired
private DynamicMapper dynamicMapper;
	@Override
	public List<Dynamic> RelevantRecom(String kind) {
		DynamicExample dynamicExample = new DynamicExample();
		Criteria criteria = dynamicExample.createCriteria();
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
