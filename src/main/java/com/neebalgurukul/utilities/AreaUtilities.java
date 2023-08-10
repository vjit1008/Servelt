package com.neebalgurukul.utilities;

public class AreaUtilities {
    public int getAreaRectangle(int l, int b) {
	return l * b;
    }

    public int getPerimeterRectangle(int l, int b) {
	return 2 * (l + b);
    }

    public boolean isRectangle(int l, int b) {
	return !(l == b);
    }

    public boolean isEquilateral(int a, int b, int c) {
	throw new UnsupportedOperationException();
    }
}
