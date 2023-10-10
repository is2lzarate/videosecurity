package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.Comparator;
import java.util.List;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc) {
        //TODO Debemos construir la logica para ordenar los usuarios por el parametro que llega en parameter y de forma ascendente o descendente segun el booleano
        //TODO Si el parametro no existe debemos retornar la lista tal cual como esta
        //TODO Si la lista esta vacia debemos retornar la lista tal cual como esta
        //TODO Si el parametro es vacio debemos retornar la lista tal cual como esta
        //TODO Si el parametro es null debemos retornar la lista tal cual como esta
        //TODO Si la lista es null debemos retornar null
        //TODO Si el parametro es otro debemos retornar la lista tal cual como esta
        //TODO El parametro a ordenar puede ser firstName, firstLastName o email unicamente
        //TODO Si el parametro es firstName debemos ordenar por el primer nombre
        //TODO Si el parametro es firstLastName debemos ordenar por el primer apellido
        //TODO Si el parametro es email debemos ordenar por el email
        if (parameter == null || parameter.isEmpty() || users == null || users.isEmpty() ) {
            return users;
        }
        if((parameter.equals("firstName"))){
            users.sort((a,b) -> asc ? a.getFirstName().compareTo(b.getFirstName()) : b.getFirstName().compareTo(a.getFirstName()));
            return users;
        }
        if((parameter.equals("firstLastName"))){
            users.sort((a,b) -> asc ? a.getFirstLastName().compareTo(b.getFirstLastName()) : b.getFirstLastName().compareTo(a.getFirstLastName()));
            return users;
        }
        if((parameter.equals("email"))){
            users.sort((a,b) -> asc ? a.getEmail().compareTo(b.getEmail()) : b.getEmail().compareTo(a.getEmail()));
            return users;
        }
        return users;
    }

}
