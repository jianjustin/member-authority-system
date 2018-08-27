package org.jerry.light4j.member.common.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.jerry.light4j.member.business.member.user.domain.MemberUser;
import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.common.sql.SqlUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 项目初始化加载数据
 * @author jian
 *
 */
@Controller
public class InitBeanFactory implements InitializingBean {
	
	@Autowired
    private BaseQueryRepositoryImpl<MemberUser, Serializable> baseQueryRepositoryImpl;

	@Override
	public void afterPropertiesSet() throws Exception {
		String sql = SqlUtils.getInitSql("MemberUser");
    	//List<MemberUser> list = baseQueryRepositoryImpl.queryAllByJPQL(sql,  SqlUtils.createParamValueList(), MemberUser.class);
		List<MemberUser> list = new ArrayList<MemberUser>();
    	System.out.println(list.size());

	}

	public BaseQueryRepositoryImpl<MemberUser, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}

	public void setBaseQueryRepositoryImpl(BaseQueryRepositoryImpl<MemberUser, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
	
	

}
