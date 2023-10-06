package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.*;

public class OrderUserByParameterUseCase {


    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc) {
        List<User> userList = users;
        if (userList == null || userList.isEmpty() || parameter == null || parameter.isEmpty())
            return userList;
        if (parameter.equals("firstLastName") )
            userList.sort(asc ? Comparator.comparing(User::getFirstLastName) : Comparator.comparing(User::getFirstLastName).reversed());
        else if (parameter.equals("email"))
            userList.sort(asc ? Comparator.comparing(User::getEmail): Comparator.comparing(User::getEmail).reversed());
        else if (parameter.equals("firstName"))
            userList.sort(asc ? Comparator.comparing(User::getFirstName): Comparator.comparing(User::getFirstName).reversed());
        return userList;
    }
}
