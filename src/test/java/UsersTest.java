import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.JVM)
public class UsersTest {

    @Test
    @DisplayName("При запросе информации о юзере приходит: " +
            "статус код 200" +
            "непустой success.users")
    @Description("/v2/users/get_user_info")
    public void getUsersInfoStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getUserInfo();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success.users"));
    }


    @Test
    @DisplayName("При запросе ссылки профиля приходит:" +
            "статус код 200" +
            "непустой success.deep_link_url")
    @Description("/v2/users/#{user_id}/get_link")
    public void getUsersLinkStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getUserLink();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success.deep_link_url"));
    }



    @Test
    @DisplayName("При запросе друзей юзера приходит:" +
            "статус код 200" +
            "непустой success.friends")
    @Description("/v2/users/friends")
    public void getUsersFriendsStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getUserFriends();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success.friends"));

    }

    @Test
    @DisplayName("При запросе количества друзей (но запрос возвращается всех друзей!!!!) юзера приходит:" +
            "статус код 200" +
            "в друзьях есть automationapi2")
    @Description("/friends/get_count_friends")
    public void getUsersCountFriendsStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getUserCountFriends();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body("success.avatar", Matchers.everyItem(Matchers.is(Matchers.notNullValue())));
       // CommonFields.response.then().body("success.approved", Matchers.everyItem(Matchers.is(Boolean.valueOf("false"))));
       // CommonFields.response.then().body("success.birthday", Matchers.everyItem(Matchers.is(936835200)));
       // CommonFields.response.then().body("success.avatar.animation", Matchers.everyItem(Matchers.containsStringIgnoringCase("assets")));
        CommonFields.response.then().body("success.uniqname", Matchers.everyItem(Matchers.containsStringIgnoringCase("automationapi2")));
    }

    @Test
    @DisplayName("При запросе моего профиля приходит:" +
            "статус код 200" +
            "uniqname automationapi1")
    @Description("/v2/users/profile")
    public void getMyProfileStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getMyProfile();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals("automationapi1", CommonFields.response.path("success.uniqname"));
    }

    @Test
    @DisplayName("При запросе моего имейла приходит" +
            "статус код 200" +
            "приходит правильный email")
    @Description("/v2/users/email")
    public void getMyEmailStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getMyEmail();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(CommonFields.email, CommonFields.response.path("success.email"));
    }

    @Test
    @DisplayName("При запросе моего номера телефона приходит 200")
    @Description("/v2/users/phone_number")
    public void getMyPhoneNumberStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getMyPhoneNumber();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNull(CommonFields.response.path("success.phone_number"));
    }

   /* @Test
    @DisplayName("При запросе списка друзей юзера приходит 200")
    @Description("/v2/users/friends")
    public void getUserFriendsListStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getUserFriendsList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }
    */


    @Test
    @DisplayName("При запросе проверки уникального имени приходит" +
            "статус код 200" +
            "success ok")
    @Description("/v2/users/check_uniqname")
    public void getCheckUniqnameStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getCheckUniqname();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals("ok", CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе генерации уникального имени приходит:" +
            "статус код 200" +
            "success соответствует введенному значению")
    @Description("/v2/users/generate_uniqname")
    public void getGenerateUniqnameStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getGenerateUniqname();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(CommonFields.source, CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе профиля юзера приходит:" +
            "статус код 200"+
            "uniqname automationapi2")
    @Description("/v2/users/:user_id/profile")
    public void getUsersProfileStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getUsersProfile();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals("automationapi2", CommonFields.response.path("success.uniqname"));
    }

    @Test
    @DisplayName("При запросе моих разрешений приходит" +
            "статус код 200")
    @Description("/v2/users/permissions")
    public void getMyPermissionStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.getMyPermissions();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("После обновления профиля приходит:" +
            "статус код 200"+
            "uniqname automationapi1")
    @Description("/v2/users/profile")
    public void postUpdateProfileReturnsStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.postUpdateProfile();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals("automationapi1", CommonFields.response.path("success.uniqname"));
    }

    @Test
    @DisplayName("После отправки профиля в чат приходит:" +
            "статус код 200" +
            "id юзера, чей профиль был отправлен")
    @Description("/v2/users/3044091/share/message")
    public void postShareProfileReturnsStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.postShareProfile();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        int actual = CommonFields.response.path("success.user_id");
        assertEquals(CommonFields.shareProfileId, actual);
    }


    @Test
    @DisplayName("После удаления профиля приходит 200")
    @Description("/v2/users/profile")
    public void deleteProfileReturnsStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.deleteProfile();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        autentication.getAuthorisation();
        users.recoverProfile();
    }

    @Test
    @DisplayName("После восстановления профиля приходит 200")
    @Description("/v2/users/profile/recover")
    public void patchRecoverProfileReturnsStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Users users = new Users();
        users.deleteProfile();
        autentication.getAuthorisation();
        users.recoverProfile();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }
}