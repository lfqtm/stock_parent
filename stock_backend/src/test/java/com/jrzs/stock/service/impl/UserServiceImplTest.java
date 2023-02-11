package com.jrzs.stock.service.impl;

import com.jrzs.stock.mapper.SysUserMapper;
import com.jrzs.stock.pojo.SysUser;
import com.jrzs.stock.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@MapperScan("com.jrzs.stock.mapper")
class UserServiceImplTest {

	@Resource
	private SysUserMapper mapper;


	@Test
	void login() {
		SysUser admin = mapper.findByUserName("admin");
		System.out.println("admin = " + admin);
	}
}
