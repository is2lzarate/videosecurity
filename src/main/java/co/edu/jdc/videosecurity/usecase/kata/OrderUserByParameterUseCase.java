package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.Comparator;
import java.util.List;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc) {
        if (parameter == null || users == null || users.isEmpty() || parameter.isEmpty()) {
            return users;
        }
        Comparator<User> comparator = null;

        switch (parameter) {
            case "firstName":
                comparator = Comparator.comparing(User::getFirstName);
                break;
            case "firstLastName":
                comparator = Comparator.comparing(User::getFirstLastName);
                break;
            case "email":
            case "other":
                comparator = Comparator.comparing(User::getEmail);
                break;
            default:
                return null;
        }

        if (!asc) {
            comparator = comparator.reversed();
        }

        users.sort(comparator);
        return users;
    }

}