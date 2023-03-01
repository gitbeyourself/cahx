package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    public GameUtil(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
    }

    /**
     * 关叉
     * @param
     * @throws Exception
     */
    public void close() throws Exception {
        new GameUtil(mFairy) {
            int j = 2;
            public void content_0() throws Exception {
                for (int i = 0; i < j; i++) {
                    mFairy.condit();

                    result = mFairy.findPic(478,197,676,755,"lingqu5.png");
                    mFairy.onTap(0.8f, result, "领取", Sleep);

                    result = mFairy.findPic(81,766,302,866,"tuichu.png");
                    mFairy.onTap(0.8f, result, "退出1", Sleep);

                    result3 =mFairy.findPic(168,758,573,873,"kbc1.png");
                    mFairy.onTap(0.8f,result3,683,34,688,44,"空白处",Sleep);

                    result = mFairy.findPic(11,266,707,382,"zdym.png");
                    mFairy.onTap(0.8f, result, 27,1244,33,1252,"组队页面退出", Sleep);

                    result =mFairy.findPic(10,1154,137,1267,new String[]{"sign out.png"});
                    mFairy.onTap(0.75f,result,"退出",Sleep);

                    result2 =mFairy.findPic(626,380,717,624,"lk.png");
                    mFairy.onTap(0.8f,result2,"离开",Sleep);

                    result1 =mFairy.findPic(612,11,712,564,new String[]{"cha.png","cha1.png","cha2.png","cha3.png"});
                    mFairy.onTap(0.8f,result1,"关闭",Sleep);

                    if (result.sim > 0.75f || result1.sim > 0.8f  || result2.sim > 0.8f) {
                        j = 5;
                    } else {
                        j = 2;
                    }
                    result = mFairy.findPic(218,1004,633,1135,"sz.png");
                    mFairy.onTap(0.8f, result, 682,1078,687,1091,"退出设置", Sleep);
                }
                setTaskEnd();
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }

}
