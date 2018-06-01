package org.jerry.light4j.member.common.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * sql工具集,用于sql注入组装
 * @author chenjianrui
 *
 */
public class SqlUtils {
	
	public static List<Object> paramValueList;
	
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

}
