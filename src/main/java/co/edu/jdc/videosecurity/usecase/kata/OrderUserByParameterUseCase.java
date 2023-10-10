package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc){
        if (users == null || users.isEmpty() || parameter == null || parameter.isEmpty() || parameter.equals("other")) {
            return users;
        }
        Comparator<User> comparator = switch (parameter) {
            case "firstName" -> Comparator.comparing(User::getFirstName);
            case "firstLastName" -> Comparator.comparing(User::getFirstLastName);
            case "email" -> Comparator.comparing(User::getEmail);
            default -> null;
        };
        users.sort(asc ? comparator : Objects.requireNonNull(comparator).reversed());
        return users;
    }
}
