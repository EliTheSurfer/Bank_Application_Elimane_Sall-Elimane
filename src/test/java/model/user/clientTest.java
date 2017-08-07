package model.user;

import static org.junit.Assert.*;
import model.account.account;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Elimane sall
 *
 */
public class clientTest {
	
	/**
	 * A client is a user who own one or more accounts
	 * A client can withdraw or deposit money
	 * We have one user ( Steve Jobs) who own 2 accounts ( JobsAccount, TeenagerAccount) and a third account which doesn't belong to Steve Jobs
	 */
	static account JobsAccount = new account();
	static account WozniakAccount = new account();
	static account TeenagerAccount = new account();
	static client steveJobs = UserBuilder.createDefaultUser().withId((long)1).withFirstname("Steve").withLastname("Jobs").build();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Steve Jobs have 2 accounts one with 1500 and the other with -500 balance
		JobsAccount.setBalance(1500);
		TeenagerAccount.setBalance(-500);
		
		JobsAccount.setOwnerId((long)1);		
		steveJobs.usersaccounts.add(JobsAccount);
		TeenagerAccount.setOwnerId((long)1);
		steveJobs.usersaccounts.add(TeenagerAccount);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testWithdrawTooMuch() throws Exception {
		//Jobs can't withdraw more money than he has
		steveJobs.withdraw(JobsAccount, 1600);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithdrawFromAnotherAccount() throws Exception {
		//Jobs can't withdraw money from Wozniak's account
		steveJobs.withdraw(WozniakAccount, 0);
		steveJobs.getHistory();

	}

	@Test
	public void testDeposit() throws Exception {
		steveJobs.deposit(JobsAccount, 500);
		//Previously Jobs had 1500 on his account , then he added 500 so now we will have 2000 on his account balance
		assertEquals("The deposit didn't work ",JobsAccount.getBalance(),2000,0);
		steveJobs.getHistory();

	}

	@Test
	public void tesGlobaltBalance() throws Exception {
		//Steve have 2 accounts one with a 1500 balance and another with -500 so he have a global balance of 1000
		assertEquals("The global balance calculator isn't working as it should ",steveJobs.balance(),1000,0);

	}

}
