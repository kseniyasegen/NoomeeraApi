import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.JVM)
public class AuthenticationTest extends Initialization {

    @Test
    @DisplayName("При запросе кода статус код 200")
    @Description("")
    public void getAuthenticationCode200() {
        autentication.getAuthenticationCode(CommonFields.emailAutomationApi1);
        assertEquals(200, CommonFields.response.statusCode());
        assertNotNull(CommonFields.response.jsonPath());
    }

    @Test
    @DisplayName("При получении кода аутентификации статус код 200")
    @Description("")
    public void getAuthentication200() {
        autentication.getAuthenticationCode(CommonFields.emailAutomationApi1);
        autentication.getAuthentication(CommonFields.emailAutomationApi1);
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("Код аутентификации получен")
    @Description("")
    public void getAuthenticationCodeAuthentication() {
        autentication.getAuthenticationCode(CommonFields.emailAutomationApi1);
        autentication.getAuthentication(CommonFields.emailAutomationApi1);
        assertNotNull(CommonFields.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе токена статус код 200")
    @Description("")
    public void getTokenStatusCode200() {
        autentication.getAuthenticationCode(CommonFields.emailAutomationApi1);
        autentication.getAuthentication(CommonFields.emailAutomationApi1);
        CommonFields.codeAuthentication = CommonFields.response.path("code_authentication");
        autentication.getToken();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("При запросе токена приходит аксес токен")
    @Description("")
    public void getAccessToken(){
        autentication.getAuthenticationCode(CommonFields.emailAutomationApi1);
        autentication.getAuthentication(CommonFields.emailAutomationApi1);
        CommonFields.codeAuthentication = CommonFields.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(CommonFields.response.jsonPath());
    }
}