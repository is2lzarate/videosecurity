package co.edu.jdc.videosecurity.usecase.partial;

import co.edu.jdc.videosecurity.domain.dto.ScaleEnum;
import co.edu.jdc.videosecurity.usecase.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MeasureTemperatureUseCaseTest {

    private MeasureTemperatureUseCase measureTemperatureUseCase;

    private List<Double> tembase;

    @BeforeAll
    void init(){
        measureTemperatureUseCase = new MeasureTemperatureUseCase();
    }

    @BeforeEach
    void setUp() {
        getListTemperatures();
    }

    @Test
    void givenListNullShouldReturnEmpty () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.CELSIUS, ScaleEnum.FAHRENHEIT, null);
        Assertions.assertTrue(nonNull(result) && result.isEmpty());
    }

    @Test
    void givenListEmptyShouldReturnEmpty () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.CELSIUS, ScaleEnum.FAHRENHEIT, List.of());
        Assertions.assertTrue(nonNull(result) && result.isEmpty());
    }

    @Test
    void givenParameterNullShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(null, ScaleEnum.FAHRENHEIT, tembase);
        Assertions.assertEquals(tembase, result);
    }

    @Test
    void givenParameterEmptyShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.CELSIUS, null, tembase);
        Assertions.assertEquals(tembase, result);
    }

    @Test
    void givenParameterCelsiusToCelsiusShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.CELSIUS, ScaleEnum.CELSIUS, tembase);
        Assertions.assertEquals(tembase, result);
    }

    @Test
    void givenParameterFahrenheitToFahrenheitShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.FAHRENHEIT, ScaleEnum.FAHRENHEIT, tembase);
        Assertions.assertEquals(tembase, result);
    }

    @Test
    void givenParameterKelvinToKelvinShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.KELVIN, ScaleEnum.KELVIN, tembase);
        Assertions.assertEquals(tembase, result);
    }

    @Test
    void givenParameterCelsiusToFahrenheitShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.CELSIUS, ScaleEnum.FAHRENHEIT, tembase);
        System.out.println("givenParameterCelsiusToFahrenheitShouldReturnList");
        System.out.println(getListCelsiusToFahrenheit());
        System.out.println(tembase);
        Assertions.assertEquals(getListCelsiusToFahrenheit(), result);
    }

    @Test
    void givenParameterCelsiusToKelvinShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.CELSIUS, ScaleEnum.KELVIN, tembase);
        Assertions.assertEquals(getListCelsiusToKelvin(), result);
    }

    @Test
    void givenParameterFahrenheitToCelsiusShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.FAHRENHEIT, ScaleEnum.CELSIUS, tembase);
        Assertions.assertEquals(getListFahrenheitToCelsius(), result);
    }

    @Test
    void givenParameterFahrenheitToKelvinShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.FAHRENHEIT, ScaleEnum.KELVIN, tembase);
        Assertions.assertEquals(getListFahrenheitToKelvin(), result);
    }

    @Test
    void givenParameterKelvinToCelsiusShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.KELVIN, ScaleEnum.CELSIUS, tembase);
        Assertions.assertEquals(getListKelvinToCelsius(), result);
    }

    @Test
    void givenParameterKelvinToFahrenheitShouldReturnList () {
        List<Double> result = measureTemperatureUseCase.calculateTemperatures(ScaleEnum.KELVIN, ScaleEnum.FAHRENHEIT, tembase);
        Assertions.assertEquals(getListKelvinToFahrenheit(), result);
    }

    private List<Double> getListKelvinToFahrenheit() {
        return tembase.stream().map(TestUtils::convertKelvinToFahrenheit).collect(Collectors.toList());
    }

    private List<Double> getListKelvinToCelsius() {
        return tembase.stream().map(TestUtils::convertKelvinToCelsius).collect(Collectors.toList());
    }

    private List<Double> getListFahrenheitToKelvin() {
        return tembase.stream().map(TestUtils::convertFahrenheitToKelvin).collect(Collectors.toList());
    }

    private List<Double> getListFahrenheitToCelsius() {
        return tembase.stream().map(TestUtils::convertFahrenheitToCelsius).collect(Collectors.toList());
    }

    private List<Double> getListCelsiusToKelvin() {
        return tembase.stream().map(TestUtils::convertCelsiusToKelvin).collect(Collectors.toList());
    }

    private List<Double> getListCelsiusToFahrenheit() {
        return tembase.stream().map(TestUtils::convertCelsiusToFahrenheit).collect(Collectors.toList());
    }

    private void getListTemperatures() {
        Random random = new Random();
        tembase = List.of(TestUtils.roundDecimals((random.nextDouble() * 2 - 1)*10),
                TestUtils.roundDecimals((random.nextDouble() * 2 - 1)*1000),
                TestUtils.roundDecimals((random.nextDouble() * 2 - 1)*300),
                TestUtils.roundDecimals((random.nextDouble() * 2 - 1)*200),
                TestUtils.roundDecimals((random.nextDouble() * 2 - 1)*500));
    }

}
