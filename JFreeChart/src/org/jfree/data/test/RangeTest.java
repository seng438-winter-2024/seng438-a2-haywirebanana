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
    
	// --------------------------------------------------------
	// THESE TESTS ARE FOR THE METHOD getLowerBound()
    
    
    @Test
    public void lowerBoundShouldBeNegativeOne() {
        assertEquals("The lower boundary of -1 and 1 should be -1",
        -1, exampleRange.getLowerBound(), .000000001d);
    }
    
    
    @Test
    public void lowerBoundShouldBeOne() {
    	// testing the method of a range of just 1
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
    	// test with lower bound as a large negative value
    	Range range = new Range(-Double.MAX_VALUE, 10);
    	assertEquals("The lower bound should be -Double.MAX_VALUE", -Double.MAX_VALUE, range.getLowerBound(), 0);
    }

    @Test
    public void lowerBoundWorstCaseTesting() {
        // test with a large range where both bounds are at the maximum representable value
        Range range = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals("the Lower bound should be Double.MAX_VALUE", Double.MAX_VALUE, range.getLowerBound(), 0);
    }
    
    
	// --------------------------------------------------------
	// THESE TESTS ARE FOR THE METHOD getUpperBound()
    
    @Test
    public void upperBoundTestOfDistinctRange() {
        assertEquals("The upper boundary of -1 and 1 should be 1",
        1, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void upperBoundShouldBeOne() {
    	// testing is the methods works for a range of just 1
        assertEquals("The upper boundary of 1 and 1 should be 1",
        1, exampleRange1.getUpperBound(), .000000001d);
    }
    
    @Test
    public void upperBoundIsLargestVal() {
        // testing with upper bound as the largest representable value
        Range range = new Range(0, Double.MAX_VALUE);
        assertEquals("Upper bound should be Double.MAX_VALUE", Double.MAX_VALUE, range.getUpperBound(), 0);
    }
  

    
    
	// --------------------------------------------------------
	// THESE TESTS ARE FOR THE METHOD getLength()
    
    @Test
    public void lengthShouldBePositiveForNonEmptyRange() {
        Range range = new Range(-1, 1); 
        assertTrue("The length of a non-empty range should be positive",
                range.getLength() > 0);
    }

    
    @Test
    public void lengthShouldBeZero() {
        assertEquals("The length of 1 and 1 should be 0",
        0, exampleRange1.getLength(), .000000001d);
    }
    
    @Test
    public void lengthWithNaNLower() {
    	// invalid length
        Range range = new Range(Double.NaN, 10);
        assertTrue("The length should be NaN", Double.isNaN(range.getLength()));

    }
    
    
	// --------------------------------------------------------
	// THESE TESTS ARE FOR THE METHOD intersects()
    
    @Test
    public void intersectLower() {
    	// testing the intersection of the lower bound
        assertTrue("The range of -2 and 0 intersects -1 and 1",
        exampleRange.intersects(-2,1));
    }
    
    @Test
    public void intersectUpper() {
    	// testing the intersection of the upper bound
        boolean result = exampleRange.intersects(0, 2);
        System.out.println("Actual Result: " + result);
        assertTrue("The range of 0 and 2 intersects -1 and 1", result);
    }
    
    @Test
    public void intersectAll() {
    	// testing the intersection of the whole range
        assertTrue("The range of -2 and 2 intersects -1 and 1",
        exampleRange.intersects(-2,2));
    }
    
    @Test
    public void intersectSame() {
    	// testing the intersection of the same range
        assertTrue("The range of -1 and 1 intersects -1 and 1",
        exampleRange.intersects(-1, 1));
    }
    
    @Test
    public void intersectNone() {
    	// testing the intersection of a distinct range
        assertTrue("The range of -4 and -2 does not intersects -1 and 1",
        exampleRange.intersects(-4,-2));
    }
    
    @Test
    public void intersectNaN() {
    	// testing is a NaN range intersects range
    	assertFalse("The range of NaN and NaN does not intersect -1 and 1",
    	exampleRange.intersects(Double.NaN, Double.NaN));
    }
    
	// --------------------------------------------------------
	// THESE TESTS ARE FOR THE METHOD contains()
    
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
