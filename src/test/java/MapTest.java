import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapTest extends Initialization {

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

}
