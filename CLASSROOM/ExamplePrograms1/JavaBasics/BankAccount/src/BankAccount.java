public class BankAccount{   // default constructor   public BankAccount()   {      balance = 0;   }   // second constructor   public BankAccount(double initialBalance)   {      balance = initialBalance;   }   // method for depositing money   public void deposit(double amount)   {      balance = balance + amount;   }   // method for withdrawing money   public void withdraw(double amount)   {      balance = balance - amount;   }   // method for getting a balance   public double getBalance()   {      return balance;   }   // instance variable   private double balance;}