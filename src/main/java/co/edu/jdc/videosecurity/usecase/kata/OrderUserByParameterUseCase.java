package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc){
        //TODO Debemos construir la logica para ordenar los usuarios por el parametro que llega en parameter y de forma ascendente o descendente segun el booleano
        //TODO Si el parametro no existe debemos retornar la lista tal cual como esta
        if(parameter == null || parameter.isEmpty()){
            return users;
        }
        //TODO Si el parametro es null debemos retornar la lista tal cual como esta


        //TODO Si la lista es null debemos retornar null
        if(users==null){
            return null;
        }
        //TODO Si la lista esta vacia debemos retornar la lista tal cual como esta
        if(users.isEmpty()){
            return users;
        }

        if(parameter.equals("firstName") && asc){
            users.sort(Comparator.comparing(User::getFirstName));
            return users;
        }
        if(parameter.equals("firstName")){
            users.sort(Comparator.comparing(User::getFirstName).reversed());
            return users;
        }

        if(parameter.equals("firstLastName") && asc){
            users.sort(Comparator.comparing(User::getFirstLastName));
            return users;
        }

        if(parameter.equals("firstLastName")){
            users.sort(Comparator.comparing(User::getFirstLastName).reversed());
            return users;
        }

        if(parameter.equals("email") && asc){
            users.sort(Comparator.comparing(User::getEmail));
            return users;
        }

        if(parameter.equals("email")){
            users.sort(Comparator.comparing(User::getEmail).reversed());
            return users;
        }
        //TODO Si el parametro es vacio debemos retornar la lista tal cual como esta
        //TODO El parametro a ordenar puede ser firstName, firstLastName o email unicamente
        //TODO Si el parametro es firstName debemos ordenar por el primer nombre

        //TODO Si el parametro es firstLastName debemos ordenar por el primer apellido
        //TODO Si el parametro es email debemos ordenar por el email
        //TODO Si el parametro es otro debemos retornar la lista tal cual como esta
        return users;
    }

}
