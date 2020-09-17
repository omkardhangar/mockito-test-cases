package com.omkar.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SystemUnderTest.class})
public class PowermockTestWithConstructor {
	
	@Mock
	ArrayList mockList;
	
 	SystemUnderTest systemUnderTest = new SystemUnderTest();
	
	@Test
	public void mockingConstuctor() throws Exception {
		when(mockList.size()).thenReturn(7);
		
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		
		int result = systemUnderTest.methodUsingAnArrayListConstructor();
		assertEquals(7, result);
		
		
		
	}

}
