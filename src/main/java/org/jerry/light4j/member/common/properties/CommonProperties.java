package org.jerry.light4j.member.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 通用配置文件设置
 * @author admin
 *
 */
@Component
public class CommonProperties {

	@Value("${jerry.light4j.projectName}")
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	
}
