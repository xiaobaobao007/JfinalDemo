package com.xiaobaobao.demo;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.xiaobaobao.demo.jfinal.ext.route.AutoBindRoutes;
import com.xiaobaobao.demo.model.sys.User;

/**
 * @author xiaobaobao
 * @date 2020/3/12，10:38
 */
public class DemoConfig extends JFinalConfig {

	//http://localhost/bmy/hello
	//http://localhost/bmy/login?a=root&b=root
	//http://localhost/bmy/logout/root-root
	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}

	/**
	 * 配置常量值
	 *
	 * @param me
	 */
	public void configConstant(Constants me) {
		PropKit.use("jdbc.properties");
		me.setDevMode(PropKit.getBoolean("devMode", false));
	}

	/**
	 * 配置路由，并访问类的index方法
	 *
	 * @param me
	 */
	public void configRoute(Routes me) {
		me.add(new AutoBindRoutes());
	}

	public void configPlugin(Plugins me) {
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);

		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		arp.setShowSql(true);
		me.add(arp);

		arp.addMapping("user", User.class);
	}

	public void configInterceptor(Interceptors me) {
		me.add(new DemoInterceptor());
	}

	public void configHandler(Handlers me) {
	}

	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("url"), PropKit.get("username"), PropKit.get("password").trim(), PropKit.get("driver"));
	}
}
