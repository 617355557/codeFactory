package com.yac.service.basic_user;

/**
* 描述：基础用户信息服务实现层接口
* @author linhuang
* @date 2018/07/27
*/
public interface ITabUserBasicInfoService{

	TabUserBasicInfo getById(Integer id);
	
	Integer count(Map<String,Object> queryMap);
	
	List<TabUserBasicInfo> queryMap(Map<String,Object> queryMap, Integer start, Integer end);
	
	Integer add(TabUserBasicInfo tabUserBasicInfo);
	
	Integer edit(TabUserBasicInfo tabUserBasicInfo);
}