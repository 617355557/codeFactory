package com.yac.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
* 描述：基础用户信息Model层
* @author linhuang
* @date 2018/07/27
*/
@Component("tabUserBasicInfoModel")
public class TabUserBasicInfoModel{

	@Resource(name = "tabUserBasicInfoDao")
	private ITabUserBasicInfoDao tabUserBasicInfoDao;

	/**
     * 总数
     * @param queryMap
     * @return
     */
	public Integer count(Map<String,Object> queryMap){
		return tabUserBasicInfoDao.count(queryMap);
	}

    /**
     * 分页查询
     * @return
     */
    public  List<TabUserBasicInfo> queryMap(Map<String,Object> queryMap, Integer start, Integer end){
        List<TabUserBasicInfo> result =  tabUserBasicInfoDao.queryMap(queryMap, start, end);
        return result;
    }
    
    /**
     * 根据id查询
     * @return
     */
    public TabUserBasicInfo getById(Integer id){
        return tabUserBasicInfoDao.getById(id);
    }

	public Integer add(TabUserBasicInfo tabUserBasicInfo){
		return tabUserBasicInfoDao.add(tabUserBasicInfo);
	}
	
	public Integer edit(TabUserBasicInfo tabUserBasicInfo){
		return tabUserBasicInfoDao.edit(tabUserBasicInfo);
	}
}