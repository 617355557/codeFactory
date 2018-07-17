package ${package_name}.sqlserver.dao;
import com.evada.inno.core.repository.BaseJpaRepository;
import ${package_name}.model.${table_name};

/**
* 描述：${table_annotation} Repository接口
* @author ${author}
* @date ${date}
*/
@Repository("${table_name?uncap_first}Dao")
public interface I${table_name}Dao {

	${table_name} getById(Integer id);
	
	Integer count(@Param("queryMap") Map<String,Object> queryMap);
	
	List<${table_name}> queryMap(@Param("queryMap") Map<String,Object> queryMap,
				@Param("start") Integer start,@Param("size") Integer end);
	
	Integer add(${table_name} ${table_name?uncap_first});
	
	Integer edit(${table_name} ${table_name?uncap_first});
}