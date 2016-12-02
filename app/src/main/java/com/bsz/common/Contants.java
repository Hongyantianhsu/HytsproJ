package com.bsz.common;

/**
 * 常量类
 * Created by sunyan on 16/11/30.
 */
public class Contants {

    public static final String HOST = "http://app.novatarot.com/index.php/Api";

    // 登录注册code
    public static final String LOGIN_CODE_URI = HOST + "/User/code";
    // 上传图片
    public static final String UPLOADING_URI = HOST + "/Common/uploadimg";
    // 用户登录验证
    public static final String LOGIN_URI = HOST + "/User/login";
    // 获取手机手机邮箱验证码
    public static final String VERIFY_CODE_URI = HOST + "/User/VerifyCode";
    // 找回密码，检测验证码
    public static final String CHECK_VERIFY_CODE_URI = HOST + "/User/checkverify";
    // 重置密码
    public static final String RESET_PWD_URI = HOST + "/User/resetpwd";
    // 第三方登录注册步骤
    public static final String REGISTER_THIRD_PARTY_URI = HOST + "/User/registerThirdParty";
    // 新版第三方注册登录
    public static final String THIRD_PARTY_LOGIN_URI = HOST + "/User/thirdPartyLogin";
    // 新版手机注册
    public static final String NEW_REGISTER_URI = HOST + "/User/newRegister";
    // 检测验证码是否正确
    public static final String CHECK_VF_CODE_URI = HOST + "/User/checkVfcode";

    // 手机绑定
    public static final String BIND_PHONE_URI = HOST + "/User/bandPhone";
    // 获取个人资料
    public static final String GET_PERSONAL_INFO_URI = HOST + "/Personal/getPersonalInfo";
    // 刷新token
    public static final String REFRESH_TOKEN_URI = HOST + "/User/refreshtoken";
    // 设置个人资料
    public static final String SET_PERSONAL_INFO_URI = HOST + "/Personal/setPersonalInfo";
    // 更新用户头像
    public static final String SET_PERSONAL_HEAD_URI = HOST + "/Personal/setPersonalheadimg";
    // 我要吐槽
    public static final String SPEEK_URI = HOST + "/Personal/sysPullAway";
    // 获取用户头像
    public static final String GET_PERSONAL_HEAD_URI = HOST + "/Personal/getPersonalheadimg";
    // 积分管理_等级
    public static final String GRADE_URI = HOST + "/GradeIntegal/grade";
    // 积分管理_积分
    public static final String INTEGRAL_URI = HOST + "/GradeIntegal/integral";
    // 我关注的list
    public static final String ATTEN_ME_LIST_URI = HOST + "/Personal/attenMeList";
    // 我的话题
    public static final String MY_TOPIC_URI = HOST + "/Personal/myTalk";
    // 塔罗师主页面
    public static final String TAROT_HOME_URI = HOST + "/HomePage/tarotHome";
    // 麻瓜主页面
    public static final String MAGA_HOME_URI = HOST + "/HomePage/magaHome";
    // 获取首页滚动广告
    public static final String HOME_SLIDE_ADV_URI = HOST + "/Index/slideAdv";
    // 首页塔罗师推荐列表
    public static final String HOME_TAROT_REC_URI = HOST + "/Index/tarotRecList";
    // 首页文章列表
    public static final String HOME_ARTICLE_URI = HOST + "/Index/homeArticle";
    // 首页推荐服务列表
    public static final String SERVICE_REC_LIST_URI = HOST + "/Index/serviceRecList";

