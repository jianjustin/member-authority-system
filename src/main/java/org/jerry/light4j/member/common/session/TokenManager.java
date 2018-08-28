package org.jerry.light4j.member.common.session;

import org.jerry.light4j.member.common.utils.EncryptionUtils;

/**
 * 自定义token
 * @author admin
 *
 */
public class TokenManager {

	public static String createTokenId(String sessionid,String ip){
		return EncryptionUtils.cryptMD5(sessionid + "-"+ip);
	}
	
	public static boolean checkTokenId(String sessionid,String ip,String tokenid){
		String tokenid2 = EncryptionUtils.cryptMD5(sessionid + "-"+ip);
		return tokenid2.equals(tokenid);
	}
}
