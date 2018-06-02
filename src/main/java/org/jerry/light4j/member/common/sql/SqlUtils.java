package org.jerry.light4j.member.common.sql;

import java.util.ArrayList;
import java.util.List;

import org.jerry.light4j.member.common.utils.StringUtils;

/**
 * sql工具集,用于sql注入组装
 * @author chenjianrui
 *
 */
public class SqlUtils {
	
	public static List<Object> paramValueList;
	public static final String initSql = "select t from modelName t where 1=1";
	
	/**
	 * 重置参数集
	 * @return
	 */
	public static List<Object> createParamValueList(){
		paramValueList = new ArrayList<Object>();
		return paramValueList;
	}
	
	/**
	 * 返回参数集
	 * @return
	 */
	public static List<Object> getParamValueList(){
		return paramValueList;
	}
	
	/**
	 * 根据表名称初始化jpql
	 * @return
	 */
	public static String getInitSql(String modelName){
		return StringUtils.replace(SqlUtils.initSql, "modelName", modelName);
	}

}
