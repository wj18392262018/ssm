package com.wj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.wj.entity.SysLog;
import com.wj.service.ILogAopService;

@RequestMapping("/sysLog")
@Controller
public class SysLogController {
	@Autowired
	private ILogAopService logAopService;
	@RequestMapping("/findAll.do")
	public ModelAndView findAll() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<SysLog> sysLogs = logAopService.findAll();
		PageInfo pageInfo=new PageInfo(sysLogs);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("syslog-list");
		return mv;
	 }
}
