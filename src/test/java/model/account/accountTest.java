package model.account;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class accountTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testGetId() throws Exception {
		final account BillGatesAccount = new account();
		BillGatesAccount.setId((long)1);
		assertSame("Account id setter doesn't work !!!", BillGatesAccount.getId(),(long)1);
	}

	@Test
	public void testGetOwnerId() throws Exception {
		final account BillGatesAccount = new account();
		BillGatesAccount.setOwnerId((long)1);
		assertSame("Account owner id setter doesn't work !!!", BillGatesAccount.getOwnerId(),(long)1);
	}

	@Test
	public void testGetBalance() throws Exception {
		final account BillGatesAccount = new account();
		double balance = 580000000;
		BillGatesAccount.setBalance(balance);
		assertEquals(BillGatesAccount.getBalance(),balance,0);

	}

	@Test
	public void testGetCreationDate() throws Exception {
		final account BillGatesAccount = new account();
		assertEquals("Account's creation date isn't correct",BillGatesAccount.getCreationDate(),new Date());

	}


}