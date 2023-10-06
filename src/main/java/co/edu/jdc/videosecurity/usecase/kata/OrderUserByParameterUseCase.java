package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;
import org.springframework.data.domain.Sort;

import java.util.List;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc) {

        if (parameter == null || parameter.isEmpty() || users == null || users.isEmpty())
            return users;
        if (parameter == "firstName")
            users.sort((a, b) -> asc ? a.getFirstName().compareTo(b.getFirstName()) : b.getFirstName().compareTo(a.getFirstName()));
        else if (parameter == "firstLastName")
            users.sort((a, b) -> asc ? a.getFirstLastName().compareTo(b.getFirstLastName()) : b.getFirstLastName().compareTo(a.getFirstLastName()));
        else if (parameter == "email")
            users.sort((a, b) -> asc ? a.getEmail().compareTo(b.getEmail()) : b.getEmail().compareTo(a.getEmail()));
        return users;
    }

}
