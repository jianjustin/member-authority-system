package org.jerry.light4j.member.common.response;

import java.net.URI;
import java.net.URISyntaxException;
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
	@SuppressWarnings("static-access")
	public static ResponseEntity<Map<String,Object>> getResponse(HttpStatus status,MultiValueMap<String, String> headers,Map<String,Object> datas,String uri){
		URI responseURI = null;
		try {
			responseURI = new URI(uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Map<String,	Object>> responseEntity = new ResponseEntity<Map<String,Object>>(datas,headers,HttpStatus.OK);
		responseEntity.created(responseURI);
		return responseEntity;
	}

}
