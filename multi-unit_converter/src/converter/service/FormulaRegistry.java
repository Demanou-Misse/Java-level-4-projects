package converter.service;

import converter.enums.DistanceUnit;
import converter.enums.TemperatureUnit;
import converter.enums.WeightUnit;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FormulaRegistry {

    private Map<Enum, Function<Double, Double>> map;

    // Distance conversion
    Function<Double, Double> kmToMile = km -> km * DistanceUnit.KM_TO_MILES.getValue();
    Function<Double, Double> mileToKm = mile -> mile * DistanceUnit.MILES_TO_KM.getValue();
    Function<Double, Double> kmToMeter = km -> km * DistanceUnit.KM_TO_METERS.getValue();
    Function<Double, Double> meterToKm = meter -> meter * DistanceUnit.METERS_TO_KM.getValue();
    Function<Double, Double> mileToMeter = mile -> mile * DistanceUnit.MILES_TO_METERS.getValue();
    Function<Double, Double> meterToMile = meter -> meter * DistanceUnit.METERS_TO_MILES.getValue();

    // Weight conversions
    Function<Double, Double> kgToPound = kg -> kg * WeightUnit.KG_TO_POUNDS.getValue();
    Function<Double, Double> poundToKg = pound -> pound * WeightUnit.POUNDS_TO_KG.getValue();

    // Temperature conversions
    Function<Double, Double> celsiusToFahrenheit = celsius -> (celsius * 9.0 / 5.0) + 32.0;
    Function<Double, Double> fahrenheitToCelsius = fahrenheit -> (fahrenheit - 32.0) * 5.0 / 9.0;
    Function<Double, Double> celsiusToKelvin = celsius -> celsius + 273.15;
    Function<Double, Double> kelvinToCelsius = kelvin -> kelvin - 273.15;
    Function<Double, Double> fahrenheitToKelvin = fahrenheit -> (fahrenheit - 32.0) * 5.0 / 9.0 + 273.15;
    Function<Double, Double> kelvinToFahrenheit = kelvin -> (kelvin - 273.15) * 9.0 / 5.0 + 32.0;


    public FormulaRegistry () {
        this.map = new HashMap<>();

        map.put(DistanceUnit.KM_TO_MILES, kmToMile);
        map.put(DistanceUnit.MILES_TO_KM, mileToKm);
        map.put(DistanceUnit.KM_TO_METERS, kmToMeter);
        map.put(DistanceUnit.METERS_TO_KM, meterToKm);
        map.put(DistanceUnit.MILES_TO_METERS, mileToMeter);
        map.put(DistanceUnit.METERS_TO_MILES, meterToMile);

        map.put(WeightUnit.KG_TO_POUNDS, kgToPound);
        map.put(WeightUnit.POUNDS_TO_KG, poundToKg);

        map.put(TemperatureUnit.CELSIUS_TO_FAHRENHEIT, celsiusToFahrenheit);
        map.put(TemperatureUnit.FAHRENHEIT_TO_CELSIUS, fahrenheitToCelsius);
        map.put(TemperatureUnit.CELSIUS_TO_KELVIN, celsiusToKelvin);
        map.put(TemperatureUnit.KELVIN_TO_CELSIUS, kelvinToCelsius);
        map.put(TemperatureUnit.FAHRENHEIT_TO_KELVIN, fahrenheitToKelvin);
        map.put(TemperatureUnit.KELVIN_TO_FAHRENHEIT, kelvinToFahrenheit);
    }

    public double result (Enum task, double value) {
        Function<Double, Double> function = map.get(task);
         return function.apply(value);
    }

}
