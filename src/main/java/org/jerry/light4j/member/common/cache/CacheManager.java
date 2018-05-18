package org.jerry.light4j.member.common.cache;


/**
 * 缓存管理
 * 通过配置缓存信息(redis,memcache)
 * @author chenjianrui
 *
 */
public interface CacheManager {
	
	public boolean init();
	public String push(String key,Object value);
	public Object pop(String key);
	public Object remove(String key);
	public boolean destory();

}
