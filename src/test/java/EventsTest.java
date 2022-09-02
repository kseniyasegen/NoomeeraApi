import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EventsTest extends Initialization {

    @Before
    public void autorise() {
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
    }

    @Test
    @DisplayName("При запросе списка уведомлений приходит:" + "статус код 200" + "в ответе success.count")
    public void getEventsUnreadedCountReturnsStatusCode200(){
        events.getEventsUnreadedCount();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success.count"));
    }

    @Test
    @DisplayName("При запросе количества новых уведомлений приходит:" + "статус код 200" + "в ответе success.count")
    public void getNewEventsCountReturnsStatusCode200(){
        events.getNewEventsCount();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        Assert.assertNotNull(CommonFields.response.path("success.count"));
    }

    @Test
    @DisplayName("При запросе списка сгруппированных уведомлений приходит:" + "статус код 200" + "в ответе success.date_group")
    public void getGroupedEventsReturnsStatusCode200() {
        events.getGroupedEvents();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body("success.date_group", Matchers.everyItem(Matchers.is(Matchers.notNullValue())));
        List<String> idList = CommonFields.response.jsonPath().getList("success.id");
        idList.stream().forEach(x-> System.out.println(x));
    }

    @Test
    @DisplayName("При запросе раскрытия группы уведомлений приходит:" + "статус код 200")
    public void getExpandedEventsReturnsStatusCode200() throws InterruptedException {
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        posts.posAddPost();
        posts.posAddPost();
        posts.posAddPost();
        Thread.sleep(180000);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        events.getGroupedEvents();
        List<String> idList = CommonFields.response.jsonPath().getList("success.id");
        idList.stream().forEach(x-> System.out.println(x));
        CommonFields.eventGroupId = idList.get(0);
        events.getExpandedEvents();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }



    @Test
    @DisplayName("При запросе удаления списка сгруппированных уведомлений приходит:" + "статус код 200" + "в ответе success == true")
    public void deleteGroupEventsReturnsStatusCode200() throws InterruptedException {
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        posts.posAddPost();
        posts.posAddPost();
        posts.posAddPost();
        Thread.sleep(180000);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        events.getGroupedEvents();
        List<String> idList = CommonFields.response.jsonPath().getList("success.id");
        idList.stream().forEach(x-> System.out.println(x));
        CommonFields.eventGroupId = idList.get(0);
        events.deleteGroupEvents();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе удаления уведомления приходит:" + "статус код 200" + "в ответе success == true")
    public void deleteEventReturnsStatusCode200() throws InterruptedException {
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(1);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        events.getGroupedEvents();
        CommonFields.response.prettyPrint();
        List<String> idList = CommonFields.response.jsonPath().getList("success.id");
        idList.stream().forEach(x-> System.out.println(x));
        CommonFields.eventId = idList.get(0);
        events.deleteEvent();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе удаления всех уведомлений приходит:" + "статус код 200" + "в ответе success == true")
    public void deleteAllEventsReturnsStatusCode200() {
        events.deleteAllEvents();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе прочитывания списка сгруппированных уведомлений приходит:" + "статус код 200" + "в ответе success.count")
    public void setAsReadGroupEventsReturnsStatusCode200() throws InterruptedException {
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        posts.posAddPost();
        posts.posAddPost();
        posts.posAddPost();
        posts.posAddPost();
        posts.posAddPost();
        posts.posAddPost();
        Thread.sleep(180000);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        events.getGroupedEvents();
        List<String> idList = CommonFields.response.jsonPath().getList("success.id");
        idList.stream().forEach(x-> System.out.println(x));
        CommonFields.eventGroupId = idList.get(0);
        events.setAsReadGroupEvents();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе прочитывания уведомления приходит:" + "статус код 200" + "в ответе success.count")
    public void setAsReadEventReturnsStatusCode200() throws InterruptedException {
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(1);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        events.getGroupedEvents();
        List<String> idList = CommonFields.response.jsonPath().getList("success.id");
        idList.stream().forEach(x-> System.out.println(x));
        CommonFields.eventId = idList.get(0);
        events.setAsReadEvent();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе прочитывания всех уведомлений приходит:" + "статус код 200" + "в ответе success.count")
    public void setAllEventsAsReadReturnsStatusCode200() throws InterruptedException {
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        posts.posAddPost();
        Thread.sleep(180000);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        events.setAllEventsAsRead();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе прочитывания списка сгруппированных уведомлений приходит:" + "статус код 200" + "в ответе success.count")
    public void setAsNotNewGroupEventsReturnsStatusCode200() throws InterruptedException {
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        posts.posAddPost();
        posts.posAddPost();
        posts.posAddPost();
        Thread.sleep(180000);
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        events.getGroupedEvents();
        List<String> idList = CommonFields.response.jsonPath().getList("success.id");
        idList.stream().forEach(x-> System.out.println(x));
        CommonFields.eventGroupId = idList.get(0);
        events.setAsNotNewGroupEvents();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
        events.getNewEventsCount();
        CommonFields.response.prettyPrint();
    }

    @Test
    @DisplayName("При запросе прочитывания уведомления приходит:" + "статус код 200" + "в ответе success.count")
    public void setEventAsNotNewReturnsStatusCode200() throws InterruptedException {
        //авторизация под юзером1 и создание сообщества
        groups.postAddGroup(1);
        CommonFields.group_id = CommonFields.response.path("success.group_id");
        CommonFields.response.prettyPrint();
        //авторизация под юзером2
        autentication.getAuthorisation(CommonFields.emailAutomationApi2);
        //подписка на сообщество
        groups.getSubscribeOnGroup();
        //авторизация под юзером1
        autentication.getAuthorisation(CommonFields.emailAutomationApi1);
        events.getGroupedEvents();
        List<String> idList = CommonFields.response.jsonPath().getList("success.id");
        idList.stream().forEach(x-> System.out.println(x));
        CommonFields.eventId = idList.get(0);
        events.setEventAsNotNew();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
        events.getNewEventsCount();
        CommonFields.response.prettyPrint();
        //удаление сообщества
        groups.getRemoveGroup();
    }

    @Test
    @DisplayName("При запросе прочитывания всех уведомлений приходит:" + "статус код 200" + "в ответе success == true")
    public void setAllEventsAsNotNewReturnsStatusCode200() {
        events.setAllEventsAsNotNew();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
    }

}
