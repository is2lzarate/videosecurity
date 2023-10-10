package co.edu.jdc.videosecurity.usecase.user;

import co.edu.jdc.videosecurity.domain.dto.UserDto;
import co.edu.jdc.videosecurity.domain.entities.User;
import co.edu.jdc.videosecurity.domain.mapper.UserMapper;
import co.edu.jdc.videosecurity.adapter.repository.UserRepository;

import java.util.List;

public class ConsultAllUseCase {

    private UserRepository userRepository;

    public ConsultAllUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> execute() {
        List <User> users = userRepository.findAll();
        List<UserDto> listUsers = UserMapper.INSTANCE.toDto(users);
        return listUsers;
    }



}
