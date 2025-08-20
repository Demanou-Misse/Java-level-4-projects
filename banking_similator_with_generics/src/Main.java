//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import model.Account;
import model.TypeAccount;
import service.BankManager;
import service.ThreadService;

public class Main {
    public static void main(String[] args) {
        BankManager bankManager = new BankManager();

        System.out.println("\n💸 Welcome to the 'Banking Simulator' with generics 💸\n");

        // Create account
        Account<Double> savings = new Account<>(1000.0, TypeAccount.SAVINGS);
        Account<Double> checking = new Account<>(500.0, TypeAccount.CHECKING);
        System.out.println("[INIT] Account created: " + savings);
        System.out.println("[INIT] Account created: " + checking + "\n");

        // Thread pool
        ThreadService threadService = new ThreadService(4);

        threadService.submit(() -> bankManager.transfer(200.0, savings, checking));
        threadService.submit(() -> bankManager.transfer(100.0, checking, savings));
        threadService.submit(() -> bankManager.transfer(300.0, savings, checking));
        threadService.submit(() -> bankManager.transfer(2000.0, checking, savings));

        // Shutdown and display final balance
        threadService.shutdown();
        bankManager.finalAccountBalances(savings, checking);

    }
}