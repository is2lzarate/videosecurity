package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderUserByParameterUseCase {

    public List<User> orderUsersByParameter(List<User> users, String parameter, boolean asc) {
        List<User> userList = users;

        if (userList == null || userList.isEmpty() || parameter == null || parameter.isEmpty()) {
            return userList;
        }
        if (asc) {
            userList.sort(Comparator.comparing(User::getFirstName));
        } else {
            userList.sort(Comparator.comparing(User::getFirstName).reversed());
        }

        if (userList == null || userList.isEmpty()) {
            return userList;
        }

        if (parameter == null || parameter.isEmpty()) {
            return userList;
        }

        if (parameter.equals("firstLastName")) {
            if (asc) {
                userList.sort(Comparator.comparing(User::getFirstLastName));
            } else {
                userList.sort(Comparator.comparing(User::getFirstLastName).reversed());
            }
        }
        if (parameter.equals("email")) {
            if (asc) {
                userList.sort(Comparator.comparing(User::getEmail));
            } else {
                userList.sort(Comparator.comparing(User::getEmail).reversed());
            }
        }

        if (parameter.equals("firstName")) {
            if (asc) {
                userList.sort(Comparator.comparing(User::getFirstName));
            } else {
                userList.sort(Comparator.comparing(User::getFirstName).reversed());
            }
        }

        return userList;
    }



}
