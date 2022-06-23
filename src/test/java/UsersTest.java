import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.JVM)
public class UsersTest {

    @Test
    @DisplayName("При запросе информации о юзере приходит 200")
    @Description("/v2/users/get_user_info")
    public void getUsersInfoStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserInfo();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе информации о юзере приходит непустой json")
    @Description("/v2/users/get_user_info")
    public void getUsersInfoNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserInfo();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе ссылки профиля приходит 200")
    @Description("/v2/users/#{user_id}/get_link")
    public void getUsersLinkStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserLink();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе ссылки профиля приходит непустой json")
    @Description("/v2/users/#{user_id}/get_link")
    public void getUsersLinkNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserLink();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе друзей юзера приходит 200")
    @Description("/v2/users/friends")
    public void getUsersFriendsStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserFriends();
        assertEquals(200, users.response.statusCode());
    }


    @Test
    @DisplayName("При запросе друзей юзера приходит непустой json")
    @Description("/v2/users/friends")
    public void getUsersFriendsNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserFriends();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе количества друзей юзера приходит 200")
    @Description("/friends/get_count_friends")
    public void getUsersCountFriendsStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserCountFriends();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе количества друзей юзера приходит непустой json")
    @Description("/friends/get_count_friends")
    public void getUsersCountFriendsNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserCountFriends();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе моего профиля приходит 200")
    @Description("/v2/users/profile")
    public void getMyProfileStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getMyProfile();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе моего профиля приходит непустой json")
    @Description("/v2/users/profile")
    public void getMyProfileNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getMyProfile();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе моего имейла приходит 200")
    @Description("/v2/users/email")
    public void getMyEmailStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getMyEmail();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе моего имейла приходит непустой json")
    @Description("/v2/users/email")
    public void getMyEmailNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getMyEmail();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе моего номера телефона приходит 200")
    @Description("/v2/users/phone_number")
    public void getMyPhoneNumberStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getMyPhoneNumber();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе моего номера телефона приходит непустой json")
    @Description("/v2/users/phone_number")
    public void getMyPhoneNumberNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getMyPhoneNumber();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе списка друзей юзера приходит 200")
    @Description("/v2/users/friends")
    public void getUserFriendsListStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserFriendsList();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе списка друзей юзера приходит непустой json")
    @Description("/v2/users/friends")
    public void getUserFriendsListNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUserFriendsList();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе проверки уникального имени приходит 200")
    @Description("/v2/users/check_uniqname")
    public void getCheckUniqnameStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getCheckUniqname();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе проверки уникального имени приходит непустой json")
    @Description("/v2/users/check_uniqname")
    public void getCheckUniqnameNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getCheckUniqname();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе генерации уникального имени приходит 200")
    @Description("/v2/users/generate_uniqname")
    public void getGeneratekUniqnameStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getGenerateUniqname();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе генерации уникального имени приходит непустой json")
    @Description("/v2/users/generate_uniqname")
    public void getGenerateUniqnameNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getGenerateUniqname();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе профиля юзера приходит 200")
    @Description("/v2/users/:user_id/profile")
    public void getUsersProfileStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUsersProfile();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе профиля юзера приходит непустой json")
    @Description("/v2/users/:user_id/profile")
    public void getUsersProfileNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getUsersProfile();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе моих разрешений приходит 200")
    @Description("/v2/users/permissions")
    public void getMyPermissionStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getMyPermissions();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("При запросе моих разрешений приходит непустой json")
    @Description("/v2/users/permissions")
    public void getMyPermissionsNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.getMyPermissions();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("После обновления профиля приходит 200")
    @Description("/v2/users/profile")
    public void postUpdateProfileReturnsStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.postUpdateProfile();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("После обновления профиля приходит непустой json")
    @Description("/v2/users/profile")
    public void postUpdateProfileReturnsNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.postUpdateProfile();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }

    @Test
    @DisplayName("После отправки профиля в чат приходит 200")
    @Description("/v2/users/3044091/share/message")
    public void postShareProfileReturnsStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.postShareProfile();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("После отправки профиля в чат приходит непустой json")
    @Description("/v2/users/3044091/share/message")
    public void postShareProfileReturnsNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.postShareProfile();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }



    @Test
    @DisplayName("После удаления профиля приходит 200")
    @Description("/v2/users/profile")
    public void deleteProfileReturnsStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.deleteProfile();
        assertEquals(200, users.response.statusCode());
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        users.recoverProfile();
    }

    @Test
    @DisplayName("После удаления профиля приходит непустой json")
    @Description("/v2/users/profile")
    public void deleteProfileReturnsNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.deleteProfile();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        users.recoverProfile();
    }

    @Test
    @DisplayName("После удаления профиля приходит 200")
    @Description("/v2/users/profile/recover")
    public void patchRecoverProfileReturnsStatusCode200(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.deleteProfile();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        users.recoverProfile();
        assertEquals(200, users.response.statusCode());
    }

    @Test
    @DisplayName("После удаления профиля приходит непустой json")
    @Description("/v2/users/profile/recover")
    public void patchRecoverProfileReturnsNotNullJson(){
        Autentication autentication=new Autentication();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        Users users = new Users();
        users.deleteProfile();
        autentication.getAuthenticationCode();
        autentication.getAuthentication();
        autentication.response.prettyPrint();
        autentication.codeAuthentication = autentication.response.path("code_authentication");
        autentication.getToken();
        assertNotNull(autentication.response.jsonPath());
        autentication.accessToken = autentication.response.path("access_token");
        users.recoverProfile();
        users.response.prettyPrint();
        assertNotNull(autentication.response.jsonPath());
    }
}