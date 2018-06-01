package org.jerry.light4j.member.common.session;

import java.util.HashMap;
import java.util.Map;

/**
 * 会话管理
 * @author admin
 *
 */
public class SessionManager {
	private static Map<String,UserSession> sessions = new HashMap<String,UserSession>();

	public static UserSession getSession(String sessionid){
		return sessions.get(sessionid);
	}
	
	public static UserSession createSession(String sessionid){
		UserSession userSession = new UserSession();
		sessions.put(sessionid, userSession);
		return userSession;
	}
	
	public static Map<String, UserSession> getSessions() {
		return sessions;
	}
	public static void setSessions(Map<String, UserSession> sessions) {
		SessionManager.sessions = sessions;
	}
}
