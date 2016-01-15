package com.sh3h.datautil.data.local.config;


import android.content.Context;

import com.sh3h.datautil.injection.annotation.ApplicationContext;

import javax.inject.Inject;

public class SystemConfig extends BaseConfig {
    public enum JineAutoCacluate {
        /**
         * 自动
         */
        auto,
        /**
         * 手动
         */
        manual,
        /**
         * 禁用，不计算
         */
        disable
    }

    /**
     * 服务跟路径
     */
    public static final String PARAM_SERVER_BASE_URI = "server.baseuri";
    /**
     * 调试模式
     */
    public static final String PARAM_SYS_IS_DEBUG_MODE = "sys.is_debug_mode";
    /**
     * 分页大小
     */
    public static final String PARAM_LIST_PAGE_COUNT = "sys.list_page_size";
    /**
     * 呼吸包发送频率
     */
    public static final String PARAM_KEEP_LIVE_INTERVAL = "sys.keepalive_interval";
    /**
     * 估表状态
     */
    public static final String PARAM_CB_GUBIAO = "cb.gubiaozt";
    /**
     * 金额是否自动计算
     */
    public static final String PARAM_CB_AUTO_CALC_JINE = "cb.auto_calc_jine";
    /**
     * 是否输入量高量低原因
     */
    public static final String PARAM_CB_INPUT_LGLDYY = "cb.need_lgldyy";
    /**
     * 是否允许2G/3G方式下载抄表数据
     */
    public static final String PARAM_NET_ALLOW_EDGED_OWNLOAD = "net.allow_edged_ownload";
    /**
     * 是否保存后自动上传抄表数据
     */
    public static final String PARAM_CB_AUTO_UPLOAD = "cb.auto_upload";
    /**
     * 是否允许WIFI自动下载抄表数据
     */
    public static final String PARAM_NET_ALLOW_AUTO_DOWNLOAD_WIFI_ENABLED = "net.allow_auto_download_wifi_enabled";
    /**
     * 是否显示垃圾费
     */
    public static final String KG_SHOW_LAJIFEI = "kg.show_lajifei";
    /**
     * 是否显示垃圾费系数
     */
    public static final String KG_SHOW_LAJIFEIXISHU = "kg.show_lajifeixishu";
    /**
     * 是否显示定额加价
     */
    public static final String KG_SHOW_DINGEJIAJIA = "kg.show_dingejiajia";
    /**
     * 是否显示违约金
     */
    public static final String KG_SHOW_WEIYUEJIN = "kg.show_weiyuejin";
    /**
     * 是否显示水表倍率
     */
    public static final String KG_SHOW_SHUIBIAOBEILV = "kg.show_shuibiaobeilv";
    /**
     * rabbitmq server url
     */
    public static final String PARAM_BROKER_URL = "broker.url";

    /**
     * 抄表状态名称是否增加PC快捷键前缀
     */
    public static final String CB_ISADD_PC_KUAIJIEJIAN_PREFIX = "cb.isadd_pc_kuaijiejian_prefix";
    /**
     * 是否显示连续估表次数
     */
    public static final String CX_ISSHOW_LIANXUGUBIAOCS = "cx.show_lianxugubiaocs";
    /**
     * 是否显示连续量高量低次数
     */
    public static final String CX_ISSHOW_LIANXULIANGGAOLDCS = "cx.show_lianxulianggaoldcs";

    /**
     * 人口水量（阶梯1）
     */
    public static final String JIETIJB1_RENKOUSL = "jietijb1.renkousl";
    /**
     * 人口水量（阶梯2）
     */
    public static final String JIETIJB2_RENKOUSL = "jietijb2.renkousl";
    /**
     * 人口水量（阶梯3）
     */
    public static final String JIETIJB3_RENKOUSL = "jietijb3.renkousl";

    /**
     * 抄表程序 or 工单程序
     */
    public static final String PARAM_SYS_IS_GONGDAN = "sys.is_gongdan";

    /**
     * 查询记录期限
     */
    public static final String CB_DATA_DOWNLOAD_TIME = "sys.data_download_time";

    /**
     * version: jiading
     */
    public static final String PARAM_SYS_VERSION = "sys.version";
    public static final String SYS_VERSION_JIADING = "jiading";

    /**
     * downloading parameter
     */
    public static final String PARAM_SYS_DOWNLOADING_TOTAL = "sys.downloading.total";

    /**
     * uploading parameter
     */
    public static final String PARAM_SYS_UPLOADING_TOTAL = "sys.uploading.total";

    /**
     * true for restful api, or for json rpc
     */
    public static final String PARAM_SYS_RESTFUL_API = "sys.restful.api";

    public SystemConfig() {

    }

}
