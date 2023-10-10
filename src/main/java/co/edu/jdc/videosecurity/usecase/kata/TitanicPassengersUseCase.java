package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.dto.ParameterEnum;
import co.edu.jdc.videosecurity.domain.dto.PassengerDto;

import java.util.List;
import java.util.Map;

public class TitanicPassengersUseCase {

    public Integer quantityOfParameter(ParameterEnum parameter, Object value) {
        //TODO: Implementar el método para que retorne la cantidad de pasajeros que cumplieron con el parámetro
        //TODO: Debe leer el archivo titanic.csv en los recursos
        //TODO: Debe retornar 0 si no hay pasajeros que cumplan con el parámetro
        //TODO: Debe retornar null si el parámetro es null
        //TODO: Debe retornar null si el parámetro no es válido
        //TODO: Debe retornar null si el archivo no existe
        //TODO: Debe retornar null si el archivo está vacío
        //TODO: Debe retornar null si el archivo no tiene el formato correcto
        //TODO: Debe retornar null si el archivo no tiene la cantidad de columnas correctas
        return 0;
    }

    public Map<Integer, List<PassengerDto>> passengersByAgeRange() {
        //TODO: Implementar el método para que retorne un mapa donde la llave son los años y el valor es una lista de pasajeros
        //TODO: Debe leer el archivo titanic.csv en los recursos
        //TODO: Debe retornar null si el archivo no existe
        //TODO: Debe retornar null si el archivo está vacío
        //TODO: Debe retornar null si el archivo no tiene el formato correcto
        //TODO: Debe retornar null si el archivo no tiene la cantidad de columnas correctas
        return null;
    }
}
