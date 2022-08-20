import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

public class CommonFields {

    public static Response response;
    public static String codeAuthentication;
    public static String accessToken;
    public static int group_id;
    public static int groupIdForLink;
    public static final String emailAutomationApi1 = "automationapi1@testmail.test";
    public static final String emailAutomationApi2 = "automationapi2@testmail.test";
    public static final String emailRandom = RandomStringUtils.randomAlphabetic(10)+"@testmail.test";
   // public static final String email = "nik1@testmail.test";
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
    //id комментария для удаления
    public static final int  commentIdForDelete = 30686;
    //id комментария для работы с ним
    public static final int  commentId = 30681;
    //id мой
    public static final int  myId = 3041994;
    //id выдуманный
    public static final int  fakeUserId = 38797384;
    //id юзера для добавления в запреты звонков
    public static final int  callBlacklistUserId = 3042157;
    //id юзера для добавления в разрешения звонков
    public static final int  callWhitelistUserId = 3042158;
    //id юзера для добавления в запреты сообщений
    public static final int  messageBlacklistUserId = 3042159;
    //id юзера для добавления в разрешения сообщений
    public static final int  messageWhitelistUserId = 3042160;
    //id юзера для добавления в список исключений уведомлений о сообщениях
    public static final int  messagesNotifyExclusionListUserId = 3042161;
    //id юзера для добавления в список исключений для отображения "Был(а) в сети"
    public static final int  onlineShowUserId = 3042162;
    //id юзера для добавления в список разрешений для отображения "Был(а) в сети"
    public static final int  onlineHideUserId = 3042163;
    //id юзера для добавления в список исключений видимости на карте
    public static final int  mapShowUserId = 3042164;
    //id юзера для добавления в список разрешений видимости на карте
    public static final int  mapHideUserId = 3042165;
    //id юзера для добавления в список юзеров, посты которых я скрыла
    public static final int  showPostsExclusionUserId = 3042166;
    //id юзера для добавления в список разрешений видимости на карте
    public static final int  blacklistExclusionUserId = 3042167;
    //id юзера для добавления в список юзеров, для которых будут скрыты моменты
    public static final int  momentsNotShowUserId = 3042168;
    //id юзера для добавления в список юзеров, для которых будут скрыты МЕСТА моментов
    public static final int  momentsHideFromUserId = 3042169;
    //id юзера для запроса списка сообществ automationapi2
    public static final int  userGroupsUserId = 3041997;
    //id юзера для добавления модератора и админа сообщества automationapi2
    public static final int  userForGroupsUserId = 3041997;
    //id юзера для шаринга сообщества в лс automationapi2
    public static final int  userShareGroup = 3041997;
    //комментарий для шаринга сообщества в лс
    public static final String  commentForShareGroup = "Шарю группу через автотест";
    //название сообщества
    public static final String  addGroupName = "Название сообщества через автотест";
    //описание сообщества
    public static final String  addGroupDescription = "Описание сообщества через автотест";
    //новое название сообщества
    public static final String  newGroupName = "Новое название сообщества через автотест";
    //новое описание сообщества
    public static final String  newGroupDescription = "Новое описание сообщества через автотест";






}
