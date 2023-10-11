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


    public Integer quantityOfParameter(ParameterEnum parameter, Object value) {
        if (parameter == null || value == null) {
            return null;
        }

        String ruta = "src/main/resources/titanic.csv";
        int count = 0;

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));

            String linea;
            String[] datos;

            String primeraLinea = lector.readLine();
            if (!primeraLinea.equals("PassengerId,Survived,Pclass,Name,Sex,Age")) {
                System.out.println("El archivo no tiene el formato correcto");
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
                    if (datos[5].equalsIgnoreCase (value.toString ().trim ())) {
                        count++;
                    }
                }


                if (parameter == ParameterEnum.AGE) {
                    if (datos[6].equals(value.toString())) {
                        count++;
                    }
                }
            }

            lector.close();
            return count;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
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


    public Map<Integer, List<PassengerDto>> passengersByAgeRange (String fila) {
  /*      List<PassengerDto> passengers = new ArrayList<> ();
        String ruta = "src/main/resources/titanic.csv";
        try {
            BufferedReader lector = new BufferedReader (new FileReader (ruta));
            CSVReader csvReader = new CSVReader (lector);
            String primeraLinea = lector.readLine ();
            if (csvReader == null || ruta.isEmpty ()) {
                System.out.println ("Archivo no encontrado");
                return null;
            } else {
                if (! primeraLinea.equals ("PassengerId,Survived,Pclass,Name,Sex,Age")) {
                    System.out.println ("El archivo no tiene el formato correcto");
                    return null;
                }
                List<String[]> rows = csvReader.readAll ();
                for (int i = 1; i < rows.size (); i++) {
                    String[] data = rows.get (i);
                    PassengerDto passenger = createPassengerFromCsvData (data);
                    if (passenger != null) {
                        passengers.add (passenger);
                    }
                }
                if (datos.length != 6) {
                    System.out.println ("El archivo no tiene la cantidad de columnas correctas");
                    return null;
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace ();

        }

        return (Map<Integer, List<PassengerDto>>) passengers;

        //TODO: Implementar el método para que retorne un mapa donde la llave son los años y el valor es una lista de pasajeros
        //TODO: Debe leer el archivo titanic.csv en los recursos
        //TODO: Debe retornar null si el archivo no existe
        //TODO: Debe retornar null si el archivo está vacío
        //TODO: Debe retornar null si el archivo no tiene el formato correcto
        //TODO: Debe retornar null si el archivo no tiene la cantidad de columnas correctas

    }

    public PassengerDto createPassengerFromCsvData (String[] data) {
        try {
            PassengerDto passenger = new PassengerDto ();
            passenger.setPassengerId ((long) Integer.parseInt (data[0]));
            passenger.setSurvived (Boolean.parseBoolean (data[1]));
            passenger.setPclass (Integer.parseInt (data[2]));
            passenger.setName (data[3]);
            passenger.setSex (data[4]);
            passenger.setAge (Integer.parseInt (data[5]));
        } catch (NumberFormatException e) {
            System.out.println ("Error al convertir los datos de dto a csv: " + e.getMessage ());
            return null;
        }

   */
        return null;
    }

}