    // 用户投票
    public static final String VOTE_URI = HOST + "/Index/vote";
    // 首页文章喜欢
    public static final String ARC_LIKE_URI = HOST + "/Index/arcLike";
    // 首页广告喜欢
    public static final String ADV_LIKE_URI = HOST + "/Index/advLike";
    // 首页塔罗师轮播图推荐
    public static final String TAROT_REC_BANNER_URI = HOST + "/Index/tarotRecBanner";
    // 获取塔罗师反馈列表
    public static final String GET_HOME_FEEDBACK_URI = HOST + "/HomePage/getHomeFeedback";
    // 签到领心币
    public static final String SIGN_LOGIN_URI = HOST + "/Personal/signLogin";
    // 查看签到领心币
    public static final String GET_SIGN_LOGIN_URI = HOST + "/Personal/getSignLogin";
    // 查看签到状态
    public static final String CHECK_SIGN_URI = HOST + "/Personal/checkSign";
    // 查看签到列表
    public static final String GET_SIGN_LIST_URI = HOST + "/Personal/getSignList";
    // 获得塔罗师个人标签
    public static final String GET_TAROT_LABEL_URI = HOST + "/HomePage/getTarotLabel";
    // 关注和取消关注
    public static final String ATTEN_PEOPLE_URI = HOST + "/Personal/attenPeple";
    // 获取系统标签
    public static final String GET_SYSTEM_LABEL_URI = HOST + "/HomePage/getSystemLabel";
    // 添加个人标签
    public static final String ADD_LABEL_URI = HOST + "/Personal/addLabel";
    // 新版塔罗大厅列表
    public static final String NEW_TAROT_HALL_LIST_URI = HOST + "/TarotHall/newTarotList";

    // 占心服务大厅列表
    public static final String SERVICE_LIST_URI = HOST + "/TarotHall/serviceList";
    public static final String NEW_SEARCH_URI = HOST + "/TarotHall/newSearch";
    // 优惠码获取优惠券接口
    public static final String GET_COUPONS_URI = HOST + "/Consult/getCouponFromCoupcode";

    // 大厅塔罗师搜索
    public static final String TAROT_SEARCH_URI = HOST + "/TarotHall/search";
    // 搜索相似的昵称
    public static final String NICK_LIKE_SEARCH_URI = HOST + "/TarotHall/nicknameLike";
    // 搜索标签列表
    public static final String TAGS_LIST_URI = HOST + "/TarotHall/tagsList";
    // 搜索标签列表
    public static final String SEARCH_KEY_WORDS_URI = HOST + "/TarotHall/searchKeywords";
    // 我的订单列表
    public static final String MY_ORDER_URI = HOST + "/Personal/newOrderList";
    // 我的订单详情
    public static final String ORDER_INFO_URI = HOST + "/Personal/newOrderInfo";
    //塔罗师确认接单详情
    public static final String TAROT_ACCEPT_ORDER = HOST + "/Personal/tarotComfirmInfo";
    // 立即咨询建立
    public static final String CREATE_CONSULT_URI = HOST + "/Consult/newCreateConsult";
    // 预约咨询预约时间选择
    public static final String CREATE_PRE_CONSULT_URI = HOST + "/Consult/createPreConsult";
    // 预约咨询确认生成订单
    public static final String CONFIRM_PRECONSULT_ORDER_URI = HOST + "/Consult/confirmPreConsultOrder";
    // 确认生成订单信息
    public static final String CONFIRM_CONSULT_ORDER_URI = HOST + "/Consult/confirmConsultOrder";
    // 订单支付
    public static final String ORDER_PAY_URI = HOST + "/Consult/orderPay";
    // 举报用户
    public static final String USER_REPORT_URI = HOST + "/Index/userReport";
    // 加入黑名单
    public static final String PLUS_BLACK_LIST_URI = HOST + "/Index/plusBlacklist";
    // 移除黑名单
    public static final String DEL_BLACK_LIST_URI = HOST + "/Index/delBlacklist";
    // 交易管理
    public static final String TRADE_MANAGER_URI = HOST + "/Personal/tradeManger";
    // 绑定支付宝
    public static final String BIND_ALPAY_URI = HOST + "/Personal/bindALPay";
    // 获取支付宝
    public static final String GET_ALPAY_URI = HOST + "/Personal/getAlpay";
    // 积分充值管理(产生订单)
    public static final String PAY_INTEGRAL_URI = HOST + "/UseIntegral/payIntegral";
    // 积分充值管理(支付)
    public static final String INTEGRAL_PAY_URI = HOST + "/UseIntegral/integralPay";
    // 获取当前积分
    public static final String GET_CURRENT_INTEGRAL_URI = HOST + "/UseIntegral/getCurrentIntegral";
    // 我的预约列表
    public static final String MY_PRETIME_URI = HOST + "/Consult/myPretime";
    // 设定咨询规则
    public static final String SET_RULE_URI = HOST + "/Consult/setRule";
    // 设定收费价格单位
    public static final String SET_PRICE_UNIT_URI = HOST + "/Consult/setPriceUnit";
    // 开启立即咨询(switchState返回开关状态,0关闭 1开启 (这个接口每次访问都会改变原来的值))
    public static final String SWITCH_CONSULT_ON_URI = HOST + "/Consult/switchNowConsultOn";
    // 设定收费价格
    public static final String SET_PRICE_URI = HOST + "/Consult/setPrice";
    // 我的咨询
    public static final String MY_CONSULT_URI = HOST + "/Consult/myConsult";
    // 设定预约咨询
    public static final String SET_PRECONSULT_URI = HOST + "/Consult/setPreConsult";
    // 设定免费价格
    public static final String SET_FREE_PRICE_URI = HOST + "/Consult/setFreePrice";
    // 评价咨询
    public static final String JUDGE_CONSULT_URI = HOST + "/Personal/judgeConsult";
    // 我的优惠券
    public static final String COUPON_URI = HOST + "/Consult/coupon";

