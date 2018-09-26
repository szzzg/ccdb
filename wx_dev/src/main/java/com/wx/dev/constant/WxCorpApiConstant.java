package com.wx.dev.constant;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年11月21日下午2:41:05
 * @author: 周志刚
 * @ClassName: WxCorpApiConstant
 * @Description: TODO
 */
public class WxCorpApiConstant {

	/** 获取accessToken */
	public static final String GET_AccessToken_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={0}&corpsecret={1}";
	/** OAuth认证 */
	public static final String oauth2_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope=snsapi_base&agentid={2}&state=1#wechat_redirect";
	/** 根据code获取成员信息 */
	public static final String GET_USERINFO_BY_CODE = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token={0}&code={1}";

	/** 该API用于获取企业号某个应用的基本信息，包括头像、昵称、帐号类型、认证类型、可见范围等信息 */
	public static final String GET_AgentInfo_URL = "https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token={0}&agentid={1}";
	/** 该API用于获取企业号应用列表信息 */
	public static final String GET_AgentInfoList_URL = "https://qyapi.weixin.qq.com/cgi-bin/agent/list?access_token={0}";

	/** 该API用于创建应用菜单 */
	public static final String Create_AgentMenu_URL = "https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token={0}&agentid={1}";
	/** 该API用于创建应用菜单列表 */
	public static final String GET_AgentMenuList_URL = "https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token={0}&agentid={1}";

	/** 该API用于创建部门 */
	public static final String Create_Dept_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token={0}";
	/** 该API用于更新部门 */
	public static final String Update_Dept_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token={0}";
	/** 该API用于删除部门 */
	public static final String Delete_Dept_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token={0}&id={1}";
	/** 该API用于获取部门列表 */
	public static final String Get_Dept_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token={0}&id={1}";

	/** 该API用于创建成员 */
	public static final String Create_User_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token={0}";
	/** 该API用于更新成员 */
	public static final String Update_User_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token={0}";
	/** 该API用于删除成员 */
	public static final String Delete_User_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token={0}&userid={1}";
	/** 该API用于批量删除成员 */
	public static final String BatchDelete_User_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token={0}";
	/** 该API用于获取成员 */
	public static final String Get_User_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token={0}&userid={1}";
	/** 该API用于获取部门成员(详情) */
	public static final String Get_DeptUser_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token={0}&department_id={1}&fetch_child={2}&status={3}";
	/** 该API用于获取部门成员详情 */
	public static final String Get_DeptUser_URL_NEW = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token={0}&department_id={1}&fetch_child={2}";

	/** 部门根节点编号 */
	public static final String RootNodeDeptId = "1";

	/** 该API用于消息发送 */
	public static final String SendMsg_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token={0}";

	/** jsapi_ticket是企业号号用于调用微信JS接口的临时票据 */
	public static final String Get_JsApi_Ticket = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token={0}";

	/** 增量更新成员 */
	public static final String SYNC_USER = "https://qyapi.weixin.qq.com/cgi-bin/batch/syncuser?access_token={0}";

	/** 全量覆盖成员 */
	public static final String REPLACE_USER = "https://qyapi.weixin.qq.com/cgi-bin/batch/replaceuser?access_token={0}";

	/** 上传临时素材文件 */
	public static final String CGI_MEDIA_UPLOAD = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token={0}&type={1}";

	/** 发消息推送 */
	public static final String SEND_MSG = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token={0}";

	public enum MEDIA_TYPE {
		image, voice, video, file
	}

}
