package com.yj.common.config;

import java.util.LinkedHashMap;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @Configuration
 * @author UID
 *
 */
@Configuration  //bean
public class SpringShiroCoinfig {
	
	/**
	 * @Bean 描述的方法，其返回值会交给spring管理
	 * @Bean 一般应用在整合第三bean资源时
	 * @return
	 */
	@Bean("securityManager")
	public SecurityManager newSecurityManager(Realm realm,CacheManager cacheManager) {
		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		sManager.setCacheManager(cacheManager);
		sManager.setRememberMeManager(newRemeberMeManager());
		sManager.setSessionManager(newSessionManager());
		return sManager;
	}
	
	/**
	 * 	配置此对象
	 * @param shiroFilterFactoryBean
	 * @return
	 */
	@Bean("shiroFilterFactoryBean")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(@Autowired SecurityManager sManager) {
		ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(sManager);
		//设置无认证转移需认证页面
		sfBean.setLoginUrl("/doLoginUI");
		//定义map,指定请求过滤规则(哪些资源允许匿名访问)
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		/**anon 允许匿名访问*/
		
		map.put("doIndexUI","authc");
		
		/**authc 除了匿名访问的资源，其他都要认证*/
		map.put("/**", "anon");
		
		sfBean.setFilterChainDefinitionMap(map);
		
		return sfBean;
	}
	
	
	/** 授权配置 */
	//1.生命周期管理
	@Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
	
	//2.配置代理创建器对象(此对象负责为所有advisor生成proxy代理对象)
	@Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator newProxyCreator() {
    	return new DefaultAdvisorAutoProxyCreator();
    }
	
	//3.配置Advisor对象  AuthorizationAttributeSourceAdvisor(授权属性资源管理器)
	@Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
	
	/** 为SecurityManager配置缓存对象 */
	@Bean("cacheManager")
	public CacheManager newCacheManager() {
		return new MemoryConstrainedCacheManager();
	}
	
	/** 为SecurityManage配置session */
	public CookieRememberMeManager newRemeberMeManager() {
		CookieRememberMeManager c = new CookieRememberMeManager();
		c.setCookie(newSimpleCookie());
		return c;
	}
	
	
	public  SimpleCookie newSimpleCookie() {
		SimpleCookie cookie = new SimpleCookie("rememberMe");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(60*60);
		return cookie;
	}
	/** 为SecurityManage配置session */
	
	public DefaultWebSessionManager newSessionManager() {
		DefaultWebSessionManager  sessionManager=new DefaultWebSessionManager();
		//sessionManager.setDeleteInvalidSessions(true);
		sessionManager.setGlobalSessionTimeout(3600000);
		return sessionManager;
	}
}
