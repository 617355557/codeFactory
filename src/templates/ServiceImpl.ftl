package ${package_name}.serviceImpl.${package_children};

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
* 描述：${table_annotation} 服务实现层
* @author ${author}
* @date ${date}
*/
@Service("${table_name?uncap_first}Service")
public class ${table_name}ServiceImpl implements I${table_name}Service {
	private Logger log = Logger.getLogger(${table_name}ServiceImpl.class);
	
    @Resource(name = "${table_name?uncap_first}Model")
    private ${table_name}Model ${table_name?uncap_first}Model;
    
    @Override
	public ${table_name} getById(Integer id) {
		${table_name} result = null;
		try {
            result = ${table_name?uncap_first}Model.getById(id);
        }catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return result;
	}

    @Override
	public List<${table_name}> queryMap(Map<String, Object> queryMap, Integer start, Integer end) {
		List<${table_name}> result = null;
		try {
            result = ${table_name?uncap_first}Model.queryMap(queryMap, start, size);
        }catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return result;
	}

	@Override
	public Integer count(Map<String, Object> queryMap) {
		Integer count = 0;
        try {
            count = ${table_name?uncap_first}Model.count(queryMap);
        }catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return count;
	}

	@Override
	public Integer add(${table_name} ${table_name?uncap_first}) {
		Integer count = 0;
        try {
            count = ${table_name?uncap_first}Model.add(${table_name?uncap_first});
        }catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return count;
	}

	@Override
	public Integer edit(${table_name} ${table_name?uncap_first}) {
		Integer count = 0;
        try {
            count = ${table_name?uncap_first}Model.edit(${table_name?uncap_first});
        }catch(Exception e) {
            log.error(e.getMessage(),e);
        }
        return count;
	}
}