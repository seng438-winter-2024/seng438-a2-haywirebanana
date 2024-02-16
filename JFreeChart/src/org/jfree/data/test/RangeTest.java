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
    public void lowerBoundShouldBeMinimumValue() {
        Range range = new Range(Integer.MIN_VALUE, 100);
        assertEquals("The lower boundary should be Integer.MIN_VALUE",
                Integer.MIN_VALUE, range.getLowerBound(), 0);
    }

    @Test
    public void lowerBoundShouldBeNaN() {
        Range range = new Range(Double.NaN, 100);
        assertTrue("The lower boundary should be NaN",
                Double.isNaN(range.getLowerBound()));
    }
    
    @Test
    public void lowerBoundIsLargestNeg() {
    	// Test with lower bound as a large negative value
    	Range range = new Range(-Double.MAX_VALUE, 10);
    	assertEquals("Lower bound should be -Double.MAX_VALUE", -Double.MAX_VALUE, range.getLowerBound(), 0);
    }

    @Test
    public void lowerBoundWorstCaseTesting() {
        // Test with a large range where both bounds are at the maximum representable value
        Range range = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals("Lower bound should be Double.MAX_VALUE", Double.MAX_VALUE, range.getLowerBound(), 0);
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
    public void upperBoundIsLargestVal() {
        // Test with upper bound as the largest representable value
        Range range = new Range(0, Double.MAX_VALUE);
        assertEquals("Upper bound should be Double.MAX_VALUE", Double.MAX_VALUE, range.getUpperBound(), 0);
    }
    
    @Test
    public void upperBoundWithNaNLower() {
        Range range = new Range(Double.NaN, 10);
        assertNull("Upper bound should be null", range.getUpperBound());
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
    public void lengthWithNaNLower() {
        Range range = new Range(Double.NaN, 10);
        assertNull("Upper bound should be null", range.getLength());
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
    public void intersectSame() {
        assertTrue("The range of -2 and 2 intersects -1 and 1",
        exampleRange.intersects(-2,2));
        assertTrue("The range of -1 and 1 intersects -1 and 1",
        exampleRange.intersects(-1, 1));
    }
    
    @Test
    public void intersectNone() {
        assertTrue("The range of -4 and -2 does not intersects -1 and 1",
        exampleRange.intersects(-4,-2));
    }
    
    @Test
    public void intersectNaN() {
    	assertFalse("The range of null and null does not intersect -1 and 1",
    	exampleRange.intersects(Double.NaN, Double.NaN));
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
    
    @Test
    public void doesNotContainNaNValue() {
    	assertFalse("The range of -1 and 1 should not contain NaN",
    	exampleRange.contains(Double.NaN));
    }
    


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
