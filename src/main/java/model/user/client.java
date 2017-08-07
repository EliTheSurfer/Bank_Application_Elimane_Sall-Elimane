package model.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.account.*;
import model.operation.operation;
/**
 * 
 * @author Elimane Sall
 * A client is a user who own one or more accounts 
 * A client can withdraw or deposit money on his accounts
 */
public class client {
	
	final Logger logger = LoggerFactory.getLogger(client.class);

	public List<account> usersaccounts = new ArrayList<account>();
	public List<operation> usersOperations = new ArrayList<operation>();
	
	/**
	 * This function allows to user to withdraw money from one of his accounts
	 * @param account currentaccount
	 * @param double withdrawalAmount
	 */
	public void withdraw(account currentAccount,double withdrawalAmount)
	{
		if(usersaccounts.contains(currentAccount)==false){
			logger.warn("Trying to withdraw money from somebody's else account");
			throw new IllegalArgumentException("You don't have the rights to do this operation !");
		}
		
		if(withdrawalAmount > currentAccount.getBalance()){
			logger.warn("Trying to withdraw too much money");
			throw new IllegalArgumentException("You don't have enough money to do this operation !");
		}
		
		//If there is no problem with the security check , the bank allows the withdrawal opertation
		logger.info("Withdrawing " + withdrawalAmount);
		currentAccount.setBalance(currentAccount.getBalance()-withdrawalAmount);
		//Update the user's operation history
		usersOperations.add(new operation("withdraw", withdrawalAmount, currentAccount.getBalance()));
	}
	
	/**
	 * This function allows to the user to deposit money on one of his accounts
	 * @param currentAccout
	 * @param depositAmount
	 */
	public void deposit(account currentAccount,double depositAmount){
		if(usersaccounts.contains(currentAccount)==false){
			logger.warn("Trying to deposit money on somebody else's account");
			throw new IllegalArgumentException("You don't have the rights to do this operation !");
		}
		
		//If there is no problem with the security control the bank can do the operation
		logger.info("Desposit : " + depositAmount );
		currentAccount.setBalance(currentAccount.getBalance()+depositAmount);	
		//Update the user's operation history
		usersOperations.add(new operation("deposit", depositAmount, currentAccount.getBalance()));

	}
	
	/**
	 * This function returns the global wealth of the user
	 * @return double wealth
	 */
	public double balance()
	{
		double wealth = 0;
		logger.info("Calculatin the global balance" );
		for(int i=0;i<usersaccounts.size();i++)
		{
			wealth+= usersaccounts.get(i).getBalance();
		}
		logger.info("The global balance is : " + wealth);
		return wealth;
	}
	
	/**
	 * Simple fonction d'affichage de l'historique des operations de l'utilisateur
	 */
	public void getHistory() {
		this.usersOperations.forEach(operation ->
			System.out.print("Operation  : " + operation.getOperationName() + " - Date : " + operation.getOperationDate()+ " - Amount : "+ operation.getOperationAmount() +" - Balance :" + operation.getAccountsBalance() )
		);
							
	}


}
