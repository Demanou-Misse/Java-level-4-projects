package converter.util;

import converter.exception.InvalidUnitException;

import java.util.List;
import java.util.Scanner;

public class InputHelper {

    private Scanner input = new Scanner(System.in);

    public int chooseOption() {

        while (true) {
            System.out.print("> Your choice: ");
            String userInput = input.nextLine().trim();
            if (userInput.isEmpty()) {
                System.out.println("❌ Your choice cannot be empty.");
                continue;
            }

            try {
                int choice = Integer.parseInt(userInput);

                if (choice >= 0 && choice <= 3) return choice;
                System.out.println("❌ Invalid input. Enter a number between (0-3).");
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input");
            }
        }

    }

    public double value() {

        while (true) {
            System.out.print("\nEnter value: ");
            String userInput = input.nextLine().trim();
            if (userInput.isEmpty()) {
                System.out.println("❌ Value cannot be empty.");
                continue;
            }

            try {
                return Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input.");
            }
        }

    }

    public String enterUnit(int choice, String string) {

        while (true) {
            System.out.print(string + " unit: ");
            String unit = input.nextLine().trim().toUpperCase();
            if (unit.isEmpty()) {
                System.out.println("❌ Unit cannot be empty.");
                continue;
            }

            try {
                switch (choice) {

                    case 1:
                        if (List.of("KM", "MILES", "METERS").contains(unit)) return unit;
                        throw new InvalidUnitException ("❌ Invalid input. Please choose between (KM, MILES, METERS)");

                    case 2:
                        if (List.of("CELSIUS", "FAHRENHEIT", "KELVIN").contains(unit)) return unit;
                        throw new InvalidUnitException ("❌ Invalid input. Please choose between (CELSIUS, FAHRENHEIT, KELVIN)");

                    case 3:
                        if (List.of("KG", "POUNDS").contains(unit)) return unit;
                        throw new InvalidUnitException ("❌ Invalid input. Please choose between (KG, POUNDS)");
                }

            } catch (InvalidUnitException e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
