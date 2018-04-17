package Challengeapi.src.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.Vicarious.Service.VicariousServiceI;
import com.Vicarious.ServiceImpl.VicariousServiceImpl;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

class VicariousServiceImplTest {
//	@Autowired VicariousServiceImpl  vicariousService;
	VicariousServiceI  vicariousService;
		VicariousServiceImpl vicariousServicemock;
	    @Before
	    public void setUp()  {
	    	System.out.println("Before");
	    	vicariousService = new VicariousServiceImpl();
	    	vicariousServicemock= mock(VicariousServiceImpl.class);
	    }
		
		@Test
		public void testGetRandomIntegerget() {
		
			Assert.assertNotNull(vicariousService.getRandomInteger());
			
			when(vicariousServicemock.getRandomInteger()).thenReturn(9);
			assertEquals(vicariousServicemock.getRandomInteger(), 9);
		}

		@Test
		public void testGetRandomIntegerposttwoarg() {
			Assert.assertNotNull(vicariousService.getRandomInteger(1,20));
			
//		when(vicariousServicemock.getRandomInteger()).thenReturn(5);
//		assertEquals(vicariousServicemock.getRandomInteger(1,20), 5);
			
			
		}

		@Test
		public void testGetRandomIntegerpostonegrtthen20() {
			int output=vicariousService.getRandomInteger(1,200);
			Assert.assertTrue(output<=20);
			
		//	when(vicariousServicemock.getRandomInteger()).thenReturn(10);
		//	assertEquals(vicariousServicemock.getRandomInteger(1,200), 10);
			
			
			
		}
		
		@Test
		public void testGetRandomIntegerpostonelsthen0() {
			int output2=vicariousService.getRandomInteger(-5,20);
			Assert.assertTrue(output2<=20);
			
		//	when(vicariousServicemock.getRandomInteger()).thenReturn(3);
		//	assertEquals(vicariousServicemock.getRandomInteger(-5,20), 3);
			
			
		}
		
		@BeforeClass
	    public static void startUp() {
	        System.out.println("BeforeClass");
	    }
	    @AfterClass
	    public static void shutDown() {
	        System.out.println("AfterClass");
	    }
	  
	    @After
	    public void tearDown() {
	    	vicariousService=null;
	    	vicariousServicemock=null;
	    	System.out.println("After");
	    }
		
		
		
		
		

}
