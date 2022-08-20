import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class PrivacyAndNotificationsSettings {


    //----general
    public void patchSetSettings() {
        JSONObject keyAndValue = new JSONObject();
        keyAndValue.put("key", "isAnonymousBlocked");
        keyAndValue.put("value", 1);
        JSONArray settings = new JSONArray();
        settings.put(keyAndValue);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("settings", settings);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .patch(Endpoints.PATCH_SET_SETTINGS_URL);
    }

    public void getSettings() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_SETTINGS_URL);
    }

    public void postRevertSettingsToDefault() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_REVERT_SETTINGS_TO_DEFAULT_URL);
    }


    //----Call exclusion list
    public void getCallBlacklist() {
        CommonFields.response = given().log().all()
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
                .get(Endpoints.GET_CALL_BLACKLIST_URL);
    }

    public void getCallWhitelist() {
        CommonFields.response = given().log().all()
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
                .get(Endpoints.GET_CALL_WHITELIST_URL);
    }

    public void postAddCallBlacklist() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.callBlacklistUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_CALL_BLACKLIST_URL);
    }

    public void postAddCallWhitelist() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.callWhitelistUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_CALL_WHITELIST_URL);
    }

    public void delCallBlacklist() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.callBlacklistUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_CALL_BLACKLIST_URL);
    }

    public void delCallWhitelist() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.callWhitelistUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_CALL_WHITELIST_URL);
    }

    public void getSearchCallBlacklist() {
        CommonFields.response = given().log().all()
                .queryParam("name", "CallBlackList")
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
                .get(Endpoints.GET_SEARCH_CALL_BLACKLIST_URL);
    }

    public void getSearchCallWhitelist() {
        CommonFields.response = given().log().all()
                .queryParam("name", "CallWhiteList")
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
                .get(Endpoints.GET_SEARCH_CALL_WHITELIST_URL);
    }


    //----Message exclusion list
    public void getMessageBlacklist() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_MESSAGE_BLACKLIST_URL);
    }

    public void getMessageWhitelist() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_MESSAGE_WHITELIST_URL);
    }

    public void postAddMessageBlacklist() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.messageBlacklistUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_MESSAGE_BLACKLIST_URL);
    }

    public void postAddMessageWhitelist() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.messageWhitelistUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_MESSAGE_WHITELIST_URL);
    }

    public void delMessageBlacklist() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.messageBlacklistUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_MESSAGE_BLACKLIST_URL);
    }

    public void delMessageWhitelist() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.messageWhitelistUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_MESSAGE_WHITELIST_URL);
    }

    public void getSearchMessageBlacklist() {
        CommonFields.response = given().log().all()
                .queryParam("name", "MessageBlackList")
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
                .get(Endpoints.GET_SEARCH_MESSAGE_BLACKLIST_URL);
    }

    public void getSearchMessageWhitelist() {
        CommonFields.response = given().log().all()
                .queryParam("name", "MessageWhiteList")
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
                .get(Endpoints.GET_SEARCH_MESSAGE_WHITELIST_URL);
    }

    //----Messages notify exclusion list
    public void getSettingsMessageNotifyExclusionList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_SETTINGS_MESSAGE_NOTIFY_EXCLUSION_LIST_URL);
    }

    public void postAddSettingsMessageNotifyExclusion() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.messagesNotifyExclusionListUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_SETTINGS_MESSAGE_NOTIFY_EXCLUSION_URL);
    }

    public void delSettingsMessageNotifyExclusion() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.messagesNotifyExclusionListUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_SETTINGS_MESSAGE_EXCLUSION_URL);
    }

    public void getSearchSettingsMessageNotifyExclusion() {
        CommonFields.response = given().log().all()
                .queryParam("name", "MessagesNotifyExclusionList")
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
                .get(Endpoints.GET_SEARCH_SETTINGS_MESSAGE_EXCLUSION_URL);
    }


    //----Online exclusion lists
    public void getOnlineShowList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_ONLINE_SHOW_LIST_URL);
    }

    public void getOlineHideList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_ONLINE_HIDE_LIST_URL);
    }

    public void postAddOnlineShow() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.onlineShowUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ONLINE_SHOW_URL);
    }

    public void postAddOnlineHide() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.onlineHideUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ONLINE_HIDE_URL);
    }

    public void delOnlineShow() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.onlineShowUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_ONLINE_SHOW_URL);
    }

    public void delOnlineHide() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.onlineHideUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_ONLINE_HIDE_URL);
    }

    public void getSearchOnlineShow() {
        CommonFields.response = given().log().all()
                .queryParam("name", "OnlineShowUserId")
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
                .get(Endpoints.GET_SEARCH_ONLINE_SHOW_URL);
    }

    public void getSearchOnlineHide() {
        CommonFields.response = given().log().all()
                .queryParam("name", "OnlineHideUserId")
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
                .get(Endpoints.GET_SEARCH_ONLINE_HIDE_URL);
    }


    //----Map exclusion lists
    public void getMapShowList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_MAP_SHOW_LIST_URL);
    }

    public void getMapHideList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_MAP_HIDE_LIST_URL);
    }

    public void postAddMapShow() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.mapShowUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_MAP_SHOW_URL);
    }

    public void postAddMapHide() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.mapHideUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_MAP_HIDE_URL);
    }

    public void delMapShow() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.mapShowUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_MAP_SHOW_URL);
    }

    public void delMapHide() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.mapHideUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_MAP_HIDE_URL);
    }

    public void getSearchMapShow() {
        CommonFields.response = given().log().all()
                .queryParam("name", "MapShowUserId")
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
                .get(Endpoints.GET_SEARCH_MAP_SHOW_URL);
    }

    public void getSearchMapHide() {
        CommonFields.response = given().log().all()
                .queryParam("name", "MapHideUserId")
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
                .get(Endpoints.GET_SEARCH_MAP_HIDE_URL);
    }

    //----Show posts exclusion list
    public void getShowPostsExclusionList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_SHOW_POSTS_EXCLUSION_LIST_URL);
    }

    public void postAddShowPostsExclusionList() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.showPostsExclusionUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_SHOW_POSTS_EXCLUSION_URL);
    }

    public void delShowPostsExclusionList() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.showPostsExclusionUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_SHOW_POSTS_EXCLUSION_URL);
    }

    public void getSearchShowPostsExclusionList() {
        CommonFields.response = given().log().all()
                .queryParam("name", "ShowPostsExclusion")
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
                .get(Endpoints.GET_SEARCH_SHOW_POSTS_EXCLUSION_URL);
    }


    //----Blacklist exclusion
    public void getBlacklistExclusionList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_BLACKLIST_EXCLUSION_LIST_URL);
    }

    public void postAddBlacklistExclusionList() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.blacklistExclusionUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_BLACKLIST_EXCLUSION_URL);
    }

    public void delBlacklistExclusionList() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.blacklistExclusionUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_BLACKLIST_EXCLUSION_URL);
    }

    public void getSearchBlacklistExclusionList() {
        CommonFields.response = given().log().all()
                .queryParam("name", "BlacklistExclusionUserId")
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
                .get(Endpoints.GET_SEARCH_BLACKLIST_EXCLUSION_URL);
    }

    //----Moments exclusion list
    public void getMomentsNotShowExclusionList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_MOMENTS_NOT_SHOW_EXCLUSION_LIST_URL);
    }

    public void getMomentsHideFromExclusionList() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("limit", CommonFields.limit);
        jsonObject.put("offset", CommonFields.offset);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_MOMENTS_HIDE_FROM_EXCLUSION_LIST_URL);
    }

    public void postAddMomentsNotShowExclusionList() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.momentsNotShowUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_MOMENTS_NOT_SHOW_BLACKLIST_EXCLUSION_URL);
    }

    public void postAddMomentsHideFromExclusionList() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.momentsHideFromUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_MOMENTS_HIDE_FROM_BLACKLIST_EXCLUSION_URL);
    }

    public void delMomentsNotShowExclusionList() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.momentsNotShowUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_MOMENTS_NOT_SHOW_BLACKLIST_EXCLUSION_URL);
    }

    public void delMomentsHideFromExclusionList() {
        JSONArray ids = new JSONArray();
        ids.put(CommonFields.momentsHideFromUserId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ids", ids);
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer " + CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .delete(Endpoints.DEL_MOMENTS_HIDE_FROM_BLACKLIST_EXCLUSION_URL);
    }
}

