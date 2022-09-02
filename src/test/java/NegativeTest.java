import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NegativeTest extends Initialization {

    @Test
    @DisplayName("При запросе профиля по несущесвующему id возвращаетcя статус код отличный от 200")
    public void getUsersProfileStatusCode200(){
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        users.getFakeUsersProfile();
        CommonFields.response.prettyPrint();
        assertNotEquals(200, CommonFields.response.statusCode());
        // assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("Проверка невозможности отправить профиль пользователя самому себе")
    public void postShareProfileToMyselfReturnsAnotherStatusCode(){
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        users.postShareProfileToMyself();
        CommonFields.response.prettyPrint();
        assertNotEquals(200, CommonFields.response.statusCode());
        // assertEquals(200, CommonFields.response.statusCode());
    }


    @Test
    @DisplayName("Запрос удаленного комментария возвращает статус код отличный от 200")
    public void getDeletedCommentReturnsAnotherStatusCode(){
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        posts.getDeletedComment();
        CommonFields.response.prettyPrint();
        assertNotEquals(200, CommonFields.response.statusCode());
       // assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("На один комментарий можно оставить только одну реакцию, в противном случае возвращается статус код отличный от 200")
    public void postCommentReactionReturnsAnotherStatusCode(){
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        posts.postAddCommentReaction();
        posts.postAddCommentReaction();
        CommonFields.response.prettyPrint();
        assertNotEquals(200, CommonFields.response.statusCode());
       //  assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("При запросе изменения настроек профиля приходит пустой json")
    public void patchSetSettingsReturnsStatusCode200(){
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        privacyAndNotificationsSettings.patchSetSettings();
        CommonFields.response.prettyPrint();
        Assert.assertNull(CommonFields.response.jsonPath());
    }

    @Test
    @DisplayName("При запросе возврата настроек профиля приходит пустой json")
    public void postRevertSettingsToDefaultReturnsStatusCode200(){
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        privacyAndNotificationsSettings.postRevertSettingsToDefault();
        CommonFields.response.prettyPrint();
        Assert.assertNull(CommonFields.response.jsonPath());
    }

}
