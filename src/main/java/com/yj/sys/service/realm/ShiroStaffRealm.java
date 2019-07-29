package com.yj.sys.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.sys.entity.SysStaff;
import com.yj.sys.mapper.SysStaffMapper;

/** 通过此realm完成认证和授权信息的获取及封装 */
@Service
public class ShiroStaffRealm extends AuthorizingRealm{
	
		@Autowired
		private SysStaffMapper mapper;
		
		@Override
		public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
			//构建凭证匹配对象
			HashedCredentialsMatcher cMatcher=new HashedCredentialsMatcher();
			//设置加密算法
			cMatcher.setStoredCredentialsHexEncoded(true);
			cMatcher.setHashAlgorithmName("MD5");
			//设置加密次数
			cMatcher.setHashIterations(1);
			super.setCredentialsMatcher(cMatcher);
		}
		
		@Override
		protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws  AuthenticationException{
			//1.从token获取用户信息
			UsernamePasswordToken ppToken = (UsernamePasswordToken)token;
			//2.基于用户名查询用户信息
			String name = ppToken.getUsername();
			System.out.println(name);
			//3.校验用户信息(用户是否存在,是否禁用)
			SysStaff user = mapper.findUserByName(name);
			if(user==null) throw new UnknownAccountException();
			
			//4.封装数据并返回  Object principal, Object hashedCredentials, ByteSource credentialsSalt, String realmName
			ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());//盐值
			
			
			SimpleAuthenticationInfo info = 
					new SimpleAuthenticationInfo(
							user,
							user.getPassword(),
							credentialsSalt,
							getName()
							);
			System.out.println("info:"+info);
			return info;
		}
		
		@Override
		protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
			//1.获取用户id
			//2.获取用户角色id
			
			return null;//返回给授权管理器
		}
		
}
