package model.account;

import static org.junit.Assert.*;
import org.junit.Test;


public class accountBuilderTest {

	@Test
	public void testCreateAccount() throws Exception {
		final account NeymarsAccount = accountBuilder.createAccount()
													.build();
		
		assertSame("The default account id setter doesn't work,  !!!", NeymarsAccount.getId(),null);
		assertSame("The default account  owner's Id setter  doesn't work !!!", NeymarsAccount.getOwnerId(),null);
		assertEquals("The default account balance setter doesn't work !!!", NeymarsAccount.getBalance(),0,0);

	}

	@Test
	public void testWhichIdIs() throws Exception {		
		final account NeymarsAccount = accountBuilder.createAccount()
													.whichIdIs((long)7)
													.build();
		
		assertSame("whichIdIs doesn't work,  !!!", NeymarsAccount.getId(),(long)7);

	}

	@Test
	public void testWhichBelongsTo() throws Exception {
		final account NeymarsAccount = accountBuilder.createAccount()
													.whichBelongsTo((long)10)
													.build();

		assertSame("whichBelongsTo doesn't work,  !!!", NeymarsAccount.getOwnerId(),(long)10);
	}

	@Test
	public void testWithBalance() throws Exception {
		final account NeymarsAccount = accountBuilder.createAccount()
													.withBalance(222000000)
													.build();

		assertEquals("withBalance doesn't work,  !!!", NeymarsAccount.getBalance(),222000000,0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testBuildIllegalArgument() throws Exception {
		accountBuilder.createAccount()
					  .withBalance(-10)
					  .build();
	}

}
