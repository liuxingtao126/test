package com.mocha.work.testWork;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.MockitoAnnotations;

/**
 * Hello world!
 *
 */
public class TestWork
{
    public static void main( final String[] args )
    {
        System.out.println( "Hello World!" );
    }
    // timeout 以毫秒计算  
    @Test
    public void method2(){
      method();
    }
    public void method(){
      System.out.println("method2");
      
    }
    
    @Test
	public void verify_behaviour1(){
    	//mock creation
    	 final List mockedList = mock(List.class);

    	 //using mock object
    	 mockedList.add("one");
    	 mockedList.clear();

    	 //verification
    	 verify(mockedList).add("one");
    	 verify(mockedList).clear();
    	 
    	 
    	
	}
    @Test
    public void verify_behaviour2(){
    	//You can mock concrete classes, not just interfaces
   	 final LinkedList mockedList = mock(LinkedList.class);

   	 //stubbing
   	 when(mockedList.get(0)).thenReturn("first");
   	 when(mockedList.get(1)).thenThrow(new RuntimeException());

   	 //following prints "first"
   	 System.out.println(mockedList.get(0));

   	 //following throws runtime exception
   	 System.out.println(mockedList.get(1));

   	 //following prints "null" because get(999) was not stubbed
   	 System.out.println(mockedList.get(999));

   	 //Although it is possible to verify a stubbed invocation, usually it's just redundant
   	 //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
   	 //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
   	 verify(mockedList).get(0);
   	 
     
   	 
    }
   
	
	@Test
    public void verify_behaviour3(){
		
		final List mockedList = mock(List.class);
		
		 //stubbing using built-in anyInt() argument matcher
		 when(mockedList.get(anyInt())).thenReturn("element");

		 //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
		 when(mockedList.contains(argThat(new isValid()))).thenReturn(false);

		 //following prints "element"
		 System.out.println(mockedList.get(999));
		 System.out.println(mockedList.add(argThat(someString -> ((String) someString).length() > 5)));
		 //you can also verify using an argument matcher
		 verify(mockedList).get(anyInt());

		 //argument matchers can also be written as Java 8 Lambdas
		 verify(mockedList).add(argThat(someString -> ((String) someString).length() > 5));
    }
	
	
	@Test
    public void verify_behaviour4(){
			
		final List mockedList = mock(List.class);
		
		//using mock
		 mockedList.add("once");

		 mockedList.add("twice");
		 mockedList.add("twice");

		 mockedList.add("three times");
		 mockedList.add("three times");
		 mockedList.add("three times");

		 //following two verifications work exactly the same - times(1) is used by default
		 verify(mockedList).add("once");
		 verify(mockedList, times(1)).add("once");

		 //exact number of invocations verification
		 verify(mockedList, times(2)).add("twice");
		 verify(mockedList, times(3)).add("three times");

		 //verification using never(). never() is an alias to times(0)
		 verify(mockedList, never()).add("never happened");

		 //verification using atLeast()/atMost()
		 verify(mockedList, atLeastOnce()).add("three times");
		 verify(mockedList, atLeast(2)).add("three times");
		 verify(mockedList, atMost(4)).add("three times");
	}
	
	@Test
    public void verify_behaviour5(){
		
		final List mockedList = mock(List.class);
		doThrow(new RuntimeException()).when(mockedList).clear();

		   //following throws RuntimeException:
		   mockedList.clear();
	}
	
	@Test
    public void verify_behaviour6(){
		// A. Single mock whose methods must be invoked in a particular order
		 final List singleMock = mock(List.class);

		 //using a single mock
		 singleMock.add("was added first");
		 singleMock.add("was added second");

		 //create an inOrder verifier for a single mock
		 final InOrder inOrder = inOrder(singleMock);

		 //following will make sure that add is first called with "was added first, then with "was added second"
		 inOrder.verify(singleMock).add("was added first");
		 inOrder.verify(singleMock).add("was added second");

		 // B. Multiple mocks that must be used in a particular order
		 final List firstMock = mock(List.class);
		 final List secondMock = mock(List.class);

		 //using mocks
		 firstMock.add("was called first");
		 secondMock.add("was called second");

		 //create inOrder object passing any mocks that need to be verified in order
		 final InOrder inOrderVerify = inOrder(firstMock, secondMock);

		 //following will make sure that firstMock was called before secondMock
		 inOrderVerify.verify(firstMock).add("was called first");
		 inOrderVerify.verify(secondMock).add("was called second");

		 // Oh, and A + B can be mixed together at will
	}
	
	@Test
    public void verify_behaviour7(){
		
		 final List mockOne = mock(List.class);
		 final List mockTwo = mock(List.class);
		 final List mockThree = mock(List.class);
		 
		//using mocks - only mockOne is interacted
		 mockOne.add("one");

		 //ordinary verification
		 verify(mockOne).add("one");

		 //verify that method was never called on a mock
		 //verify(mockOne, never()).add("two");

		 //verify that other mocks were not interacted   查询没有交互的mock对象 
		 //verifyZeroInteractions(mockTwo, mockThree);
		 
		 mockOne.add("two");

		 verify(mockOne).add("one");

		 //following verification will fail 查询多余的方法调用 
		 verifyNoMoreInteractions(mockTwo);  
	}
	
	@Test
    public void verify_behaviour8(){
		
		MockitoAnnotations.initMocks(this);

	
	}
	
    
    
}
