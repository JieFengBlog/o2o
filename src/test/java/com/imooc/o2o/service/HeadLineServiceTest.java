package com.imooc.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.HeadLine;

public class HeadLineServiceTest extends BaseTest{
	@Autowired
	private HeadLineService headLineService;
	
	@Test
	public void testGetHeadLineList() {
		HeadLine headLineCondition = new HeadLine();
		headLineCondition.setEnableStatus(1);
		List<HeadLine> headLineList = headLineService.getHeadLineList(headLineCondition);
		System.out.println(headLineList.size());
		for(HeadLine headLine:headLineList) {
			System.out.println(headLine.getLineImg());
		}
	}
	
}
