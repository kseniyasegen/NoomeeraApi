public class Endpoints {

    //--
    public static final String URL = "https://api2.stage.noomera.ru";
    //public static final String URL = "https://api2.rke.dev.noomera.ru";

    //--AUTHENTICATION
    public static final String AUTHENTICAUTION_SEND_CODE_URL = URL +"/v2/authentication/send_code";
    public static final String AUTHENTICAUTION_AUTHENTICATE_URL = URL +"/v2/authentication/authenticate";
    public static final String AUTHENTICAUTION_TOKEN_URL = URL +"/v2/authentication/token";

    //--REGISTRATION
    public static final String REGISTRATION_URL = URL +"/v3/users/signup";

    //--USERS
    public static final String GET_USER_INFO_URL = URL +"/v2/users/get_user_info";
    public static final String GET_USER_LINK_URL = URL +"/v2/users/"+CommonFields.userLinkId+"/get_link";
    public static final String GET_USER_FRIENDS_URL = URL +"/v2/users/friends";
    public static final String GET_USER_COUNT_FRIENDS_URL = URL +"/friends/get_count_friends";
    public static final String GET_MY_PROFILE_URL = URL +"/v2/users/profile";
    public static final String GET_MY_EMAIL_URL = URL +"/v2/users/email";
    public static final String GET_MY_PHONE_NUMBER_URL = URL +"/v2/users/phone_number";
    public static final String GET_USER_FRIENDS_LIST_URL = URL +"/v2/users/friends";
    public static final String GET_CHECK_UNIQNAME_URL = URL +"/v2/users/check_uniqname";
    public static final String GET_GENERATE_UNIQNAME_URL = URL +"/v2/users/generate_uniqname";
    public static final String GET_USERS_PROFILE_URL = URL +"/v2/users/"+CommonFields.usersProfileId +"/profile";
    public static final String GET_FAKE_USERS_PROFILE_URL = URL +"/v2/users/"+CommonFields.fakeUserId +"/profile";
    public static final String GET_MY_PERMISSIONS_URL = URL +"/v2/users/permissions";
    public static final String POST_UPDATE_PROFILE_URL = URL +"/v2/users/profile";
    public static final String POST_SHARE_PROFILE_URL = URL +"/v2/users/" + CommonFields.shareProfileId +"/share/message";
    public static final String POST_SHARE_PROFILE_TO_MYSELF_URL = URL +"/v2/users/" + CommonFields.myId +"/share/message";
    public static final String DELETE_PROFILE_URL = URL +"/v2/users/profile";
    public static final String PATCH_RECOVER_PROFILE_URL = URL +"/v2/users/profile/recover";

    //--POSTS
    //----main
    public static final String GET_POSTS_URL = URL +"/v1/posts";
    public static final String GET_POST_BY_ID_URL = URL +"/v1/posts/" + CommonFields.post_id;
    public static final String DELETE_POST_URL = URL +"/v1/posts/:id";
    public static final String POST_HIDE_POST_URL = URL + "/v1/posts/"+ CommonFields.hidePostID + "/hide";
    public static final String GET_EDIT_POST_COMMENT_URL = URL + "/posts/edit_post_comment"; //???
    public static final String POST_UPLOADS_POST_URL = URL + "/v2/uploads/images/posts";
    public static final String PATCH_SUBSCRIBE_AT_POST_URL = URL + "/v1/posts/"+ CommonFields.subscribePostID +"/subscribe";
    public static final String PATCH_UNSUBSCRIBE_AT_POST_URL = URL + "/v1/posts/"+CommonFields.unsubscribePostID+"/unsubscribe";
    public static final String POST_HIDE_POSTS_USER_URL = URL + "/v1/users/"+CommonFields.hidePostsUserID+"/hide_posts";
    public static final String POST_UNHIDE_POSTS_USER_URL = URL + "/v1/users/"+CommonFields.unhidePostsUserID+"/unhide_posts";
    public static final String POST_ADD_POST_URL = URL + "/v2/posts";
    public static final String GET_POST_LINK_URL = URL + "/v2/posts/"+CommonFields.postIdToGetLink+"/get_link";
    public static final String POST_ADD_POST_REACTION_URL = URL + "/v3/posts/"+CommonFields.postIdToPostReaction+"/add_reaction";
    public static final String POST_REMOVE_POST_REACTION_URL = URL + "/v3/posts/"+CommonFields.postIdToPostReaction+"/remove_reaction";

    //----reposts
    public static final String POST_ADD_REPOST_TO_ROADTYPE_URL = URL + "/v2/posts/"+CommonFields.postIdForRepost+"/repost/roadtape";
    public static final String POST_ADD_REPOST_TO_GROUP_URL = URL + "/v2/posts/"+CommonFields.postIdForRepost+"/repost/group";
    public static final String POST_ADD_REPOST_TO_USER_MESSAGE_URL = URL + "/v2/posts/"+CommonFields.postIdForRepost+"/repost/message";

    //----comments
    public static final String POST_ADD_POST_COMMENT_URL = URL + "/v3/posts/"+CommonFields.postIdForComments+"/add_comment";
    public static final String GET_COMMENT_BY_ID_URL = URL + "/posts/get_post_comments";
    public static final String POST_DELETE_POST_COMMENT_URL = URL + "/posts/delete_post_comment";
    public static final String POST_ADD_COMMENT_REACTION_URL = URL + "/v3/comments/"+CommonFields.commentId+"/add_reaction";
    public static final String REMOVE_COMMENT_REACTION_URL = URL + "/v3/comments/"+CommonFields.commentId+"/remove_reaction";
    public static final String GET_COMMENT_URL = URL + "/v3/comments/"+CommonFields.commentId;
    public static final String GET_DELETED_COMMENT_URL = URL + "/v3/comments/"+CommonFields.commentIdForDelete;

    //--SETTINGS
    //----general
    public static final String PATCH_SET_SETTINGS_URL = URL + "/v2/users/settings";
    public static final String GET_SETTINGS_URL = URL + "/v2/users/settings";
    public static final String POST_REVERT_SETTINGS_TO_DEFAULT_URL = URL + "/v2/users/settings/revert_to_default";

    //----Call exclusion list
    public static final String GET_CALL_BLACKLIST_URL = URL + "/v2/users/call/blacklist";
    public static final String GET_CALL_WHITELIST_URL = URL + "/v2/users/call/whitelist";
    public static final String POST_ADD_CALL_BLACKLIST_URL = URL + "/v2/users/call/blacklist";
    public static final String POST_ADD_CALL_WHITELIST_URL = URL + "/v2/users/call/whitelist";
    public static final String DEL_CALL_BLACKLIST_URL = URL + "/v2/users/call/blacklist";
    public static final String DEL_CALL_WHITELIST_URL = URL + "/v2/users/call/whitelist";
    public static final String GET_SEARCH_CALL_BLACKLIST_URL = URL + "/v2/users/call/blacklist/search";
    public static final String GET_SEARCH_CALL_WHITELIST_URL = URL + "/v2/users/call/whitelist/search";

    //----Message exclusion list
    public static final String GET_MESSAGE_BLACKLIST_URL = URL + "/v2/users/message/blacklist";
    public static final String GET_MESSAGE_WHITELIST_URL = URL + "/v2/users/message/whitelist";
    public static final String POST_ADD_MESSAGE_BLACKLIST_URL = URL + "/v2/users/message/blacklist";
    public static final String POST_ADD_MESSAGE_WHITELIST_URL = URL + "/v2/users/message/whitelist";
    public static final String DEL_MESSAGE_BLACKLIST_URL = URL + "/v2/users/message/blacklist";
    public static final String DEL_MESSAGE_WHITELIST_URL = URL + "/v2/users/message/whitelist";
    public static final String GET_SEARCH_MESSAGE_BLACKLIST_URL = URL + "/v2/users/message/blacklist/search";
    public static final String GET_SEARCH_MESSAGE_WHITELIST_URL = URL + "/v2/users/message/whitelist/search";

    //----Messages notify exclusion list
    public static final String GET_SETTINGS_MESSAGE_NOTIFY_EXCLUSION_LIST_URL = URL + "/v2/users/settings/messages/exclusion";
    public static final String POST_ADD_SETTINGS_MESSAGE_NOTIFY_EXCLUSION_URL = URL + "/v2/users/settings/messages/exclusion";
    public static final String DEL_SETTINGS_MESSAGE_EXCLUSION_URL = URL + "/v2/users/settings/messages/exclusion";
    public static final String GET_SEARCH_SETTINGS_MESSAGE_EXCLUSION_URL = URL + "/v2/users/settings/messages/exclusion/search";

    //----Online exclusion lists
    public static final String GET_ONLINE_SHOW_LIST_URL = URL + "/v2/users/privacy/online/exclusion/show";
    public static final String POST_ONLINE_SHOW_URL = URL + "/v2/users/privacy/online/exclusion/show";
    public static final String DEL_ONLINE_SHOW_URL = URL + "/v2/users/privacy/online/exclusion/show";
    public static final String GET_SEARCH_ONLINE_SHOW_URL = URL + "/v2/users/privacy/online/exclusion/show/search";
    public static final String GET_ONLINE_HIDE_LIST_URL = URL + "/v2/users/privacy/online/exclusion/hide";
    public static final String POST_ONLINE_HIDE_URL = URL + "/v2/users/privacy/online/exclusion/hide";
    public static final String DEL_ONLINE_HIDE_URL = URL + "/v2/users/privacy/online/exclusion/hide";
    public static final String GET_SEARCH_ONLINE_HIDE_URL = URL + "/v2/users/privacy/online/exclusion/hide/search";

    //----Map exclusion lists
    public static final String GET_MAP_SHOW_LIST_URL = URL + "/v2/users/privacy/map/exclusion/show";
    public static final String POST_MAP_SHOW_URL = URL + "/v2/users/privacy/map/exclusion/show";
    public static final String DEL_MAP_SHOW_URL = URL + "/v2/users/privacy/map/exclusion/show";
    public static final String GET_SEARCH_MAP_SHOW_URL = URL + "/v2/users/privacy/map/exclusion/show/search";
    public static final String GET_MAP_HIDE_LIST_URL = URL + "/v2/users/privacy/map/exclusion/hide";
    public static final String POST_ADD_MAP_HIDE_URL = URL + "/v2/users/privacy/map/exclusion/hide";
    public static final String DEL_MAP_HIDE_URL = URL + "/v2/users/privacy/map/exclusion/hide";
    public static final String GET_SEARCH_MAP_HIDE_URL = URL + "/v2/users/privacy/map/exclusion/hide/search";

    //----Show posts exclusion list
    public static final String GET_SHOW_POSTS_EXCLUSION_LIST_URL = URL + "/v2/users/privacy/show-posts/exclusion";
    public static final String POST_ADD_SHOW_POSTS_EXCLUSION_URL = URL + "/v2/users/privacy/show-posts/exclusion";
    public static final String DEL_SHOW_POSTS_EXCLUSION_URL = URL + "/v2/users/privacy/show-posts/exclusion";
    public static final String GET_SEARCH_SHOW_POSTS_EXCLUSION_URL = URL + "/v2/users/privacy/show-posts/exclusion/search";

    //----Blacklist exclusion
    public static final String GET_BLACKLIST_EXCLUSION_LIST_URL = URL + "/v2/users/privacy/blacklist/exclusion";
    public static final String POST_ADD_BLACKLIST_EXCLUSION_URL = URL + "/v2/users/privacy/blacklist/exclusion";
    public static final String DEL_BLACKLIST_EXCLUSION_URL = URL + "/v2/users/privacy/blacklist/exclusion";
    public static final String GET_SEARCH_BLACKLIST_EXCLUSION_URL = URL + "/v2/users/privacy/blacklist/exclusion/search";

    //----Moments exclusion list
    public static final String GET_MOMENTS_NOT_SHOW_EXCLUSION_LIST_URL = URL + "/v2/users/privacy/moment/exclusion/not_show";
    public static final String GET_MOMENTS_HIDE_FROM_EXCLUSION_LIST_URL = URL + "/v2/users/privacy/moment/exclusion/hide_from";
    public static final String POST_ADD_MOMENTS_NOT_SHOW_BLACKLIST_EXCLUSION_URL = URL + "/v2/users/privacy/moment/exclusion/not_show";
    public static final String POST_ADD_MOMENTS_HIDE_FROM_BLACKLIST_EXCLUSION_URL = URL + "/v2/users/privacy/moment/exclusion/hide_from";
    public static final String DEL_MOMENTS_NOT_SHOW_BLACKLIST_EXCLUSION_URL = URL + "/v2/users/privacy/moment/exclusion/not_show";
    public static final String DEL_MOMENTS_HIDE_FROM_BLACKLIST_EXCLUSION_URL = URL + "/v2/users/privacy/moment/exclusion/hide_from";


    //--GROUPS
    public static final String POST_ADD_GROUP_URL = URL + "/groups/add_group";
    public static final String GET_USERS_IN_GROUP_URL = URL + "/groups/get_group_users";
    public static final String GET_USER_GROUPS_URL = URL + "/groups/get_user_groups";
    public static final String GET_SEARCH_GROUPS_URL = URL + "/groups/search_groups";
    public static final String GET_TOPS_GROUPS_URL = URL + "/groups/get_groups_top";
    public static final String GET_GROUPS_URL = URL + "/groups/get_groups";
    public static  String POST_SHARE_GROUPS_URL = URL + "/v2/groups/{group_id}/share/message";
    public static final String GET_GROUP_LINK_URL = URL + "/v2/groups/"+CommonFields.groupIdForLink+"/get_link";
    public static final String GET_GROUPS_ALLOWED_FOR_REPOST_URL = URL + "/v3/groups/repost_allowed_list";
    public static final String GET_GROUPS_INFO_URL = URL + "/groups/get_group_info";
    public static final String POST_SET_GROUP_INFO_URL = URL + "/groups/set_group_info";
   // public static final String GET_MODERATORS_IN_GROUP_URL = URL + "/groups/get_group_moderators";
    public static final String GET_SUBSCRIBE_ON_GROUP_URL = URL + "/groups/subscribe_group";
    public static final String GET_UNSUBSCRIBE_ON_GROUP_URL = URL + "/groups/unsubscribe_group";
    public static final String GET_SUBSCRIBE_NOTIFICATIONS_URL = URL + "/groups/subscribe_notifications";
    public static final String GET_UNSUBSCRIBE_NOTIFICATIONS_URL = URL + "/groups/unsubscribe_notifications";
    public static final String GET_ADD_MODERATOR_IN_GROUP_URL = URL + "/groups/add_group_moderator";
    public static final String GET_ADD_ADMIN_IN_GROUP_URL = URL + "/groups/add_group_admin";
    public static final String GET_REMOVE_ADMIN_IN_GROUP_URL = URL + "/groups/remove_group_admin";
    public static final String GET_REMOVE_GROUP_MEMBER_URL = URL + "/groups/remove_group_member";
    public static final String GET_BLOCK_USER_IN_GROUP_URL = URL + "/groups/block_user";
    public static final String GET_UNBLOCK_USER_IN_GROUP_URL = URL + "/groups/unblock_user";
    public static final String GET_UNBLOCK_ALL_USERS_IN_GROUP_URL = URL + "/groups/unblock_all_users";
  //  public static final String GET_BLOCKED_USERS_URL = URL + "/groups/get_blocked_users";
  //  public static final String GET_SEARCH_FRIEND_IN_GROUP_URL = URL + "/groups/search_friends";
    public static final String GET_APPROVE_USER_URL = URL + "/groups/approve_user";
   // public static final String GET_APPROVE_GROUP_USERS_URL = URL + "/groups/approve_group_users";
    public static final String GET_DECLINE_USER_URL = URL + "/groups/decline_user";
    public static final String GET_REMOVE_GROUP_URL = URL + "/groups/remove_group";


    //--EVENTS
    public static final String GET_EVENTS_UNREADED_COUNT_URL = URL + "/v3/users/events/unreaded_count";
    public static final String GET_NEW_EVENTS_COUNT_URL = URL + "/v2/users/events/new_count";
    public static final String GET_GROUPED_EVENTS_URL = URL + "/v2/users/events";
    public static final String GET_EXPANDED_EVENTS_URL = URL + "/v2/users/events/expand";
    public static final String DELETE_GROUP_EVENTS_URL = URL + "/v2/users/events";
    public static final String DELETE_EVENT_URL = URL + "/v2/users/events/";
    public static final String DELETE_ALL_EVENTS_URL = URL + "/v2/users/events/";
    public static final String SET_AS_READ_GROUP_EVENTS_URL = URL + "/v2/users/events/as_read";
    public static final String SET_AS_READ_EVENT_URL = URL + "/v2/users/events/as_read";

    Set as read event
    PATCH




}
