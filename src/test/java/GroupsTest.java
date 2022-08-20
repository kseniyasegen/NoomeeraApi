import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GroupsTest {

    Autentication autentication = new Autentication();
    Groups groups = new Groups();

    @Before
    public void autorise() {
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
    }

    @Test
    @DisplayName("При запросе создания сообщества приходит:" + "статус код 200" + "в ответе success.group_id")
    public void postAddGroupReturnsStatusCode200(){
        groups.postAddGroup(0);
        CommonFields.response.prettyPrint();
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success.group_id"));
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе удаления сообщества приходит:" + "статус код 200" + "в ответе success")
    public void getRemoveGroupReturnsStatusCode200(){
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        groups.getRemoveGroup();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе списка участников сообщества приходит:" + "статус код 200" + "в ответе more_items и total_count")
    public void getUsersInGroupReturnsStatusCode200(){
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        groups.getUsersInGroup();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertNotNull(CommonFields.response.path("success.more_items"));
        assertNotNull(CommonFields.response.path("success.total_count"));
        groups.getRemoveGroup();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("При запросе списка сообществ юзера приходит:" + "статус код 200" + "в ответе success.groups")
    public void getUserGroupsReturnsStatusCode200(){
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        groups.getUserGroups();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body("success.groups", Matchers.everyItem(Matchers.is(Matchers.notNullValue())));
        groups.getRemoveGroup();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("При запросе поиска сообщества приходит:" + "статус код 200" + "в ответе success.groups.name")
    public void getSearchGroupsReturnsStatusCode200(){
        groups.getSearchGroups();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body("success.groups.name", Matchers.everyItem(Matchers.is(Matchers.notNullValue())));
    }

    @Test
    @DisplayName("При запросе списка топ сообществ приходит:" + "статус код 200" + "в ответе success.groups.name")
    public void getTopsGroupsReturnsStatusCode200(){
        groups.getTopsGroups();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body("success.groups.name", Matchers.everyItem(Matchers.is(Matchers.notNullValue())));
    }

    @Test
    @DisplayName("При запросе списка моих сообществ приходит:" + "статус код 200" + "в ответе success.groups.name")
    public void getGroupsReturnsStatusCode200(){
        groups.getGroups();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body("success.groups.name", Matchers.everyItem(Matchers.is(Matchers.notNullValue())));
    }

    @Test
    @DisplayName("При запросе шаринга сообщества сообществ приходит:" + "статус код 200" + "в ответе success.name")
    public void postShareGroupsReturnsStatusCode200(){
        groups.postAddGroup(0);
        CommonFields.response.prettyPrint();
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        System.out.println("---------------------"+CommonFields.group_id);
        System.out.println(Endpoints.POST_SHARE_GROUPS_URL);
        groups.postShareGroups();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertNotNull(CommonFields.response.path("success.name"));
        groups.getRemoveGroup();
    }



    @Test
    @DisplayName("При запросе списка моих сообществ приходит:" + "статус код 200" + "в ответе success.deep_link_url")
    public void getGroupLinkReturnsStatusCode200(){
        groups.postAddGroup(0);
        CommonFields.groupIdForLink = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        groups.getGroupLink();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertNotNull(CommonFields.response.path("success.deep_link_url"));
        groups.getRemoveGroupLink();
    }

    @Test
    @DisplayName("При запросе списка сообществ, в которые можно пошарить что-либо приходит:" + "статус код 200" + "в ответе success.groups.name")
    public void getGroupsAllowedForRepostReturnsStatusCode200(){
        groups.getGroupsAllowedForRepost();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body("success.groups.name", Matchers.everyItem(Matchers.is(Matchers.notNullValue())));
    }

    @Test
    @DisplayName("При запросе информации о сообществе приходит:" + "статус код 200" + "в ответе success.group.name")
    public void getGroupsInfoReturnsStatusCode200(){
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertNotNull(CommonFields.response.path("success.group.name"));
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе обновления информации о сообществе приходит:" + "статус код 200" + "правильные success.group.name и success.group.description")
    public void postSetGroupInfoReturnsStatusCode200(){
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        groups.postSetGroupInfo();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        String actualName = CommonFields.response.path("success.group.name");
        assertEquals(CommonFields.newGroupName, actualName);
        String actualDescription = CommonFields.response.path("success.group.description");
        assertEquals(CommonFields.newGroupDescription, actualDescription);
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе подписки на сообщество приходит:" + "статус код 200" + "в success.group.is_subscribed приходит 1")
    public void getSubscribeOnGroupReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        //проверка, что подписка прошла
        groups.getGroupsInfo();
        int actualSubscribe = CommonFields.response.path("success.group.is_subscribed");
        assertEquals(1, actualSubscribe);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе отмены подписки на сообщество приходит:" + "статус код 200" + "в success.group.is_subscribed приходит 0")
    public void getUnsubscribeOnGroupReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //отмена подписки на сообщество
        groups.getUnsubscribeOnGroup();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        //проверка, что подписка прошла
        groups.getGroupsInfo();
        int actualSubscribe = CommonFields.response.path("success.group.is_subscribed");
        assertEquals(0, actualSubscribe);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе вкл оповещений сообщества приходит:" + "статус код 200" + "в success.group.subscribed_notifications приходит 1")
    public void getSubscribeNotificationsReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        CommonFields.response.prettyPrint();
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //вкл оповещения сообщества
        groups.getSubscribeNotifications();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        //проверка, что вкл оповещения сообщества
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        int actualSubscribe = CommonFields.response.path("success.group.subscribed_notifications");
        assertEquals(1, actualSubscribe);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе выкл оповещений сообщества приходит:" + "статус код 200" + "в success.group.subscribed_notifications приходит 0")
    public void getUnsubscribeNotificationsReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        CommonFields.response.prettyPrint();
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //вкл оповещения сообщества
        groups.getSubscribeNotifications();
        //выкл оповещения сообщества
        groups.getUnsubscribeNotifications();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        //проверка, что выкл оповещения сообщества
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        int actualSubscribe = CommonFields.response.path("success.group.subscribed_notifications");
        assertEquals(0, actualSubscribe);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе назначения модератором сообщества приходит:" + "статус код 200" + "в success.group.is_moderator приходит 0")
    public void getAddModeratorInGroupReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //назначение юзера2 модератором
        groups.getAddModeratorInGroup();
        assertEquals(200, CommonFields.response.statusCode());
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //проверка, что юзер2 модератор сообщества
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        int actualModerator = CommonFields.response.path("success.group.is_moderator");
        assertEquals(1, actualModerator);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе назначения админом сообщества приходит:" + "статус код 200" + "в success.group.is_admin приходит 1")
    public void getAddAdminInGroupReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //назначение юзера2 админом
        groups.getAddAdminInGroup();
        assertEquals(200, CommonFields.response.statusCode());
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //проверка, что юзер2 модератор сообщества
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        int actualAdmin = CommonFields.response.path("success.group.is_admin");
        assertEquals(1, actualAdmin);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе назначения удаления из админов сообщества приходит:" + "статус код 200" + "в success.group.is_admin приходит 0")
    public void getRemoveAdminInGroupReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //назначение юзера2 админом
        groups.getAddAdminInGroup();
        //удаления юзера2 из админов
        groups.getRemoveAdminInGroup();
        assertEquals(200, CommonFields.response.statusCode());
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //проверка, что юзер2 модератор сообщества
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        int actualAdmin = CommonFields.response.path("success.group.is_admin");
        assertEquals(0, actualAdmin);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе блокировки юзера в сообществе приходит:" + "статус код 200" + "в success.group.user_status приходит 5")
    public void getBlockUserInGroupReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //блокировка юзера2
        groups.getBlockUserInGroup();
        assertEquals(200, CommonFields.response.statusCode());
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //проверка, что юзер2 модератор сообщества
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        int actualUserStatus = CommonFields.response.path("success.group.user_status");
        assertEquals(5, actualUserStatus);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе разблокировки юзера в сообществе приходит:" + "статус код 200" + "в success.group.user_status приходит 1")
    public void getUnblockUserInGroupReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //блокировка юзера2
        groups.getBlockUserInGroup();
        //разблокировка юзера2
        groups.getUnblockUserInGroup();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //проверка, что юзер2 модератор сообщества
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        int actualUserStatus = CommonFields.response.path("success.group.user_status");
        assertEquals(1, actualUserStatus);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе разблокировки всех юзеров в сообществе приходит:" + "статус код 200" + "в success.group.user_status приходит 1")
    public void getUnblockAllUsersInGroupReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(0);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //блокировка юзера2
        groups.getBlockUserInGroup();
        //разблокировка всех юзеров
        groups.getUnblockAllUsersInGroup();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //проверка, что юзер2 модератор сообщества
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        int actualUserStatus = CommonFields.response.path("success.group.user_status");
        assertEquals(1, actualUserStatus);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе принятия заявки юзера в сообщество приходит:" + "статус код 200" + "в success.group.user_status приходит 4")
    public void getApproveUserReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(1);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //принятие заявки юзера2 на добавление в сообщесттво
        groups.getApproveUser();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //проверка, что юзер2 модератор сообщества
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        int actualUserStatus = CommonFields.response.path("success.group.user_status");
        assertEquals(4, actualUserStatus);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе отклонения заявки юзера в сообщество приходит:" + "статус код 200" + "в success.group.user_status приходит 3")
    public void getDeclineUserReturnsStatusCode200(){
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(1);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //отклонение заявки юзера2 на добавление в сообщесттво
        groups.getDeclineUser();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //проверка, что юзер2 модератор сообщества
        groups.getGroupsInfo();
        CommonFields.response.prettyPrint();
        int actualUserStatus = CommonFields.response.path("success.group.user_status");
        assertEquals(3, actualUserStatus);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        //удаление сообщества
        groups.getRemoveGroup();
    }

}
