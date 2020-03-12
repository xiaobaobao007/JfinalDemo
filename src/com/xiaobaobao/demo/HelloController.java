package com.xiaobaobao.demo;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.xiaobaobao.demo.jfinal.ext.route.ControllerBind;
import com.xiaobaobao.demo.model.sys.User;

@ControllerBind(controllerKey = "/bmy")
public class HelloController extends Controller {

	@Clear
	public void hello() {
		renderText("hello");
	}

	public void login() {
		String a = getPara("a");
		String b = getPara("b");
		User login = User.dao.login(a, b);
		renderText("result=" + (login != null));
	}

	public void logout() {
		String a = getPara(0);
		String b = getPara(1);
		User login = User.dao.login(a, b);
		renderText("result=" + (login != null));
	}
}