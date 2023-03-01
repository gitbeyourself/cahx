package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    FindResult result4;
    GameUtil gameUtil;


    public SingleTask(AtFairyImpl ATFairy) throws Exception {
        Sleep = 2000;
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);

    }
    /**
     * 第一阶段新手主线任务
     *
     * @throws Exception
     */
    //新手引导
    public void novice() throws Exception {
        new SingleTask(mFairy) {
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

                result = mFairy.findPic(new String[]{"In picture.png", "In picture1.png"});
                LtLog.e(mFairy.getLineInfo("过图："+result.sim));
                if (result.sim > 0.92f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
                result = mFairy.findPic(511, 6, 805, 437, "Pathfinding.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("寻路中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
                result = mFairy.findPic("dutiao.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("读条中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
            }

            //主线
            @Override
            public void content_0() throws Exception {
                long dazeTime1 = mFairy.mMatTime(11,110,45,16, 0.9f);
                LtLog.e("发呆时间=="+dazeTime1);
                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e("回合中");
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);

                    mFairy.initMatTime();
                }
                if (dazeTime1 > 8) {
                    result = mFairy.findPic(207,943,567,1074,"chapter.png");
                    result1 = mFairy.findPic(496,184,705,445,"zhu.png");
                    if (result.sim>0.8f){
                        mFairy.onTap(0.8f, result, "章程", Sleep);
                        mFairy.initMatTime();
                    }else{
                        mFairy.onTap(0.8f, result1, "主线", Sleep);
                        mFairy.initMatTime();
                    }

                    if (result.sim > 0.8f || result1.sim > 0.8f) {
                        mFairy.initMatTime();
                    }else{
                        LtLog.e("未找到主线");
                    }
                }
                if (dazeTime1 > 20) {
                    gameUtil.close();
                }
                result = mFairy.findPic(52,993,512,1070,"18ji.png");
                result1 = mFairy.findPic(488,176,707,404,"dj3.png");
                result2 = mFairy.findPic(205,1034,507,1198,"xzzm.png");
                result3 = mFairy.findPic(223,542,582,723,"name.png");
                if (result.sim>0.8f || result1.sim>0.8f || result2.sim>0.8f || result3.sim>0.8f){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(20,1063,131,1151,"zt.png");
                mFairy.onTap(0.85f, result, "自动对话", Sleep);

                result = mFairy.findPic(156,171,582,282,"rhxz.png");
                mFairy.onTap(0.8f, result, 137,831,153,857,"左侧1", Sleep);
                mFairy.onTap(0.8f, result, 137,831,153,857,"左侧2", Sleep);
                mFairy.onTap(0.8f, result, 137,831,153,857,"左侧3", Sleep);


                result = mFairy.findPic(20,1063,131,1151,"zt.png");
                mFairy.onTap(0.9f, result, "自动对话", Sleep);

                result = mFairy.findPic(512,413,683,1130,"jiequ.png");
                mFairy.onTap(0.8f, result, "接取", Sleep);

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

                result = mFairy.findPic(247,714,466,1037,"hand.png");
                mFairy.onTap(0.8f, result, "手", Sleep);

                result = mFairy.findPic(181,1169,523,1257,"hundun.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(64,57,582,1108,500, (long) 500,0);
                }
                result1 = mFairy.findPic(115,745,621,971,"zhaoshi.png");
                result = mFairy.findPic(104,728,647,979,new String[]{"xdzl.png","xdzl1.png"});
                if (result.sim > 0.8f || result1.sim > 0.8f) {
                    LtLog.e("滑动");
                    mFairy.ranSwipe(229,962,363,330,500, (long) 500,0);
                }

                result1 = mFairy.findPic(588,424,716,664,"jiantou.png");
                result = mFairy.findPic(164,628,690,1121,"yaoling.png");
                if (result.sim > 0.8f && result1.sim<0.8f) {
                    mFairy.onTap(0.8f, result, 58,462,65,471,"寻找妖灵", Sleep);
                    mFairy.onTap(0.8f, result, 58,462,65,471,"寻找妖灵", Sleep);
                    mFairy.onTap(0.8f, result, 58,462,65,471,"寻找妖灵", Sleep);
                }else if(result.sim > 0.8f && result1.sim>0.8f){
                    mFairy.onTap(0.8f, result, 679,658,693,666,"寻找妖灵2", Sleep);
                    mFairy.onTap(0.8f, result, 679,658,693,666,"寻找妖灵2", Sleep);
                    mFairy.onTap(0.8f, result, 499,519,503,522,"寻找妖灵2", Sleep);
                    mFairy.onTap(0.8f, result, 499,519,503,522,"寻找妖灵2", Sleep);
                }

                result = mFairy.findPic(72,697,586,912,"tianyan.png");
                mFairy.onTap(0.8f, result, 677,924,685,933,"天眼", Sleep);
                mFairy.onTap(0.8f, result, 532,408,537,418,"真灵塔入口", Sleep);

                result = mFairy.findPic(237,91,468,1076,new String[]{"guanqia.png","guanqia1.png"});
                mFairy.onTap(0.8f, result, "关卡选择", Sleep);

                result = mFairy.findPic(218,1161,513,1272,"pk.png");
                mFairy.onTap(0.8f, result, "战斗", Sleep);

                result = mFairy.findPic(181,530,604,689,"yl.png");
                mFairy.onTap(0.8f, result, 384,323,391,343,"战斗", Sleep);

                result = mFairy.findPic(176,901,601,1079,"qr.png");
                mFairy.onTap(0.8f, result, "确定", Sleep);

                result = mFairy.findPic(151,625,561,1051,"xzbs.png");
                mFairy.onTap(0.8f, result, "寻找帮手", Sleep);

                result = mFairy.findPic(209,245,525,311,"bjzz.png");
                mFairy.onTap(0.8f, result, 194,760,201,769,"并肩作战", Sleep);
                mFairy.onTap(0.8f, result, 355,977,367,989,"并肩作战选择", Sleep);
                mFairy.onTap(0.8f, result, 526,793,538,803,"并肩作战确定", Sleep);

                result = mFairy.findPic(93,947,530,1063,"xxxjn.png");
                mFairy.onTap(0.8f, result, 678,1087,682,1093,"菜单", Sleep);
                mFairy.onTap(0.8f, result, 280,954,288,962,"技能", Sleep);
                mFairy.onTap(0.8f, result, 193,568,197,573,"第三技能", Sleep);
                mFairy.onTap(0.8f, result, 354,986,364,991,"学习", Sleep);
                mFairy.onTap(0.8f, result, 54,1219,68,1229,"退出", Sleep);
                mFairy.onTap(0.8f, result, 54,1219,68,1229,"退出", Sleep);

                result = mFairy.findPic(177,785,531,1255,new String[]{"kbc1.png","kbc.png","kbc2.png"});
                mFairy.onTap(0.8f, result, 683,34,688,44,"点击空白处", Sleep);

                result = mFairy.findPic(19,889,152,1046,"npc1.png");
                mFairy.onTap(0.8f, result, 84,965,96,972,"选择npc", Sleep);
                mFairy.onTap(0.8f, result, 353,1219,363,1224,"战斗", Sleep);

                result = mFairy.findPic(461,196,683,556,"receive.png");
                mFairy.onTap(0.8f, result, "领取", Sleep);

                result = mFairy.findPic(236,658,473,785,new String[]{"qd.png","qd1.png"});
                mFairy.onTap(0.8f, result, "确定", Sleep);

                result = mFairy.findPic(214,726,492,871,"chatan.png");
                mFairy.onTap(0.8f, result, "查探", Sleep);

                result = mFairy.findPic(473,550,678,862,"rd.png");
                mFairy.onTap(0.8f, result, "入队", Sleep);

                result = mFairy.findPic(99,938,481,1074,"jineng.png");
                mFairy.onTap(0.8f, result, 676,1086,682,1092,"技能", Sleep);
                mFairy.onTap(0.8f, result, 282,953,293,960,"技能1", Sleep);
                mFairy.onTap(0.8f, result, 189,379,194,389,"技能1", Sleep);

                result = mFairy.findPic(371,816,689,1068,"jnxd.png");
                mFairy.onTap(0.8f, result, 524,989,533,996,"技能心得", Sleep);
                mFairy.onTap(0.8f, result, 524,989,533,996,"学习", Sleep);
                mFairy.onTap(0.8f, result, 643,145,647,157,"退出自动学习", Sleep);
                mFairy.onTap(0.8f, result, 56,1210,65,1226,"退出技能", Sleep);

                result = mFairy.findPic(623,885,699,1118,new String[]{"dialogue.png","dialogue1.png"});
                mFairy.onTap(0.8f, result, "对话", Sleep);
                /*result = mFairy.findPic(54,657,673,1089,"xuexi.png");
                mFairy.onTap(0.8f, result, 643,145,647,157,"自动学习", Sleep);
                mFairy.onTap(0.8f, result, 643,145,647,157,"自动学习1", Sleep);*/

                result = mFairy.findPic(390,909,583,1051,"yingyong.png");
                mFairy.onTap(0.8f, result, "应用", Sleep);

                result = mFairy.findPic(169,742,551,934,"sdxy.png");
                mFairy.onTap(0.8f, result, "手动寻妖", Sleep);

                result = mFairy.findPic(218,1004,633,1135,"sz.png");
                mFairy.onTap(0.8f, result, 682,1078,687,1091,"退出设置", Sleep);

                result = mFairy.findPic(211,945,488,1172,new String[]{"hulu1.png","hulu.png"});
                mFairy.onTap(0.9f, result, "葫芦", Sleep);

                result = mFairy.findPic(85,935,505,1065,"shuilinghu.png");
                mFairy.onTap(0.8f, result, 676,1090,683,1093,"水灵狐", Sleep);
                mFairy.onTap(0.8f, result, 380,957,390,966,"水灵狐1", 2000);
                mFairy.onTap(0.8f, result, 414,1210,422,1215,"水灵狐1", 2000);
                mFairy.onTap(0.8f, result, 224,880,228,893,"水灵狐1", 2000);
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(139,245,357,260,500, (long) 500,0);
                }

                result = mFairy.findPic(26,1028,465,1161,"yljyd.png");
                mFairy.onTap(0.8f, result, 538,1204,544,1208,"妖灵经验丹", Sleep);
                mFairy.onTap(0.8f, result, 103,273,114,285,"妖灵经验丹1", Sleep);
                mFairy.onTap(0.8f, result, 359,1095,370,1101,"妖灵经验丹2", Sleep);
                if (result.sim > 0.8f) {
                    gameUtil.close();
                }

                result = mFairy.findPic(157,235,616,418,"ltrk.png");
                mFairy.onTap(0.8f, result, 39,183,46,188,"真灵塔入口", Sleep);
                mFairy.onTap(0.8f, result, 558,655,566,664,"真灵塔入口", Sleep);

                result = mFairy.findPic(113,583,600,643,"jlklq.png");
                mFairy.onTap(0.8f, result, 524,815,535,820,"奖励可领取", Sleep);

                result = mFairy.findPic(155,1069,570,1265,"jrjz.png");
                mFairy.onTap(0.8f, result, "进入决战", Sleep);
                mFairy.onTap(0.8f, result, "进入决战", Sleep);

                result = mFairy.findPic(135,786,574,1004,"zd.png");
                mFairy.onTap(0.8f, result, "立即战斗", Sleep);

                result = mFairy.findPic(216,746,487,891,"yiyue.png");
                mFairy.onTap(0.8f, result, "已阅", Sleep);

                result = mFairy.findPic(274,356,441,538,new String[]{"dj.png","dj1.png","dj2.png"});
                mFairy.onTap(0.8f, result, "点击", Sleep);

                result = mFairy.findPic(94,201,527,348,"lingjie.png");
                mFairy.onTap(0.8f, result, 664,61,668,65,"灵阶", Sleep);
                mFairy.onTap(0.8f, result, 658,1221,668,1226,"灵阶", Sleep);

                result = mFairy.findPic(292,365,611,475,"yldk.png");
                mFairy.onTap(0.8f, result, 39,272,48,284,"渡口", Sleep);

                result = mFairy.findPic(50,572,447,684,"zldd.png");
                mFairy.onTap(0.8f, result, 622,477,627,482,"接取", Sleep);
                mFairy.onTap(0.8f, result, 197,1028,203,1036,"一键派遣", Sleep);
                mFairy.onTap(0.8f, result, 516,1029,525,1033,"出发", Sleep);

                result = mFairy.findPic(50,633,432,741,"ddwc.png");
                mFairy.onTap(0.8f, result, 610,481,620,490,"完成", Sleep);
                mFairy.onTap(0.8f, result, 610,481,620,490,"完成", Sleep);
                mFairy.onTap(0.8f, result, 69,1196,78,1203,"退出", Sleep);
                mFairy.onTap(0.8f, result, 69,1196,78,1203,"退出", Sleep);

                result = mFairy.findPic(26,564,490,712,"jieyige.png");
                mFairy.onTap(0.8f, result, 620,476,631,490,"接取", Sleep);
                mFairy.onTap(0.8f, result, 197,1028,203,1036,"一键派遣", Sleep);
                mFairy.onTap(0.8f, result, 516,1029,525,1033,"出发", Sleep);
                mFairy.onTap(0.8f, result, 620,476,631,490,"加速", Sleep);
                mFairy.onTap(0.8f, result, 620,476,631,490,"领取", Sleep);
                mFairy.onTap(0.8f, result, 69,1196,78,1203,"退出", Sleep);

                result = mFairy.findPic(47,556,503,696,"hybhl.png");
                mFairy.onTap(0.8f, result, 616,477,623,482,"接取", Sleep);
                mFairy.onTap(0.8f, result, 197,1028,203,1036,"一键派遣", Sleep);
                mFairy.onTap(0.8f, result, 516,1029,525,1033,"出发", Sleep);
                mFairy.onTap(0.8f, result, 69,1196,78,1203,"退出", Sleep);

                result = mFairy.findPic(145,940,605,1059,"yltp.png");
                mFairy.onTap(0.8f, result, 676,1083,682,1092,"菜单", Sleep);
                mFairy.onTap(0.8f, result, 370,953,379,959,"灵宠", Sleep);
                mFairy.onTap(0.8f, result, 99,273,105,279,"选择", Sleep);

                result = mFairy.findPic(44,1032,540,1165,"yltp.png");
                mFairy.onTap(0.8f, result, 643,1212,651,1224,"进化", Sleep);
                mFairy.onTap(0.8f, result, 351,1091,359,1097,"突破", 2000);
                mFairy.onTap(0.8f, result, 69,1196,78,1203,"退出", Sleep);
                mFairy.onTap(0.8f, result, 69,1196,78,1203,"退出", Sleep);
                mFairy.onTap(0.8f, result, 69,1196,78,1203,"退出", Sleep);
                mFairy.onTap(0.8f, result, 69,1196,78,1203,"退出", Sleep);

                result = mFairy.findPic(133,745,618,1065,new String[]{"tz.png","tz1.png"});
                mFairy.onTap(0.8f, result, "挑战", Sleep);

                result = mFairy.findPic(70,741,663,855,"jxtz.png");
                mFairy.onTap(0.8f, result, "继续挑战", Sleep);

            }

            //经验
            public void content_1() throws Exception {

            }

        }.taskContent(mFairy, "新手引导");
    }

    /**
     * 真灵塔
     */
    public void zlt() throws Exception {
        new SingleTask(mFairy) {

            public void inOperation() throws Exception {

                result = mFairy.findPic(623,885,699,1118,new String[]{"dialogue.png","dialogue1.png"});
                result1 = mFairy.findPic(559,1064,710,1147,"tiaoguo.png");
                result2 = mFairy.findPic(140,546,609,676,"xzdh.png");
                if (result.sim > 0.9f || result1.sim > 0.8f || result2.sim > 0.8f) {
                    mFairy.onTap(0.8f, result2, "选择对话", Sleep);
                    mFairy.onTap(0.9f, result, "对话", Sleep);
                    mFairy.onTap(0.8f, result1, "跳过", Sleep);
                    LtLog.e(mFairy.getLineInfo("对话中"));
                    mFairy.initMatTime();
                    err = 0;
                }
                result = mFairy.findPic(623,885,699,1118,new String[]{"dialogue.png","dialogue1.png"});
                mFairy.onTap(0.9f, result, "对话", Sleep);

                result = mFairy.findPic(236,762,508,858, "Pathfinding.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("寻路中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }

                result = mFairy.findPic("dutiao.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("读条中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(9,0))return;
                result =mFairy.findPic(7,131,180,520,"play.png");
                mFairy.onTap(0.8f,result,"玩法",Sleep);

                result =mFairy.findPic(203,1115,527,1248,"xyc.png");
                mFairy.onTap(0.8f,result,"下一作",Sleep);

                result =mFairy.findPic(192,931,537,1064,"jinta.png");
                mFairy.onTap(0.8f,result,"进塔",Sleep);

                result =mFairy.findPic(98,556,591,678,"klq.png");
                mFairy.onTap(0.8f,result,514,806,529,819,"前往领奖",Sleep);

                result = mFairy.findPic(478,197,676,755,"lingqu5.png");
                mFairy.onTap(0.8f, result, "领取", Sleep);

                result1 = mFairy.findPic(237,91,468,1076,new String[]{"guanqia.png","guanqia1.png"});
                result =mFairy.findPic(471,534,663,767,"zlt.png");
                if (result.sim > 0.8f || result1.sim > 0.8f){
                    mFairy.onTap(0.8f,result,"真灵塔前往",Sleep);
                    setTaskName(2);return;
                }


               /* result =mFairy.findPic(200,780,361,878,"ywc.png");
                if (result.sim > 0.8f){
                    LtLog.e("已完成");
                    mFairy.onTap(0.8f, result, 53,1231,60,1241,"宗门任务完成退出", Sleep);
                    setTaskEnd();return;
                }*/
            }
            public void content_2() throws Exception {

                long dazeTime = mFairy.mMatTime(11,110,45,16, 0.9f);
                LtLog.e("发呆时间=="+dazeTime);
                if (dazeTime > 20){
                    setTaskName(0);return;
                }

                result = mFairy.findPic(237,91,468,1076,new String[]{"guanqia.png","guanqia1.png"});
                mFairy.onTap(0.8f, result, "关卡选择", Sleep);

                result = mFairy.findPic(218,1161,513,1272,"pk.png");
                mFairy.onTap(0.8f, result, "战斗", Sleep);



                result = mFairy.findPic(478,197,676,755,new String[]{"lingqu3.png","lingqu7.png"});
                mFairy.onTap(0.8f, result, "领取", Sleep);

                result =mFairy.findPic(152,992,647,1173,"tsyx.png");
                result1 =mFairy.findPic(45,539,673,712,"dytjpf.png");
                if (result.sim > 0.8f || result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result1, 179,789,195,794,"低于推荐评分", Sleep);
                    mFairy.onTap(59,1222,68,1238,"失败退出", Sleep);
                    LtLog.e("已完成");
                    setTaskEnd();return;
                }
                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e("回合中");
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);
                    mFairy.initMatTime();
                }

            }

        }.taskContent(mFairy, "真灵塔");
    }

    /**
     * 宗门任务
     */
    public void zmrw() throws Exception {
        new SingleTask(mFairy) {

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

                result = mFairy.findPic("dutiao.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("读条中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(9,0))return;
                result =mFairy.findPic(7,131,180,520,"play.png");
                mFairy.onTap(0.8f,result,"玩法",Sleep);

                result =mFairy.findPic(213,632,469,860,"zmrw.png");
                mFairy.onTap(0.8f,result,"宗门任务",Sleep);

                result =mFairy.findPic(238,611,458,1069,"qw.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,"前往",Sleep);
                    setTaskName(2);return;
                }

                result =mFairy.findPic(200,780,361,878,"ywc.png");
                if (result.sim > 0.8f){
                    LtLog.e("已完成");
                    mFairy.onTap(0.8f, result, 53,1231,60,1241,"宗门任务完成退出", Sleep);
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(11,110,45,16, 0.9f);
                LtLog.e("发呆时间=="+dazeTime);

                if (dazeTime > 5){
                    result =mFairy.findPic(221,967,546,1053,"zmrws.png");
                    result1 =mFairy.findPic(489,184,709,419,"zmrws1.png");
                    if (result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"宗门任务下",Sleep);
                    }else{
                        mFairy.onTap(0.8f,result1,"宗门任务右",Sleep);
                    }
                }
                if (dazeTime > 20){
                    setTaskName(0);return;
                }
                result =mFairy.findPic(167,853,569,969,"zmrw1.png");
                mFairy.onTap(0.8f,result,"宗门任务1",Sleep);

                result =mFairy.findPic(149,282,616,545,"zmrw2.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 59,1222,68,1238,"宗门任务完成", Sleep);
                    LtLog.e("已完成");
                    setTaskEnd();return;
                }
                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e("回合中");
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);
                    mFairy.initMatTime();
                }

            }
            public void content_3() throws Exception {
                if (overtime(6,2))return;

            }
        }.taskContent(mFairy, "宗门任务");
    }

    /**
     * 奖励
     */
    public void reward() throws Exception {
        new SingleTask(mFairy) {

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }

            public void content_2() throws Exception {
                if (overtime(9,3))return;

                result =mFairy.findPic(5,135,188,592,"shouyi2.png");
                mFairy.onTap(0.8f,result,"收益",1000);

                result =mFairy.findPic(8,61,263,144,"juling1.png");
                if (result.sim>0.8f){
                    LtLog.e("聚灵页面");
                    mFairy.onTap(0.8f,result,336,479,347,486,"聚灵",Sleep);
                    err=0;
                }
                result1 =mFairy.findPic(131,340,622,461,"myjl.png");
                result =mFairy.findPic(144,250,579,404,"gxhd1.png");
                if (result.sim>0.8f || result1.sim>0.8f){
                    LtLog.e("恭喜获得");
                    err=0;
                    mFairy.onTap(0.8f,result,74,1189,82,1198,"恭喜获得",Sleep);
                    gameUtil.close();
                    setTaskName(4);
                }

            }
            public void content_3() throws Exception {
                if (overtime(9,4)){
                    gameUtil.close();
                    return;
                }

                result =mFairy.findPic(209,1103,708,1272,"shouyi1.png");
                mFairy.onTap(0.8f,result,"收益",Sleep);

                result =mFairy.findPic(537,405,705,1004,"lingqu.png");
                if (result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f,result,"领取",1000);
                    mFairy.onTap(0.8f,result,74,1189,82,1198,"恭喜获得",Sleep);
                }else{
                    result =mFairy.findPic(209,1103,708,1272,"juling.png");
                    if (result.sim>0.8f){
                        err=0;
                        mFairy.onTap(0.8f,result,"聚灵",Sleep);
                        setTaskName(4);
                    }
                }
            }
            public void content_4() throws Exception {
                if (overtime(8,5)){
                    gameUtil.close();
                    return;
                }
                result =mFairy.findPic(620,417,714,830,"shouce.png");
                mFairy.onTap(0.8f,result,"手册",1000);

                result =mFairy.findPic(509,491,684,1151,new String[]{"lingqu3.png","lingqu6.png"});
                result1 =mFairy.findPic(79,447,126,1149,"hongdian.png");
                if (result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f,result,"领取",Sleep);
                }else if (result1.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f,result1,"红点",Sleep);
                }else{
                    gameUtil.close();
                    setTaskName(5);
                }

            }
            public void content_5() throws Exception {
                if (overtime(8, 6)){}

                result = mFairy.findPic(628, 1041, 714, 1129, "caidan.png");
                mFairy.onTap(0.8f, result, "菜单", Sleep);

                result = mFairy.findPic(126, 1004, 638, 1115, "fuli.png");
                mFairy.onTap(0.8f, result, "福利", Sleep);

                result = mFairy.findPic(109,1163,446,1277, "fuli1.png");
                mFairy.onTap(0.8f, result, "福利1", Sleep);

                result = mFairy.findPic(225,1010,489,1185, "degnlu.png");
                mFairy.onTap(0.8f, result, "登录礼", Sleep);

                result = mFairy.findPic(8, 568, 715, 1070, new String[]{"lingqu2.png","lingqu3.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "领取", Sleep);
                    err=0;
                }
            }
            public void content_6() throws Exception {
                if (overtime(8, 7)) {
                    setTaskName(7);
                    return;
                }
                result = mFairy.findPic(628, 1041, 714, 1129, "caidan.png");
                mFairy.onTap(0.8f, result, "菜单", Sleep);

                result = mFairy.findPic(126, 1004, 638, 1115, "fuli.png");
                mFairy.onTap(0.8f, result, "福利", Sleep);

                result = mFairy.findPic(109,1163,446,1277, "fuli1.png");
                mFairy.onTap(0.8f, result, "福利1", Sleep);

                result = mFairy.findPic(225,1010,489,1185, "dengji.png");
                mFairy.onTap(0.8f, result, "等级", Sleep);


                result = mFairy.findPic(205,926,535,1021, new String[]{ "lingqu1.png", "lingqu.png"});
                result1 = mFairy.findPic(124,23,713,70, "hongdian1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "领取", Sleep);
                    err=0;
                }else if (result1.sim>0.8f){
                    mFairy.onTap(0.8f, result1, "领取", Sleep);
                }else {
                    setTaskName(7);
                    return;
                }

                result1 = mFairy.findPic(172,344,536,446, "djbz.png");
                if (result.sim > 0.8f) {
                    setTaskName(7);
                }

            }
            public void content_7() throws Exception {
                if (overtime(8, 99)) {
                    gameUtil.close();
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(628, 1041, 714, 1129, "caidan.png");
                mFairy.onTap(0.8f, result, "菜单", Sleep);

                result = mFairy.findPic(126, 1004, 638, 1115, "fuli.png");
                mFairy.onTap(0.8f, result, "福利", Sleep);

                result = mFairy.findPic(109,1163,446,1277, "zhaohui.png");
                mFairy.onTap(0.8f, result, "找回", Sleep);

                result = mFairy.findPic(504,510,698,1229, new String[]{ "lingqu4.png", "lingqu.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "领取", Sleep);
                    err=0;
                }

                result =mFairy.findPic(448,524,709,803,"shiyong.png");
                mFairy.onTap(0.8f,result,"err使用",Sleep);

            }
        }.taskContent(mFairy, "奖励日常");
    }

    /**
     * 寻宝罗盘
     */
    public void xblp() throws Exception {
        new SingleTask(mFairy) {

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

                result = mFairy.findPic("dutiao.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("读条中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result =mFairy.findPic(7,131,180,520,"play.png");
                mFairy.onTap(0.8f,result,"玩法",Sleep);

                result =mFairy.findPic(398,800,629,1050,"xblp.png");
                mFairy.onTap(0.8f,result,"寻宝罗盘",Sleep);

                result =mFairy.findPic(238,611,458,1069,"qw.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,"前往",Sleep);
                    setTaskName(2);return;
                }

                result =mFairy.findPic(200,780,361,878,"ywc.png");
                if (result.sim > 0.8f){
                    LtLog.e("已完成");
                    mFairy.onTap(0.8f, result, 53,1231,60,1241,"宗门任务完成退出", Sleep);
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(11,110,45,16, 0.9f);
                LtLog.e("发呆时间=="+dazeTime);

                if (dazeTime > 5){
                    result =mFairy.findPic(221,967,546,1053,"xblp1.png");
                    result1 =mFairy.findPic(489,184,709,419,"xblp2.png");
                    if (result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"寻宝罗盘下",Sleep);
                    }else{
                        mFairy.onTap(0.8f,result1,"寻宝罗盘右",Sleep);
                    }
                }
                if (dazeTime > 20){
                    setTaskName(0);return;
                }


                result =mFairy.findPic(149,282,616,545,"zmrw2.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 59,1222,68,1238,"寻宝罗盘完成", Sleep);
                    LtLog.e("已完成");
                    setTaskEnd();return;
                }
                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e("回合中");
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);
                    mFairy.initMatTime();
                }

            }
            public void content_3() throws Exception {
                if (overtime(6,2))return;

            }
        }.taskContent(mFairy, "寻宝罗盘任务");
    }

    /**
     * 宗门竞技
     */
    public void zmjj() throws Exception {
        new SingleTask(mFairy) {

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

                result = mFairy.findPic("dutiao.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("读条中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(15,0))return;
                result =mFairy.findPic(7,131,180,520,"play.png");
                mFairy.onTap(0.8f,result,"玩法",Sleep);

                result =mFairy.findPic(46,905,247,1098,"zmjj.png");
                mFairy.onTap(0.8f,result,"宗门竞技",Sleep);

                /*result =mFairy.findPic(213,3,503,78,"zmjj1.png");
                if (result.sim > 0.8f){
                    LtLog.e("宗门竞技中");
                    setTaskName(2);return;
                }*/

                result =mFairy.findPic(260,586,495,689,"tz2.png");
                mFairy.onTap(0.8f,result,"挑战",Sleep);

                result =mFairy.findPic(211,1170,510,1264,"zhandou.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);

                result =mFairy.findPic(213,632,469,860,"jxtz1.png");
                mFairy.onTap(0.8f,result,"继续挑战",Sleep);

                result =mFairy.findPic(16,456,701,876,"qwlq.png");
                mFairy.onTap(0.8f,result,"前往领取",Sleep);

                result = mFairy.findPic(504,510,698,1229, new String[]{ "lingqu4.png", "lingqu.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "领取", Sleep);
                    err=0;
                }

                result =mFairy.findPic(448,524,709,803,"shiyong.png");
                mFairy.onTap(0.8f,result,"err使用",Sleep);

                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e("回合中");
                    err=0;
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);
                    mFairy.initMatTime();
                }
                result =mFairy.findPic(58,976,221,1112,"ywc.png");
                result1 =mFairy.findPic(664,897,687,927,"4.png");
                result2 =mFairy.findPic(235,5,492,72,"zmjj2.png");
                if (result.sim > 0.8f || (result1.sim > 0.8f && result2.sim > 0.8f)){
                    LtLog.e("已完成");
                    mFairy.onTap(0.8f, result, 53,1231,60,1241,"宗门任务完成退出", Sleep);
                    gameUtil.close();
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "宗门竞技任务");
    }

    /**
     * 御灵道场
     */
    public void yldc() throws Exception {
        new SingleTask(mFairy) {

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

                result = mFairy.findPic("dutiao.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("读条中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(9,0))return;
                result =mFairy.findPic(7,131,180,520,"play.png");
                mFairy.onTap(0.8f,result,"玩法",Sleep);

                result =mFairy.findPic(604,250,716,477,"yldc.png");
                mFairy.onTap(0.8f,result,"御灵道场",Sleep);

                result =mFairy.findPic(3,5,174,91,"yldc1.png");
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }

                result =mFairy.findPic(627,423,717,476,"ywc.png");
                if (result.sim > 0.8f){
                    LtLog.e("已完成");
                    mFairy.onTap(0.8f, result, 53,1231,60,1241,"御灵道场完成退出", Sleep);
                    setTaskEnd();return;
                }
            }
            int n=0;
            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(11,110,45,16, 0.9f);
                LtLog.e("发呆时间=="+dazeTime);

                result =mFairy.findPic(4,92,178,157,"3c.png");
                if (result.sim > 0.8f) {
                    gameUtil.close();
                    LtLog.e("御灵道场任务完成");
                    setTaskEnd();return;
                }

                result =mFairy.findPic(2,5,155,89,"yldc1.png");
                if (result.sim > 0.8f){
                    LtLog.e("御灵道场中");
                    if (dazeTime > 5){
                        if (AtFairyConfig.getOption("4xtz").equals("1")){
                            result1 =mFairy.findPic(300,331,346,363,"4x.png");
                            result2 =mFairy.findPic(614,334,665,371,"4x.png");
                            result3 =mFairy.findPic(301,712,344,745,"4x.png");
                            result4 =mFairy.findPic(617,718,661,752,"4x.png");
                            if (result1.sim > 0.8f) {
                                result =mFairy.findPic(result1.x-232,result1.y+109,result1.x+13,result1.y+226,"ywc1.png");
                                if (result.sim > 0.8f) {
                                    n=1;
                                }else{
                                    n=0;
                                    mFairy.onTap(0.8f, result1, "4星邀约1", Sleep);
                                }
                            }else if (result2.sim > 0.8f) {
                                result =mFairy.findPic(result2.x-232,result2.y+109,result2.x+13,result2.y+226,"ywc1.png");
                                if (result.sim > 0.8f) {
                                    n=1;
                                }else{
                                    n=0;
                                    mFairy.onTap(0.8f, result2, "4星邀约2", Sleep);
                                }
                            }else if (result3.sim > 0.8f) {
                                result =mFairy.findPic(result3.x-232,result3.y+109,result3.x+13,result3.y+226,"ywc1.png");
                                if (result.sim > 0.8f) {
                                    n=1;
                                }else{
                                    n=0;
                                    mFairy.onTap(0.8f, result3, "4星邀约3", Sleep);
                                }
                            }else if (result4.sim > 0.8f) {
                                result =mFairy.findPic(result4.x-232,result4.y+109,result4.x+13,result4.y+226,"ywc1.png");
                                if (result.sim > 0.8f) {
                                    n=1;
                                }else{
                                    n=0;
                                    mFairy.onTap(0.8f, result4, "4星邀约3", Sleep);

                                }
                            }else{
                                result =mFairy.findPic(552,55,692,172,"shuaxin.png");
                                mFairy.onTap(0.8f,result,"刷新",2000);
                            }

                            if (n==1) {
                                result =mFairy.findPic(552,55,692,172,"shuaxin.png");
                                mFairy.onTap(0.8f,result,"刷新",2000);
                                n=0;
                            }
                        }else{
                            result1 =mFairy.findPic(66,217,346,574,new String[]{"tzyy.png","tzyy1.png","tzyy2.png"});
                            result2 =mFairy.findPic(66,217,346,574,"ywc1.png");
                            if (result1.sim > 0.8f && result2.sim < 0.8f) {
                                mFairy.onTap(0.8f, result1, "4星邀约1", 2000);
                            }else{
                                result1 =mFairy.findPic(378,217,656,575,new String[]{"tzyy.png","tzyy1.png","tzyy2.png"});
                                result2 =mFairy.findPic(378,217,656,575,"ywc1.png");
                                if (result1.sim > 0.8f && result2.sim < 0.8f) {
                                    mFairy.onTap(0.8f, result1, "4星邀约2", 2000);
                                }else{
                                    result1 =mFairy.findPic(47,593,360,964,new String[]{"tzyy.png","tzyy1.png","tzyy2.png"});
                                    result2 =mFairy.findPic(47,593,360,964,"ywc1.png");
                                    if (result1.sim > 0.8f && result2.sim < 0.8f) {
                                        mFairy.onTap(0.8f, result1, "4星邀约3", 2000);
                                    }else{
                                        result1 =mFairy.findPic(380,602,654,955,new String[]{"tzyy.png","tzyy1.png","tzyy2.png"});
                                        result2 =mFairy.findPic(380,602,654,955,"ywc1.png");
                                        if (result1.sim > 0.8f && result2.sim < 0.8f) {
                                            mFairy.onTap(0.8f, result1, "4星邀约4", 2000);
                                        }else{
                                            result =mFairy.findPic(552,55,692,172,"shuaxin.png");
                                            mFairy.onTap(0.8f,result,"刷新",2000);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                result =mFairy.findPic(154,743,539,1033,"tz.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f,result,"挑战",Sleep);
                    mFairy.initMatTime();
                }

                if (dazeTime > 10 && dazeTime < 30){
                    result =mFairy.findPic(218,967,555,1052,"yldc2.png");
                    mFairy.onTap(0.8f,result,"御灵道场任务",2000);
                }

                if (dazeTime > 30){
                    LtLog.e("发呆时间"+dazeTime);
                    setTaskName(0);return;
                }


                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e("回合中");
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);
                    mFairy.initMatTime();
                }

                result =mFairy.findPic(73,590,639,835,"sfxh.png");
                mFairy.onTap(0.8f,result,522,792,533,799,"消耗几分",Sleep);

                result =mFairy.findPic(154,743,539,1033,"tz.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f,result,"挑战",Sleep);
                    mFairy.initMatTime();
                }
                result =mFairy.findPic(24,434,697,917,"ndjg.png");
                mFairy.onTap(0.8f,result,524,815,530,820,"难度较高重新开始",Sleep);

                result =mFairy.findPic(181,1164,558,1276,"zhandou.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);

                LtLog.e("n="+n);

                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e("回合中");
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);
                    mFairy.initMatTime();
                }

            }
        }.taskContent(mFairy, "御灵道场任务");
    }

    /**
     * 妖灵秘境
     */
    public void ylmj() throws Exception {
        new SingleTask(mFairy) {

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

                result = mFairy.findPic("dutiao.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("读条中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(9,0))return;
                result =mFairy.findPic(7,131,180,520,"play.png");
                mFairy.onTap(0.8f,result,"玩法",Sleep);

                result =mFairy.findPic(114,1111,707,1266,"tiaozhan.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,"挑战",Sleep);
                    result =mFairy.findPic(505,160,714,349,"ywc.png");
                    if (result.sim > 0.8f){
                        LtLog.e("已完成");
                        mFairy.onTap(0.8f, result, 53,1231,60,1241,"宗门任务完成退出", Sleep);
                        setTaskEnd();return;
                    }
                }


                result =mFairy.findPic(489,126,715,372,"ylmj.png");
                mFairy.onTap(0.8f,result,"妖灵秘境",Sleep);

                result1 =mFairy.findPic(220,945,493,1051,new  String[]{"sdz.png","sd.png"});
                result =mFairy.findPic(238,611,458,1069,"qw.png");
                if (result.sim > 0.8f || result1.sim > 0.8f){
                    mFairy.onTap(0.8f,result,"前往",Sleep);
                    setTaskName(2);return;
                }

                result =mFairy.findPic(505,160,714,349,"ywc.png");
                if (result.sim > 0.8f){
                    LtLog.e("已完成");
                    mFairy.onTap(0.8f, result, 53,1231,60,1241,"宗门任务完成退出", Sleep);
                    setTaskEnd();return;
                }
            }
            int n=0;
            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(11, 110, 45, 16, 0.9f);
                LtLog.e("发呆时间==" + dazeTime);

                if (dazeTime > 30) {
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic(192, 972, 568, 1127, "jrmj.png");
                mFairy.onTap(0.8f, result, "进入秘境", Sleep);

                result = mFairy.findPic(62, 825, 677, 979, "guanbi.png");
                mFairy.onTap(0.8f, result, "关闭", Sleep);

                result = mFairy.findPic(62, 825, 677, 979, "guanbi.png");
                mFairy.onTap(0.8f, result, "关闭", Sleep);


                result = mFairy.findPic(123, 361, 587, 464, "manji.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(239, 953, 485, 1053, "sdz.png");
                    mFairy.onTap(0.8f, result, "停止扫荡", 3000);

                    result = mFairy.findPic(492, 143, 708, 342, "bz.png");
                    mFairy.onTap(0.8f, result, "布阵", 3000);

                    result = mFairy.findPic(25, 821, 147, 971, "gou.png");
                    result1 = mFairy.findPic(210, 3, 536, 44, "czjm.png");
                    if (result.sim > 0.8f && result1.sim > 0.8f) {
                        mFairy.onTap(214, 875, 223, 887, "第二个", 3000);
                        mFairy.onTap(59, 1216, 71, 1222, "退出布阵", 3000);
                    } else if (result.sim < 0.8f && result1.sim > 0.8f) {
                        mFairy.onTap(82, 879, 88, 889, "第一个", 3000);
                        mFairy.onTap(59, 1216, 71, 1222, "退出布阵", 3000);
                    }
                    n++;
                } else {
                    result = mFairy.findPic(220, 945, 493, 1051, "sd.png");
                    mFairy.onTap(0.8f, result, "扫荡", Sleep);
                }

                result = mFairy.findPic(192, 972, 568, 1127, "jrmj.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 59, 1222, 68, 1238, "宗门任务完成", Sleep);
                    LtLog.e("已完成");
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic(56, 555, 669, 885, "lldd.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, 181, 812, 198, 823, "历练点底取消", Sleep);
                    n=3;
                }

                result = mFairy.findPic(494,186,701,336, "0.png");
                if (n>=2 || result.sim > 0.8f) {
                    LtLog.e("两个满级");
                    result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                    if (result.sim > 0.8f) {
                        LtLog.e("回合中准备退出");
                        result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                        result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                        mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);
                        mFairy.initMatTime();
                    }else{
                        result =mFairy.findPic(220,945,493,1051, "sdz.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, "取消扫荡", Sleep);
                        }
                        gameUtil.close();
                        setTaskEnd();return;
                    }

                }

                result =mFairy.findPic(220,945,493,1051, "sdz.png");
                if (result.sim > 0.8f) {
                    LtLog.e("扫荡中");
                    mFairy.initMatTime();
                }
                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(2,4,96,106,"wyl.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "无妖灵点击", 3000);

                        result = mFairy.findPic(25, 821, 147, 971, "gou.png");
                        result1 = mFairy.findPic(210, 3, 536, 44, "czjm.png");
                        if (result.sim > 0.8f && result1.sim > 0.8f) {
                            mFairy.onTap(214, 875, 223, 887, "第二个", 3000);
                            mFairy.onTap(59, 1216, 71, 1222, "退出布阵", 3000);
                        } else if (result.sim < 0.8f && result1.sim > 0.8f) {
                            mFairy.onTap(82, 879, 88, 889, "第一个", 3000);
                            mFairy.onTap(59, 1216, 71, 1222, "退出布阵", 3000);
                        }
                        n++;
                    }
                }
                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e("回合中");
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);
                    mFairy.initMatTime();
                }

            }

        }.taskContent(mFairy, "妖灵秘境任务");
    }

    /**
     * 妖灵渡口
     */
    public void yldk() throws Exception {
        new SingleTask(mFairy) {

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

                result = mFairy.findPic("dutiao.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("读条中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
            }
            int js=0,js1;
            String[] str = {};
            public void content_0() throws Exception {
                gameUtil.close();
                if (AtFairyConfig.getOption("shangpin").equals("1")){
                    str= new String[]{"gupin.png", "zhenpin.png", "shangpin.png"};
                }
                if (AtFairyConfig.getOption("zhenpin").equals("1")){
                    str= new String[]{"gupin.png", "zhenpin.png"};
                }
                if (AtFairyConfig.getOption("gupin").equals("1")){
                    str= new String[]{"gupin.png"};
                }
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(20,0))return;
                result =mFairy.findPic(5,135,188,592,"shouyi2.png");
                mFairy.onTap(0.8f,result,"收益",1000);

                result =mFairy.findPic(209,1103,708,1272,"shouyi1.png");
                mFairy.onTap(0.8f,result,"收益",Sleep);

                result =mFairy.findPic(537,405,705,1004,"lingqu.png");
                if (result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f,result,"领取",1000);
                    mFairy.onTap(0.8f,result,74,1189,82,1198,"恭喜获得",Sleep);
                    err=0;
                }

                result =mFairy.findPic(5,60,187,139,"yldkz.png");
                if (result.sim > 0.8f){
                    LtLog.e("妖灵渡口中");
                        if (AtFairyConfig.getOption("shangpin").equals("1") || AtFairyConfig.getOption("zhenpin").equals("1") || AtFairyConfig.getOption("gupin").equals("1")){
                            result1 =mFairy.findPic(14,400,158,996,str);
                            result2 =mFairy.findPic(21,567,140,710,str);
                            result3 =mFairy.findPic(16,694,137,824,str);
                            if (result1.sim > 0.8f) {
                                result =mFairy.findPic(result1.x+499,result1.y-3,result1.x+635,result1.y+76,"jiequ1.png");
                                if (result.sim > 0.8f) {
                                    mFairy.onTap(0.8f, result, "接取1", Sleep);
                                    err=0;
                                }
                            }
                            if (result2.sim > 0.8f) {
                                result =mFairy.findPic(result2.x+499,result2.y-3,result2.x+635,result2.y+76,"jiequ1.png");
                                if (result.sim > 0.8f) {
                                    mFairy.onTap(0.8f, result, "接取2", Sleep);
                                }
                            }
                            if (result3.sim > 0.8f) {
                                result =mFairy.findPic(result3.x+499,result3.y-3,result3.x+635,result3.y+76,"jiequ1.png");
                                if (result.sim > 0.8f) {
                                    mFairy.onTap(0.8f, result, "接取3", Sleep);
                                }
                            }
                            js1++;
                            LtLog.e("计数"+js1);
                        }else{
                            LtLog.e("随机寻找");
                            result =mFairy.findPic(537,391,692,1022,"jiequ1.png");
                            if (result.sim > 0.8f) {
                                mFairy.onTap(0.8f, result, "接取随机", 2000);
                            }else{
                                js1++;
                            }
                        }
                        result =mFairy.findPic(134,629,590,744,"shouqu.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, "收取", 3000);
                            mFairy.onTap(0.8f, result, 347,475,361,490,"收取", 2000);
                            js++;
                            err=0;
                        }

                        if (js1>=3){
                            mFairy.taskSlid(err, new int[]{0,2,4,6,8,10,12,14,16}, 0, 376,933, 363,501, 1000, 1500,2);
                        }

                        if (js1>=5){
                            result =mFairy.findPic(208,995,504,1113,new String[]{"ylsx.png","mfsx.png"});
                            mFairy.onTap(0.8f,result,"刷新",1000);
                            js1=0;
                            err=0;
                        }
                    }

                result =mFairy.findPic(147,355,588,439,"myjl.png");
                result1 =mFairy.findPic(208,358,520,440,"bnjq.png");
                if (result.sim > 0.8f || result1.sim > 0.8f || js>=2) {
                    LtLog.e("不能接取或没有能量");
                    js=0;
                    js1=0;
                    gameUtil.close();
                    setTaskEnd();return;

                }

                result =mFairy.findPic(59,943,683,1088,"yjpq.png");
                mFairy.onTap(0.8f,result,"一键派遣",2000);
                mFairy.onTap(0.8f,result,512,1032,522,1039,"出发",2000);

            }
        }.taskContent(mFairy, "妖灵渡口任务");
    }

    /**
     * 钟馗追鬼
     */
    public void zkzg() throws Exception {
        new SingleTask(mFairy) {
            int cishu=0;
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

                result = mFairy.findPic("dutiao.png");
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("读条中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(10,0))return;

                result =mFairy.findPic(7,131,180,520,"play.png");
                mFairy.onTap(0.8f,result,"玩法",Sleep);

                if (AtFairyConfig.getOption("10c").equals("1") || AtFairyConfig.getOption("60c").equals("")){
                    result =mFairy.findPic(333,307,494,552,"ywc.png");
                    if (result.sim > 0.8f){
                        LtLog.e("已完成10次");
                        setTaskEnd();return;
                    }
                    result =mFairy.findPic(350,324,500,526,"zkzg.png");
                    mFairy.onTap(0.8f,result,"钟馗追鬼10",Sleep);
                }

                if (AtFairyConfig.getOption("60c").equals("1")){
                    result =mFairy.findPic(360,293,527,523,"zkzg60.png");
                    mFairy.onTap(0.8f,result,403,414,409,422,"钟馗追鬼",2000);
                }

                result =mFairy.findPic(238,611,458,1069,"qw.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,"前往",Sleep);
                    cishu++;
                    LtLog.e("第——"+cishu+"次钟馗捉鬼");
                    setTaskName(2);return;
                }

                if (cishu>=13){
                    LtLog.e("已完成60次");
                    setTaskEnd();return;
                }

                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e("回合中");
                    err=0;
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);
                    mFairy.initMatTime();
                    setTaskName(2);return;
                }
            }
            int sum=0;
            public void content_2() throws Exception {
                if (overtime(20,0))return;

                result =mFairy.findPic(192,963,560,1130,"jsrw.png");
                mFairy.onTap(0.8f,result,"接受任务",1000);

                result =mFairy.findPic(188,883,521,1065,"gb.png");
                mFairy.onTap(0.8f,result,"关闭",1000);

                result =mFairy.findPic(32,426,684,809,"wczkzg.png");
                if (result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f,result,182,739,198,756,"取消",1000);
                    mFairy.initMatTime();
                    setTaskName(1);return;
                }

                result =mFairy.findPic(159,605,566,860,new String[]{"zddt.png","zmdy.png"});
                if (result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f,result,"组队大厅/招募队友",2000);
                    mFairy.initMatTime();
                    setTaskName(3);return;
                }

                result = mFairy.findPic(225,0,498,68,"huihezhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e("回合中");
                    err=0;
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    result = mFairy.findPic(190,832,714,1271,new String[]{"bh.png","fy.png","zhaoshi1.png"});
                    mFairy.onTap(0.8f, result, 657,1216,664,1223,"自动战斗", Sleep);
                    mFairy.initMatTime();
                    result = mFairy.findPic(548,17,715,136, new String[]{"zk.png","zk1.png"});
                    if (result.sim > 0.8f) {
                        LtLog.e("钟馗中");
                        sum++;
                    }
                    LtLog.e("sum===="+sum);
                }
            }
            public void content_3() throws Exception {
                if (overtime(9,0))return;
                result =mFairy.findPic(2,265,716,394,"zkzg2.png");
                result1 =mFairy.findPic(6,320,171,1017,"duiwu.png");
                if (result.sim>0.8f || result1.sim>0.8f){
                    LtLog.e("组队页面");
                    err=0;
                }

                result =mFairy.findPic(6,320,171,1017,"zkzgzd.png");
                mFairy.onTap(0.8f,result,"钟馗追鬼目标",1000);

                result =mFairy.findPic(176,1112,710,1212,"cjdw.png");
                mFairy.onTap(0.8f,result,"创建队伍",1000);

                result =mFairy.findPic(217,803,505,950,"zhaomu.png");
                mFairy.onTap(0.8f,result,"招募",1000);

                result =mFairy.findPic(2,265,716,394,"zhaomu1.png");
                mFairy.onTap(0.8f,result,"招募1",1000);

                result =mFairy.findPic(77,563,661,871,"zkzg1.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,509,795,522,802,"捉鬼开始",1000);
                    setTaskName(2);return;
                }
            }
        }.taskContent(mFairy, "钟馗追鬼任务");
    }

    /**
     *
     * 千骸之墓
     */
    public void towerThroneszm() throws Exception {
        new SingleTask(mFairy) {
            int wzcs =0;
            boolean bd1 =false;
            boolean bd2 =false;
            boolean bd3 =false;
            boolean bd4 =false;
            boolean bd5 =false;
            boolean bd6 =false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("tupabd").equals("1")){
                    bd1=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("2")){
                    bd2=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("3")){
                    bd3=true;

                }
                if (AtFairyConfig.getOption("tupabd").equals("4")){
                    bd4=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("5")){
                    bd5=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("6")){
                    bd6=true;
                }
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        wzcs=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定次数默认为一次");
                        wzcs =1 ;
                    }
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(6);
            }
            public void content_6() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic("Thousand bones.png");
                mFairy.onTap(0.8f,result,"千骸之墓",500);
                result =mFairy.findPic("nointo.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启千骸之墓结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic("week4.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启千骸之墓结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",500);
                result =mFairy.findPic("notz.png");
                if (result.sim >0.8f){
                    LtLog.e("每天只能打10层结束");
                    setTaskEnd();return;
                }

                if (bd1){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",500);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd1=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd2){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd2=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd3){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd3=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd4){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd4=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd5){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd5=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd6){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd6=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }
                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs --;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        setTaskEnd();return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);

                result =mFairy.findPic("check.png");
                mFairy.onTap(0.8f,result,467,835,477,846,"战斗校验失败确定",Sleep);


            }
        }.taskContent(mFairy, "千骸之墓");
    }


}

