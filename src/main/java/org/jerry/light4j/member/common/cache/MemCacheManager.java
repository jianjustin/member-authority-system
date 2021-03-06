package org.jerry.light4j.member.common.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 内存缓存器,用于简易实现缓存功能
 * @author jian
 *
 */
public class MemCacheManager{
	public static Map<String,Object> memCache = new HashMap<String,Object>();
	
	public static boolean init(){
		try {
			memCache = new HashMap<String,Object>();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static String push(String key,Object value){
		if(null == memCache)init();//如果不存在则生成缓存实体
		if(null == key)return "";
		memCache.put(key, value);
		return key;
	}
	public static Object pop(String key){
		if(null == memCache)init();//如果不存在则生成缓存实体
		if(null == key)return "";
		return memCache.get(key);
	}
	public static Object remove(String key){
		if(null == memCache)init();//如果不存在则生成缓存实体
		if(null == key)return "";
		return memCache.remove(key);
	}
	
	public static boolean destory(){
		try {
			memCache = new HashMap<String,Object>();
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