    // 心币规则
    public static final String INTEGRAL_DESCRITION_URI = HOST + "/Share/integraldescrition";
    // 优惠券说明
    public static final String COUPON_INTRO_URI = HOST + "/index/couponIntro";
    // 免费拿优惠券
    public static final String SHARE_TO_REGISTER_URI = HOST + "/index/shareToRegister";
    // 塔罗师认证
    public static final String TAROT_VERIFY_URI = HOST + "/index/tarotVerify";
    // 塔罗师认证状态
    public static final String TAROT_VERIFY_STATE_URI = HOST + "/index/tarotVerifyState";

    // 商品列表
    public static final String SHOP_LIST_URI = HOST + "/Shop/list";
    // 商品详情
    public static final String SHOP_VIEW_URI = HOST + "/Shop/view";
    // 兑换商品
    public static final String SHOP_PAY_URI = HOST + "/Shop/pay";
    // 兑换列表
    public static final String SHOP_EXCHANGE_LIST_URI = HOST + "/Shop/exchangeList";

    // 新版塔罗师个人主页
    public static final String NEW_TAROT_HOME_URI = HOST + "/HomePage/newTarotHome";
    // 塔罗师名片
    public static final String PERSONAL_CARD_URI = HOST + "/Personal/personalCard";
    // 塔罗师名片保存
    public static final String PERSONAL_CARD_SAVE_URI = HOST + "/Personal/personalCardSave";
    // 新版评价反馈
    public static final String TAROT_FEEDBACK_LIST_URI = HOST + "/HomePage/tarotFeedbackList";
    // 服务详情
    public static final String SERVICE_INFO_URI = HOST + "/HomePage/serviceInfo";
    // 新版服务详情
    public static final String NEW_SERVICE_INFO_URI = HOST + "/HomePage/newServiceInfo";
    // 评价详情
    public static final String FEEDBACK_INFO_URI = HOST + "/Personal/feedbackInfo";
    // 塔罗师回评提交
    public static final String TAROT_FEEDBACK_SAVE_URI = HOST + "/Personal/tarotFeedbackSave";
    // 首页服务分类列表
    public static final String SERVER_URI = HOST + "/Index/server";
    // 获取账户余额
    public static final String GET_BALANCE_URI = HOST + "/Personal/getBalance";
    // 绑定支付宝
    public static final String BIND_ALIPAY_URI = HOST + "/Personal/bindAlipay";
    // 判断是否绑定支付宝
    public static final String IS_BIND_ALIPAY_URI = HOST + "/Personal/isBindAlipay";
    // 提现申请
    public static final String WITHDRAW_URI = HOST + "/Personal/withdraw";
    // 解绑支付宝
    public static final String UN_BIND_ALIPAY_URI = HOST + "/Personal/unBindAlipay";
    // 账户明细
    public static final String ACCOUNT_DETAILS_URI = HOST + "/Personal/accountDetails";
    // 提现文案
    public static final String WITH_DRAW_TEXT_URI = HOST + "/Personal/withdrawText";

