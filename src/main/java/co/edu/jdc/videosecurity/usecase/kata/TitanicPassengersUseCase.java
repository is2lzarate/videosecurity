package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.dto.ParameterEnum;
import co.edu.jdc.videosecurity.domain.dto.PassengerDto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class TitanicPassengersUseCase {

    public Integer quantityOfParameter(ParameterEnum parameter, Object value) {
        //TODO: Implementar el método para que retorne la cantidad de pasajeros que cumplieron con el parámetro

        //TODO: Debe leer el archivo titanic.csv en los recursos
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("titanic.csv");

        //TODO: Debe retornar 0 si no hay pasajeros que cumplan con el parámetro

        //TODO: Debe retornar null si el parámetro es null
        if(parameter == null){
            return null;
        }
        //TODO: Debe retornar null si el parámetro no es válido
        //TODO: Debe retornar null si el archivo no existe
        if(EnumSet.allOf(ParameterEnum.class).contains(parameter)){
            return null;
        }


        //TODO: Debe retornar null si el archivo no tiene el formato correcto
        if (inputStream == null) {
            // El archivo no se encuentra en los recursos.
            return null;
        }
        try (CSVParser parser = CSVParser.parse(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8),
                CSVFormat.DEFAULT)) {
            //TODO: Debe retornar null si el archivo está vacío
            if (!parser.iterator().hasNext()) {
                return null;  // El archivo está vacío.
            }

            if (!validateCSVFormat(parser)) {
                return null;  // El archivo no tiene el formato correcto.
            }

            int count = 0;
            for (CSVRecord record : parser) {
                if (record.get("Parameter").equals(value.toString())) {
                    count++;
                }
            }
            return count;
        } catch (IOException e) {
            // Manejar errores de lectura del archivo CSV.
            return null;
        }
    }


    //TODO: Debe retornar null si el archivo no tiene la cantidad de columnas correctas
    private boolean validateCSVFormat(CSVParser parser) {
        // Verificar si el archivo CSV tiene exactamente 6 columnas.
        return parser.getHeaderMap().size() == 6;
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
