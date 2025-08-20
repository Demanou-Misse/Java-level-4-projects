package model;

public class Account<T> {

   private double balance;
   private TypeAccount type;

   public Account (double balance, TypeAccount type) {
       this.balance = balance;
       this.type = type;
   }

   public double getBalance() {
       return balance;
   }
   public void setBalance(double newBalance) {
       balance = newBalance;
   }

   public TypeAccount getType() {
       return type;
   }
   public void setType(TypeAccount newType) {
       type = newType;
   }

   @Override
   public String toString() {
       return type + " : " + " - Balance: " + balance;
   }

}
