package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {
	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Ignore
	@Test
	public void testBQueryByShopId() throws Exception{
		long shopId = 8;
		List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
		System.err.println("该店铺的自定义店铺数为:" + productCategoryList.size());
	}
	

	@Test
	public void testABatchInsertProductCategory() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("商品类别1");
		productCategory.setPriority(1);
		productCategory.setCreateTime(new Date());
		productCategory.setShopId(16L);
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setProductCategoryName("商品类别2");
		productCategory2.setPriority(1);
		productCategory2.setCreateTime(new Date());
		productCategory2.setShopId(16L);
		List<ProductCategory> productCategoryList = new ArrayList<>();
		productCategoryList.add(productCategory);
		productCategoryList.add(productCategory2);
		int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
		assertEquals(2,effectedNum );	
	}
	
	@Test
	public void testCDeleteProductCategory() throws Exception{
		long shopId = 16L;
		List<ProductCategory> productCategoryList = new ArrayList<>();
		productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
		for(ProductCategory pc: productCategoryList) {
			if("商品类别1".equals(pc.getProductCategoryName()) || "商品类别2".equals(pc.getProductCategoryName())) {
				System.out.println(pc.getProductCategoryId()+"-----------------------------");
				int effectNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(), shopId);
				assertEquals(1, effectNum);
			}
		}
	}
}
