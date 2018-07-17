<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package_name}.sqlserver.dao.I${table_name}Dao">
	
	<resultMap type="${package_name}.entity.${table_name}" id="${table_name}Result">
		
	</resultMap>
	
	<#if model_column?exists>
        <#list model_column as model>
		    /**
		    *${model.columnComment!}
		    */
		    <#if (model.columnType = 'varchar' || model.columnType = 'text')>
		    @Column(name = "${model.columnName}",columnDefinition = "VARCHAR")
		    private String ${model.changeColumnName?uncap_first};
		
		    </#if>
		    <#if model.columnType = 'timestamp' >
		    @Column(name = "${model.columnName}",columnDefinition = "TIMESTAMP")
		    private Date ${model.changeColumnName?uncap_first};
		
		    </#if>
        </#list>
    </#if>
	
	<#if model_column?exists>
	<#list model_column as model>
	<#if (model.columnType = 'varchar' || model.columnType = 'text')>
	    public String get${model.changeColumnName}() {
	        return this.${model.changeColumnName?uncap_first};
	    }
	
	    public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
	        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
	    }
	
	</#if>
	<#if model.columnType = 'timestamp' >
	    public Date get${model.changeColumnName}() {
	        return this.${model.changeColumnName?uncap_first};
	    }
	
	    public void set${model.changeColumnName}(Date ${model.changeColumnName?uncap_first}) {
	        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
	    }
	
	</#if>
	</#list>
	</#if>
	
</mapper>