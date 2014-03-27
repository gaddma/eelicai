package com.fb.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.po.PrototypeObj;
import com.fb.po.RequestObj;
import com.fb.po.SessionObj;
import com.fb.po.SingletonObj;

@Controller
public class IndexController implements ApplicationContextAware {

	private RequestObj RequestObj;

	private SessionObj SessionObj;

	private PrototypeObj PrototypeObj;

	private SingletonObj SingletonObj;

	private ApplicationContext applicationContext;

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		print();
		return "Welcome";
	}

	public void print() {
		System.out.println("first  time singleton is :" + getSingletonObj());
		System.out.println("second time singleton is :" + getSingletonObj());

		System.out.println("first  time prototype is :" + getPrototypeObj());
		System.out.println("second time prototype is :" + getPrototypeObj());

		System.out.println("first  time request is :" + getRequestObj());
		System.out.println("second time request is :" + getRequestObj());

		System.out.println("first  time session is :" + getSessionObj());
		System.out.println("second time session is :" + getSessionObj());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public RequestObj getRequestObj() {
		return applicationContext.getBean(RequestObj.class);
	}

	public void setRequestObj(RequestObj requestObj) {
		RequestObj = requestObj;
	}

	public SessionObj getSessionObj() {
		return applicationContext.getBean(SessionObj.class);
	}

	public void setSessionObj(SessionObj sessionObj) {
		SessionObj = sessionObj;
	}

	public PrototypeObj getPrototypeObj() {
		return applicationContext.getBean(PrototypeObj.class);
	}

	public void setPrototypeObj(PrototypeObj prototypeObj) {
		PrototypeObj = prototypeObj;
	}

	public SingletonObj getSingletonObj() {
		return applicationContext.getBean(SingletonObj.class);
	}

	public void setSingletonObj(SingletonObj singletonObj) {
		SingletonObj = singletonObj;
	}

}
