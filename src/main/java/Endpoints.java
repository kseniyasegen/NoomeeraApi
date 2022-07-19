public class Endpoints {


   //--AUTHENTICATION
    public static final String URL = "https://api2.stage.noomera.ru";
    //public static final String URL = "https://api2.rke.dev.noomera.ru";
    public static final String AUTHENTICAUTION_SEND_CODE_URL = URL +"/v2/authentication/send_code";
    public static final String AUTHENTICAUTION_AUTHENTICATE_URL = URL +"/v2/authentication/authenticate";
    public static final String AUTHENTICAUTION_TOKEN_URL = URL +"/v2/authentication/token";

    //USERS
    public static final String GET_USER_INFO_URL = URL +"/v2/users/get_user_info";
    public static final String GET_USER_LINK_URL = URL +"/v2/users/"+CommonFields.userLinkId+"/get_link";
    public static final String GET_USER_FRIENDS_URL = URL +"/v2/users/friends";
    public static final String GET_USER_COUNT_FRIENDS_URL = URL +"/friends/get_count_friends";
    public static final String GET_MY_PROFILE_URL = URL +"/v2/users/profile";
    public static final String GET_MY_EMAIL_URL = URL +"/v2/users/email";
    public static final String GET_MY_PHONE_NUMBER_URL = URL +"/v2/users/phone_number";
    public static final String GET_USER_FRIENDS_LIST_URL = URL +"/v2/users/friends";
    public static final String GET_CHECK_UNIQNAME_URL = URL +"/v2/users/check_uniqname";
    public static final String GET_GENERATE_UNIQNAME_URL = URL +"/v2/users/generate_uniqname";
    public static final String GET_USERS_PROFILE_URL = URL +"/v2/users/"+CommonFields.usersProfileId +"/profile";
    public static final String GET_MY_PERMISSIONS_URL = URL +"/v2/users/permissions";
    public static final String POST_UPDATE_PROFILE_URL = URL +"/v2/users/profile";
    public static final String POST_SHARE_PROFILE_URL = URL +"/v2/users/" + CommonFields.shareProfileId +"/share/message";
    public static final String DELETE_PROFILE_URL = URL +"/v2/users/profile";
    public static final String PATCH_RECOVER_PROFILE_URL = URL +"/v2/users/profile/recover";

    //--POSTS
    //----main
    public static final String GET_POSTS_URL = URL +"/v1/posts";
    public static final String GET_POST_BY_ID_URL = URL +"/v1/posts/" + CommonFields.post_id;
    public static final String DELETE_POST_URL = URL +"/v1/posts/:id";
    public static final String POST_HIDE_POST_URL = URL + "/v1/posts/"+ CommonFields.hidePostID + "/hide";
    public static final String GET_EDIT_POST_COMMENT_URL = URL + "/posts/edit_post_comment"; //???
    public static final String POST_UPLOADS_POST_URL = URL + "/v2/uploads/images/posts";
    public static final String PATCH_SUBSCRIBE_AT_POST_URL = URL + "/v1/posts/"+ CommonFields.subscribePostID +"/subscribe";
    public static final String PATCH_UNSUBSCRIBE_AT_POST_URL = URL + "/v1/posts/"+CommonFields.unsubscribePostID+"/unsubscribe";
    public static final String POST_HIDE_POSTS_USER_URL = URL + "/v1/users/"+CommonFields.hidePostsUserID+"/hide_posts";
    public static final String POST_UNHIDE_POSTS_USER_URL = URL + "/v1/users/"+CommonFields.unhidePostsUserID+"/unhide_posts";
    public static final String POST_ADD_POST_URL = URL + "/v2/posts";
    public static final String GET_POST_LINK_URL = URL + "/v2/posts/"+CommonFields.postIdToGetLink+"/get_link";
    public static final String POST_ADD_POST_REACTION_URL = URL + "/v3/posts/"+CommonFields.postIdToPostReaction+"/add_reaction";
    public static final String POST_REMOVE_POST_REACTION_URL = URL + "/v3/posts/"+CommonFields.postIdToPostReaction+"/remove_reaction";

    //----reposts
    public static final String POST_ADD_REPOST_TO_ROADTYPE_URL = URL + "/v2/posts/"+CommonFields.postIdForRepost+"/repost/roadtape";
    public static final String POST_ADD_REPOST_TO_GROUP_URL = URL + "/v2/posts/"+CommonFields.postIdForRepost+"/repost/group";
    public static final String POST_ADD_REPOST_TO_USER_MESSAGE_URL = URL + "/v2/posts/"+CommonFields.postIdForRepost+"/repost/message";

    //----comments
//    public static final String GET_POST_COMMENTS_URL1 = URL + "/v3/posts/:post_id/comments";
    public static final String POST_ADD_POST_COMMENT_URL = URL + "/v3/posts/"+CommonFields.postIdForComments+"/add_comment";
    public static final String GET_COMMENT_BY_ID_URL = URL + "/posts/get_post_comments";
    public static final String POST_DELETE_POST_COMMENT_URL = URL + "/posts/delete_post_comment";
    public static final String POST_ADD_COMMENT_REACTION_URL = URL + "/v3/comments/:comment_id/add_reaction";
    public static final String DELETE_REMOVE_COMMENT_REACTION_URL = URL + "/v3/comments/:comment_id/remove_reaction";
    public static final String GET_COMMENT_URL = URL + "/v3/comments/"+CommonFields.commentIdForDelete;





















}
