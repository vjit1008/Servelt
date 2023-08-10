package com.neebalgurukul.utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FirstJUnit {

    @Test
    public void testGetAreaRectangle() {
	AreaUtilities aUtil = new AreaUtilities();
	int l = 4;
	int b = 3;
	int expextedOutput = 12;
	int actualOutput = aUtil.getAreaRectangle(l, b);
	assertEquals(expextedOutput, actualOutput);
    }

    @Test
    public void tesGetPerimetereREactangle() {
	AreaUtilities aUtil = new AreaUtilities();
	int l = 4;
	int b = 3;
	int expextedOutput = 14;
	int actualOutput = aUtil.getPerimeterRectangle(l, b);
	assertEquals(expextedOutput, actualOutput);
    }

    @Test
    public void testIsRectangle() {
	AreaUtilities aUtil = new AreaUtilities();
	int l = 3;
	int b = 4;
//	int expextedOutput = 14;
	boolean actualOutput = aUtil.isRectangle(l, b);
	assertTrue(actualOutput);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIsEquilateral() {
	AreaUtilities aUtil = new AreaUtilities();
	assertTrue(aUtil.isEquilateral(2, 2, 2));
    }
}
