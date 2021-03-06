import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.JVM)
public class AuthenticationTest {

   // public static Response response;


    @Test
    @DisplayName("При запросе кода статус код 200")
    @Description("")
    public void getAuthenticationCode200() {
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        assertEquals(200, CommonFields.response.statusCode());
        assertNotNull(CommonFields.response.jsonPath());
    }

    @Test
    @DisplayName("При получении кода аутентификации статус код 200")
    @Description("")
    public void getAuthentication200() {
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("Код аутентификации получен")
    @Description("")
    public void getAuthenticationCodeAuthentication() {
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        assertNotNull(CommonFields.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе токена статус код 200")
    @Description("")
    public void getTokenStatusCode200() {
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        CommonFields.codeAuthentication = CommonFields.response.path("code_authentication");
        autentication.getToken();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("При запросе токена приходит аксес токен")
    @Description("")
    public void getAccessToken(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        CommonFields.codeAuthentication = CommonFields.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(CommonFields.response.jsonPath());
    }
}