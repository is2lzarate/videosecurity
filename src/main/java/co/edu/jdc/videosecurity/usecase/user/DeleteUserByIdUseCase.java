package co.edu.jdc.videosecurity.usecase.user;

import co.edu.jdc.videosecurity.domain.exception.UserException;
import co.edu.jdc.videosecurity.adapter.repository.UserRepository;

public class DeleteUserByIdUseCase {

    private UserRepository userRepository;

    public DeleteUserByIdUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void execute(Long id){
        if(userRepository.existUser(id).intValue() == 0)
            throw new UserException("User not found");
        this.userRepository.deleteById(id);
    }
}
