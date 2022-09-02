import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PrivacyAndNotificationsSettingsTest extends Initialization {

    @Before
    public void autorise() {
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
    }

    //----general
    @Test
    @DisplayName("При запросе изменения настроек профиля приходит:" + "статус код 200")
    public void patchSetSettingsReturnsStatusCode200(){
        privacyAndNotificationsSettings.patchSetSettings();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("При запросе настроек профиля приходит:" + "статус код 200" + "success.settings.key непустые")
    public void getSettingsReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSettings();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body("success.settings.key", Matchers.everyItem(Matchers.is(Matchers.notNullValue())));
    }

    @Test
    @DisplayName("При запросе возврата настроек по умолчанию:" + "статус код 200")
    public void postRevertSettingsToDefaultReturnsStatusCode200(){
        privacyAndNotificationsSettings.postRevertSettingsToDefault();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }

    //----Call exclusion list
    @Test
    @DisplayName("При запросе списка исключений для звонков приходит:" + "статус код 200" + "success")
    public void getCallBlacklistReturnsStatusCode200(){
        privacyAndNotificationsSettings.getCallBlacklist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе списка разрешений для звонков приходит:" + "статус код 200" + "success")
    public void getCallWhitelistReturnsStatusCode200(){
        privacyAndNotificationsSettings.getCallWhitelist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список исключений звонков приходит:" + "статус код 200" + "success")
    public void postAddCallBlacklistReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddCallBlacklist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delCallBlacklist();
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список разрешений звонков приходит:" + "статус код 200" + "success")
    public void postAddCallWhitelistReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddCallWhitelist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delCallWhitelist();
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка исключений звонков приходит:" + "статус код 200" + "success")
    public void delCallBlacklistReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddCallBlacklist();
        privacyAndNotificationsSettings.delCallBlacklist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка разрешений звонков приходит:" +"статус код 200" + "success")
    public void delCallWhitelistReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddCallWhitelist();
        privacyAndNotificationsSettings.delCallWhitelist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров в списке исключений звонков приходит:" + "статус код 200" + "success")
    public void getSearchCallBlacklistReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchCallBlacklist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров из списке разрешений звонков приходит:" +
            "статус код 200" +
            "success")
    public void getSearchCallWhitelistReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchCallWhitelist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    //----Message exclusion list
    @Test
    @DisplayName("При запросе списка исключений для сообщений приходит:" + "статус код 200" + "success")
    public void getMessageBlacklistReturnsStatusCode200(){
        privacyAndNotificationsSettings.getMessageBlacklist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе списка разрешений для сообщений приходит:" + "статус код 200" + "success")
    public void getMessageWhitelistReturnsStatusCode200(){
        privacyAndNotificationsSettings.getMessageWhitelist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список исключений сообщений приходит:" + "статус код 200" + "success")
    public void postAddMessageBlacklistReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMessageBlacklist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delMessageBlacklist();
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список разрешений сообщений приходит:" + "статус код 200" + "success")
    public void postAddMessageWhitelistReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMessageWhitelist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delMessageWhitelist();
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка исключений сообщений приходит:" + "статус код 200" + "success")
    public void delMessageBlacklistReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMessageBlacklist();
        privacyAndNotificationsSettings.delMessageBlacklist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка разрешений сообщений приходит:" + "статус код 200" + "success")
    public void delMessageWhitelistReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMessageWhitelist();
        privacyAndNotificationsSettings.delMessageWhitelist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров в списке исключений сообщений приходит:" + "статус код 200" + "success")
    public void getSearchMessageBlacklistReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchMessageBlacklist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров из списке разрешений сообщений приходит:" + "статус код 200" + "success")
    public void getSearchMessageWhitelistReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchMessageWhitelist();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }


    //----Messages notify exclusion list
    @Test
    @DisplayName("При запросе списка исключений отображения уведомлений сообщений приходит:" + "статус код 200" + "success")
    public void getSettingsMessageNotifyExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSettingsMessageNotifyExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список исключений уведомлений сообщений приходит:" + "статус код 200" + "success")
    public void postAddSettingsMessageNotifyExclusionReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddSettingsMessageNotifyExclusion();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delSettingsMessageNotifyExclusion();
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка исключений уведомлений сообщений приходит:" + "статус код 200" + "success")
    public void delSettingsMessageNotifyExclusionReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddSettingsMessageNotifyExclusion();
        privacyAndNotificationsSettings.delSettingsMessageNotifyExclusion();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров в списке исключений уведомлений сообщений приходит:" + "статус код 200" + "success")
    public void getSearchSettingsMessageNotifyExclusionReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchSettingsMessageNotifyExclusion();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }


    //----Online exclusion lists
    @Test
    @DisplayName("При запросе списка разрешений отображения Был(а) в сети моего профиля приходит:" + "статус код 200" + "success")
    public void getOnlineShowListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getOnlineShowList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе списка исключений отображения Был(а) в сети моего профиля приходит:" + "статус код 200" + "success")
    public void getOlineHideListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getOlineHideList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список разрешений отображения Был(а) в сети моего профиля приходит:" + "статус код 200" + "success")
    public void postAddOnlineShowReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddOnlineShow();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delOnlineShow();
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список исключений отображения Был(а) в сети моего профиля приходит:" + "статус код 200" + "success")
    public void postAddOnlineHideReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddOnlineHide();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delOnlineHide();
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка разрешений отображения Был(а) в сети моего профиля приходит:" + "статус код 200" + "success")
    public void delOnlineShowReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddOnlineShow();
        privacyAndNotificationsSettings.delOnlineShow();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка исключений отображения Был(а) в сети моего профиля приходит:" + "статус код 200" + "success")
    public void delOnlineHideReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddOnlineHide();
        privacyAndNotificationsSettings.delOnlineHide();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров в списке разрешений отображения Был(а) в сети моего профиля приходит:" + "статус код 200" + "success")
    public void getSearchOnlineShowReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchOnlineShow();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров списке исключений отображения Был(а) в сети моего профиля приходит:" + "статус код 200" + "success")
    public void getSearchOnlineHideReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchOnlineHide();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }



    //----Map exclusion lists
    @Test
    @DisplayName("При запросе списка разрешений отображения на карте моего профиля приходит:" + "статус код 200" + "success")
    public void getMapShowListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getMapShowList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе списка запретов отображения на карте моего профиля приходит:" + "статус код 200" + "success")
    public void getMapHideListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getMapHideList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список разрешений отображения на карте моего профиля приходит:" + "статус код 200" + "success")
    public void postAddMapShowReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMapShow();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delMapShow();
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список исключений отображения на карте моего профиля приходит:" + "статус код 200" + "success")
    public void postAddMapHideReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMapHide();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delMapHide();
    }

    @Test
    @DisplayName("При запросе удаления юзеров из разрешений отображения на карте моего профиля приходит::" + "статус код 200" + "success")
    public void delMapShowReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMapShow();
        privacyAndNotificationsSettings.delMapShow();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе удаления юзеров из исключений отображения на карте моего профиля приходит:" + "статус код 200" + "success")
    public void delMapHideReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMapHide();
        privacyAndNotificationsSettings.delMapHide();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров в списке разрешений отображения на карте моего профиля приходит:" + "статус код 200" + "success")
    public void getSearchMapShowReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchMapShow();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров в списке исключений отображения на карте моего профиля приходит:" + "статус код 200" + "success")
    public void getSearchMapHideReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchMapHide();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }



    //----Show posts exclusion list
    @Test
    @DisplayName("При запросе списка пользователей, посты которых я скрыл, приходит:" + "статус код 200" +"success")
    public void getShowPostsExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getShowPostsExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список пользователей, посты которых я скрыл, приходит:" + "статус код 200" + "success")
    public void postAddShowPostsExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddShowPostsExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delShowPostsExclusionList();
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка пользователей, посты которых я скрыл, приходит:" + "статус код 200" + "success")
    public void delShowPostsExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddShowPostsExclusionList();
        privacyAndNotificationsSettings.delShowPostsExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров в списке пользователей, посты которых я хочу скрыть, приходит:" + "статус код 200" + "success")
    public void getSearchShowPostsExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchShowPostsExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }



    //----Blacklist exclusion
    @Test
    @DisplayName("При запросе списка заблокированных профилей приходит:" + "статус код 200" +"success")
    public void getBlacklistExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getBlacklistExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список пользователей, посты которых я скрыл, приходит:" + "статус код 200" + "success")
    public void postAddBlacklistExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddBlacklistExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delBlacklistExclusionList();
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка пользователей, посты которых я скрыл, приходит:" + "статус код 200" + "success")
    public void delBlacklistExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddBlacklistExclusionList();
        privacyAndNotificationsSettings.delBlacklistExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе поиска юзеров в списке пользователей, посты которых я хочу скрыть, приходит:" + "статус код 200" + "success")
    public void getSearchBlacklistExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getSearchBlacklistExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    //----Moments exclusion list
    @Test
    @DisplayName("При запросе списка запретов для отображения моментов приходит:" + "статус код 200" + "success")
    public void getMomentsNotShowExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getMomentsNotShowExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе списка запретов для отображения МЕСТ моментов приходит:" + "статус код 200" + "success")
    public void getMomentsHideFromExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.getMomentsHideFromExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список запретов для отображения моментов приходит:" + "статус код 200" + "success")
    public void postAddMomentsNotShowExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMomentsNotShowExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delMomentsNotShowExclusionList();
    }

    @Test
    @DisplayName("При запросе добавления юзеров в список запретов для отображения МЕСТ моментов приходит:" + "статус код 200" + "success")
    public void postAddMomentsHideFromExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMomentsHideFromExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
        privacyAndNotificationsSettings.delMomentsHideFromExclusionList();
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка запретов для отображения моментов приходит:" + "статус код 200" + "success")
    public void delMomentsNotShowExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMomentsNotShowExclusionList();
        privacyAndNotificationsSettings.delMomentsNotShowExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }

    @Test
    @DisplayName("При запросе удаления юзеров из списка запретов для отображения МЕСТ моментов приходит:" + "статус код 200" + "success")
    public void delMomentsHideFromExclusionListReturnsStatusCode200(){
        privacyAndNotificationsSettings.postAddMomentsHideFromExclusionList();
        privacyAndNotificationsSettings.delMomentsHideFromExclusionList();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body(Matchers.containsStringIgnoringCase("success"));
    }


}
