package com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.text.html.parser.DTD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.DynamicInfo;
import com.github.pagehelper.PageHelper;
import com.mapper.AttentionMapper;
import com.mapper.CollectionMapper;
import com.mapper.DynamicMapper;
import com.mapper.UserMapper;
import com.pojo.Attention;
import com.pojo.AttentionExample;
import com.pojo.Collection;
import com.pojo.CollectionExample;
import com.pojo.CollectionExample.Criteria;
import com.pojo.Dynamic;
import com.pojo.DynamicExample;
import com.pojo.User;
import com.pojo.UserExample;

/**
 * 收藏动态
 * 
 * @author Dell
 *
 */
@Service
public class DynamicServiceImpl implements DynamicService {
	@Autowired
	private DynamicMapper dynamicMapper;
	@Autowired
	private CollectionMapper collectionMapper;
	@Autowired
	private AttentionMapper attentionMapper;
	@Autowired
	private UserMapper userMapper;

	@Override   
	public void addDynamicCollect(int dynamicId, int userId) {
		Collection collection = new Collection(dynamicId, userId);
		collectionMapper.insert(collection);
	}

	@Override
	public void deleteDynamicCollect(int dynamicId, int userId) {
		CollectionExample collectionExample = new CollectionExample();
		Criteria criteria = collectionExample.createCriteria();
	
		criteria.andDynamicIdEqualTo(dynamicId);
		criteria.andUserIdEqualTo(userId);
		
		collectionMapper.deleteByExample(collectionExample);
	}

	@Override
	public List<Dynamic> queryDynamicCollect(int userId) {
		CollectionExample collectionExample = new CollectionExample();
		Criteria criteria = collectionExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Collection> collectionList = collectionMapper.selectByExample(collectionExample);
		List<Dynamic> dynamicList = new ArrayList();
		for (Collection c : collectionList) {
			DynamicExample dynamicExample = new DynamicExample();
			com.pojo.DynamicExample.Criteria dynamicCriteria = dynamicExample.createCriteria();
			dynamicCriteria.andIdEqualTo(c.getDynamicId());
			List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
			dynamicList.add(dynamics.get(0));
		}
		return dynamicList;
	}

	@Override
	public List<DynamicInfo> CommendDynamics(int page, int row) {

		DynamicExample dynamicExample = new DynamicExample();
		com.pojo.DynamicExample.Criteria criteria = dynamicExample.createCriteria();
		PageHelper.startPage(page, row);
		criteria.getAllCriteria();
		dynamicExample.setOrderByClause("view_Num  DESC");  //  DESC 降序   ASC  升序
		
		List<Dynamic> dynamicList = dynamicMapper.selectByExample(dynamicExample);

		List<DynamicInfo> dyInfoList = new ArrayList(); 
		for(Dynamic dy :dynamicList) {
//			UserExample userExample = new UserExample();
//			com.pojo.UserExample.Criteria userCriteria = userExample.createCriteria();
			User  author = userMapper.selectByPrimaryKey(dy.getAuthorId());
			DynamicInfo dynamicInfo = new DynamicInfo(dy.getId(), dy.getTitle()
					, dy.getIntroduction(), dy.getImageUrl(), dy.getKind()
					, dy.getVideoUrl(), dy.getPraisesNum(), dy.getViewNum()
					, dy.getCollectNum(), dy.getDate(), dy.getAuthorId()
					, author.getName(), author.getHeadUrl());
			dyInfoList.add(dynamicInfo);
			}
		
		return dyInfoList;
	}

	@Override
	public List<Dynamic> RelevantRecom(String kind) {
		DynamicExample dynamicExample = new DynamicExample();
		com.pojo.DynamicExample.Criteria criteria = dynamicExample.createCriteria();
		criteria.andKindEqualTo(kind);
		List<Dynamic> dynamicList = dynamicMapper.selectByExample(dynamicExample);
		List<Dynamic> relevantRecomList;
		if (dynamicList.size() > 5) { // 数量大于五 就 随机取五个
			relevantRecomList = new ArrayList();
			// 取同类随机数
			Set<Integer> dySet = new HashSet();

			while (dySet.size() < 5) {
				Random ran = new Random();
				int i = ran.nextInt(dynamicList.size());
				dySet.add(i);
			}
			for (int i : dySet) {
				relevantRecomList.add(dynamicList.get(i));

			}
		} else { // 数量不足五 就是 全部取
			relevantRecomList = dynamicList;
		}

		return relevantRecomList;
	}

	@Override
	public List<DynamicInfo> queryAttentDynamic(int userId) {
		AttentionExample attentionExample = new AttentionExample();
		com.pojo.AttentionExample.Criteria attentionCriteria = attentionExample.createCriteria();
		attentionCriteria.andUser1IdEqualTo(userId);
		DynamicExample dynamicExample = new DynamicExample();

		List<Attention> attentionList = attentionMapper.selectByExample(attentionExample);
		for (Attention attention : attentionList) {
			com.pojo.DynamicExample.Criteria dynamicCriteria = dynamicExample.or();
			int user2Id = attention.getUser2Id();
			dynamicCriteria.andAuthorIdEqualTo(user2Id);
		}
		List<Dynamic> dynamicList = dynamicMapper.selectByExample(dynamicExample);
		
		List<DynamicInfo> dyInfoList = new ArrayList(); 
		for(Dynamic dy :dynamicList) {
//			UserExample userExample = new UserExample();
//			com.pojo.UserExample.Criteria userCriteria = userExample.createCriteria();
			User  author = userMapper.selectByPrimaryKey(dy.getAuthorId());
			DynamicInfo dynamicInfo = new DynamicInfo(dy.getId(), dy.getTitle()
					, dy.getIntroduction(), dy.getImageUrl(), dy.getKind()
					, dy.getVideoUrl(), dy.getPraisesNum(), dy.getViewNum()
					, dy.getCollectNum(), dy.getDate(), dy.getAuthorId()
					, author.getName(), author.getHeadUrl());
			dyInfoList.add(dynamicInfo);
			}
		
		return dyInfoList;
	}

	@Override
	public List<DynamicInfo> queryMyDynamic(int userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		DynamicExample dynamicExample = new DynamicExample();
		com.pojo.DynamicExample.Criteria dynamicCriteria = dynamicExample.createCriteria();
		dynamicCriteria.andAuthorIdEqualTo(userId);
		List<Dynamic> dynamicList = dynamicMapper.selectByExample(dynamicExample);
		List<DynamicInfo>dynamicInfoList = new ArrayList();
		for (Dynamic dynamic : dynamicList) {
			DynamicInfo dynamicInfo = new DynamicInfo(dynamic.getId(), dynamic.getTitle()
					, dynamic.getIntroduction(), dynamic.getImageUrl(), dynamic.getKind()
					, dynamic.getVideoUrl(), dynamic.getPraisesNum(), dynamic.getViewNum()
					, dynamic.getCollectNum(),dynamic.getDate(),dynamic.getAuthorId()
					, user.getName(), user.getHeadUrl());
			dynamicInfoList.add(dynamicInfo);
		}
		return dynamicInfoList;
	}
}
