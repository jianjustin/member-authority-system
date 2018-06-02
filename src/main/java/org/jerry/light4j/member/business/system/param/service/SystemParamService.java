package org.jerry.light4j.member.business.system.param.service;

import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.business.system.param.domain.SystemParam;

/******************************************
 * 实体服务接口
 * @author janine
 *
 *******************************************/
public interface SystemParamService {
     /**
      * 实体保存
      * @param systemParam
      * @return
      */
     public SystemParam save(SystemParam systemParam);
     /**
      * 实体更新
      * @param systemParam
      * @return
      */
     public SystemParam update(SystemParam systemParam);
     /**
      * 实体删除
      * @param systemParam
      * @return
      */
     public SystemParam delete(SystemParam systemParam);
     /**
 	 * 根据JPQL语句返回查询实体列表
 	 * @param jpql
 	 * @param paramValueList 参数列表,防止sql注入
 	 * @return
 	 */
 	public  List<SystemParam> queryAllByJPQL(String jpql,List<Object> paramValueList);
 	
 	/**
 	 * 根据JPQL语句返回查询键值对列表
 	 * @param jpql
 	 * @param paramValueList
 	 * @return
 	 */
 	public List<Map<String,Object>> queryAllColumnByJPQL(String jpql,List<Object> paramValueList);
 	
 	/**
 	 * 根据sql语句查询实体列表
 	 * @param sql
 	 * @param paramValueList
 	 * @return
 	 */
 	public  List<SystemParam> queryAllBySQL(String sql,List<Object> paramValueList);
 	
 	/**
 	 * 根据sql语句查询键值对列表
 	 * @param sql
 	 * @param paramValueList
 	 * @return
 	 */
 	public List<Map<String,Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList);
}
