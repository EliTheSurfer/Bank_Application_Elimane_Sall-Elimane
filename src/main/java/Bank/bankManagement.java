package Bank;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.account.*;
import model.user.*;

/**
 * 
 * @author Elimane sall
 *
 */
public class bankManagement {


	public List<account> accounts = new ArrayList<account>();
	public List<user> users = new ArrayList<user>();
	final Logger logger = LoggerFactory.getLogger(bankManagement.class);

	/**
	 * This function allows us to add a new user in the bank's clients list
	 * @param user userToAdd
	 */
	public void addUser(user userToAdd)
	{
		if(!users.contains(userToAdd))
		{
			logger.info("Adding " + userToAdd.getFirstname()+ " "+ userToAdd.getLastname()+ " to client list");
			users.add(userToAdd);
		}
		else
		{
            logger.error("Trying to overwrite an existing user");
            throw new IllegalArgumentException("This user exists already !"); 
		}
	}
	
	/**
	 * This function allows us to delete a user from the client list
	 * @param user userTodelete
	 */
	public void deleteUser(user userTodelete){
		if(users.contains(userTodelete))
		{
			logger.info("Removing " + userTodelete.getFirstname() + " " + userTodelete.getLastname());
			users.remove(userTodelete);
		}
		else
		{
			logger.error("Trying to remove an non existing user : " +userTodelete.getFirstname() +" "+ userTodelete.getLastname());
            throw new IllegalArgumentException("This user doesn't exist !"); 
		}
	}
	
	/**
	 * This function gives us all the informations about a user
	 * @param user userToRead
	 */
	public void readUser(user userToRead)
	{
		if(users.contains(userToRead)==false)
		{
			logger.error("Trying to read an non existing user");
            throw new IllegalArgumentException("This user doesn't exist !"); 
		}
		else
		{
			logger.info("Reading user's informations : " );
			System.out.println("Firstname : " + userToRead.getFirstname() +  ", Lastname : " + userToRead.getLastname());
			System.out.println("Address : " + userToRead.getAdress() + ", Phone number : " + userToRead.getPhonenumber());
			System.out.println("List of accounts : "+ userToRead.usersaccounts + ", Global balance : "+ String.valueOf(userToRead.balance()) );
		}
	}
	
	/**
	 * This function allows us to add an account
	 * @param account accountToAdd
	 */
	public void addAccount(account accountToAdd)
	{
		if(accounts.contains(accountToAdd))
		{
			logger.error("Trying to overwrite an existing account");
            throw new IllegalArgumentException("This account  exists already !"); 
		}
		else
		{
			logger.info("Adding a new account");
			accounts.add(accountToAdd);
		}
		
	}
	
	/**
	 * This function allows to the bank to delete an account
	 * @param account accountTodelete
	 */
	public void deleteAccount(account accountTodelete){
		if(!accounts.contains(accountTodelete))
		{
			logger.error("Trying to delete an non existing account");
            throw new IllegalArgumentException("This account doesn't exist !"); 
		}
		else
		{
			logger.info("Deleting an account");
			accounts.remove(accountTodelete);
		}
	}
	
	/**
	 * This function give to the bank all the informations about an account
	 * @param accountToRead
	 */
	public void readAccount(account accountToRead)
	{
		if(!accounts.contains(accountToRead))
		{
			//We can't display informations about an account that doesn't exist
			logger.error("Trying to read a non existing account");
            throw new IllegalArgumentException("This account doesn't exist !"); 
		}
		else
		{
			logger.info("Printing accoun'ts information");
			//Display the account's information
			System.out.println("Id : " + accountToRead.getId());
			System.out.println("Creation date : " + accountToRead.getCreationDate());
			System.out.println("Balance : " + accountToRead.getBalance());
			
			//Display the owner's information
			users.stream()
			.filter(user->user.getId()==accountToRead.getOwnerId())
			.forEach(user->System.out.println("Owner  : "+user.getFirstname() + " " +user.getLastname() + " - owner id : "+ user.getId() ));;
		}
	}
	
	/**
	 * This function allows to the bank to link an account to one of its clients
	 * @param account accountToLink
	 * @param user userToLink
	 */
	public void linkAccountToUser(account accountToLink, user userToLink)
	{
		if(userToLink.getId()==null)
		{
			logger.error("Missing user id");
            throw new IllegalArgumentException(userToLink.getFirstname() +" "+ userToLink.getLastname()+"'s id is not set  !"); 
		}
		else
		{
			logger.info("Adding a new account to " + userToLink.getFirstname() + " "+ userToLink.getLastname() );
			userToLink.usersaccounts.add(accountToLink);
			accountToLink.setOwnerId(userToLink.getId());
		}
		
	}
	
	
	
}
