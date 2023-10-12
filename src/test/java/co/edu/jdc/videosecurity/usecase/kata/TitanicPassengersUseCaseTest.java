package co.edu.jdc.videosecurity.usecase.kata;import co.edu.jdc.videosecurity.domain.dto.ParameterEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TitanicPassengersUseCaseTest {
    private TitanicPassengersUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new TitanicPassengersUseCase();
    }

    @Test
    public void testQuantityOfParameterValidInput() {
        // Prueba con un parámetro válido y un valor existente en el archivo CSV.
        Integer result = useCase.quantityOfParameter(ParameterEnum.AGE, "SomeValue");
        assertNotNull(result);
        assertEquals(22, result.intValue()); // Asegura que la cantidad sea correcta.
    }

    @Test
    public void testQuantityOfParameterNullParameter() {
        // Prueba con un parámetro nulo.
        Integer result = useCase.quantityOfParameter(null, "SomeValue");
        assertNull(result);
    }

    @Test
    public void testQuantityOfParameterInvalidParameter() {
        // Prueba con un parámetro no válido.
        Integer result = useCase.quantityOfParameter(ParameterEnum.AGE, "SomeValue");
        assertNull(result);
    }

    @Test
    public void testQuantityOfParameterNonexistentFile() {
        // Prueba con un archivo que no existe.
        Integer result = useCase.quantityOfParameter(ParameterEnum.SEX, "SomeValue");
        assertNull(result);
    }

    @Test
    public void testQuantityOfParameterEmptyFile() {
        // Prueba con un archivo CSV vacío.
        Integer result = useCase.quantityOfParameter(ParameterEnum.SURVIVED, "SomeValue");
        assertNull(result);
    }

    @Test
    public void testQuantityOfParameterIncorrectFormat() {
        // Prueba con un archivo CSV que tiene un formato incorrecto.
        Integer result = useCase.quantityOfParameter(ParameterEnum.SURVIVED, "SomeValue");
        assertNull(result);
    }
}
