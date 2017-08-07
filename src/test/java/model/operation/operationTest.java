package model.operation;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class operationTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSetOperationName() throws Exception {
		operation testOperation = new operation();
		testOperation.setOperationName("withdraw");
		assertEquals("The operationName getter/setter isn't working ",testOperation.getOperationName(),"withdraw");
	}

	@Test
	public void testSetOperationAmount() throws Exception {
		operation testOperation = new operation();
		testOperation.setOperationAmount(1000);
		assertEquals("The operationAmount getter/setter isn't working ",testOperation.getOperationAmount(),1000.0,0);
	}

	@Test
	public void testSetAccountsBalance() throws Exception {
		operation testOperation = new operation();
		testOperation.setAccountsBalance(130);
		assertEquals("The accountsBalance getter/setter isn't working ",testOperation.getAccountsBalance(),130,0);
	}

	@Test
	public void testOperationStringDoubleDouble() throws Exception {
		operation testOperation = new operation("withdraw",10,10);
		assertSame("The operationName is wrong ",testOperation.getOperationName(),"withdraw");
		assertEquals("The operationAmount is wrong ",testOperation.getOperationAmount(),10,0);
		assertEquals("The accountsBalance is wrong ",testOperation.getAccountsBalance(),10,0);


	}
}