import static io.restassured.RestAssured.given;

public class Map {

    public void postAddEventOnMap() {
        CommonFields.response = given().log().all()
                .queryParam("gps_x", CommonFields.addGroupName)
                .queryParam("gps_y", CommonFields.addGroupDescription)
                .queryParam("royalty", 0)
                .queryParam("image", "")
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_ADD_EVENT_ON_MAP_URL);
    }

}
