package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.List;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc){
        //TODO Debemos construir la logica para ordenar los usuarios por el parametro que llega en parameter y de forma ascendente o descendente segun el booleano
        //TODO Si el parametro no existe debemos retornar la lista tal cual como esta
        if(parameter.isEmpty()){
            return users;
        }
        //TODO Si el parametro es null debemos retornar la lista tal cual como esta
        //TODO Si la lista es null debemos retornar null
        //TODO Si la lista esta vacia debemos retornar la lista tal cual como esta
        //TODO Si el parametro es vacio debemos retornar la lista tal cual como esta
        //TODO El parametro a ordenar puede ser firstName, firstLastName o email unicamente
        //TODO Si el parametro es firstName debemos ordenar por el primer nombre
        //TODO Si el parametro es firstLastName debemos ordenar por el primer apellido
        //TODO Si el parametro es email debemos ordenar por el email
        //TODO Si el parametro es otro debemos retornar la lista tal cual como esta
        return null;
    }

}
