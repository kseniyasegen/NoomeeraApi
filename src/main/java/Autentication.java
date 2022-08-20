import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Autentication {

    public void getAuthenticationCode(String email) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", email);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.AUTHENTICAUTION_SEND_CODE_URL);
    }

    public void getAuthentication(String email) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", email);
        jsonObject.put("code", "111111");
        jsonObject.put("code_challenge", "kqU8naFQSp6ANPs45HRzPNMVv7pHPWu462pamEmDlxw=");
        jsonObject.put("code_challenge_method", "sha256");
        CommonFields.response = given().log().all()
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
        jsonObject.put("code_authentication", CommonFields.codeAuthentication);
        jsonObject.put("code_verifier", CommonFields.code_verifier);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.AUTHENTICAUTION_TOKEN_URL);
    }

    public void getAuthorisation(String email) {
        getAuthenticationCode(email);
        getAuthentication(email);
        CommonFields.codeAuthentication = CommonFields.response.path("code_authentication");
        getToken();
        CommonFields.accessToken = CommonFields.response.path("access_token");
    }




}
