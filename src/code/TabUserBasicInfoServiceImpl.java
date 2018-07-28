package com.yac.serviceImpl.basic_user;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
* 描述：基础用户信息 服务实现层
* @author linhuang
* @date 2018/07/27
*/
@Service("tabUserBasicInfoService")
public class TabUserBasicInfoServiceImpl implements ITabUserBasicInfoService {
	private Logger log = Logger.getLogger(TabUserBasicInfoServiceImpl.class);
	
    @Resource(name = "tabUserBasicInfoModel")
    private TabUserBasicInfoModel tabUserBasicInfoModel;
    
    @Override
	public TabUserBasicInfo getById(Integer id) {
		TabUserBasicInfo result = null;
		try {
            result = tabUserBasicInfoModel.getById(id);
        }catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return result;
	}

    @Override
	public List<TabUserBasicInfo> queryMap(Map<String, Object> queryMap, Integer start, Integer end) {
		List<TabUserBasicInfo> result = null;
		try {
            result = tabUserBasicInfoModel.queryMap(queryMap, start, end);
        }catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return result;
	}

	@Override
	public Integer count(Map<String, Object> queryMap) {
		Integer count = 0;
        try {
            count = tabUserBasicInfoModel.count(queryMap);
        }catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return count;
	}

	@Override
	public Integer add(TabUserBasicInfo tabUserBasicInfo) {
		Integer count = 0;
        try {
            count = tabUserBasicInfoModel.add(tabUserBasicInfo);
        }catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return count;
	}

	@Override
	public Integer edit(TabUserBasicInfo tabUserBasicInfo) {
		Integer count = 0;
        try {
            count = tabUserBasicInfoModel.edit(tabUserBasicInfo);
        }catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return count;
	}
}