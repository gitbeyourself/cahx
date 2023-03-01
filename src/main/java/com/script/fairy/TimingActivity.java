package com.script.fairy;

import com.script.framework.TaskContent;
import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    GameUtil gameUtil;
    boolean ghwh=true;

    public TimingActivity(AtFairyImpl ATFairy) throws Exception {
        Sleep = 2000;
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);
    }

    public void timingActivity() throws Exception {
        int h = mFairy.dateHour();
        int m = mFairy.dateMinute();
        LtLog.e("查看限时任务！！！！！");

        //篝火晚会
        if (AtFairyConfig.getOption("ghyh").equals("1") && ghwh && h == 19 && (m > 30 && m < 50)) {
            ghwh();
            ghwh = false;
        }

    }

    /**
     * 等待限时
     */
    public void Timelimit() throws Exception {
        new TimingActivity(mFairy) {
            TaskMain taskMain;
            public void inOperation() throws Exception {
                result = mFairy.findPic(623,885,699,1118,new String[]{"dialogue.png","dialogue1.png"});
                result1 = mFairy.findPic(559,1064,710,1147,"tiaoguo.png");
                result2 = mFairy.findPic(140,546,609,676,"xzdh.png");
                if (result.sim > 0.8f || result1.sim > 0.8f || result2.sim > 0.8f) {
                    mFairy.onTap(0.8f, result2, "选择对话", Sleep);
                    mFairy.onTap(0.8f, result, "对话", Sleep);
                    mFairy.onTap(0.8f, result1, "跳过", Sleep);
                    LtLog.e(mFairy.getLineInfo("对话中"));
                    mFairy.initMatTime();
                    err = 0;
                }
                result = mFairy.findPic(623,885,699,1118,new String[]{"dialogue.png","dialogue1.png"});
                mFairy.onTap(0.8f, result, "对话", Sleep);

                result = mFairy.findPic(236,762,508,858, "Pathfinding.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("寻路中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
            }
            public void content_0() throws Exception {
                int h = mFairy.dateHour();
                int m = mFairy.dateMinute();
                timingActivity();
                Thread.sleep(60000);
                if (AtFairyConfig.getOption("resetting").equals("1")  && h==7  && m==1) {
                    ghwh=true;
                    LtLog.e("7点重置任务" );
                    create();
                    taskMain.main();
                }
            }
        }.taskContent(mFairy, "等待限时任务");
    }

    /**
     * 篝火晚会
     */
    public void ghwh() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                int h = mFairy.dateHour();
                int m = mFairy.dateMinute();
                result = mFairy.findPic(623,885,699,1118,new String[]{"dialogue.png","dialogue1.png"});
                result1 = mFairy.findPic(559,1064,710,1147,"tiaoguo.png");
                result2 = mFairy.findPic(140,546,609,676,"xzdh.png");
                if (result.sim > 0.8f || result1.sim > 0.8f || result2.sim > 0.8f) {
                    mFairy.onTap(0.8f, result2, "选择对话", Sleep);
                    mFairy.onTap(0.8f, result, "对话", Sleep);
                    mFairy.onTap(0.8f, result1, "跳过", Sleep);
                    LtLog.e(mFairy.getLineInfo("对话中"));
                    mFairy.initMatTime();
                    err = 0;
                }
                result = mFairy.findPic(623,885,699,1118,new String[]{"dialogue.png","dialogue1.png"});
                mFairy.onTap(0.8f, result, "对话", Sleep);

                result = mFairy.findPic(236,762,508,858, "Pathfinding.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("寻路中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }

                if (h != 19 || (m > 50)) {
                    LtLog.e("超时间结束！");
                    setTaskEnd();
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(20,0))return;

                result =mFairy.findPic(3,316,94,741,"yanhui.png");
                mFairy.onTap(0.8f,result,"宴会",Sleep);

                result =mFairy.findPic(29,414,678,584,"ghwh1.png");
                mFairy.onTap(0.8f,result,522,767,532,771,"前往",Sleep);

                result =mFairy.findPic(213,690,487,828,"kspc.png");
                mFairy.onTap(0.8f,result,"品尝",Sleep);

                result =mFairy.findPic(3,6,165,36,"bpz.png");
                result1 = mFairy.findPic(4,135,90,235,"yanhui.png");
                if (result.sim > 0.8f || result1.sim > 0.8f) {
                    LtLog.e("帮派中！");
                    setTaskName(2);
                }
            }
            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(11,110,45,16, 0.9f);
                LtLog.e("发呆时间=="+dazeTime);
                if (dazeTime > 30){
                    setTaskName(0);return;
                }

                result =mFairy.findPic(213,690,487,828,"kspc.png");
                mFairy.onTap(0.8f,result,"品尝",Sleep);

                result =mFairy.findPic(233,804,519,934,"pinchang1.png");
                mFairy.onTap(0.8f,result,"品尝1",Sleep);

                result = mFairy.findPic(443,130,710,444,new String[]{"yanhui1.png","dati.png"});
                result1 = mFairy.findPic(4,135,90,235,"yanhui.png");
                if (result.sim > 0.8f || result1.sim > 0.8f) {
                    LtLog.e("宴会中");
                    mFairy.initMatTime();
                }

            }
        }.taskContent(mFairy, "篝火晚会任务");
    }
}
