package com.pixel.pgback.common;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.common
 * @Author: zhouzw
 * @CreateTime: 2019/5/10 15:29
 * @Description: 常量类
 */
public class Constants {
    //返回码
    /**
     * 返回码：成功
     */
    public static final int RESULT_CODE_SUCCESS = 200;
    /**
     * 返回码：bad request
     */
    public static final int RESULT_CODE_BAD_REQUEST = 400;
    /**
     * 返回码：没有对应结果
     */
    public static final int RESULT_CODE_SERVER_ERROR = 500;


    //返回信息
    /**
     * 返回信息：成功
     */
    public static final String RESULT_MESSAGE_SUCCESS = "SUCCESS";
    /**
     * 返回信息：失败
     */
    public static final String RESULT_MESSAGE_FAIL = "FAIL";

    //01 前台登录身份，对应登录页面单选框内容
    /**
     * 候选人
     */
    public static final String LOGIN_IDENTITY_CANDIDATE = "0101";
    /**
     * 招聘团队
     */
    public static final String LOGIN_IDENTITY_RECRUITING = "0102";


    //02 人员身份
    /**
     * 面试官
     */
    public static final String IDENTITY_INTERVIEWER = "0201";
    /**
     * 招聘团队
     */
    public static final String IDENTITY_RECRUITING = "0202";
    /**
     * 候选人
     */
    public static final String IDENTITY_CANDIDATE = "0203";
    /**
     * 主管理员
     */
    public static final String IDENTITY_PRIMARY_ADMIN = "0204";
    /**
     * 子管理员
     */
    public static final String IDENTITY_ADMIN = "0205";
    /**
     * 面试官和招聘团队双重身份
     */
    public static final String IDENTITY_REANDIN = "0206";

    //03 面试类型
    /**
     * Screen Interview
     */
    public static final String INTERVIEW_TYPE_SI = "0301";
    /**
     * Final Interview
     */
    public static final String INTERVIEW_TYPE_FI = "0302";

    //04 面试官选择时间
    /**
     * 上午
     */
    public static final String INTERVIEWER_TIME_MORNING = "0401";
    /**
     * 下午
     */
    public static final String INTERVIEWER_TIME_AFTERNOON = "0402";

    //面试时段
    /**
     * 09:00-09:45
     */
    public static final String INTERVIEW_TIME_09 = "09:00:00";
    /**
     * 10:00-10:45
     */
    public static final String INTERVIEW_TIME_10 = "10:00:00";
    /**
     * 11:00-11:45
     */
    public static final String INTERVIEW_TIME_11 = "11:00:00";
    /**
     * 13:00-13:45
     */
    public static final String INTERVIEW_TIME_13 = "13:00:00";
    /**
     * 14:00-14:45
     */
    public static final String INTERVIEW_TIME_14 = "14:00:00";
    /**
     * 15:00-15:45
     */
    public static final String INTERVIEW_TIME_15 = "15:00:00";
    /**
     * 16:00-16:45
     */
    public static final String INTERVIEW_TIME_16 = "16:00:00";


    //---------------------------------------end---------


    //面试区域
    /**
     * Overseas
     */
    public static final String INTERVIEW_AREA_OV = "Overseas";
    /**
     * GZ and HK
     */
    public static final String INTERVIEW_AREA_GZHK = "GZ and HK";
    /**
     * TJ and BJ
     */
    public static final String INTERVIEW_AREA_TJBJ = "TJ and BJ";
    /**
     * SH
     */
    public static final String INTERVIEW_AREA_SH = "SH";
    /**
     * WX
     */
    public static final String INTERVIEW_AREA_WX = "WX";
    /**
     * HZ
     */
    public static final String INTERVIEW_AREA_HZ = "HZ";
    /**
     * XA
     */
    public static final String INTERVIEW_AREA_XA = "XA";
    /**
     * CD
     */
    public static final String INTERVIEW_AREA_CD = "CD";
    /**
     * WH
     */
    public static final String INTERVIEW_AREA_WH = "WH";
    /**
     * HRB and DL
     */
    public static final String INTERVIEW_AREA_HRBDL = "HRB and DL";


    //面试官可选时间
    /**
     * 10.11
     */
    public static final String INTERVIEWER_TIME_11 = "Oct 11";
    /**
     * 10.12
     */
    public static final String INTERVIEWER_TIME_12 = "Oct 12";
    /**
     * 10.13
     */
    public static final String INTERVIEWER_TIME_13 = "Oct 13";
    /**
     * 10.14
     */
    public static final String INTERVIEWER_TIME_14 = "Oct 14";
    /**
     * 10.15
     */
    public static final String INTERVIEWER_TIME_15 = "Oct 15";
    /**
     * 10.16
     */
    public static final String INTERVIEWER_TIME_16 = "Oct 16";
    /**
     * 10.17
     */
    public static final String INTERVIEWER_TIME_17 = "Oct 17";
    /**
     * 10.18
     */
    public static final String INTERVIEWER_TIME_18 = "Oct 18";
    /**
     * 10.19
     */
    public static final String INTERVIEWER_TIME_19 = "Oct 19";
    /**
     * 10.20
     */
    public static final String INTERVIEWER_TIME_20 = "Oct 20";
    /**
     * 10.21
     */
    public static final String INTERVIEWER_TIME_21 = "Oct 21";
    /**
     * 10.22
     */
    public static final String INTERVIEWER_TIME_22 = "Oct 22";
    /**
     * 10.23
     */
    public static final String INTERVIEWER_TIME_23 = "Oct 23";
    /**
     * 10.24
     */
    public static final String INTERVIEWER_TIME_24 = "Oct 24";
    /**
     * 10.25
     */
    public static final String INTERVIEWER_TIME_25 = "Oct 25";


    //候选人状态
    /**
     * 准备
     */
    public static final String CANDIDATE_STATUS_PRE = "Preparation";
    /**
     * 一面
     */
    public static final String CANDIDATE_STATUS_SI = "Screen Interview";
    /**
     * 一面评估
     */
    public static final String CANDIDATE_STATUS_ASS_SI = "Assessment SI";
    /**
     * 二面
     */
    public static final String CANDIDATE_STATUS_FI = "Final Interview";
    /**
     * 二面评估
     */
    public static final String CANDIDATE_STATUS_ASS_FI = "Assessment FI";
    /**
     * offer
     */
    public static final String CANDIDATE_STATUS_OFF = "Offer";


    //面试类型
    /**
     * 一面
     */
    public static final String INVERTIEW_TYPE_SI = "Screen Interview";
    /**
     * 二面
     */
    public static final String INVERTIEW_TYPE_FI = "Final Interview";


    //员工身份
    /**
     * 面试官
     */
    public static final String EMPLOYEE_IDENTITY_IN = "Interviewer";
    /**
     * 招聘团队
     */
    public static final String EMPLOYEE_IDENTITY_RE = "Recruiting Team";


    //面试官等级
    /**
     * director
     */
    public static final String INTERVIERER_LEVEL_DE = "Director";
    /**
     * senior manager
     */
    public static final String INTERVIERER_LEVEL_SM = "Senior Manager";
}
