package com.wj.service;

import java.util.List;

import com.wj.entity.SysLog;

public interface ILogAopService {
	public void addLog(SysLog syLog) ;
	//≤È—Ø
	public List<SysLog> findAll();
}
