package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;
import co.edu.jdc.videosecurity.domain.exception.UserException;
import lombok.SneakyThrows;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderUserByParameterUseCase {

    @SneakyThrows
    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc){

        Comparator<User> comparator = null;


        //TODO Debemos construir la logica para ordenar los usuarios por el parametro que llega en parameter y de forma ascendente o descendente segun el booleano

        //TODO Si el parametro no existe debemos retornar la lista tal cual como esta
        if(parameter == null || parameter.isEmpty()){
            return users;
        }
        //TODO Si el parametro es null debemos retornar la lista tal cual como esta
        if (parameter == null){
            return users;
        }

        if (parameter.equals("other") && asc == true ){
            return users;
        }else if (parameter.equals("other")){
            return users;
        }
        //TODO Si la lista es null debemos retornar null
        if (users == null){
            return null;
        }
        //TODO Si la lista esta vacia debemos retornar la lista tal cual como esta
        if (users.isEmpty()){
            return users;
        }
        //TODO Si el parametro es vacio debemos retornar la lista tal cual como esta
        if (parameter == null){
            return users;
        }
        //TODO El parametro a ordenar puede ser firstName, firstLastName o email unicamente
        if (!parameter.equals("firstName") && !parameter.equals("firstLastName") && !parameter.equals("email")){
            throw new IllegalArgumentException("No existe el parametro");
        }
        if (parameter.equals("firstName")){
           comparator = Comparator.comparing(User::getFirstName);
        } else if (parameter.equals("firstLastName")) {
            comparator = Comparator.comparing(User::getFirstLastName);
        } else if (parameter.equals("email")) {
            comparator = Comparator.comparing(User::getEmail);
        }
        if (!asc){
            comparator = comparator.reversed();
        }
        //TODO Si el parametro es firstName debemos ordenar por el primer nombre
        /*if (parameter.equals("firstName")){
            users.sort(Comparator.comparing(User::getUsername).reversed());
            return users;
        }

        //apellido asc
        if (parameter.equals("fistLastName")  && asc){
            users.sort(Comparator.comparing(User::getFirstLastName));
            return users;
        }
        //TODO Si el parametro es firstLastName debemos ordenar por el primer apellido
        if (parameter.equals("firstLastName")){
            users.sort(Comparator.comparing(User::getFirstLastName).reversed());
            return users;
        }
        //TODO Si el parametro es email debemos ordenar por el email
        if (parameter.equals("email")){
            users.sort(Comparator.comparing(User::getEmail));
            return users;
        }
        //TODO Si el parametro es otro debemos retornar la lista tal cual como esta
        */
        Collections.sort(users,comparator);
        return users;
    }

}
