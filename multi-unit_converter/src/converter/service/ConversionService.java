package converter.service;

import converter.enums.DistanceUnit;
import converter.enums.TemperatureUnit;
import converter.enums.WeightUnit;
import converter.util.InputHelper;

import java.util.Locale;

public class ConversionService {
    InputHelper inputHelper = new InputHelper();
    FormulaRegistry formulaRegistry = new FormulaRegistry();


    // Conversions
    public void conversions (int choice) {
        double value = inputHelper.value();

        String  fromUnit = inputHelper.enterUnit(choice, "From");
        String toUnit = inputHelper.enterUnit(choice, "To");

        if (fromUnit.equals(toUnit)) {
            System.out.printf(Locale.US, "✅ Result: %.2f %s = %.3f %s%n", value, fromUnit, value, toUnit);
            System.out.println("\n" + "*".repeat(40));
            return;
        }

        Enum task = switch (choice) {
            case 1 -> DistanceUnit.valueOf(fromUnit + "_TO_" + toUnit);
            case 2 -> TemperatureUnit.valueOf(fromUnit + "_TO_" + toUnit);
            case 3 -> WeightUnit.valueOf(fromUnit + "_TO_" + toUnit);
            default -> null;
        };

        double result = formulaRegistry.result(task, value);
        System.out.printf(Locale.US, "✅ Result: %.2f %s = %.3f %s%n", value, fromUnit, result, toUnit);
        System.out.println("\n" + "*".repeat(40));
    }

}
