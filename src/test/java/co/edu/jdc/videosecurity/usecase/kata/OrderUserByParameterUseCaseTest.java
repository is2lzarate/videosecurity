package co.edu.jdc.videosecurity.usecase.kata;

import co.edu.jdc.videosecurity.domain.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderUserByParameterUseCaseTest {

    private OrderUserByParameterUseCase orderUserByParameterUseCase;

    @BeforeAll
    void init(){
        orderUserByParameterUseCase = new OrderUserByParameterUseCase();
    }

    @Test
    void givenListNullShouldReturnNull () {
        List<User> listNull = null;
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(listNull, "firstName", true);
        Assertions.assertNull(result);
    }

    @Test
    void givenListEmptyShouldReturnEmpty () {
        List<User> listEmpty = getListUsers();
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(listEmpty, "firstName", true);
        Assertions.assertEquals(listEmpty, result);
    }

    @Test
    void givenParameterNullShouldReturnList () {
        List<User> list = getListUsers();
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(list, null, true);
        Assertions.assertEquals(list, result);
    }

    @Test
    void givenParameterEmptyShouldReturnList () {
        List<User> list = getListUsers();
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(list, "", true);
        Assertions.assertEquals(list, result);
    }

    @Test
    void givenParameterFirstNameShouldReturnListAsc () {
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(getListUsers(), "firstName", true);
        Assertions.assertEquals(getListFirstNameAsc(), result);
    }

    @Test
    void givenParameterFirstNameShouldReturnListDesc () {
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(getListUsers(), "firstName", false);
        Assertions.assertEquals(getListFirstNameDes(), result);
    }

    @Test
    void givenParameterFirstLastNameShouldReturnListAsc () {
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(getListUsers(), "firstLastName", true);
        Assertions.assertEquals(getListFirstLastNameAsc(), result);
    }

    @Test
    void givenParameterFirstLastNameShouldReturnListDesc () {
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(getListUsers(), "firstLastName", false);
        Assertions.assertEquals(getListFirstLastNameDes(), result);
    }

    @Test
    void givenParameterEmailShouldReturnListAsc () {
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(getListUsers(), "email", true);
        Assertions.assertEquals(getLisEmailAsc(), result);
    }

    @Test
    void givenParameterEmailShouldReturnListDesc () {
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(getListUsers(), "email", false);
        Assertions.assertEquals(getListEmailDes(), result);
    }

    @Test
    void givenParameterOtherAscShouldReturnList () {
        List<User> list = getListUsers();
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(list, "other", true);
        Assertions.assertEquals(list, result);
    }

    @Test
    void givenParameterOtherDescShouldReturnList () {
        List<User> list = getListUsers();
        List<User> result = orderUserByParameterUseCase.orderUsersByParameter(list, "other", false);
        Assertions.assertEquals(list, result);
    }


    private List<User> getListFirstNameAsc(){
        List<User> list = getListUsers();
        list.sort((a,b) -> a.getFirstName().compareTo(b.getFirstName()));
        return list;
    }

    private List<User> getListFirstNameDes(){
        List<User> list = getListUsers();
        list.sort((a,b) -> b.getFirstName().compareTo(a.getFirstName()));
        return list;
    }

    private List<User> getListFirstLastNameAsc(){
        List<User> list = getListUsers();
        list.sort((a,b) -> a.getFirstLastName().compareTo(b.getFirstLastName()));
        return list;
    }

    private List<User> getListFirstLastNameDes(){
        List<User> list = getListUsers();
        list.sort((a,b) -> b.getFirstLastName().compareTo(a.getFirstLastName()));
        return list;
    }

    private List<User> getLisEmailAsc(){
        List<User> list = getListUsers();
        list.sort((a,b) -> a.getEmail().compareTo(b.getEmail()));
        return list;
    }

    private List<User> getListEmailDes(){
        List<User> list = getListUsers();
        list.sort((a,b) -> b.getEmail().compareTo(a.getEmail()));
        return list;
    }


    private List<User> getListUsers(){
        User a = new User();
        a.setEmail("antonio@gmail.com");
        a.setFirstName("Jose");
        a.setFirstLastName("Sanchez");

        User b = new User();
        b.setEmail("daniel@gmail.com");
        b.setFirstName("Beto");
        b.setFirstLastName("Fernandez");

        User c = new User();
        c.setEmail("camila@gmail.com");
        c.setFirstName("Zara");
        c.setFirstLastName("Gomez");
        return Arrays.asList(a,b,c);
    }


}
