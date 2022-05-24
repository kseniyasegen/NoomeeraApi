import com.google.gson.JsonObject;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class AuthenticationTest {

    public static Response response;
    public static String status;
    public static String codeAuthentication;

    @Test
    @DisplayName("При запросе кода статус код 200")
    @Description("")
    public void getAuthenticationCode() {
    //    File json = new File("src/test/resources/email.json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "nik1@testmail.test");
        response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.AUTHENTICAUTION_SEND_CODE_URL);
        assertEquals(200, response.statusCode());
       // assertNull(response.jsonPath());
      // status = response.path("ok");
    }

    @Test
    @DisplayName("Получение кода аутентификации")
    @Description("")
    public void getAuthentication() {
        //    File json = new File("src/test/resources/email.json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "nik1@testmail.test");
        jsonObject.put("code", "111111");
        jsonObject.put("code_challenge", "kqU8naFQSp6ANPs45HRzPNMVv7pHPWu462pamEmDlxw=");
        jsonObject.put("code_challenge_method", "sha256");
        response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.AUTHENTICAUTION_AUTHENTICATE_URL);
        assertEquals(200, response.statusCode());
        assertNotNull(response.jsonPath());
        codeAuthentication = response.path("code_authentication");
    }


/*
    private int courierId;
    private CourierClient courierClient;

    @Before
    public void setUp() {
        courierClient = new CourierClient();

    }

    @Test
    @DisplayName("Авторизация с рандомными кредами /api/v1/courier/login")
    @Description("Курьер может авторизоваться;\n" +
            "Успешный запрос возвращает id;\n")
    public void courierLogin() {
        //создать курьера
        Courier courier = Courier.getRandom();
        courierClient.create(courier);
        //авторизоваться для получения id
        CourierCredentials creds = CourierCredentials.from(courier);
        courierClient.login(creds);
        //проверить, что возвращается статус код 200
        assertEquals(CourierClient.response.statusCode(), 200);
        //проверить, что возвращается id
        assertNotEquals(0, courierClient.courierId);
        //удалить курьера
        courierClient.delete(courierClient.courierId);
    }

    @Test
    @DisplayName("Авторизация без логина /api/v1/courier/login")
    @Description("Для авторизации нужно передать все обязательные поля;\n" +
            "Если какого-то поля нет, запрос возвращает ошибку;\n")
    public void courierLoginWithoutLogin() {
        //дернуть ручку с конструктором, в котором одно обязательное поле
        CourierCredentials creds = new CourierCredentials("", "Segen0123");
        courierClient.loginWithWrong(creds);
        //проверить, что возвращается статус код 400
        assertEquals(CourierClient.response.statusCode(), 400);
        //проверить, что возвращается текст ошибки
        assertEquals(CourierClient.keysValue, "Недостаточно данных для входа");
    }

    @Test
    @DisplayName("Авторизация без пароля /api/v1/courier/login")
    @Description("Для авторизации нужно передать все обязательные поля;\n" +
            "Если какого-то поля нет, запрос возвращает ошибку;\n")
    public void courierLoginWithoutPassword() {
        //дернуть ручку с конструктором, в котором одно обязательное поле
        CourierCredentials creds = new CourierCredentials("Segen0123", "");
        courierClient.loginWithWrong(creds);
        //проверить, что возвращается статус код 400
        assertEquals(CourierClient.response.statusCode(), 400);
        //проверить, что возвращается текст ошибки
        assertEquals(CourierClient.keysValue, "Недостаточно данных для входа");
    }

    @Test
    @DisplayName("Авторизация без логина и пароля /api/v1/courier/login")
    @Description("Для авторизации нужно передать все обязательные поля;\n" +
            "Если какого-то поля нет, запрос возвращает ошибку;\n")
    public void courierLoginWithoutLoginAndPassword() {
        //дернуть ручку с конструктором, в котором одно обязательное поле
        CourierCredentials creds = new CourierCredentials("", "");
        courierClient.loginWithWrong(creds);
        //проверить, что возвращается статус код 400
        assertEquals(CourierClient.response.statusCode(), 400);
        //проверить, что возвращается текст ошибки
        assertEquals(CourierClient.keysValue, "Недостаточно данных для входа");
    }

    @Test
    @DisplayName("Авторизация с несуществующими кредами")
    @Description("Система вернёт ошибку, если неправильно указать логин или пароль;\n" +
            "Если авторизоваться под несуществующим пользователем, запрос возвращает ошибку;\n")
    public void courierLoginWithWrongCreds() {
        //указать несуществующие логин и пароль
        CourierCredentials creds = new CourierCredentials("Segen0123", "Segen0123");
        courierClient.loginWithWrong(creds);
        //проверить, что возвращается статус код 400
        assertEquals(CourierClient.response.statusCode(), 404);
        //проверить, что возвращается текст ошибки
        assertEquals(CourierClient.keysValue, "Учетная запись не найдена");
    }

 */
}