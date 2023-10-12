package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.dto.ParameterEnum;
import com.opencsv.CSVReader;
import co.edu.jdc.videosecurity.domain.dto.PassengerDto;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TitanicPassengersUseCase {

    public static List<String[]> leerCSV() {
        List<String[]> datos = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader("src\\main\\resources\\titanic.csv"))) {
            String[] linea;
            while ((linea = reader.readNext()) != null) {
                datos.add(linea);
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return datos;
    }

    public Integer quantityOfParameter(ParameterEnum parameter, Object value) {
        //TODO: Implementar el método para que retorne la cantidad de pasajeros que cumplieron con el parámetro
        //TODO: Debe leer el archivo titanic.csv en los recursos
        List<String[]> datos = leerCSV();
        //TODO: Debe retornar 0 si no hay pasajeros que cumplan con el parámetro

        //TODO: Debe retornar null si el parámetro es null
        if (parameter == null){
            return null;
        }
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
