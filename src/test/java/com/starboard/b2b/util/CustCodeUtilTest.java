package com.starboard.b2b.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustCodeUtilTest {

	@Test
	public void testGetCustCodeWithoutCurrency() {
		String custCode = "AE-007-EUR";
		assertEquals("AE-007", CustCodeUtil.getCustCodeWithoutCurrency(custCode));
		assertEquals("", CustCodeUtil.getCustCodeWithoutCurrency(null));
		assertEquals("", CustCodeUtil.getCustCodeWithoutCurrency(""));
		assertEquals("", CustCodeUtil.getCustCodeWithoutCurrency("ASDF"));
		assertEquals("AE", CustCodeUtil.getCustCodeWithoutCurrency("AE-007"));
		
		
	}

}
