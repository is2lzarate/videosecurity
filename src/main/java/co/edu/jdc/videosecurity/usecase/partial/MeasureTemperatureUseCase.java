package co.edu.jdc.videosecurity.usecase.partial;

import co.edu.jdc.videosecurity.domain.dto.ScaleEnum;

import java.math.BigDecimal;
import java.util.List;

public class MeasureTemperatureUseCase {

    public List<Double> calculateTemperatures(ScaleEnum scaleOrigin, ScaleEnum scaleTarget, List<Double> temperatures) {
        //TODO tenga en cuenta que para convertir de celsius a fahrenheit debe aplicar la siguiente formula: (celsius * 9/5) + 32
        //TODO tenga en cuenta que para convertir de celsius a kelvin debe aplicar la siguiente formula: celsius + 273.15
        //TODO tenga en cuenta que para convertir de fahrenheit a celsius debe aplicar la siguiente formula: (fahrenheit - 32) * 5/9
        //TODO tenga en cuenta que para convertir de fahrenheit a kelvin debe aplicar la siguiente formula: (fahrenheit + 459.67) * 5/9
        //TODO tenga en cuenta que para convertir de kelvin a celsius debe aplicar la siguiente formula: kelvin - 273.15
        //TODO tenga en cuenta que para convertir de kelvin a fahrenheit debe aplicar la siguiente formula: kelvin * 9/5 - 459.67
        //TODO IMPORTANTE solo se permite la conversion si la temperatura de origen esta en el rango de zero absoluto y punto de ebullicion del agua valores que se encuentran en la enumeracion ScaleEnum
        //TODO IMPORTANTE si la temperatura de origen no esta en el rango de zero absoluto y punto de ebullicion del agua se debe retornar null
        //TODO consejo utilice roundDecimal para redondear los valores de las temperaturas a 2 decimales
        return null;
    }

    private static double roundDecimals(double resultado) {
        BigDecimal bd = new BigDecimal(resultado);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

}
