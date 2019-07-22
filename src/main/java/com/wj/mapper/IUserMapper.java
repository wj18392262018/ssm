package com.wj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wj.entity.User;

public interface IUserMapper {
	//用户登陆验证
	@Select("select * from users where username=#{username}")
	public User getUserByName(String username);
	 @Select("select * from users where username=#{username}")
	 @Results({
	 @Result(id = true, property = "id", column = "id"),
	 @Result(column = "username", property = "username"),
	 @Result(column = "email", property = "email"), 
	 @Result(column = "password", property = "password"),
	 @Result(column = "phoneNum", property = "phoneNum"), 
	 @Result(column = "status", property = "status"),
	 @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.wj.mapper.IRoleMapper.findRoleByUserId")) 
	 })
	 public User findByUsername(String username);
	 
	 //添加
	 @Insert("insert into users values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})") 
	public void save(User user) throws Exception;
	 //显示用户信息
	 @Select("select * from users")
	 public List<User> findAll();
	 //显示详情(链表查询)
	 @Select("select * from users where id=#{id}")
	 @Results({
	 @Result(id = true, property = "id", column = "id"),
	 @Result(column = "username", property = "username"),
	 @Result(column = "email", property = "email"), 
	 @Result(column = "password", property = "password"),
	 @Result(column = "phoneNum", property = "phoneNum"), 
	 @Result(column = "status", property = "status"),
	 @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.wj.mapper.IRoleMapper.findRoleByUserId")) 
	 })
	public User findById(String id);
	 //用户添加角色（操作中间表）
	@Insert("insert into users_role value(#{userId},#{roleId})")
	public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
