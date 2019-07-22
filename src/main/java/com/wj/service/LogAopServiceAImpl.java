package com.wj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wj.entity.SysLog;
import com.wj.mapper.LogAopMapper;
@Service("logAopService")
public class LogAopServiceAImpl  implements ILogAopService{
	@Autowired
	private LogAopMapper logAopMapper;
	//ÃÌº”
	@Override
	public void addLog(SysLog syLog) {
		// TODO Auto-generated method stub
		logAopMapper.addLog(syLog);
	}
	//≤È—Ø
	@Override
	public List<SysLog> findAll() {
		// TODO Auto-generated method stub
		return logAopMapper.findAll();
	}
	
}
