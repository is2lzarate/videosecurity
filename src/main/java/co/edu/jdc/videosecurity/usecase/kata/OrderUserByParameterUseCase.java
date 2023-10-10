package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.dto.UserDto;
import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc) {

        Comparator<User> comparator = null;


        //TODO Debemos construir la logica para ordenar los usuarios por el parametro que llega en parameter y de forma ascendente o descendente segun el booleano


        //TODO Si el parametro no existe debemos retornar la lista tal cual como esta

        //TODO Si el parametro es null debemos retornar la lista tal cual como esta

        if (parameter == null || users == null || users.isEmpty() || parameter.isEmpty() && asc){
            return users;
        } if(parameter.equals("firstName") && asc == true && users == null){
            return users;
        }
        // git mersh

        if (parameter.equals("other") && asc == true) {
            return users;
        }else if(parameter.equals("other")){
            return users;
        }
       /* //TODO Si la lista es null debemos retornar null
        if (users == null) {
            return null;
        }
        //TODO Si la lista esta vacia debemos retornar la lista tal cual como esta
        if (users.isEmpty()) {
            return users;
        }
        //TODO Si el parametro es vacio debemos retornar la lista tal cual como esta
        if (parameter.isEmpty()) {
            return users;
        }*/
        //TODO El parametro a ordenar puede ser firstName, firstLastName o email unicamente

        if (!parameter.equals("firstName") && !parameter.equals("firstLastName") && !parameter.equals("email") && !parameter.equals("other") && parameter.equals("other") ) {
            throw new IllegalArgumentException("SOLO SE PUEDE FIRSTNAME, FIRST LAS NAME Y EMAIL");
        }
        //TODO El parametro a ordenar puede ser firstName, firstLastName o email unicamente
        if ("firstName".equals(parameter)) {
            comparator = Comparator.comparing(User::getFirstName);
        } else if ("firstLastName".equals(parameter)) {
            comparator = Comparator.comparing(User::getFirstLastName);
        } else if ("email".equals(parameter)) {
            comparator = Comparator.comparing(User::getEmail);
        }
        if (!asc) {
            comparator = comparator.reversed();
        }
       /* //TODO Si el parametro es firstName debemos ordenar por el primer nombre
        if (parameter.equals("firstName")) {
            comparator = Comparator.comparing(User::getFirstName);
            return users;
        }
        //TODO Si el parametro es firstLastName debemos ordenar por el primer apellido

        if (parameter.equals("firstLastName")) {
            comparator = Comparator.comparing(User::getFirstName);
            return users;
        }
        //TODO Si el parametro es email debemos ordenar por el email
        if (parameter.equals("email")) {
            comparator = Comparator.comparing(User::getEmail);
            return users;
        }
*/
        //TODO Si el parametro es otro debemos retornar la lista tal cual como esta


        Collections.sort(users,comparator);
        return users;
    }
}
