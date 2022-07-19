import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PostsTest {

    @Test
    @DisplayName("При запросе списка постов приходит:" +
            "статус код 200" +
            "хотя один пост в поле privacy == public")
    @Description("/v1/posts")
    public void getPostsStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.getPosts();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body("success.posts.privacy", Matchers.everyItem(Matchers.containsStringIgnoringCase("public")));

    }


    @Test
    @DisplayName("При запросе поста по id приходит:" +
            "статус код 200" +
            "id поста в ответе")
    @Description("/v1/posts/:id")
    public void getPostByIdStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.getPostById();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        int actual = CommonFields.response.path("success.id");
        assertEquals(CommonFields.post_id, actual);
    }

    @Test
    @DisplayName("При запросе скрыть пост приходит:" +
            "статус код 200")
    @Description("/v1/posts/:id/hide")
    public void getPostHidePostStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.postHidePost();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
    }


    @Test
    @DisplayName("При запросе подписки на пост приходит" +
            "статус код 200" +
            "success == true")
    @Description("/v1/posts/:id/subscribe")
    public void getPatchSubscribeAtPostStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.patchSubscribeAtPost();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе отписки на пост приходит:" +
            "статус код 200" +
            "success == true")
    @Description("/v1/posts/:id/unsubscribe")
    public void getPatchUnsubscribeAtPostStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.patchUnsubscribeAtPost();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertEquals(true, CommonFields.response.path("success"));
    }

    @Test
    @DisplayName("При запросе скрытия постов юзера" +
            "статус код 200")
    @Description("/v1/users/:id/hide_postse")
    public void postHidePostsUserStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.postHidePostsUser();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("При запросе открытия видимости постов юзера" +
            "статус код 200")
    @Description("/v1/users/:id/hide_postse")
    public void postUnhidePostsUserStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.postUnhidePostsUser();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("При создании поста:" +
            "статус код 200" +
            "непустой success.post_id")
    @Description("/v2/posts")
    public void posAddPostStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.posAddPost();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertNotNull( CommonFields.response.path("success.post_id"));
    }

    @Test
    @DisplayName("При запросе ссылки на пост:" +
            "статус код 200" +
            "непустой success.deep_link_url")
    @Description("/v2/posts/:post_id/get_link")
    public void getPostLinkStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.getPostLink();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertNotNull( CommonFields.response.path("success.deep_link_url"));
    }

    @Test
    @DisplayName("При проставлении реакции к посту:" +
            "статус код 200" +
            "в success.post.id приходит id поста")
    @Description("/v3/posts/:post_id/add_reaction")
    public void postPostReactionStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.postPostReaction();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        int actual = CommonFields.response.path("success.post.id");
        assertEquals(CommonFields.postIdToPostReaction, actual);
        posts.removePostReaction();

    }

    @Test
    @DisplayName("При удалении реакции к посту:" +
            "статус код 200" +
            "в success.post.id приходит id поста")
    @Description("/v3/posts/:post_id/remove_reaction")
    public void removePostReactionStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.postPostReaction();
        posts.removePostReaction();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        int actual = CommonFields.response.path("success.post.id");
        assertEquals(CommonFields.postIdToPostReaction, actual);

    }

    @Test
    @DisplayName("При репосте поста в дорогу:" +
            "статус код 200" +
            "в success.post.id приходит id поста")
    @Description("/v2/posts/:post_id/repost/roadtape")
    public void getAddPostRepostToRoadtypeStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.postAddRepostToRoadtype();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        int actual = CommonFields.response.path("success.post.id");
        assertEquals(CommonFields.postIdForRepost, actual);
    }

    @Test
    @DisplayName("При репосте поста в сообщество:" +
            "статус код 200" +
            "в success.post.id приходит id поста")
    @Description("/v2/posts/:post_id/repost/group")
    public void getAddPostRepostToGroupStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.postAddRepostToGroup();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        int actual = CommonFields.response.path("success.post.id");
        assertEquals(CommonFields.postIdForRepost, actual);
    }

    @Test
    @DisplayName("При репосте поста в сообщения:" +
            "статус код 200" +
            "в success.post.id приходит id поста")
    @Description("/v2/posts/:post_id/repost/message")
    public void getPostAddRepostToMessageStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.postAddRepostToMessage();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        int actual = CommonFields.response.path("success.post.id");
        assertEquals(CommonFields.postIdForRepost, actual);
    }

    @Test
    @DisplayName("При отправке комментария к посту:" +
            "статус код 200" +
            "непустой success.comment")
    @Description("/v3/posts/:post_id/add_comment")
    public void getPostAddCommentToPostStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.postAddCommentToPost();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        assertNotNull(CommonFields.response.path("success.comment"));
    }

    @Test
    @DisplayName("При запросе комментариев к посту:" +
            "статус код 200" +
            "непустой success.comments.name")
    @Description("/posts/get_post_comments")
    public void getPostCommentsStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.getPostComments();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
        CommonFields.response.then().body("success.comments.name", Matchers.everyItem(Matchers.is(Matchers.notNullValue())));
    }

    @Test
    @DisplayName("При запросе удаления комментария к посту:" +
            "статус код 200")
    @Description("/posts/get_post_comments")
    public void getPostDeleteCommentStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.postDeleteComment();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    }

    @Test
    @DisplayName("При запросе комментария по id:" +
            "статус код 200" +
            "непустой success.comments.name")
    @Description("/v3/comments/:comment_id")
    public void getCommentStatusCode200(){
        Autentication autentication = new Autentication();
        autentication.getAuthorisation();
        Posts posts = new Posts();
        posts.getComment();
        CommonFields.response.prettyPrint();
        assertEquals(200, CommonFields.response.statusCode());
    //    CommonFields.response.then().body("success.comments.name", Matchers.everyItem(Matchers.is(Matchers.notNullValue())));
    }



}
