<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package_name}.sqlserver.dao.${package_children}.I${table_name}Dao">
	<#assign x = "#"+"{">
	<#assign y = "}">
	<resultMap type="${package_name}.entity.${package_children}.${table_name}" id="${table_name}Result">
		<#if model_column?exists>
	        <#list model_column as model>
       	<result column="${model.columnName}" property="${model.changeColumnName?uncap_first}"/>
	        </#list>
	    </#if>
		
	</resultMap>
	
	<select id="getById" resultMap="${table_name}Result">
		select 
			*
		from
			${table_name_small}
		where
			ID = ${x}id${y}
	</select>
	
	<sql id="whereConditions">
		<#if model_column?exists>
	        <#list model_column as model>
	    <if test="queryMap.q_${model.changeColumnName?uncap_first} != null and queryMap.q_${model.changeColumnName?uncap_first} != ''">and ${model.columnName} = ${x}queryMap.q_${model.changeColumnName?uncap_first}${y}</if>
	        </#list>
	    </#if>
	</sql>
	
	<select id="queryMap" resultMap="${table_name}Result">
		SELECT 
			* 
		FROM (
			SELECT 
				ROW_NUMBER() OVER (order by T.id) AS Row,
				T.*  
			from 
				${table_name_small} T
			where
				1=1
			<include refid="whereConditions" />
		) TT 
		WHERE 
			TT.Row between ${x}start${y} and ${x}end${y}
	</select>

	<select id="count" resultType="java.lang.Integer">
		select
			count(1)
		from
			${table_name_small}
		where
		1=1
		<include refid="whereConditions" />
	</select>
	
	<insert id="add" parameterType="${package_name}.entity.${package_children}.${table_name}"
		keyProperty="id" keyColumn="ID" useGeneratedKeys="true">
		insert into ${table_name_small}
		(
			<#if model_column?exists>
		        <#list model_column as model>
        	${model.columnName},
		        </#list>
		    </#if>
		)
		values
		(
			<#if model_column?exists>
		        <#list model_column as model>
        	${x}${model.changeColumnName?uncap_first}${y},
		        </#list>
		    </#if>
		)
	</insert> 
	
	<update id="edit" parameterType="${package_name}.entity.${package_children}.${table_name}">
		update ${table_name_small}
		set
			<#if model_column?exists>
		        <#list model_column as model>
        	<if test="${model.changeColumnName?uncap_first} !=null and ${model.changeColumnName?uncap_first} != ''">${model.columnName} = ${x}${model.changeColumnName?uncap_first}${y},</if>
		        </#list>
		    </#if>
		where
			ID = ${x}id${y}
	</update>
</mapper>