    //消息中心服务器地址
    public static final String CHAT_ADDRESS = "120.24.54.165";
    public static final int CHAT_PORT = 9508;
    //图片上传
    public static String UPLOAD_IMAG = "http://120.24.54.165:8090/index/uploadImg";
    //语音上传
    public static String UPLOAD_VOICE = "http://120.24.54.165:8090/index/uploadVoice";
    //获取头像，姓名
    public static String AVATAR_NAME = "http://app.novatarot.com/index.php/Api/User/nvchatUserInfo";
    //取消咨询
    public static String CANCEL_CONSULT = HOST + "/Consult/cancelConsult";
    //塔罗师确认接单
    public static String TAROT_CONFIRM = HOST + "/Consult/serviceConfirm";

    //v2.1.4付款后塔罗师确认接单
    public static String CONFIRM_ORDER = HOST + "/Consult/accessConsult";

    //塔罗师拒绝接单
    public static String TAROT_REJECT = HOST + "/Consult/tarotReject";
    //关闭咨询
    public static String CLOSE_CONSULT = HOST + "/Consult/closeConsult";

    //获取socket服务器地址
    public static String GET_HOSTADDRESS = HOST + "/User/socketHost";

    //退出账号登录（参数：uid）
    public static String QUIT_LOGIN = HOST + "/User/logout";

    //设备上传
    public static String DEVICE_UPLOAD = HOST + "/User/uploadAndroidToken";

    //工作室.
    public static String MY_WORKROOM = HOST + "/Consult/myWorkroom";

    //腾讯行家开关
    public static String QQ_EXPERT = HOST + "/Tengxun/switchTxConsultOn";

    //拒绝该订单
    public static String REJECT_ORDER = HOST + "/Tengxun/rejectOrder";

    //呼叫用户
    public static String CALL_USER = HOST + "/Tengxun/callUser";

    //结束行家订单
    public static String FINISH_ORDER = HOST +"/Tengxun/finishOrder";

    //预约时间
    public static String PRETIME = HOST + "/Consult/getPretimeList";

    //开启预约咨询
    public static String PRECONSULT_ON_OFF = HOST + "/Consult/switchPreConsultOn";

    //生成预约咨询订单
    public static String PRECONSULT_ORDER = HOST + "/Consult/newCreatePreConsultAndOrder";

    //下单服务列表
    public static String SERVICE_LISTS = HOST + "/Consult/myOpenServiceList";

    //选择服务
    public static String COMMIT_SERVICE = HOST + "/Consult/newSelectService";

    //暂停服务
    public static String PAUSE_SERVICE = HOST + "/Consult/switchService";

    //删除服务
    public static String DELETE_SERVICE = HOST + "/Consult/delService";

    //保存服务
    public static String KEEP_SERVICE = HOST + "/Consult/saveServer";

    //服务列表
    public static String SERVICE_LIST = HOST + "/Consult/serverList";

    //服务下架
    public static String SERVICE_OUT = HOST + "/Consult/outService";

    //检查版本号
    public static String VERSION_CHECK = HOST+ "/Common/checkVersion";

    //获取塔罗牌抽取h5地址
    public static String TAROTCARD_H5 = "http://app.novatarot.com/h5/tarot_card/api.php";

    //v2.1.4立即下单
    public static String CONFIRM_SERVICE = HOST + "/Consult/comfirmService";

    //v2.1.4 咨询时间选择列表
    public static String SELECT_CONSULTTIME = HOST + "/Consult/selectConsultTime";

    //获取账户余额
    public static String GETBALANE = HOST + "/Personal/getBalance";
}

