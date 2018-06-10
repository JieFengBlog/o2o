package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.LocalAuth;
import com.imooc.o2o.entity.PersonInfo;

public class LocalAuthDaoTest extends BaseTest{
	
	@Autowired
	private LocalAuthDao localAuthDao;
	private static final String username = "testUsername";
	private static final String password = "testPassword";
	
	@Ignore
	@Test
	public void testInsertLocalAuth() {
		LocalAuth localAuth = new LocalAuth();
		localAuth.setUsername(username);
		localAuth.setPassword(password);
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		localAuth.setPersonInfo(personInfo);
		localAuth.setCreateTime(new Date());
		int effectedNum = localAuthDao.insertLocalAuth(localAuth);
		assertEquals(1, effectedNum);
	}
	
	@Ignore
	@Test
	public void testQueryLocalAuthByNameAndPwd() {
		LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(username, password);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = simpleDateFormat.format(localAuth.getCreateTime());
		System.out.println(date);
	}
	
	@Ignore
	@Test
	public void testQueryLocalAuthByUserId() {
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
		System.out.println(localAuth.getPersonInfo().getName());
	}
	
	@Test
	public void testUpdateLocalAuth() {
		Date date = new Date();
		int effectedNum = localAuthDao.updateLocalAuth(1L, username, password, "newPassword", date);
		assertEquals(1, effectedNum);
		LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
		System.out.println(localAuth.getPassword());
	}
}
