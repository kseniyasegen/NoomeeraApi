public class Endpoints {

   // public static final String URL = "https://api2.stage.noomera.ru";
    public static final String URL = "https://api2.rke.dev.noomera.ru";
    public static final String AUTHENTICAUTION_SEND_CODE_URL = URL +"/v2/authentication/send_code";
    public static final String AUTHENTICAUTION_AUTHENTICATE_URL = URL +"/v2/authentication/authenticate";
    public static final String AUTHENTICAUTION_TOKEN_URL = URL +"/v2/authentication/token";
    public static final String GET_USER_INFO_URL = URL +"/v2/users/get_user_info";
    public static final String GET_USER_LINK_URL = URL +"/v2/users/#{user_id}/get_link";
    public static final String GET_USER_FRIENDS_URL = URL +"/v2/users/friends";
    public static final String GET_USER_COUNT_FRIENDS_URL = URL +"/friends/get_count_friends";
    public static final String GET_MY_PROFILE_URL = URL +"/v2/users/profile";
    public static final String GET_MY_EMAIL_URL = URL +"/v2/users/email";
    public static final String GET_MY_PHONE_NUMBER_URL = URL +"/v2/users/phone_number";
}
