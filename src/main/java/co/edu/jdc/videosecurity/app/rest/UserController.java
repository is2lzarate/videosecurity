package co.edu.jdc.videosecurity.app.rest;

import co.edu.jdc.videosecurity.domain.dto.UserDto;
import co.edu.jdc.videosecurity.usecase.user.ConsulUserUseCase;
import co.edu.jdc.videosecurity.usecase.user.ConsultRoleUseCase;
import co.edu.jdc.videosecurity.usecase.user.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private ConsultRoleUseCase consultRoleUseCase;

    @Autowired
    private ConsulUserUseCase consulUserUseCase;

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto){
        this.createUserUseCase.execute(userDto);
    }

    @GetMapping(value = "/rol", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> consultRol(@RequestParam(value="username") String username){
        return this.consultRoleUseCase.execute(username);
    }

    @GetMapping(value = "/permissions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> consultPermissions(@RequestParam(value="username") String username){
        return this.consulUserUseCase.getPermissionUsername(username);
    }

}
