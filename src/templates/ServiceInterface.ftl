package ${package_name}.service.${package_children};

/**
* 描述：${table_annotation}服务实现层接口
* @author ${author}
* @date ${date}
*/
public interface I${table_name}Service{

	${table_name} getById(Integer id);
	
	Integer count(Map<String,Object> queryMap);
	
	List<${table_name}> queryMap(Map<String,Object> queryMap, Integer start, Integer end);
	
	Integer add(${table_name} ${table_name?uncap_first});
	
	Integer edit(${table_name} ${table_name?uncap_first});
}