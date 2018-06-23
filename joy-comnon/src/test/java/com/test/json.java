package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.common.JsonUtils;

public class json {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		UserInfo userInfo = new UserInfo("000000", "AWQI","18734741443","http://140.143.16.51/image/head/c.jpg", 1);
		String j = JsonUtils.objectToJson(userInfo);
		System.out.println("userInfo="+j);
		
	}

}
