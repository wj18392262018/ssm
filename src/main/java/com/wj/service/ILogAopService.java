package com.wj.service;

import java.util.List;

import com.wj.entity.SysLog;

public interface ILogAopService {
	public void addLog(SysLog syLog) ;
	//��ѯ
	public List<SysLog> findAll();
}
