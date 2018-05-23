package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	
	
	@Test
	public void testQueryShopList() {
		Shop shopCondition = new Shop();
		ShopCategory parent = new ShopCategory();
		parent.setShopCategoryId(1L);
		ShopCategory category = new ShopCategory();
		category.setParent(parent);
		shopCondition.setShopCategory(category);
		List<Shop> shoplist = shopDao.queryShopList(shopCondition, 0, 5);
		System.out.println("first================================14");
		System.out.println(shoplist.size());
		for(Shop shop:shoplist) {
			System.out.println(shop.getShopId()+ shop.getShopName());
		}
	}
	
	@Ignore
	@Test
	public void testQueryByShopId() {
		long shopId = 8;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println("areaId" + shop.getArea().getAreaId());
		System.out.println("areaName" + shop.getArea().getAreaName());
	}
	
	@Ignore
	@Test
	public void testInsertShop() {
		// TODO Auto-generated method stub
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(20);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("SSSSSSSS");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
	@Ignore
	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		shop.setShopId(1L);
		owner.setUserId(1L);
		area.setAreaId(20);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("第二次测试店铺");
		shop.setShopDesc("沙aaaaa");
		shop.setShopAddr("test");
		shop.setPhone("13509752195");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(2);
		shop.setAdvice("这是测试");
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
		
	}
}
