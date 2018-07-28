package com.yac.controller.basic_user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* 描述：基础用户信息控制层
* @author linhuang
* @date 2018/07/27
*/
@Controller
@RequestMapping(value = "/")
public class TabUserBasicInfoController {

    @Resource(name = "tabUserBasicInfoService")
    private ITabUserBasicInfoService tabUserBasicInfoService;

	/**
	 * 转发
	 */
	@RequestMapping(value = "/queryIndex")
    public String queryIndex(Map<String,Object> dataMap,HttpServletRequest req) {
        //获取以q_开头的参数集合
        Map<String,Object> queryMap = MapUtil.proMap(req);
        //默认每页10条
        Integer pageSize = ConvertUtils.string2Integer(req.getParameter("pageSize"), 10);
        Integer pageIndex = ConvertUtils.string2Integer(req.getParameter("pageIndex"), 1);
        //结尾数
        Integer start = (pageIndex-1)*pageSize+1;
        Integer end = pageIndex*pageSize;
        
        List<TabUserBasicInfo> resultList = tabUserBasicInfoService.queryMap(queryMap, start, end);
        Integer count = tabUserBasicInfoService.count(queryMap);
        
        dataMap.put("resultList", resultList);
        dataMap.put("count", count);
        dataMap.put("index", pageIndex);
        if(count%pageSize != 0) {
            dataMap.put("totalPage", count/pageSize+1);
        }else {
            dataMap.put("totalPage", count/pageSize);
        }
        dataMap.put("pageSize", pageSize);
        
        return "";
    }

	/**
	 * ajax异步
	 */
    @RequestMapping(value = "/queryMap",method = {RequestMethod.POST})
    public @ResponseBody Object queryMap(HttpServletRequest req) {
        Map<String,Object> dataMap = new HashMap<String, Object>();
        //获取以q_开头的参数集合
        Map<String,Object> queryMap = MapUtil.proMap(req);
        //默认每页10条
        Integer pageSize = ConvertUtils.string2Integer(req.getParameter("pageSize"), 10);
        Integer pageIndex = ConvertUtils.string2Integer(req.getParameter("pageIndex"), 1);
        //结尾数
        Integer start = (pageIndex-1)*pageSize+1;
        Integer end = pageIndex*pageSize;
        
        List<TabUserBasicInfo> resultList = tabUserBasicInfoService.queryMap(queryMap, start, end);
        Integer count = tabUserBasicInfoService.count(queryMap);
        
        dataMap.put("resultList", resultList);
        dataMap.put("count", count);
        dataMap.put("index", pageIndex);
        if(count%pageSize != 0) {
            dataMap.put("totalPage", count/pageSize+1);
        }else {
            dataMap.put("totalPage", count/pageSize);
        }
        dataMap.put("pageSize", pageSize);
        return dataMap;
    }

	/**
     * 新增角色页
     * @param dataMap
     * @param req
     * @return
     */
    @RequestMapping(value = "/addIndex")
    public String addIndex(Map<String, Object> dataMap, HttpServletRequest req) {
        return "";
    }
    
    /**
     * 编辑角色页
     * @param dataMap
     * @param req
     * @return
     */
    @RequestMapping(value = "/editIndex")
    public String editIndex(Map<String, Object> dataMap, HttpServletRequest req) {
        
        Integer id = ConvertUtils.string2Integer(req.getParameter("id"), 0);
        TabUserBasicInfo obj = tabUserBasicInfoService.getById(id);
        dataMap.put("obj", obj);
        return "";
    }
	
	/**
     * 添加
     * @param req
     * @return
     */
    @RequestMapping(value = "/add", method = { RequestMethod.POST })
    public @ResponseBody Integer add(HttpServletRequest req,TabUserBasicInfo tabUserBasicInfo) {
        return tabUserBasicInfoService.add(tabUserBasicInfo);
    }
    
    /**
     * 编辑
     * @param req
     * @return
     */
    @RequestMapping(value = "/edit", method = { RequestMethod.POST })
    public @ResponseBody Integer edit(HttpServletRequest req,TabUserBasicInfo tabUserBasicInfo) {
        return tabUserBasicInfoService.edit(tabUserBasicInfo);
    }
}