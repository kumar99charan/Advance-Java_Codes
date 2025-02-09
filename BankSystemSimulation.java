import java.util.ArrayList;
 class BankAccount{
 private int accountNumber;
 private String accountHolderName;
 private double balance;
   public BankAccount(int accountNumber,String accountHolderName,double balance){
    this.accountNumber=accountNumber;
    this.accountHolderName=accountHolderName;
    this.balance=balance;
  }
   public void deposit(double amount){
        balance=balance+amount;
       System.out.println("The amount deposited is: "+amount);
       displayAccountInfo();
    }
   
    public void withdraw(double amount){
      balance=balance-amount;
      System.out.println("The amount withdrawn is: "+amount);
      displayAccountInfo(); 
   }
 
   public void displayAccountInfo(){
        System.out.println("AccountNo. "+accountNumber+", "+accountHolderName+" has balance: "+balance);
    } 
}

class SavingsAccount extends BankAccount {
 private double interestRate;
  
  public SavingsAccount(int accountNumber,String accountHolderName,double balance,double interestRate)
  {
    super(accountNumber,accountHolderName,balance);
     this.interestRate=interestRate;
     addinterest();
  }
 public void addinterest(){
     System.out.println("Account will get interest added soon"); 
  }
 
}

class CurrentAccount extends BankAccount{
  private double overdraftLimit;
   
   public CurrentAccount(int accountNumber,String accountHolderName,double balance,double overdraftLimit){
   super(accountNumber,accountHolderName,balance);
   this.overdraftLimit=overdraftLimit;
   }

}

class Bank{
   
 

  public void createAccount(BankAccount account){}
  
  public void findAccount( int accountNumber){}
  
  public void listAllAccounts(){}
   
  
}
 
public class BankSystemSimulation{
  public static void main(String[] args){
     BankAccount account1=new BankAccount(224216,"Charan",5000);
     account1.deposit(5000);
     account1.withdraw(5000);
  } 


}


