package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.Comparator;
import java.util.List;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc){
        if (users == null || parameter == null || parameter.isEmpty || parameter.equals("other")) {
            return users;
        }
        package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.Comparator;
import java.util.List;

        public class OrderUserByParameterUseCase {

            public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc) {
                // Verificar si los parámetros son inválidos y retornar la lista tal cual
                if (users == null || parameter == null || parameter.isEmpty()) {
                    return users;
                }

                Comparator<User> userComparator;

                // Definir el comparador en función del parámetro
                switch (parameter) {
                    case "firstName":
                        userComparator = Comparator.comparing(User::getFirstName);
                        break;
                    case "firstLastName":
                        userComparator = Comparator.comparing(User::getFirstLastName);
                        break;
                    case "email":
                        userComparator = Comparator.comparing(User::getEmail);
                        break;
                    default:
                        // Si el parámetro no es válido, retornar la lista tal cual
                        return users;
                }

                // Ordenar en orden ascendente o descendente según sea necesario
                if (!asc) {
                    userComparator = userComparator.reversed();
                }

                users.sort(userComparator);
                return users;
            }
        }
