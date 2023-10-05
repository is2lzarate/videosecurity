package co.edu.jdc.videosecurity.domain.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String email;
    private String password;
    private String username;
}
