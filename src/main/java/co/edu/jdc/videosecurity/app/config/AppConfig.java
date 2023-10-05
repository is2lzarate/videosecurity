package co.edu.jdc.videosecurity.app.config;

import co.edu.jdc.videosecurity.adapter.cipher.CipherInfoImpl;
import co.edu.jdc.videosecurity.adapter.repository.RolePermissionRepository;
import co.edu.jdc.videosecurity.adapter.repository.UserRoleRepository;
import co.edu.jdc.videosecurity.usecase.port.CipherInfo;
import co.edu.jdc.videosecurity.adapter.repository.UserRepository;
import co.edu.jdc.videosecurity.usecase.user.ConsulUserUseCase;
import co.edu.jdc.videosecurity.usecase.user.ConsultRoleUseCase;
import co.edu.jdc.videosecurity.usecase.user.CreateUserUseCase;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Bean
    public CreateUserUseCase createUserUseCase(){
        return new CreateUserUseCase(userRepository, cipherInfo());
    }

    @Bean
    public CipherInfo cipherInfo(){
        return new CipherInfoImpl();
    }

    @Bean
    public ConsultRoleUseCase createConsultRoleUseCase(){
        return new ConsultRoleUseCase(userRoleRepository);
    }

    @Bean
    public ConsulUserUseCase consulUserUseCase(){
        return new ConsulUserUseCase(rolePermissionRepository);
    }
}
