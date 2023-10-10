package co.edu.jdc.videosecurity.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerDto {
    private Long passengerId;
    private Boolean survived;
    private Integer pclass;
    private String name;
    private String sex;
    private Integer age;
}
