package model.account;
import java.util.Date;

/**
 * 
 * @author Elimane
 * Builder pattern for an account
 */
public class accountBuilder {

	//These are the information for a default account
	private Long id = null;
	private Long ownerId = null;
	private double balance = 0;
	private Date creationDate = new Date();
	
	 /**
     * This function returns a new default account
     * @return account
     */
    public static accountBuilder createAccount() { 
        return new accountBuilder(); 
    } 
    
    /**
     * This function sets a new Id for this account
     * @param newId
     * @return accountBuilder
     */
    public accountBuilder whichIdIs( Long newId) {
    		this.id = newId;
    		return this;
    }
    
    /**
     * This fonction sets the owner of this account
     * @param newOwnerId
     * @return accountBuilder
     */
    public  accountBuilder whichBelongsTo(Long newOwnerId) {
    		this.ownerId = newOwnerId;
    		return this;
    }
    
    
    /**
     * This function sets a new balance for this account
     * @param newBalance
     * @return accountBuilder
     */
    public accountBuilder withBalance( double newBalance ) {
    		this.balance = newBalance;
    		return this;
    }
    
    public account build() {
	    	if (balance < 0) { 
	
	            throw new IllegalArgumentException("You can't create  an account with a negative balance!"); 
	        } 
	        return new account(id, ownerId, balance, creationDate); 
    }
}
