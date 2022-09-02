import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Events {

    public void getEventsUnreadedCount() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_EVENTS_UNREADED_COUNT_URL);
    }

    public void getNewEventsCount() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_NEW_EVENTS_COUNT_URL);
    }

    public void getGroupedEvents() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_GROUPED_EVENTS_URL);
    }

    public void getExpandedEvents() {
        CommonFields.response = given().log().all()
               // .queryParam("id", "d547af3175604884b1dff8aafbfe8f5a")
                .queryParam("id", CommonFields.eventGroupId)
                .queryParam("limit", CommonFields.limit)
                .queryParam("offset", CommonFields.offset)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_EXPANDED_EVENTS_URL);
    }

    public void deleteGroupEvents() {
        CommonFields.response = given().log().all()
                .queryParam("id", CommonFields.eventGroupId)
                .queryParam("is_group", 1)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .delete(Endpoints.DELETE_GROUP_EVENTS_URL);
    }

    public void deleteEvent() {
        CommonFields.response = given().log().all()
                .queryParam("id", CommonFields.eventId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .delete(Endpoints.DELETE_EVENT_URL);
    }

    public void deleteAllEvents() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .delete(Endpoints.DELETE_ALL_EVENTS_URL);
    }

    public void setAsReadGroupEvents() {
        CommonFields.response = given().log().all()
                .queryParam("id", CommonFields.eventGroupId)
                .queryParam("is_group", 1)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .patch(Endpoints.PATCH_SET_AS_READ_GROUP_EVENTS_URL);
    }

    public void setAsReadEvent() {
        CommonFields.response = given().log().all()
                .queryParam("id", CommonFields.eventId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .patch(Endpoints.PATCH_SET_AS_READ_EVENT_URL);
    }

    public void setAllEventsAsRead() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .patch(Endpoints.PATCH_SET_ALL_EVENTS_AS_READ_URL);
    }

    public void setAsNotNewGroupEvents() {
        CommonFields.response = given().log().all()
                .queryParam("id", CommonFields.eventGroupId)
                .queryParam("is_group", 1)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .patch(Endpoints.PATCH_SET_AS_NOT_NEW_GROUP_EVENTS_URL);
    }

    public void setArrayOfEventsAsNotNew() {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id", CommonFields.eventId);
        jsonObject1.put("is_group", CommonFields.eventIsGroup);
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject1);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("ids", jsonArray);
        CommonFields.response = given().log().all()
                .queryParam("id", CommonFields.eventId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .body(jsonObject2.toMap())
                .when().log().all()
                .patch(Endpoints.PATCH_SET_ARRAY_OF_EVENTS_AS_NOT_NEW_URL);
    }

    public void setEventAsNotNew() {
        CommonFields.response = given().log().all()
                .queryParam("id", CommonFields.eventId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .patch(Endpoints.PATCH_SET_EVENT_AS_NOT_NEW_URL);
    }

    public void setAllEventsAsNotNew() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .patch(Endpoints.PATCH_SET_ALL_EVENTS_AS_NOT_NEW_URL);
    }


}
