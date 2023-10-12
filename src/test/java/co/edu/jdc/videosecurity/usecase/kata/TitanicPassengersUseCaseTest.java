package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.dto.ParameterEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TitanicPassengersUseCaseTest {
    //TODO: Implementar pruebas unitarias para el método quantityOfParameter
    //TODO: Implementar pruebas unitarias para el método passengersByAgeRange
    private TitanicPassengersUseCase titanicPassengersUseCase;
    @BeforeAll
    void init(){ titanicPassengersUseCase = new TitanicPassengersUseCase();}

    @Test
    void givenParameterNullShouldReturnNull(){
        Integer result = titanicPassengersUseCase.quantityOfParameter(null, null);
        Assertions.assertNull(result);
    }

}
