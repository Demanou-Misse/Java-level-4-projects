package converter;

import converter.service.ConversionService;
import converter.util.InputHelper;

public class Main {
    public static void main(String[] args) {
        int choice;
        InputHelper inputHelper = new InputHelper();
        ConversionService conversionService = new ConversionService();

        System.out.println("\n==== 🌍 Universal Unit Converter ===");

        do {

            System.out.println("\nChoose a category:");
            System.out.println("    1. Distance");
            System.out.println("    2. Temperature");
            System.out.println("    3. Weight");
            System.out.println("    0. Exit");
            choice = inputHelper.chooseOption();

            switch (choice) {

                case 0:
                    System.out.println("\n👋 Goodbye!");
                    break;

                case 1:
                    System.out.println("\n***** 📐 Distance Conversion *****");
                    System.out.println("Available units: [KM, MILES, METERS]");
                    conversionService.conversions(choice);
                    break;

                case 2:
                    System.out.println("\n*****⛅ Temperature Conversion *****");
                    System.out.println("Available units: [CELSIUS, FAHRENHEIT, KELVIN]");
                    conversionService.conversions(choice);
                    break;

                case 3:
                    System.out.println("\n*****💪 Weight Conversion *****");
                    System.out.println("Available units: [KG, POUNDS]");
                    conversionService.conversions(choice);
                    break;
            }

        } while (choice != 0);

    }
}