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

    public PassengerDto (Long passengerId,  Boolean survived, Integer pclass, String name, String sex, Integer age) {
        this.passengerId = passengerId;
        this.survived = survived;
        this.pclass = pclass;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
