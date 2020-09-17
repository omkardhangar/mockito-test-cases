package com.omkar.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTestCases {

	@Test
	public void test1() {

		List mockList = mock(List.class);

		when(mockList.size()).thenReturn(7).thenReturn(9);

		assertEquals(7, mockList.size());
		assertEquals(9, mockList.size());

	}

	@Test
	public void test2() {

		List mockList = mock(List.class);

		when(mockList.get(anyInt())).thenReturn("salman khan");

		assertEquals("salman khan", mockList.get(anyInt()));
	}

	@Test
	public void test3BBD() {

		List<String> mockList = mock(List.class);

		given(mockList.get(anyInt())).willReturn("salman khan");

		String name = mockList.get(0);

		assertThat(name, is("salman khan"));
	}
	
	
	@Test(expected = NullPointerException.class)
	public void test4() {

		List mockList = mock(List.class);

		when(mockList.get(anyInt())).thenThrow(new NullPointerException());
		mockList.get(anyInt());

		//assertEquals("salman khan", mockList.get(anyInt()));
	}

}
