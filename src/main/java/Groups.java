import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Groups {

    public void postAddGroup(int privateGroup) {
        CommonFields.response = given().log().all()
                .queryParam("name", CommonFields.addGroupName)
                .queryParam("description", CommonFields.addGroupDescription)
                .queryParam("private", privateGroup)
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
                .post(Endpoints.POST_ADD_GROUP_URL);
    }

    public void getRemoveGroup() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_REMOVE_GROUP_URL);
    }

    public void getRemoveGroupLink() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.groupIdForLink)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_REMOVE_GROUP_URL);
    }

    public void getUsersInGroup() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .queryParam("query", "")
                .queryParam("quantity", 20) //default: 20
                .queryParam("start_index", 0) //default: 0
                .queryParam("user_state", 0)  //Enum(0: all | 1: blocked | 2: not_approved | 3: approved)
                .queryParam("user_type", "UserSimple") //Enum(UserSimple, UserSimpleWithGroup)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USERS_IN_GROUP_URL);
    }

    public void getUserGroups() {
        CommonFields.response = given().log().all()
                .queryParam("user_id", CommonFields.userGroupsUserId)
                .queryParam("start_index", 0)//default: 0
                .queryParam("quantity", 20) //default: 20
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_USER_GROUPS_URL);
    }

    public void getSearchGroups() {
        CommonFields.response = given().log().all()
                .queryParam("search", "Сообщество для автотестов")
                .queryParam("quantity", 20)//default: 20
                .queryParam("start_index", 0) //default: 0
                .queryParam("group_type", 0) //default: 0 - all, 1 - author, 2 - member
                .queryParam("repost_allowed_only", false)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_SEARCH_GROUPS_URL);
    }

    public void getTopsGroups() {
        CommonFields.response = given().log().all()
                .queryParam("quantity", 20)//default: 20
                .queryParam("start_index", 0) //default: 0
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_TOPS_GROUPS_URL);
    }

    public void getGroups() {
        CommonFields.response = given().log().all()
                .queryParam("quantity", 20)//default: 20
                .queryParam("start_index", 0) //default: 0
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_GROUPS_URL);
    }

    public void postShareGroups() {
        JSONArray user_ids = new JSONArray();
        user_ids.put(CommonFields.userShareGroup);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("comment", CommonFields.commentForShareGroup);
        jsonObject.put("user_ids", user_ids);
        jsonObject.put("room_ids", "");
        CommonFields.response = given().log().all()
                .pathParams("group_id", CommonFields.group_id)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_SHARE_GROUPS_URL);
    }

    public void getGroupLink() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_GROUP_LINK_URL);
    }

    public void getGroupsAllowedForRepost() {
        CommonFields.response = given().log().all()
                .queryParam("limit", 20) //default: 20
                .queryParam("offset", 0) //default: 0
                .queryParam("exclude_group_ids", "") //array
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_GROUPS_ALLOWED_FOR_REPOST_URL);
    }

    public void getGroupsInfo() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_GROUPS_INFO_URL);
    }

    public void postSetGroupInfo() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .queryParam("name", CommonFields.newGroupName)
                .queryParam("description", CommonFields.newGroupDescription)
                .queryParam("private", 0)
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
                .post(Endpoints.POST_SET_GROUP_INFO_URL);
    }

    public void getSubscribeOnGroup() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_SUBSCRIBE_ON_GROUP_URL);
    }

    public void getUnsubscribeOnGroup() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_UNSUBSCRIBE_ON_GROUP_URL);
    }

    public void getSubscribeNotifications() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_SUBSCRIBE_NOTIFICATIONS_URL);
    }

    public void getUnsubscribeNotifications() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_UNSUBSCRIBE_NOTIFICATIONS_URL);
    }

    public void getAddModeratorInGroup() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .queryParam("user_id", CommonFields.userForGroupsUserId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_ADD_MODERATOR_IN_GROUP_URL);
    }

    public void getAddAdminInGroup() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .queryParam("user_id", CommonFields.userForGroupsUserId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_ADD_ADMIN_IN_GROUP_URL);
    }

    public void getRemoveAdminInGroup() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .queryParam("user_id", CommonFields.userForGroupsUserId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_REMOVE_ADMIN_IN_GROUP_URL);
    }

    public void getBlockUserInGroup() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .queryParam("user_id", CommonFields.userForGroupsUserId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_BLOCK_USER_IN_GROUP_URL);
    }

    public void getUnblockUserInGroup() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .queryParam("user_id", CommonFields.userForGroupsUserId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_UNBLOCK_USER_IN_GROUP_URL);
    }

    public void getUnblockAllUsersInGroup() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_UNBLOCK_ALL_USERS_IN_GROUP_URL);
    }

    public void getApproveUser() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .queryParam("user_id", CommonFields.userForGroupsUserId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_APPROVE_USER_URL);
    }

    public void getDeclineUser() {
        CommonFields.response = given().log().all()
                .queryParam("group_id", CommonFields.group_id)
                .queryParam("user_id", CommonFields.userForGroupsUserId)
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_DECLINE_USER_URL);
    }


}
