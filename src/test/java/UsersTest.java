import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.JVM)
public class UsersTest {

    public static Response response;
    public static String status;
    //public static String codeAuthentication;



    @Test
    @DisplayName("При запросе информации о юзере приходит 200")
    @Description("")
    public void getUsersInfoStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserInfo();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе информации о юзере приходит непустой json")
    @Description("")
    public void getUsersInfoNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserInfo();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе информации о юзере приходит 200")
    @Description("")
    public void getUsersLinkStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserInfo();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе информации о юзере приходит непустой json")
    @Description("")
    public void getUsersLinkNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserInfo();
        assertNotNull(autentication.response.jsonPath());
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