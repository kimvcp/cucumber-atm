package ku.atm;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount {

   private double balance;
   private double negotiated = 0;
   private String accountType  = "normal";

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance) {
      balance = initialBalance;
   }

   /**
      Constructs a bank account with a given balance and can overdraw to negotiated amount.
      @param initialBalance the initial balance
      @param  negotiatedAmount the negotiated amount.
   */
   public BankAccount(double initialBalance, double negotiatedAmount) {
      balance = initialBalance;
      negotiated = negotiatedAmount;
   }
 
   /** 
      Deposits money into the account.
      @param amount the amount of money to withdraw
   */
   public void deposit(double amount) {
      balance = balance + amount;
   }

   /**
      Withdraws money from the account.
      @param amount the amount of money to deposit
   */
   public void withdraw(double amount) throws NotEnoughBalanceException {
      if (negotiated > 0){
         if (amount > balance+negotiated) throw new NotEnoughBalanceException("cannot withdraw more than negotiated amount");
            balance -= amount;
            negotiated -= balance;
      } else {
         if (amount > balance) throw new NotEnoughBalanceException("cannot withdraw more than balance");
         balance -= amount;
      }
   }

   /** 
      Gets the account balance.
      @return the account balance
   */
   public double getBalance() {
      return balance;
   }

   /**Get type of account.*/
   public String getType(){
      if (negotiated > 0) accountType = "OD";
      return accountType;
   }
}

