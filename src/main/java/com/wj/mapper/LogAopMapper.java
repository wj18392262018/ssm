package com.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.wj.entity.SysLog;

public interface LogAopMapper {
	@Insert("insert into syslog values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
	void addLog(SysLog syLog);
	//≤È—Ø
	@Select("select * from syslog")
	List<SysLog> findAll();

}
