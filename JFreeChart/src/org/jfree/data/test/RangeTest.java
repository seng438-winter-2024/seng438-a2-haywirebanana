package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range exampleRange1;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception 
    { 
    	exampleRange = new Range(-1, 1);
    	exampleRange1 = new Range(1, 1);
    }


    @Test
    public void lowerBoundShouldBeNegativeOne() {
        assertEquals("The lower boundary of -1 and 1 should be -1",
        -1, exampleRange.getLowerBound(), .000000001d);
    }
    
    
    @Test
    public void lowerBoundShouldBeOne() {
        assertEquals("The lower boundary of 1 and 1 should be 1",
        1, exampleRange1.getLowerBound(), .000000001d);
    }
    
    @Test
    public void upperBoundShouldBeNegativeOne() {
        assertEquals("The upper boundary of -1 and 1 should be 1",
        -1, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void upperBoundShouldBeOne() {
        assertEquals("The upper boundary of 1 and 1 should be 1",
        1, exampleRange1.getUpperBound(), .000000001d);
    }
    
    
    @Test
    public void lengthShouldBeTwo() {
        assertEquals("The length of 1 and 1 should be 3",
        2, exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void lengthShouldBeZero() {
        assertEquals("The upper boundary of 1 and 1 should be 0",
        0, exampleRange1.getLength(), .000000001d);
    }
    
    @Test
    public void intersectLower() {
        assertTrue("The range of -2 and 0 intersects -1 and 1",
        exampleRange.intersects(-2,1));
    }
    
    @Test
    public void intersectUpper() {
        boolean result = exampleRange.intersects(0, 2);
        System.out.println("Actual Result: " + result);
        assertTrue("The range of 0 and 2 intersects -1 and 1", result);
    }
    
    @Test
    public void intersectAll() {
        assertTrue("The range of -2 and 2 intersects -1 and 1",
        exampleRange.intersects(-2,2));
    }
    
    @Test
    public void intersectNone() {
        assertTrue("The range of -4 and -2 does not intersects -1 and 1",
        exampleRange.intersects(-4,-2));
    }
    
    @Test
    public void containsValue() {
        assertTrue("The range of -1 and 1 contains the value 0",
        exampleRange.contains(0));
    }
    
    @Test
    public void doesNotContainValue() {
        assertFalse("The range of -1 and 1 should not contain the value 5",
        exampleRange.contains(5));
    }
    
    


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
