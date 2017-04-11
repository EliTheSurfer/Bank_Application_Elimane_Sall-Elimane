package model.user;

/**
 * 
 * @author Elimane Sall
 * Builder pattern for a user
 */
public class UserBuilder {
	
	/**
	 * Theses are the informations for a default user
	 */
	static Long id = null;
	private String firstname ="DefaultFirstname";
	private String lastname = "DefaultLastname";
	private int age = 18;
	private String address = "Default location";
	private String phonenumber ="+33 0 00 00 00 00";
	private String email = "default@mail.com";

    private UserBuilder() { 

    } 

 
    /**
     * This function returns a new default user
     * @return user
     */
    public static UserBuilder createDefaultUser() { 
        return new UserBuilder(); 
    } 
    
    /**
     * This function sets a new firstname 
     * @param firstname
     * @return
     */
    public UserBuilder withId(final Long id) { 
        this.id = id; 
        return this; 
    } 
    
    /**
     * This function sets a new firstname 
     * @param firstname
     * @return
     */
    public UserBuilder withFirstname(final String firstname) { 
        this.firstname = firstname; 
        return this; 
    } 
    
    /**
     * This function sets a new lastname
     * @param lastname
     * @return
     */
    public UserBuilder withLastname(final String lastname) { 
        this.lastname = lastname; 
        return this; 
    } 

    /**
     * This function updates the age of the user
     * @param age
     * @return
     */
    public UserBuilder withAge(final int age) { 
        this.age = age; 
        return this; 
    }
    
    /**
     * This function set a new address for the user
     * @param address
     * @return
     */
    public UserBuilder withAddress(final String address) { 
        this.address = address; 
        return this; 
    } 
    
    /**
     * This function set a new phone number for the user
     * @param phonenumber
     * @return
     */
    public UserBuilder withPhonenumber(final String phonenumber) { 
        this.phonenumber = phonenumber; 
        return this; 
    } 
    
    /**
     * This function set a new email for the user
     * @param email
     * @return
     */
    public UserBuilder withEmail(final String email) { 
        this.email = email; 
        return this; 
    } 
    
    /**
     * This function build the user withe differents parameters
     * it also guarantee that the user that we are building is coherent
     * @return
     */
    public user build() { 
        if (age < 18 || age > 140) { 

            throw new IllegalArgumentException("The age is incorrect !"); 
        } 
        return new user(id, firstname, lastname, age, address, phonenumber, email); 

    } 
    
}


