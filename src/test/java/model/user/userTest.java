package model.user;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class userTest {
	
	private user currentUser = new user();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSetGetId() throws Exception {
		currentUser.setId((long) 1);
		assertSame("The Id setter/getter don't work !!!", currentUser.getId(),(long)1);
	}

	@Test
	public void testSetFirstname() throws Exception {
		currentUser.setFirstname("Francois");
		assertSame("The Firstname Getter/setter don't work !!!", currentUser.getFirstname(),"Francois");

	}

	@Test
	public void testSetLastname() throws Exception {
		currentUser.setLastname("Dupond");
		assertSame("The lastname Getter/setter don't work !!!", currentUser.getLastname(),"Dupond");

	}


	@Test
	public void testSetAge() throws Exception {
		currentUser.setAge(20);
		assertSame("The age Getter/setter don't work !!!", currentUser.getAge(),20);

	}


	@Test
	public void testSetAdress() throws Exception {
		currentUser.setAdress("20 rue des colombes, Paris, 75016");
		assertSame("The adress Getter/setter don't work !!!", currentUser.getAdress(),"20 rue des colombes, Paris, 75016");
	}

	@Test
	public void testSetPhonenumber() throws Exception {
		currentUser.setPhonenumber("+ 33 6 54 23 87 65");
		assertSame("The phone number Getter/setter don't work !!!", currentUser.getPhonenumber(),"+ 33 6 54 23 87 65");
	}

	@Test
	public void testSetEmail() throws Exception {
		currentUser.setEmail("jon.snow@gmail.com");
		assertSame("The email Getter/setterdon't work !!!", currentUser.getEmail(),"jon.snow@gmail.com");	
	}

	@Test
	public void testUserCompleteBuilder() throws Exception {
		currentUser =  new user((long)1,"Obiwan","Kenobi",45,"The Bright side of the force, Paris, 75010","+33 0 00 00 00 00", "obiwan.kenobi@mail.com");
		assertSame("The id complete builder setter doesn't work !!!", currentUser.getId(),(long)1);	
		assertSame("The firstname complete builder setter doesn't work !!!", currentUser.getFirstname(),"Obiwan");	
		assertSame("The firstname complete builder setter doesn't work !!!", currentUser.getLastname(),"Kenobi");	
		assertSame("The age complete builder setter doesn't work !!!", currentUser.getAge(),45);	
		assertSame("The address complete builder setter doesn't work !!!", currentUser.getAdress(),"The Bright side of the force, Paris, 75010");
		assertSame("The phone number complete builder setter doesn't work !!!", currentUser.getPhonenumber(),"+33 0 00 00 00 00");
		assertSame("The email complete builder setter doesn't work !!!", currentUser.getEmail(),"obiwan.kenobi@mail.com");

	}

}
