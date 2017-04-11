package model.account;

import java.util.Date;

/**
 * 
 * @author Elimane Sall
 * This class provides all the informations about a bank account
 */
public class account {
	
	private Long id;
	private Long ownerId;
	private double balance;
	private Date creationDate = new Date();
	
	/**
	 * This function  returns the account's id
	 * @return Long Id
	 */
	public Long getId()
	{
		return this.id;
	}
	
	/**
	 * This function allows us to set the account's id
	 * @param Long id
	 */
	public void setId(Long id)
	{
		this.id = id;
	}
	
	/**
	 * This function returns the account owner's id
	 * @return Long ownerId
	 */
	public Long getOwnerId()
	{
		return this.ownerId;
	}
	
	/**
	 * This function allows us to set owner's id
	 * @param ownerId
	 */
	public void setOwnerId(Long ownerId)
	{
		this.ownerId = ownerId ;
	}
	
	/**
	 * this function returns the account's balance
	 * @return double balance
	 */
	public double getBalance()
	{
		return this.balance;
	}

	/**
	 * This function allows us to update the balance of an account
	 * @param double balance
	 */
	public void setBalance(double balance)
	{
		this.balance  = balance;
	}
	
	/**
	 * This function returns the account's creation date
	 * @return date creationDate
	 */
	public Date getCreationDate()
	{
		return this.creationDate;
	}
}
