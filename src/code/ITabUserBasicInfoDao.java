package com.yac.sqlserver.dao;

import com.yac.model.TabUserBasicInfo;

/**
* 描述：基础用户信息 Dao层
* @author linhuang
* @date 2018/07/27
*/
@Repository("tabUserBasicInfoDao")
public interface ITabUserBasicInfoDao {

	TabUserBasicInfo getById(Integer id);
	
	Integer count(@Param("queryMap") Map<String,Object> queryMap);
	
	List<TabUserBasicInfo> queryMap(@Param("queryMap") Map<String,Object> queryMap,
				@Param("start") Integer start,@Param("end") Integer end);
	
	Integer add(TabUserBasicInfo tabUserBasicInfo);
	
	Integer edit(TabUserBasicInfo tabUserBasicInfo);
}