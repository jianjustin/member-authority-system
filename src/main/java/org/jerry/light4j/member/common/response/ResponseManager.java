package org.jerry.light4j.member.common.response;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * 响应实体封装
 * @author admin
 *
 */
public class ResponseManager {
	
	/**
	 * 根据参数集产生响应实体
	 * @param status
	 * @param headers
	 * @param datas
	 * @return
	 */
	public static ResponseEntity<Map<String,Object>> getResponse(HttpStatus status,MultiValueMap<String, String> headers,Map<String,Object> datas){
		ResponseEntity<Map<String,	Object>> responseEntity = new ResponseEntity<Map<String,Object>>(datas,headers,HttpStatus.OK);
		return responseEntity;
	}

}
