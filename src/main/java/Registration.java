import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class Registration {

    public void registrationName() {
        JSONObject name = new JSONObject();
        name.put("name", RandomStringUtils.randomAlphabetic(10));
        JSONObject registration = new JSONObject();
        registration.put("registration", name);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(registration.toMap())
                .when().log().all()
                .patch(Endpoints.REGISTRATION_URL);
    }

    public void registrationВirthday() {
        JSONObject birthday = new JSONObject();
        birthday.put("birthday", 934070400);
        JSONObject registration = new JSONObject();
        registration.put("registration", birthday);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(registration.toMap())
                .when().log().all()
                .patch(Endpoints.REGISTRATION_URL);
    }

    public void registrationGender() {
        JSONObject gender = new JSONObject();
        gender.put("gender", 1);
        JSONObject registration = new JSONObject();
        registration.put("registration", gender);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(registration.toMap())
                .when().log().all()
                .patch(Endpoints.REGISTRATION_URL);
    }

    public void registrationCountry() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("country_id", 3159);
        jsonObject.put("city_id", 4400);
        JSONObject registration = new JSONObject();
        registration.put("registration", jsonObject);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(registration.toMap())
                .when().log().all()
                .patch(Endpoints.REGISTRATION_URL);
    }

    public void registrationUniqname() {
        JSONObject avatar = new JSONObject();
        avatar.put("big", "");
        avatar.put("small", "");
        avatar.put("animation", "");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uniqname", RandomStringUtils.randomAlphabetic(10));
        jsonObject.put("avatar", avatar);
        JSONObject registration = new JSONObject();
        registration.put("registration", jsonObject);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(registration.toMap())
                .when().log().all()
                .patch(Endpoints.REGISTRATION_URL);
    }



}
