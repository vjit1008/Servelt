package com.neebalgurukul.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestLoginValidationService {
    @Test
    public void testLoginUserValidations() throws Exception {
	LoginService service = new LoginService();

	// boolean expectedOutput = true;
	assertTrue(service.isValidUser("Shrikant", "shrikant123"));
    }
}
