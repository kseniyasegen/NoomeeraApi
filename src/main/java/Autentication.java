import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Autentication {

    public static Response response;
    public static String status;
    public static String codeAuthentication;
    public static String accessToken;

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
        // assertNull(response.jsonPath());
        // status = response.path("ok");
    }

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
    }

    public void getToken() {
        //    File json = new File("src/test/resources/email.json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code_authentication", this.codeAuthentication);
        jsonObject.put("code_verifier", "axnkpyjwpsxx");
        response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.AUTHENTICAUTION_TOKEN_URL);
    }
}
