package co.edu.jdc.videosecurity.usecase.kata;


import co.edu.jdc.videosecurity.domain.dto.ParameterEnum;
import co.edu.jdc.videosecurity.domain.dto.PassengerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;

import static co.edu.jdc.videosecurity.domain.dto.ParameterEnum.AGE;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TitanicPassengersUseCaseTest {

    private TitanicPassengersUseCase titanicPassengersUseCase;
    private BufferedReader lector;
    String ruta = "src/main/resources/titanic.csv";

    @BeforeAll
    void init() {
        titanicPassengersUseCase = new TitanicPassengersUseCase();
    }

    @Test
    void givenParameterNullShouldReturnNull() {
        Integer result = titanicPassengersUseCase.quantityOfParameter(null, null, ruta);
        Assertions.assertNull(result);
    }

    //crearun test por cada parametro,

    @Test
    void givenValidFileIfSurvived() {
        Integer result = titanicPassengersUseCase.quantityOfParameter(ParameterEnum.SURVIVED, 1, ruta);
        Assertions.assertEquals(result, 10);
    }

    @Test
    void givenValidFileElseSurvived() {
        Integer result = titanicPassengersUseCase.quantityOfParameter(ParameterEnum.SURVIVED, 0, ruta);
        Assertions.assertEquals(result, 10);
    }

    @Test
    void givenValidFileIfSurvivedFalse() {
        Integer result = titanicPassengersUseCase.quantityOfParameter(ParameterEnum.SURVIVED, 3, ruta);
        Assertions.assertEquals(result, 0);
    }


    @Test
    void givenValidFileClassOne() {
        Integer result = titanicPassengersUseCase.quantityOfParameter(ParameterEnum.PCLASS, 1, ruta);
        Assertions.assertEquals(result, 4);
    }

    @Test
    void givenValidFileClassTwo() {
        Integer result = titanicPassengersUseCase.quantityOfParameter(ParameterEnum.PCLASS, 2, ruta);
        Assertions.assertEquals(result, 3);
    }


    @Test
    void givenValidFileClassThree() {
        Integer result = titanicPassengersUseCase.quantityOfParameter(ParameterEnum.PCLASS, 3, ruta);
        Assertions.assertEquals(result, 13);
    }

    @Test
    void givenValidFileClassThreeFalse() {
        Integer result = titanicPassengersUseCase.quantityOfParameter(ParameterEnum.PCLASS, 4, ruta);
        Assertions.assertEquals(result, 0);
    }

    @Test
    void givenValidFileSexMale() {
        Integer result = titanicPassengersUseCase.quantityOfParameter(ParameterEnum.SEX, "male", ruta);
        Assertions.assertEquals(result, 9);
    }
    @Test
    void givenValidFileSexFemale(){
        Integer result = titanicPassengersUseCase.quantityOfParameter(ParameterEnum.SEX, "female", ruta);
        Assertions.assertEquals(result, 11);
    }
    @Test
    void givenValidFileSexFemaleFalse(){
        Integer result = titanicPassengersUseCase.quantityOfParameter(ParameterEnum.SEX, "ma", ruta);
        Assertions.assertEquals (result, 0);
    }

    @Test
    void givenValidFileAge(){
        Integer result = titanicPassengersUseCase.quantityOfParameter(AGE, 22, ruta);
        Assertions.assertEquals(result, 1);
    }


    @Test
    void givenValidFileAgeFalse(){
        Integer result = titanicPassengersUseCase.quantityOfParameter(AGE, 100, ruta);
        Assertions.assertEquals(result, 0);
    }

    @Test
    void givenParameterMapNullShouldReturnNull() {
        Map<Integer, List<PassengerDto>> result = titanicPassengersUseCase.passengersByAgeRange (null);
        Assertions.assertNull(result);
    }


    //TODO: Implementar pruebas unitarias para el método quantityOfParameter
    //TODO: Implementar pruebas unitarias para el método passengersByAgeRange
}
