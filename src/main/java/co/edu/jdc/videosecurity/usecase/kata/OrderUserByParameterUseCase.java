package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.List;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc) {

        if (users == null || users.isEmpty() || parameter == null || parameter.isEmpty())
            return users;

        if (parameter.equals("firstName"))
            users.sort((u1, u2) -> asc ? u1.getFirstName().compareTo(u2.getFirstName()) : u2.getFirstName().compareTo(u1.getFirstName()));
        if (parameter.equals("firstLastName"))
            users.sort((u1, u2) -> asc ? u1.getFirstLastName().compareTo(u2.getFirstLastName()) : u2.getFirstLastName().compareTo(u1.getFirstLastName()));
        if (parameter.equals("email"))
            users.sort((u1, u2) -> asc ? u1.getEmail().compareTo(u2.getEmail()) : u2.getEmail().compareTo(u1.getEmail()));

        return users;


    }
}
