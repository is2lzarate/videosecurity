package co.edu.jdc.videosecurity.usecase.utils;

import co.edu.jdc.videosecurity.domain.dto.ScaleEnum;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

public class TestUtils {

    public static double roundDecimals(double resultado) {
        BigDecimal bd = new BigDecimal(resultado);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public static boolean validateTemperature(ScaleEnum scaleEnum, Double temperature) {
        return nonNull(scaleEnum) && nonNull(temperature) && temperature >= scaleEnum.getAbsoluteZero() && temperature <= scaleEnum.getBoilingWater();
    }

    public static Double convertKelvinToFahrenheit(Double temperature) {
        return validateTemperature(ScaleEnum.KELVIN, temperature) ? roundDecimals(temperature * 9 / 5 - 459.67) : null;
    }

    public static Double convertKelvinToCelsius(Double temperature) {
        return validateTemperature(ScaleEnum.KELVIN, temperature) ? roundDecimals(temperature - 273.15) : null;
    }

    public static Double convertFahrenheitToKelvin(Double temperature) {
        return validateTemperature(ScaleEnum.FAHRENHEIT, temperature) ? roundDecimals((temperature + 459.67) * 5 / 9) : null;
    }

    public static Double convertFahrenheitToCelsius(Double temperature){
        return validateTemperature(ScaleEnum.FAHRENHEIT, temperature) ? roundDecimals((temperature - 32) / 1.8) : null;
    }

    public static Double convertCelsiusToKelvin(Double temperature){
        return validateTemperature(ScaleEnum.CELSIUS, temperature) ? roundDecimals(temperature + 273.15) : null;
    }

    public static Double convertCelsiusToFahrenheit(Double temperature){
        return validateTemperature(ScaleEnum.CELSIUS, temperature) ?  roundDecimals(temperature * 1.8 + 32) : null;
    }
}
