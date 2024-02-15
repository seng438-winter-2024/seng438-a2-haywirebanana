package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.ExpectationError;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	@Test
	public void testNegativeValues() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(-10));
	            one(values).getValue(1, 0);
	            will(returnValue(5));

	        }
	    });
	   
	    // This line will throw an InvalidParameterException when a null value is encountered
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals(-5, result, 0.0001);
	}

	@Test
	public void testNullValue() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(null));
	        }
	    });
	   
	    // This line will throw an InvalidParameterException when a null value is encountered
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals(0, result, 0.0001);
	}

	@Test(expected = ExpectationError.class)
	public void testNegativeColumnIndex() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(10));
	        }
	    });
	   
	    // This line will throw an InvalidParameterException when a null value is encountered
	    double result = DataUtilities.calculateColumnTotal(values, -1);
	}

	@Test
	public void testColumnOtherThanOne() {
	    // setup
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getColumnCount();
	            will(returnValue(4));
	            one(values).getValue(0, 0);
	            will(returnValue(1));
	            one(values).getValue(0, 1);
	            will(returnValue(2));
	            one(values).getValue(0, 2);
	            will(returnValue(3));
	            one(values).getValue(0, 3);
	            will(returnValue(4));
	            one(values).getValue(1, 0);
	            will(returnValue(5));
	            one(values).getValue(1, 1);
	            will(returnValue(5));
	            one(values).getValue(1, 2);
	            will(returnValue(5));
	            one(values).getValue(1, 3);
	            will(returnValue(5));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 2);
	    // verify
	    assertEquals(result, 8.0, .000000001d);
	    // tear-down: NONE in this test method
	}
	@Test
	public void testTenRowsForColumnTotal() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	        one(values).getRowCount();
	            will(returnValue(10));
	            one(values).getValue(0, 0);
	            will(returnValue(12));
	            one(values).getValue(1, 0);
	            will(returnValue(13));
	            one(values).getValue(2, 0);
	            will(returnValue(55));
	            one(values).getValue(3, 0);
	            will(returnValue(123));
	            one(values).getValue(4, 0);
	            will(returnValue(23));
	            one(values).getValue(5, 0);
	            will(returnValue(21313));
	            one(values).getValue(6, 0);
	            will(returnValue(123));
	            one(values).getValue(7, 0);
	            will(returnValue(11));
	            one(values).getValue(8, 0);
	            will(returnValue(1));
	            one(values).getValue(9, 0);
	            will(returnValue(2.1));

	        }
	    });
	   
	    // This line will throw an InvalidParameterException when a null value is encountered
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals(21676.1, result, 0.0001);
	}

	@Test(expected = ExpectationError.class)
	public void testInvalidDataObject() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue("HI"));
	            one(values).getValue(0, 1);
	            will(returnValue(5));
	        }
	    });
	   
	    // This line will throw an InvalidParameterException when a null value is encountered
	    double result = DataUtilities.calculateRowTotal(values, -1);
	}

	@Test
	public void testIntAsValueInData() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {

	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(5));
	            one(values).getValue(0,1);
	            will(returnValue(5));
	            one(values).getValue(1, 0);
	            will(returnValue(5));
	            one(values).getValue(1,1);
	            will(returnValue(5));
	        }
	    });
	   
	    // This line will throw an InvalidParameterException when a null value is encountered
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    assertEquals(10, result, 0.0001);
	}

	@Test
	public void testDoubleAsValueInData() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {

	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(0.5));
	            one(values).getValue(0,1);
	            will(returnValue(0.2));

	        }
	    });
	   
	    // This line will throw an InvalidParameterException when a null value is encountered
	    double result = DataUtilities.calculateRowTotal(values, 0);
	    assertEquals(0.7, result, 0.0001);
	}

	@Test(expected = ExpectationError.class)
	public void testNegativeRowIndex() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	        one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(1));
	            one(values).getValue(0,1);
	            will(returnValue(1));
	            one(values).getValue(1, 0);
	            will(returnValue(2));
	            one(values).getValue(1,1);
	            will(returnValue(2));
	        }
	    });
	   
	    // This line will throw an InvalidParameterException when a null value is encountered
	    double result = DataUtilities.calculateColumnTotal(values, -1);
	}
	 
	 @Test
	 public void calculateCumulativePercentageForThreeValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final KeyedValues vals = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(vals).getKey(0);
	             will(returnValue(0));
	             allowing(vals).getKey(1);
	             will(returnValue(1));
	             allowing(vals).getKey(2);
	             will(returnValue(2));
	             allowing(vals).getValue(0);
	             will(returnValue(5));
	             allowing(vals).getValue(1);
	             will(returnValue(9));
	             allowing(vals).getValue(2);
	             will(returnValue(2));
	             allowing(vals).getItemCount();
	             will(returnValue(3));
	         }
	     });
	     KeyedValues result = DataUtilities.getCumulativePercentages(vals);

	     // verify
	     assertEquals(0.3125, result.getValue(0)); // Key 0 should have value 0.3125
	     assertEquals(0.875, result.getValue(1));   // Key 1 should have value 0.875
	     assertEquals(1.0, result.getValue(2));     // Key 2 should have value 1.0
	 }
	 
	 @Test
	 public void calculateCumulativePercentageForOneValue() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final KeyedValues vals = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(vals).getKey(0);
	             will(returnValue(0));
	             allowing(vals).getValue(0);
	             will(returnValue(5));
	             allowing(vals).getItemCount();
	             will(returnValue(1));
	         }
	     });
	     KeyedValues result = DataUtilities.getCumulativePercentages(vals);

	     // verify
	     assertEquals(1.0, result.getValue(0)); 
	 }
	 
	    @Test
	    public void calculateCumulativePercentageForEmpty() {
	        Mockery mockingContext = new Mockery();
	        final KeyedValues vals = mockingContext.mock(KeyedValues.class);

	        mockingContext.checking(new Expectations() {
	            {
	                allowing(vals).getItemCount();
	                will(returnValue(0));
	            }
	        });

	        KeyedValues result = DataUtilities.getCumulativePercentages(vals);
	        assertTrue(result.getItemCount() == 0);
	    }
	 
	 @Test
	 public void calculateCumulativePercentageWithNegativeValues() {
	     Mockery mockingContext = new Mockery();
	     final KeyedValues vals = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(vals).getKey(0);
	             will(returnValue(0));
	             allowing(vals).getKey(1);
	             will(returnValue(1));
	             allowing(vals).getKey(2);
	             will(returnValue(2));
	             allowing(vals).getValue(0);
	             will(returnValue(-5));
	             allowing(vals).getValue(1);
	             will(returnValue(9));
	             allowing(vals).getValue(2);
	             will(returnValue(-2));
	             allowing(vals).getItemCount();
	             will(returnValue(3));
	         }
	     });
	     KeyedValues result = DataUtilities.getCumulativePercentages(vals);

	     // verify
	     assertEquals(0.3125, result.getValue(0)); // Key 0 should have value 0.3125
	     assertEquals(0.875, result.getValue(1));   // Key 1 should have value 0.875
	     assertEquals(1.0, result.getValue(2));     // Key 2 should have value 1.0
	 }
	
	 @Test
	 public void calculateCumulativePercentageWithFloatingPointValues() {
	     Mockery mockingContext = new Mockery();
	     final KeyedValues vals = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(vals).getKey(0);
	             will(returnValue(0));
	             allowing(vals).getKey(1);
	             will(returnValue(1));
	             allowing(vals).getKey(2);
	             will(returnValue(2));
	             allowing(vals).getValue(0);
	             will(returnValue(0.5));
	             allowing(vals).getValue(1);
	             will(returnValue(0.25));
	             allowing(vals).getValue(2);
	             will(returnValue(0.25));
	             allowing(vals).getItemCount();
	             will(returnValue(3));
	         }
	     });
	     KeyedValues result = DataUtilities.getCumulativePercentages(vals);

	     // verify
	     assertEquals(0.5, result.getValue(0)); // Key 0 should have value 0.3125
	     assertEquals(0.75, result.getValue(1));   // Key 1 should have value 0.875
	     assertEquals(1.0, result.getValue(2));     // Key 2 should have value 1.0
	 }
		 

}
