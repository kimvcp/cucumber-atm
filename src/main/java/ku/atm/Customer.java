package ku.atm;

/**
   A bank customer with a checking and a savings account.
*/
public class Customer {
   private int customerNumber;
   private int pin;
   private BankAccount account;


   /**
    Constructs a customer with a given number and PIN.
    @param aNumber the customer number
    @param aPin the personal identification number
    @param currentBalance the current balance of customer
    @param negotiatedAmount the amount of negotiation
    */
   public Customer(int aNumber, int aPin, double currentBalance, double negotiatedAmount) {
      customerNumber = aNumber;
      pin = aPin;
      account = new BankAccount(currentBalance, negotiatedAmount);
   }

   /**
    Constructs a customer with a given number and PIN.
    @param aNumber the customer number
    @param aPin the personal identification number
    */
   public Customer(int aNumber, int aPin) {
      this(aNumber, aPin, 0,0);
   }

   /**
      Tests if this customer matches a customer number
      and PIN.
      @param aPin a personal identification number
      @return true if the customer number and PIN match
   */
   public boolean match(int aPin) {
      return pin == aPin;
   }

   /**
      Gets the account of this customer.
      @return the account
   */
   public BankAccount getAccount() {
      return account;
   }

   /**
    Gets the number of this customer.
    @return the number
    */
   public int getCustomerNumber() {
      return customerNumber;
   }

}
