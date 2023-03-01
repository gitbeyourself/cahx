package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2023/2/15.
 */

public class Abnormal extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    public Abnormal(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
    }
    String task_id= AtFairyConfig.getOption("task_id");
    //全局处理
    public void erro() throws Exception {

        result =mFairy.findPic(348,1119,701,1269,"xyty.png");
        mFairy.onTap(0.8f,result,"err协议同意",Sleep);

        result =mFairy.findPic(267,431,464,504,"zuyq.png");
        mFairy.onTap(0.8f,result,186,765,195,776,"err组队邀请",Sleep);

        result =mFairy.findPic(448,524,709,803,"shiyong.png");
        mFairy.onTap(0.8f,result,"err使用",Sleep);

        result =mFairy.findPic(206,666,520,760,"bddl.png");
        mFairy.onTap(0.9f,result,255,711,259,715,"err本次登录不再提示",Sleep);

        result =mFairy.findPic(218,672,515,801,"queding.png");
        mFairy.onTap(0.8f,result,"err确定",Sleep);

        result = mFairy.findPic(139,821,582,1137,"checkvx.png");
        if (result.sim > 0.8f) {

            switch (AtFairyConfig.getOption("dl")) {
                case "1":
                    mFairy.onTap(0.8f, result, 351,915,372,934, "errvx登录界面_QQ登录", Sleep);
                    break;
                case "2":
                    mFairy.onTap(0.8f, result, 363,1054,373,1063,"errvx登录界面_微信登录", Sleep);
                    break;
            }
        }

        result = mFairy.findPic(10,1007,701,1219,"Authorized.png");
        mFairy.onTap(0.8f, result, "errqq完成授權", Sleep);

        result = mFairy.findPic(new String[]{"login.png", "login2.png", "login3.png"});
        mFairy.onTap(0.8f, result, "err新版qq登陆", Sleep);

        result = mFairy.findPic(444, 846, 598, 991, "sure.png");
        mFairy.onTap(0.8f, result, "err新版qq隐私政策同意", Sleep);

        result = mFairy.findPic("authorization.png");
        mFairy.onTap(0.8f, result, "err新版qq授权", Sleep);

        result = mFairy.findPic(new String[]{"login.png", "login2.png", "login3.png"});
        mFairy.onTap(0.8f, result, "err新版qq登陆", Sleep);

        result = mFairy.findPic(219, 850, 512, 1114, "checkvx3.png");
        mFairy.onTap(0.8f, result, "errqq登录角色", Sleep);

        result = mFairy.findPic(219, 850, 512, 1114, "checkvx4_1.png");
        mFairy.onTap(0.8f, result, "errqq登录角色", Sleep);

        result = mFairy.findPic(160, 656, 525, 1233, "qqlogn.png");
        mFairy.onTap(0.8f, result, "errqq登录角色1", Sleep);

        result = mFairy.findPic(151,1066,570,1208,"read.png");
        mFairy.onTap(0.8f, result, 206,1173,209,1177,"err协议阅读并同意", Sleep);

        result = mFairy.findPic(151,1066,570,1208,"trca.png");
        mFairy.onTap(0.8f, result, "err踏入长安", Sleep);

        result = mFairy.findPic(25,770,700,1147,"hmsz.png");
        mFairy.onTap(0.8f, result, 88,967,98,969,"err省电", Sleep);
        mFairy.onTap(0.8f, result, 352,1069,366,1074,"err画面省电确定", Sleep);

        result = mFairy.findPic(204,1101,514,1229, "jrca.png");
        mFairy.onTap(0.8f, result, "err进入长安", Sleep);

        result = mFairy.findPic(74,577,636,646, "cangku.png");
        mFairy.onTap(0.8f, result, 173,813,191,826,"err仓库取消", Sleep);

        result = mFairy.findPic(177,785,531,1255,new String[]{"kbc1.png","kbc.png","kbc2.png"});
        mFairy.onTap(0.8f, result, 683,34,688,44,"点击空白处", Sleep);

        result = mFairy.findPic(244,699,469,944,"hand.png");
        mFairy.onTap(0.8f, result, "手", Sleep);

        result = mFairy.findPic(139,266,568,413,"gxhd.png");
        mFairy.onTap(0.8f, result, 670,211,679,227,"恭喜获得", Sleep);

        result = mFairy.findPic(153,878,587,1022,"jiesuo.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("err解锁中"));
            mFairy.ranSwipe(198,942,521,945,500, (long) 500,0);
        }
    }



}
