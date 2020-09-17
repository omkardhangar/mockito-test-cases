package com.omkar.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTestCases {

	@Test
	public void test() {
		// tell diff btw mock() & spy()
		List mockList = spy(ArrayList.class);
		List list = new ArrayList();

		mockList.add("omkar");
		mockList.add("some1");
		mockList.add("some2");
		// mockList.remove("omkar");

		assertEquals(0, mockList.size());

	}

}
