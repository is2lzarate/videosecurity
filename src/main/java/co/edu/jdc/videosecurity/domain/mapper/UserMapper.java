package co.edu.jdc.videosecurity.domain.mapper;

import co.edu.jdc.videosecurity.domain.dto.UserDto;
import co.edu.jdc.videosecurity.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    UserDto toDto(User user);
    User toEntity(UserDto user);
    List<UserDto> toDto(List<User> user);
    List<User> toEntity(List<UserDto> user);
}
