package com.comcast.crm.invoice_test;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class CreateInvoiceTest extends BaseClass {
	@Test(retryAnalyzer = com.comcast.crm.listener_utility.RetryAnalyzerImp.class)
	public void invoiceTest() {
		Assert.fail();
	}

}
