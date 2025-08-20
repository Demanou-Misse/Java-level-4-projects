package service;

import model.*;

public class BankManager {

    // transfers
    public synchronized void transfer(double amount, Account<Double> from, Account<Double> to) {
        System.out.println("\n👉 [" + Thread.currentThread().getName() + "] Trying to transfer "
                + amount + " from " + from.getType() + " to " + to.getType());

        // Si pas assez de fonds, attendre
        while (amount > from.getBalance()) {
            try {
                System.out.println("❌ [" + Thread.currentThread().getName() + "] Waiting... insufficient funds in " + from.getType());
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        System.out.println("🎉 [" + Thread.currentThread().getName() + "] Transfer successful!");
        System.out.println("\t" + from);
        System.out.println("\t" + to);

        notifyAll();
    }

    public void finalAccountBalances(Account<Double> a1, Account<Double> a2) {
        System.out.println("\n=== FINAL ACCOUNT BALANCES ===");
        System.out.println(a1);
        System.out.println(a2);
    }

}
