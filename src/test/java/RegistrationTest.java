import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class RegistrationTest extends Initialization {

    @Before
    public void autorise() {
        autentication.getAuthorisation(CommonFields.emailRandom);
    }

    @Test
    @DisplayName("Заполнение имени:" + "статус код 200")
    public void registrationNameReturnsStatusCode200(){
        registration.registrationName();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("Заполнение даты рождения:" + "статус код 200")
    public void postAddGroupReturnsStatusCode200() {
        registration.registrationName();
        registration.registrationВirthday();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("Заполнение пола:" + "статус код 200")
    public void registrationGenderReturnsStatusCode200() {
        registration.registrationName();
        registration.registrationВirthday();
        registration.registrationGender();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("Заполнение страны и города:" + "статус код 200")
    public void registrationCountryReturnsStatusCode200() {
        registration.registrationName();
        registration.registrationВirthday();
        registration.registrationGender();
        registration.registrationCountry();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("Заполнение уникального имени и аватара:" + "статус код 200")
    public void registrationUniqnameReturnsStatusCode200() {
        registration.registrationName();
        registration.registrationВirthday();
        registration.registrationGender();
        registration.registrationCountry();
        registration.registrationUniqname();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        users.deleteProfile();
    }
}
