package com.fb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.po.Query;
import com.fb.service.QueryService;
import com.fb.service.UserService;

@Controller
public class IndexController {
    
    @Autowired
    private UserService userService;
    
    @Resource
    private QueryService queryService;
    
	@RequestMapping("/")
	@ResponseBody
    public String index(Model model) {
        return "Welcome";
    }
	
	@RequestMapping("/hello")
    @ResponseBody
    public String hello(Model model) {
	    String userName = userService.getUserName();
        return "Hello " + userName;
    }
	
	
	@RequestMapping("/query")
    @ResponseBody
    public String query(String input) {
		List<Query> queryList = queryService.getQueryList(input);
        return "result is : " + queryList.toString();
    }
}
