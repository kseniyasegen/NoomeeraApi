public class Endpoints {

   // public static final String URL = "https://api2.stage.noomera.ru";
    public static final String URL = "https://api2.rke.dev.noomera.ru";
    public static final String AUTHENTICAUTION_SEND_CODE_URL = URL +"/v2/authentication/send_code";
    public static final String AUTHENTICAUTION_AUTHENTICATE_URL = URL +"/v2/authentication/authenticate";
    public static final String AUTHENTICAUTION_TOKEN_URL = URL +"/v2/authentication/token";
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
}
