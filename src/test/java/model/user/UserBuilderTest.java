package model.user;

import static org.junit.Assert.assertSame;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserBuilderTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testWithAddress() throws Exception {
		final user BillGates = UserBuilder.createDefaultUser().withAddress("Redmond, Washington").build();
		assertSame("WithFirstName setter doesn't work !!!", BillGates.getAdress(),"Redmond, Washington");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testBuildUnderage() throws Exception {
		final user BillGates = UserBuilder.createDefaultUser().withAge(17).build();	
	}

	@Test(expected=IllegalArgumentException.class)
	public void testBuildOverage() throws Exception {
		final user BillGates = UserBuilder.createDefaultUser().withAge(141).build();	
	}

	@Test
	public void testWithAge() throws Exception {
		final user BillGates = UserBuilder.createDefaultUser().withAge(55).build();
		assertSame("WithAge setter doesn't work !!!", BillGates.getAge(),55);
	}

	@Test
	public void testWithEmail() throws Exception {
		final user BillGates = UserBuilder.createDefaultUser().withEmail("bill.gates@msn.com").build();
		assertSame("WithEmail setter doesn't work !!!", BillGates.getEmail(),"bill.gates@msn.com");
	}

	@Test
	public void testWithFirstname() throws Exception {
		final user BillGates = UserBuilder.createDefaultUser().withFirstname("Bill").build();
		assertSame("WithFirstName setter doesn't work !!!", BillGates.getFirstname(),"Bill");
	}

	@Test
	public void testWithLastname() throws Exception {
		final user BillGates = UserBuilder.createDefaultUser().withLastname("Gates").build();
		assertSame("WithLastName setter doesn't work !!!", BillGates.getLastname(),"Gates");
	}

	@Test
	public void testWithPhonenumber() throws Exception {
		final user BillGates = UserBuilder.createDefaultUser().withPhonenumber("+33 0 01 01 01 01").build();
		assertSame("WithPhonenumber setter doesn't work !!!", BillGates.getPhonenumber(),"+33 0 01 01 01 01");

	}

	@Test
	public void testCreateDefaultUser() throws Exception {
		final user BillGates = UserBuilder.createDefaultUser().build();
		assertSame("The default user builder id setter doesn't work !!!", BillGates.getId(),null);	
		assertSame("The default user builder firstname  setter doesn't work !!!", BillGates.getFirstname(),"DefaultFirstname");	
		assertSame("The default user builder Lastname  setter doesn't work !!!", BillGates.getLastname(),"DefaultLastname");	
		assertSame("The default user builder age setter doesn't work !!!", BillGates.getAge(),18);	
		assertSame("The default user builder address setter doesn't work !!!", BillGates.getAdress(),"Default location");
		assertSame("The default user builder number setter doesn't work !!!", BillGates.getPhonenumber(),"+33 0 00 00 00 00");
		assertSame("The default user builder email setter doesn't work !!!", BillGates.getEmail(),"default@mail.com");	
	}

}
