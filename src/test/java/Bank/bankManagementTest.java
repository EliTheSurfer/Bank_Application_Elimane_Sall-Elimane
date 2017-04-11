package Bank;

import static org.junit.Assert.*;
import model.account.account;
import model.user.UserBuilder;
import model.user.client;
import model.user.user;

import org.junit.BeforeClass;
import org.junit.Test;

public class bankManagementTest {
	
	static account hiddenCaimanIslandAccount = new account();
	static account dailyLifeAccount = new account();
	static account anotherHiddenAccount = new account();
	
	static user jeromeCahuzac = UserBuilder.createDefaultUser().withId((long)1).withFirstname("Jerome").withLastname("Cahuzac").build();
	static user userTodelete = UserBuilder.createDefaultUser().build();
	
	static bankManagement bank = new bankManagement();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		jeromeCahuzac.setEmail("insideJoke@gouv.com");
		
		hiddenCaimanIslandAccount.setBalance(1000000);
		dailyLifeAccount.setBalance(2000);
		anotherHiddenAccount.setBalance(3500000);
		
		bank.addUser(jeromeCahuzac);
		bank.addUser(userTodelete);
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

}
