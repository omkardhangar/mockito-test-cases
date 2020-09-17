package com.omkar.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.reflect.Whitebox;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class PowermockTestWithPrivateMethod {
	
	@Mock
	Dependency dependencyMock;

	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Test
	public void mockingPrivateMethod() throws Exception {
		
		when(dependencyMock.retrieveAllStats()).thenReturn(Arrays.asList(1,2,3));
		// be careful at imports auto import gets wrong one
		int result = Whitebox.invokeMethod(systemUnderTest,"privateMethodUnderTest");
		
		assertEquals(6, result);
		
		
		
	}

}
