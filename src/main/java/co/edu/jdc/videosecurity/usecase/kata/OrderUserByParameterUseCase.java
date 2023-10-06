package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;
import org.springframework.data.domain.Sort;

import java.util.List;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc){
        //TODO Debemos construir la logica para ordenar los usuarios por el parametro que llega en parameter y de forma ascendente o descendente segun el booleano

        //TODO Si el parametro no existe debemos retornar la lista tal cual como esta
        //TODO Si el parametro es null debemos retornar la lista tal cual como esta
        //TODO Si la lista es null debemos retornar null
        if(validateTest(users, parameter, asc))
            return users;

        if (asc){
            if (parameter == "firstName"){
                users.sort((a,b) -> a.getFirstName().compareTo(b.getFirstName()));
                return users;
            }
        }else{
            if (parameter == "firstName"){
                users.sort((a,b) -> b.getFirstName().compareTo(a.getFirstName()));
                return users;
            }
        }

        if (asc){
            if (parameter == "firstLastName"){
                users.sort((a,b) -> a.getFirstLastName().compareTo(b.getFirstLastName()));
                return users;
            }
        }else{
            if (parameter == "firstLastName"){
                users.sort((a,b) -> b.getFirstLastName().compareTo(a.getFirstLastName()));
                return users;
            }
        }

        if (asc){
            if (parameter == "email"){
                users.sort((a,b) -> a.getEmail().compareTo(b.getEmail()));
                return users;
            }
        }else{
            if (parameter == "email"){
                users.sort((a,b) -> b.getEmail().compareTo(a.getEmail()));
                return users;
            }
        }

        if (!(parameter == "firstName" ||parameter == "firstLastName" || parameter == "email")){
            return users;
        }
        //TODO El parametro a ordenar puede ser firstName, firstLastName o email unicamente
        //TODO Si el parametro es firstName debemos ordenar por el primer nombre
        //TODO Si el parametro es firstLastName debemos ordenar por el primer apellido
        //TODO Si el parametro es email debemos ordenar por el email
        //TODO Si el parametro es otro debemos retornar la lista tal cual como esta
        return null;
    }

    private boolean validateTest(List<User> users, String parameter, boolean asc){

        if(parameter == null || parameter.isEmpty()){
            return true;
        }

        if(users == null || users.isEmpty()){
            return true;
        }



        return false;

    }
}
