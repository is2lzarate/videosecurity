package co.edu.jdc.videosecurity.usecase.user;

import co.edu.jdc.videosecurity.adapter.repository.UserRoleRepository;
import co.edu.jdc.videosecurity.domain.exception.UserException;

import java.util.List;

import static java.util.Objects.isNull;

public class ConsultRoleUseCase {

    private UserRoleRepository userRoleRepository;

    public ConsultRoleUseCase(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public List<String> execute(String username) {
        if(username == null || username.trim().isEmpty())
            throw new UserException("El nombre de usuario no puede ser nulo o vacio");
        List<String> rols = userRoleRepository.getRolByUserName(username);

        return isNull(rols) ? List.of() : rols;
    }
}
