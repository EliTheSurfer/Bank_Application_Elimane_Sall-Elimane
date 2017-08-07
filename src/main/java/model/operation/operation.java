package model.operation;

import java.util.Date;

/**
 * 
 * @author Elimane Sall
 * This class is a model for a client's operation
 */
public class operation {
	
	private String operationName;
	private Date operationDate = new Date();
	private double operationAmount;
	private double accountsBalance;
	
	/**
	 * This function sets the operation's name
	 * @param String newOperationName
	 */
	public  void setOperationName(String newOperationName) {
		this.operationName = newOperationName;
	}
	
	/**
	 * this function sets the operation's amount
	 * @param double newOperationAmount
	 */
	public void setOperationAmount(double newOperationAmount) {
		this.operationAmount = newOperationAmount;
	}
	
	/**
	 * This function sets the account's balance
	 * @param double newAccountsBalance
	 */
	public void setAccountsBalance( double newAccountsBalance) {
		this.accountsBalance = newAccountsBalance;
	}
	
	/**
	 * This function returns the operation's Name 
	 * @return String operationName
	 */
	public String getOperationName() {
		return this.operationName;
	}
	
	/**
	 * This function provide the operation's Date
	 * @return Date operationDate
	 */
	public Date getOperationDate() {
		return this.operationDate;
	}
	
	/**
	 * this function returns the amount used for this operation
	 * @return double operationAmount
	 */
	public double getOperationAmount() {
		return this.operationAmount;
	}
	
	/**
	 * This function returns the account's balance after the operation
	 * @return double accountBalance
	 */
	public double getAccountsBalance() {
		return this.accountsBalance;
	}
	/**
	 * Complete operation constructor
	 * @param operationName
	 * @param operationAmount
	 * @param accountsBalance
	 */
	public operation(String operationName, double operationAmount, double accountsBalance) {
		this.operationName = operationName;
		this.operationDate = new Date();
		this.operationAmount = operationAmount;
		this.accountsBalance = accountsBalance;
	}
	
	/**
	 * operation default constructor
	 */
	public operation() {
		//
	}

}
