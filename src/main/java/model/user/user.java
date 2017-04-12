package model.user;

/*
 * Author : Elimane Sall
 * 
 * This class is a user model, it defines every informations that we need about one bank user
 */
public class user extends client {

	/*
	 * Theses variables below are the user's  informations that we need
	 * ----------------------------------------------------------------
	 * We define one variable per line in order to have a very readable 
	 * code ( Craftmanship) 
	 */
	private Long id = null;
	private String firstname;
	private String lastname;
	private int age;
	private String address;
	private String phonenumber;
	private String email;
	
	/**
	 * Definition of setters and getters
	 */
	
	
	/**
	 * Set the id of the current user
	 * @param Long id
	 */
	public void setId(Long id){
		this.id = id;
	}
	/**
	 * provide the Id of the current user
	 */
	public Long getId(){
		return this.id;
	}
	
	/**
	 * Set the firstname of the current user
	 * @param String firstname
	 */
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	/**
	 * Returns the firstname of the current user
	 */
	public String getFirstname(){
		return this.firstname;
	}
	
	/**
	 * Set the firstname of the current user
	 * @param String Lastname
	 */
	public void setLastname(String Lastname){
		this.lastname = Lastname;
	}
	
	/**
	 * Returns the Lastname of the current user
	 */
	public String getLastname(){
		return this.lastname;
	}
	
	/**
	 * Set the age of the current user
	 * @param int age
	 */
	public void setAge(int age){
		this.age = age;
	}
	
	/**
	 * Returns the age of the current user
	 */
	public int getAge(){
		return this.age;
	}

	/**
	 * Set the adress of the current user
	 * @param adress
	 */
	public void setAdress(String adress){
		this.address = adress;
	}
	
	/**
	 * Returns the adress of the current user
	 */
	public String getAdress(){
		return this.address;
	}
	
	/**
	 * Set the phone number of the current user
	 * @param phonenumber
	 */
	public void setPhonenumber(String Phonenumber){
		this.phonenumber= Phonenumber;
	}
	
	/**
	 * Return the phone number of the current user
	 */
	public String getPhonenumber(){
		return this.phonenumber;
	}
	
	/**
	 * Set the email of the current user
	 * @param email
	 */
	public void setEmail(String email){
		this.email= email;
	}
	
	/**
	 * Return the email of the current user
	 */
	public String getEmail(){
		return this.email;
	}
	
	
	/**
	 * Complete constructor
	 * @param Long id
	 * @param String firstname
	 * @param String  lastname
	 * @param int age
	 * @param String address
	 * @param String phonenumber
	 * @param String email
	 */
	public user(Long id, String firstname, String lastname, int age,String address, String phonenumber, String email) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	
	/**
	 * Default constructor
	 */
	public user() {
	}



	
	
	
		
}
