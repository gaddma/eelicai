package com.fb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.po.PrototypeObj;
import com.fb.po.RequestObj;
import com.fb.po.SessionObj;
import com.fb.po.SingletonObj;

@Controller
@Scope("prototype")
public class SecondController {

	@Autowired
	private RequestObj RequestObj;

	@Autowired
	private SessionObj SessionObj;

	@Autowired
	private PrototypeObj PrototypeObj;

	@Autowired
	private SingletonObj SingletonObj;

	@RequestMapping("/test")
	@ResponseBody
	public String index() {
		print();
		return "Welcome";
	}

	public void print() {
		System.out.println("first  time singleton is :" + SingletonObj);
		System.out.println("second time singleton is :" + SingletonObj);

		System.out.println("first  time prototype is :" + PrototypeObj);
		System.out.println("second time prototype is :" + PrototypeObj);

		System.out.println("first  time request is :" + RequestObj);
		System.out.println("second time request is :" + RequestObj);

		System.out.println("first  time session is :" + SessionObj);
		System.out.println("second time session is :" + SessionObj);
	}

}
