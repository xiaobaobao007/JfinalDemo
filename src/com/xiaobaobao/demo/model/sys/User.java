package com.xiaobaobao.demo.model.sys;

import com.xiaobaobao.demo.model.sys.base.BaseUser;

/**
 * @author xiaobaobao
 * @date 2020/3/12，12:23
 */
public class User extends BaseUser<User> {

	public static final User dao = new User();

	public User login(String account,String password){
		return findFirst("select * from user where account=? and password=?", account,password);
	}

}
