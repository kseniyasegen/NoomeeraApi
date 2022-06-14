import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class Users {

    public static Response response;
    public static String status;


    public void getUserInfo() {
        Autentication autentication = new Autentication();
        response = given().log().all()
                .queryParam("user_id", "3041293")
                .queryParam("user_type", "UserSimple")
                .queryParam("version", "4.44")
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ autentication.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USER_INFO_URL);
    }

    public void getUserLink() {
        Autentication autentication = new Autentication();
        response = given().log().all()
                .queryParam("user_id", "3041293")
                .queryParam("user_type", "UserSimple")
                .queryParam("version", "4.44")
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ autentication.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USER_LINK_URL);
    }

    public void getUserFriends() {
        Autentication autentication = new Autentication();
        response = given().log().all()
                .queryParam("user_id", "3041293")
                .queryParam("user_type", "UserSimple")
                .queryParam("limit", "20")
                .queryParam("offset", "0")
                .queryParam("state", "2")
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ autentication.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USER_FRIENDS_URL);
    }


    public void getUserCountFriends() {
        Autentication autentication = new Autentication();
        response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ autentication.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USER_COUNT_FRIENDS_URL);
    }

    public void getMyProfile() {
        Autentication autentication = new Autentication();
        response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ autentication.accessToken)
                .when().log().all()
                .get(Endpoints.GET_MY_PROFILE_URL);
    }

    public void getMyEmail() {
        Autentication autentication = new Autentication();
        response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ autentication.accessToken)
                .when().log().all()
                .get(Endpoints.GET_MY_EMAIL_URL);
    }

    public void getMyPhoneNumber() {
        Autentication autentication = new Autentication();
        response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ autentication.accessToken)
                .when().log().all()
                .get(Endpoints.GET_MY_PHONE_NUMBER_URL);
    }

}
