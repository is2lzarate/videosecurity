package co.edu.jdc.videosecurity.usecase.partial;

import co.edu.jdc.videosecurity.domain.dto.ScaleEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MeasureTemperatureUseCase {

    public List<Double> calculateTemperatures(ScaleEnum scaleOrigin, ScaleEnum scaleTarget, List<Double> temperatures) {
        if(temperatures == null || temperatures.isEmpty()){
            List<Double> list = new ArrayList<>();
            return list;
        }
        if(scaleOrigin == ScaleEnum.CELSIUS && scaleTarget == ScaleEnum.FAHRENHEIT){
            List<Double> list = new ArrayList<>();
            for (Double celsius : temperatures) {
                double fahrenheit = roundDecimals((celsius * 9/5) + 32);
                if (fahrenheit> -459.67 && fahrenheit < 212.0){
                    list.add(fahrenheit);
                }else
                    list.add(null);
            }
            return list;
        }else if (scaleOrigin == ScaleEnum.CELSIUS && scaleTarget == ScaleEnum.KELVIN){
            List<Double> list = new ArrayList<>();
            for (Double celsius : temperatures) {
                double kelvin = roundDecimals(celsius + 273.15);
                if (kelvin> 0.00 && kelvin < 373.15){
                    list.add(kelvin);
                }else
                    list.add(null);
            }
            return list;
        } else if (scaleOrigin == ScaleEnum.FAHRENHEIT && scaleTarget == ScaleEnum.CELSIUS){
            List<Double> list = new ArrayList<>();
            for (Double fahrenheit : temperatures) {
                double celsius = roundDecimals((fahrenheit - 32) * 5/9);
                if (celsius> -273.15 && celsius < 100){
                    list.add(celsius);
                }else
                    list.add(null);
            }
            return list;
        }else if(scaleOrigin == ScaleEnum.FAHRENHEIT && scaleTarget == ScaleEnum.KELVIN){
            List<Double> list = new ArrayList<>();
            for (Double fahrenheit : temperatures) {
                double kelvin = roundDecimals((fahrenheit + 459.67) * 5/9);
                if (kelvin> 0.00 && kelvin < 373.15){
                    list.add(kelvin);
                }else
                    list.add(null);
            }
            return list;
        }else if (scaleOrigin == ScaleEnum.KELVIN && scaleTarget == ScaleEnum.CELSIUS){
            List<Double> list = new ArrayList<>();
            for (Double kelvin : temperatures) {
                double celsius = roundDecimals(kelvin - 273.15);
                if (celsius> -273.15 && celsius < 100){
                    list.add(celsius);
                }else
                    list.add(null);
            }
            return list;
        }else if (scaleOrigin == ScaleEnum.KELVIN && scaleTarget == ScaleEnum.FAHRENHEIT){
            List<Double> list = new ArrayList<>();
            for (Double kelvin : temperatures) {
                double fahrenheit = roundDecimals( kelvin * 9/5 - 459.67);
                if (fahrenheit> -459.67 && fahrenheit < 212.0){
                    list.add(fahrenheit);
                }else
                    list.add(null);
            }
            return list;
        }else{
            return temperatures;
        }
    }

    private static double roundDecimals(double resultado) {
        BigDecimal bd = new BigDecimal(resultado);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

}
