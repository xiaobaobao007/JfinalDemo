package com.xiaobaobao.demo;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author xiaobaobao
 * @date 2020/3/12，20:22
 */
public class DemoInterceptor implements Interceptor {
	public void intercept(Invocation inv) {
		System.out.println("Before method invoking");
		inv.invoke();
		System.out.println("After method invoking");
	}
}