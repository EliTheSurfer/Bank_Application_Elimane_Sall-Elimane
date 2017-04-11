package model.user;

import java.util.ArrayList;
import java.util.List;

import model.account.*;
/**
 * 
 * @author Elimane Sall
 * A client is a user who own one or more accounts 
 * A client can withdraw or deposit money on his accounts
 */
public class client {
	
	public List<account> usersaccounts = new ArrayList<account>();
	
	/**
	 * This function allows to user to withdraw money from one of his accounts
	 * @param account currentaccount
	 * @param double withdrawalAmount
	 */
	public void withdraw(account currentAccount,double withdrawalAmount)
	{
		if(usersaccounts.contains(currentAccount)==false){
			throw new IllegalArgumentException("You don't have the rights to do this operation !");
		}
		
		if(withdrawalAmount > currentAccount.getBalance()){
			throw new IllegalArgumentException("You don't have enough money to do this operation !");
		}
		
		//If there is no problem , the bank allows the withdrawal opertation
		currentAccount.setBalance(currentAccount.getBalance()-withdrawalAmount);
	}
	
	/**
	 * This function allows to the user to deposit money on one of his accounts
	 * @param currentAccout
	 * @param depositAmount
	 */
	public void deposit(account currentAccount,double depositAmount){
		if(usersaccounts.contains(currentAccount)==false){
			throw new IllegalArgumentException("You don't have the rights to do this operation !");
		}
		
		//If there is no problem with the security control the bank can do the operation
		currentAccount.setBalance(currentAccount.getBalance()+depositAmount);		
	}
	
	/**
	 * This function returns the global wealth of the user
	 * @return double wealth
	 */
	public double balance()
	{
		double wealth = 0;
		for(int i=0;i<usersaccounts.size();i++)
		{
			wealth+= usersaccounts.get(i).getBalance();
		}
		return wealth;
	}


}
