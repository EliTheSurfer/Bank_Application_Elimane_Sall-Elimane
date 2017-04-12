package Bank;

import static org.junit.Assert.*;
import model.account.account;
import model.user.UserBuilder;
import model.user.user;

import org.junit.BeforeClass;
import org.junit.Test;

public class bankManagementTest {
	
	static account hiddenCaimanIslandAccount = new account();
	static account dailyLifeAccount = new account();
	static account anotherHiddenAccount = new account();
	
	static user jeromeCahuzac = UserBuilder.createDefaultUser().withId((long)5).withFirstname("Jerome").withLastname("Cahuzac").build();
	static user userTodelete = UserBuilder.createDefaultUser().build();
	
	static bankManagement bank = new bankManagement();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		jeromeCahuzac.setEmail("insideJoke@gouv.com");
		
		hiddenCaimanIslandAccount.setBalance(1000000);
		dailyLifeAccount.setBalance(2000);
		anotherHiddenAccount.setBalance(3500000);
		
		
		hiddenCaimanIslandAccount.setId((long)10);
		
		bank.addUser(jeromeCahuzac);
		bank.addUser(userTodelete);
		
		bank.addAccount(hiddenCaimanIslandAccount);
		bank.addAccount(anotherHiddenAccount);
		

		bank.linkAccountToUser(hiddenCaimanIslandAccount, jeromeCahuzac);
		bank.linkAccountToUser(anotherHiddenAccount, jeromeCahuzac);
	}

	@Test
	public void testAddUser() throws Exception {
		user elimane = UserBuilder.createDefaultUser().build();
		bank.addUser(elimane);
		assertTrue(bank.users.contains(elimane));
	}

	@Test
	public void testDeleteUser() throws Exception {
		bank.deleteUser(userTodelete);
		assertFalse(bank.users.contains(userTodelete));

	}

	@Test
	public void testReadUser() throws Exception {
		bank.readUser(jeromeCahuzac);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testReadUnknownUser() throws Exception {
		user ronaldinho = UserBuilder.createDefaultUser().build();
		bank.readUser(ronaldinho);
	}

	@Test
	public void testAddAccount() throws Exception {
		account wikiLeaksAccount = new account();
		bank.addAccount(wikiLeaksAccount);
		assertEquals("The account hadn't been added !",bank.accounts.contains(wikiLeaksAccount),true);  

	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddExistingAccount() throws Exception {
		account wikiLeaksAccount = new account();
		bank.addAccount(wikiLeaksAccount);
		bank.addAccount(wikiLeaksAccount);
	}

	@Test
	public void testDeleteAccount() throws Exception {
		assertEquals("There is no hidden account !",bank.accounts.contains(anotherHiddenAccount),true);  
		bank.deleteAccount(anotherHiddenAccount);
		assertEquals("The hidden account hadn't been deleted !",bank.accounts.contains(anotherHiddenAccount),false);  
	}

	@Test
	public void testLinkAccountToUser() throws Exception {

		assertFalse(jeromeCahuzac.usersaccounts.contains(dailyLifeAccount));
		assertFalse(dailyLifeAccount.getOwnerId()==jeromeCahuzac.getId());
		
		bank.linkAccountToUser(dailyLifeAccount, jeromeCahuzac);
		
		assertTrue(jeromeCahuzac.usersaccounts.contains(dailyLifeAccount));
		assertTrue(dailyLifeAccount.getOwnerId()==jeromeCahuzac.getId());
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testReadAccount() throws Exception {
		//Display Informations
		bank.readAccount(hiddenCaimanIslandAccount);
		//Trigger an exception
		bank.readAccount(dailyLifeAccount);
		
	}
	
	

}
