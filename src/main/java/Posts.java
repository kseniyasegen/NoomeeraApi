import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Posts {

    public void getPosts() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("road_type", "0");
        //jsonObject.put("start_post_id", "");
        //jsonObject.put("start_index", "");
        jsonObject.put("quantity", "20");
        //jsonObject.put("group_id", "");
        //jsonObject.put("user_id", "");
        //jsonObject.put("countries", "");
        //jsonObject.put("cities", "");
        //jsonObject.put("include_groups", "");
        //jsonObject.put("include_top_rated", "");
        //jsonObject.put("hashtag", "");
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .get(Endpoints.GET_POSTS_URL);
    }

    public void getPostById() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
               // .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_POST_BY_ID_URL);
    }

    public void postHidePost() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_HIDE_POST_URL);
    }


    public void patchSubscribeAtPost() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .patch(Endpoints.PATCH_SUBSCRIBE_AT_POST_URL);
    }

    public void patchUnsubscribeAtPost() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .patch(Endpoints.PATCH_UNSUBSCRIBE_AT_POST_URL);
    }

    public void postHidePostsUser() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_HIDE_POSTS_USER_URL);
    }

    public void postUnhidePostsUser() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_UNHIDE_POSTS_USER_URL);
    }

    public void posAddPost() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .queryParam("group_id", 0)  // 0 - roadtape
                .queryParam("file", "")
                .queryParam("upload_id", "")
                .queryParam("media", "")
                .queryParam("text", "Это пост через автотест" + RandomStringUtils.randomAlphabetic(3))
                .queryParam("privacy", 0)   // 0 - public (default), 1 - private
                .queryParam("gps_x", "")
                .queryParam("gps_y", "")
                .queryParam("comment_availability", 1)  // 0 - nobody, 1 - all, 2 - friends, 3 - community_members
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_ADD_POST_URL);
    }

    public void getPostLink() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_POST_LINK_URL);
    }

    public void postPostReaction() {
        CommonFields.response = given().log().all()
                .queryParam("reaction", "fire") //laugh_tears | facepalm | fire | in_love | crying | green_light | red_light
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_ADD_POST_REACTION_URL);
    }

    public void removePostReaction() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .delete(Endpoints.POST_REMOVE_POST_REACTION_URL);
    }

    public void postAddRepostToRoadtype() {
        CommonFields.response = given().log().all()
                .queryParam("comment", "Это репост в дорогу через автотест")
                .queryParam("comment_availability", 1)  //Integer [0 - nobody, 1 - all, 2 - friends]
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_ADD_REPOST_TO_ROADTYPE_URL);
    }

    public void postAddRepostToGroup() {
        CommonFields.response = given().log().all()
                .queryParam("comment", "Это репост в сообщество через автотест")
                .queryParam("group_id", CommonFields.groupIdForRepostPost)
                .queryParam("comment_availability", 1)  //Integer [0 - nobody, 1 - all, 2 - friends]
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_ADD_REPOST_TO_GROUP_URL);
    }

    public void postAddRepostToMessage() {
        JSONArray user_ids = new JSONArray();
        user_ids.put(CommonFields.userIdToRepostPost);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("comment", "Это репост в сообщения через автотест");
        jsonObject.put("user_ids", user_ids);
        jsonObject.put("room_ids", "");
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .body(jsonObject.toMap())
                .when().log().all()
                .post(Endpoints.POST_ADD_REPOST_TO_USER_MESSAGE_URL);
    }

    public void postAddCommentToPost() {
        CommonFields.response = given().log().all()
                .queryParam("text", "Это комментарий к посту через автотест")
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_ADD_POST_COMMENT_URL);
    }

    public void getPostComments() {
        CommonFields.response = given().log().all()
                .queryParam("post_id", CommonFields.postIdForComments)
                .queryParam("quantity", 20) //default: 20
                .queryParam("start_index", 0) //default: 0
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_COMMENT_BY_ID_URL);
    }

    public void postDeleteComment() {
        CommonFields.response = given().log().all()
                .queryParam("comment_id", CommonFields.commentIdForDelete)

                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_DELETE_POST_COMMENT_URL);
    }

    public void getComment() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_COMMENT_URL);
    }

    public void getDeletedComment() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .get(Endpoints.GET_DELETED_COMMENT_URL);
    }

    public void postAddCommentReaction() {
        CommonFields.response = given().log().all()
                .queryParam("reaction", "fire") //laugh_tears | facepalm | fire | in_love | crying | green_light | red_light
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .post(Endpoints.POST_ADD_COMMENT_REACTION_URL);
    }

    public void removeCommentReaction() {
        CommonFields.response = given().log().all()
                .baseUri(Endpoints.URL)
                .header("Content-type", "application/json")
                .header("n-build", "4.43.0")
                .header("n-device", "emulator")
                .header("n-device-id", "123")
                .header("n-os", "iOS")
                .header("Authorization", "Bearer "+ CommonFields.accessToken)
                .when().log().all()
                .delete(Endpoints.REMOVE_COMMENT_REACTION_URL);
    }



}
