package ku.atm;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount {
   private double normalBalance;
   private double oDBalance;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount() {

      normalBalance = 0;
      oDBalance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance) {

      normalBalance = initialBalance;
      oDBalance = initialBalance;
   }
 
   /** 
      Deposits money into the account.
      @param amount the amount of money to withdraw
   */
   public void deposit(double amount) {
      normalBalance = normalBalance + amount;
   }

   /**
      Withdraws money from the account.
      @param amount the amount of money to deposit
   */
   public void withdraw(double amount) throws NotEnoughBalanceException {
      if (amount > normalBalance)
         throw new NotEnoughBalanceException("cannot withdraw more than balance");
      normalBalance -= amount;
   }

   /** 
      Gets the account balance.
      @return the account balance
   */
   public double getBalance() {
      return normalBalance;
   }

}

