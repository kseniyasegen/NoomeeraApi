import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.C;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class Users {

    //public static Response response;


    public void getUserInfo() {
        CommonFields.response = given().log().all()
                .queryParam("user_id", CommonFields.user_id)
                .queryParam("user_type", CommonFields.user_type)
                .queryParam("version", CommonFields.version)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USER_INFO_URL);
    }

    public void getUserLink() {
        CommonFields.response = given().log().all()
                .queryParam("user_id", CommonFields.user_id)
                .queryParam("user_type", CommonFields.user_type)
                .queryParam("version", CommonFields.version)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USER_LINK_URL);
    }

    public void getUserFriends() {
        CommonFields.response = given().log().all()
                .queryParam("user_id", CommonFields.user_id)
                .queryParam("user_type", CommonFields.user_type)
                .queryParam("limit", CommonFields.limit)
                .queryParam("offset", CommonFields.offset)
                .queryParam("state", CommonFields.state)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USER_FRIENDS_URL);
    }


    public void getUserCountFriends() {
      CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USER_COUNT_FRIENDS_URL);
    }

    public void getMyProfile() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_MY_PROFILE_URL);
    }

    public void getMyEmail() {
       CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_MY_EMAIL_URL);
    }

    public void getMyPhoneNumber() {
      CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_MY_PHONE_NUMBER_URL);
    }

    public void getUserFriendsList() {
       CommonFields.response = given().log().all()
                .queryParam("user_id", CommonFields.user_id)
                .queryParam("user_type", CommonFields.user_type)
                .queryParam("limit", CommonFields.limit)
                .queryParam("offset", CommonFields.offset)
                .queryParam("state", CommonFields.state)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USER_FRIENDS_LIST_URL);
    }

    public void getCheckUniqname() {
       CommonFields.response = given().log().all()
                .queryParam("uniqname", CommonFields.uniqname)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_CHECK_UNIQNAME_URL);
    }

    public void getGenerateUniqname() {
       CommonFields.response = given().log().all()
                .queryParam("source", CommonFields.source)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_GENERATE_UNIQNAME_URL);
    }

    public void getUsersProfile() {
        CommonFields.response = given().log().all()
              //  .queryParam("user_id", CommonFields.user_id)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USERS_PROFILE_URL);
    }

    public void getFakeUsersProfile() {
        CommonFields.response = given().log().all()
                //  .queryParam("user_id", CommonFields.user_id)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_FAKE_USERS_PROFILE_URL);
    }

    public void getMyPermissions() {
       CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_MY_PERMISSIONS_URL);
    }

    public void postUpdateProfile() {
        CommonFields.response = given().log().all()
                .queryParam("name", "")
                .queryParam("uniqname", "")
                .queryParam("city_id", "")
                .queryParam("country_id", "")
                .queryParam("birthday", "")
                .queryParam("status", "")
                .queryParam("gender", "")
                .queryParam("phone", "")
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_UPDATE_PROFILE_URL);
    }

    public void postShareProfile() {
        JSONArray user_ids = new JSONArray();
        user_ids.put(CommonFields.user_ids);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("comment", CommonFields.comment);
        jsonObject.put("user_ids", user_ids);
        jsonObject.put("room_ids", "");

        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_SHARE_PROFILE_URL);
    }

    public void postShareProfileToMyself() {
        JSONArray user_ids = new JSONArray();
        user_ids.put(CommonFields.myId);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("comment", CommonFields.comment);
        jsonObject.put("user_ids", user_ids);
        jsonObject.put("room_ids", "");

        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_SHARE_PROFILE_TO_MYSELF_URL);
    }


    public void deleteProfile() {
       CommonFields.response = given().log().all()
                .queryParam("reason_id", "")
                .queryParam("comment", "")
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .delete(Endpoints.DELETE_PROFILE_URL);
    }

    public void recoverProfile() {
       CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .patch(Endpoints.PATCH_RECOVER_PROFILE_URL);
    }

}
