package org.jerry.light4j.member.common.code;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.common.sql.SqlUtils;
import org.jerry.light4j.member.common.utils.StringUtils;

/**
 * 自定义编号规则
 * @author admin
 *
 */
public class CodeUtils {
	private static final String initCode = "00000000";
	private static final String queryMaxCode = "select max(tableNameCode) from TableName t where 1=1";
	private static final String codeSize = "1";
	
	/**
	 * 通过最大编号获取下一编号
	 * @param oldCode
	 * @return
	 */
	public static String getCode(String oldCode){
		String newCode = oldCode;
		if(StringUtils.isBlank(oldCode)){
			newCode = CodeUtils.initCode;
		}else{
			BigDecimal codeValue = new BigDecimal(newCode);
			BigDecimal codeSize = new BigDecimal(CodeUtils.codeSize);
			codeValue = codeValue.add(codeSize);
			DecimalFormat df = new DecimalFormat(CodeUtils.initCode);
			newCode = df.format(codeValue);
		}
		return newCode;
	}
	
	public static <T> String queryMax(BaseQueryRepositoryImpl<T, Serializable> baseQueryRepositoryImpl,String tableName,Class<T> clazz){
		String sql = CodeUtils.queryMaxCode;
		sql = StringUtils.replace(sql, "tableName", tableName);
		sql = StringUtils.replace(sql, "TableName", StringUtils.upperFirst(tableName));
    	List<Map<String,Object>> list = baseQueryRepositoryImpl.queryAllColumnByJPQL(sql, SqlUtils.createParamValueList(), clazz);
    	if(null == list || list.size() == 0 || StringUtils.isBlank(list.get(0).get(tableName+"Code")))return null;
		return list.get(0).get(tableName+"Code").toString();
	}
	
	public static Date queryNow(){
		return new Date();
	}
	
	
	public static void main(String[] args) {
		System.out.println(getCode("00000000"));
	}

}
