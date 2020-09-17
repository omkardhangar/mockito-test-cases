package com.omkar.service;

import static org.junit.Assert.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;

import com.omkar.repo.AppRepository;

//@RunWith(MockitoJUnitRunner.class)
public class MockitoWithAnnotationsTestCases {
	@Rule
	public MockitoRule mockRule = MockitoJUnit.rule();

	@Mock
	private AppRepository mockRepo;
	@InjectMocks
	ServiceClass service;
	@Captor
	ArgumentCaptor<String> argumentCaptor;

	List<String> dummyUsers = Arrays.asList("salman khan", "sr khan", "aamir khan", "Amarendra bahubali",
			"mahesh babu");

	@Test
	public void test1() {

		when(mockRepo.fetchUsers()).thenReturn(dummyUsers);

		List<String> listUsers = service.getAllUsers();

		// assertEquals(5, listUsers.size());

	}

	@Test
	public void test2() {

		when(mockRepo.fetchUsers()).thenReturn(dummyUsers);

		assertEquals(3, service.getHindiUsers().size());

		verify(mockRepo, times(1)).getHindiUsers();

//		then(mockRepo).should(times(1)).getHindiUsers();
//		verify(mockRepo, never()).getTeluguUsers();
//		then(mockRepo).should(never()).getHindiUsers();

	}

	@Test
	public void test3() {

		when(mockRepo.fetchUsers()).thenReturn(dummyUsers);

		service.getTamilUsers();
		verify(mockRepo).getTamilUsers(argumentCaptor.capture());
		assertEquals("kamal hasan", argumentCaptor.getValue());
		// assertEquals("kamal hasan", argumentCaptor.getAllValues());

	}

}
