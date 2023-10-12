package co.edu.jdc.videosecurity.usecase.user;

import co.edu.jdc.videosecurity.domain.dto.UserDto;
import co.edu.jdc.videosecurity.domain.entities.User;
import co.edu.jdc.videosecurity.domain.exception.UserException;
import co.edu.jdc.videosecurity.domain.mapper.UserMapper;
import co.edu.jdc.videosecurity.usecase.port.CipherInfo;
import co.edu.jdc.videosecurity.adapter.repository.UserRepository;
import co.edu.jdc.videosecurity.usecase.validator.UserValidator;

public class .2020.CreateUserUseCase {

    private UserRepository userRepository;

    private CipherInfo cipherInfo;

    public CreateUserUseCase(UserRepository userRepository, CipherInfo cipherInfo){
        this.userRepository = userRepository;
        this.cipherInfo = cipherInfo;
    }

    public void execute(UserDto dto) {
        // validar informacion de usuario
        UserValidator.validateInputDto(dto);
        // validar que el usuario no exista
        if(this.userRepository.existsUser(dto.getUsername().trim()).intValue() > 0)
            throw new UserException("El usuario ya existe");
        // convertir dto a entidad
        User user = UserMapper.INSTANCE.toEntity(dto);
        // cifrar contraseña
        user.setPassword(this.cipherInfo.encrypt(dto.getPassword()));
        // guardar usuario
        this.userRepository.save(user);
    }

}
