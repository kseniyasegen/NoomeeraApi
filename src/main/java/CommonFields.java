import io.restassured.response.Response;

public class CommonFields {

    public static Response response;

    public static String codeAuthentication;
    public static String accessToken;
    public static final String email = "automationapi1@testmail.test";
    public static final String code_verifier = "axnkpyjwpsxx";
    public static final int user_id = 3041293;
    public static final String user_type = "UserSimple";
    public static final String version = "4.44";
    public static final int limit = 20;
    public static final int offset = 0;
    public static final int state = 2;
    public static final String uniqname = "nikfirstchat32";
    public static final String source = "4535343534";
    //комментарий при шаринге профиля
    public static final String comment = "Через автотест";
    //id юзеров, которым будет шариться профиль
    public static final int user_ids = 3041066;
    //id юзера, чей профиль будет шариться
    public static final int shareProfileId = 3041293;
    //id юзера, чей профиль будет запрашиваться
    public static final int usersProfileId = 3041997;
    //id юзера, ссылка на чей профиль будет запрашиваться
    public static final int  userLinkId = 3041293;
    public static final int  post_id = 17236;
    public static final int  hidePostID = 17236;
    public static final int  subscribePostID = 17236;
    public static final int  unsubscribePostID = 17236;

    public static final int  hidePostsUserID = 3041997;
    public static final int  unhidePostsUserID = 3041997;
    //id поста для получения ссылки на пост
    public static final int  postIdToGetLink = 17462;
    //id поста для реакции на пост
    public static final int  postIdToPostReaction = 17465;
    //id поста для шаринга поста
    public static final int  postIdForRepost = 17465;
    //id сообщества для шаринга поста
    public static final int  groupIdForRepostPost = 672;
    //id юзера для шаринга поста
    public static final int userIdToRepostPost = 3041997;
    //id поста для комментариев
    public static final int  postIdForComments = 17465;
    //id комментария
    public static final int  commentIdForDelete = 30686;







}
