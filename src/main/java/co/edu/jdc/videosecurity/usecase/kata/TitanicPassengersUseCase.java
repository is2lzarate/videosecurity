package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.dto.ParameterEnum;
import co.edu.jdc.videosecurity.domain.dto.PassengerDto;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;

public class TitanicPassengersUseCase {

    private BufferedReader lector;// lee el archivo
    private String linea; //recibe cada linea
    private String[] datos; //recibe los datos de cada linea
    FileHandler fileHandler;
    String ruta = "src/main/resources/titanic.csv";


    public Integer quantityOfParameter (ParameterEnum parameter, Object value, String ruta) {
        if (parameter == null || value == null) {
            return null;
        }
        int count = 0;
        try {
            BufferedReader lector = new BufferedReader (new FileReader (ruta));

            String linea;
            String[] datos;

            String primeraLinea = lector.readLine ();
            if (! primeraLinea.equals ("PassengerId,Survived,Pclass,Name,Sex,Age")) {
                System.out.println ("El archivo no tiene el formato correcto");
                return null;
            }

            while ((linea = lector.readLine()) != null) {
                datos = linea.split(",");

                if (parameter == ParameterEnum.SURVIVED) {
                    if (datos[1].equals(value.toString())) {
                        count++;
                    }
                }
                if (parameter == ParameterEnum.PCLASS) {
                    if (datos[2].equals(value.toString())) {
                        count++;
                    }
                }
               /* if(parameter == ParameterEnum.SEX){
                    if(value.equals ("male")){
                        count = 9;
                        System.out.println (datos[6]);
                    }
                }
                */
                if (parameter == ParameterEnum.SEX) {
                    if (datos[4].equalsIgnoreCase (value.toString ().trim ())) {
                        count++;
                    }
                }


                if (parameter == ParameterEnum.AGE) {
                    if (datos[5].equals(value.toString())) {
                        count++;
                    }
                }
            }

            lector.close();
            return count;
        } catch (IOException e) {
            System.out.println ("Error al leer el archivo: " + e.getMessage ());
            return null;
        }
    }


    //TODO: Implementar el método para que retorne la cantidad de pasajeros que cumplieron con el parámetro
    //TODO: Debe leer el archivo titanic.csv en los recursos
    //TODO: Debe retornar 0 si no hay pasajeros que cumplan con el parámetro
    //TODO: Debe retornar null si el parámetro es null
    //TODO: Debe retornar null si el parámetro no es válido
    //TODO: Debe retornar null si el archivo no existe
    //TODO: Debe retornar null si el archivo está vacío
    //TODO: Debe retornar null si el archivo no tiene el formato correcto
    //TODO: Debe retornar null si el archivo no tiene la cantidad de columnas correctas


    public Map<Integer, List<PassengerDto>> passengersByAgeRange (String ruta) {
        Map<Integer, List<PassengerDto>> pasajeroEdad = new HashMap<> ();
        if (ruta == null) {
            return null;
        }
        try {
            BufferedReader lector = new BufferedReader (new FileReader (ruta));

            String linea;
            String[] datos;

            String primeraLinea = lector.readLine ();
            if (! primeraLinea.equals ("PassengerId,Survived,Pclass,Name,Sex,Age")) {
                System.out.println ("El archivo no tiene el formato correcto");
                return null;
            }

            while ((linea = lector.readLine ()) != null) {
                datos = linea.split (",");
                int edad = Integer.parseInt (datos[5]);

                if (! pasajeroEdad.containsKey (edad)) {
                    pasajeroEdad.put (edad, new ArrayList<> ());
                }
                PassengerDto pasajero = new PassengerDto (
                        Long.parseLong (datos[0]),
                        Boolean.parseBoolean (datos[1]),
                        Integer.parseInt (datos[2]),
                        datos[3],
                        datos[4],
                        Integer.parseInt (datos[5])
                );

                pasajeroEdad.get (edad).add (pasajero);
            }

            lector.close ();
            return pasajeroEdad;
        } catch (IOException e) {
            System.out.println ("Error al leer el archivo: " + e.getMessage ());
            return null;
        }
    }


    //TODO: Implementar el método para que retorne un mapa donde la llave son los años y el valor es una lista de pasajeros
    //TODO: Debe leer el archivo titanic.csv en los recursos
    //TODO: Debe retornar null si el archivo no existe
    //TODO: Debe retornar null si el archivo está vacío
    //TODO: Debe retornar null si el archivo no tiene el formato correcto
    //TODO: Debe retornar null si el archivo no tiene la cantidad de columnas correctas

}
