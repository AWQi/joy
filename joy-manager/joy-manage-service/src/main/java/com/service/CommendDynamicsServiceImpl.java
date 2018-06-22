package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mapper.DynamicMapper;
import com.pojo.Dynamic;
import com.pojo.DynamicExample;
import com.pojo.DynamicExample.Criteria;
import com.pojo.DynamicExample.Criterion;
@Service
public class CommendDynamicsServiceImpl implements CommendDynamicsService{

@Autowired
private DynamicMapper  dynamicMapper;
	@Override
	public List<Dynamic> CommendDynamics(int page ,int row) {
	
		 DynamicExample dynamicExample= new DynamicExample();
		 Criteria criteria = dynamicExample.createCriteria();
		 PageHelper.startPage(page, row);
		 criteria.getAllCriteria();
		 dynamicExample.setOrderByClause("viewNum");
		 List<Dynamic> dynamicList = dynamicMapper.selectByExample(dynamicExample);
		return dynamicList;
	}

}
