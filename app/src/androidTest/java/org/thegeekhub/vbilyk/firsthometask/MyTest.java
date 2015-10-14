package org.thegeekhub.vbilyk.firsthometask;

import junit.framework.TestCase;

public class MyTest extends TestCase {

    public void testFactorial() throws Exception {
        assertEquals(1, SecondActivity.factorial(0));
        assertEquals(6, SecondActivity.factorial(3));
        assertEquals(24, SecondActivity.factorial(4));
        assertEquals(120, SecondActivity.factorial(5));
    }

    public void testFibonacci() throws Exception {
        assertEquals(1, SecondActivity.fibonacci(1));
        assertEquals(1, SecondActivity.fibonacci(2));
        assertEquals(8, SecondActivity.fibonacci(6));
    }
}
