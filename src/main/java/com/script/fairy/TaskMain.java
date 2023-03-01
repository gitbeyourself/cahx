package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;


/**
 * Created by Administrator on 2019/1/24 0024.
 */

public class TaskMain {
     AtFairyImpl mFairy;
     GameUtil gameUtil;
     TeamTask teamTask;
     SingleTask singleTask;
     FindResult result;
     LimitlessTask limitlessTask;
     TimingActivity timingActivity;
     OtherGame otherGame;
     static List<String> list = new ArrayList<>();
     public  TaskMain (AtFairyImpl ypFairy) throws Exception {
         mFairy = ypFairy;
         mFairy.setGameName("长安幻想");
         mFairy.setGameVersion(20);
         init();
         gameUtil = new GameUtil(mFairy);
         teamTask=new TeamTask(mFairy);
         singleTask=new SingleTask(mFairy);
         limitlessTask=new LimitlessTask(mFairy);
         timingActivity=new TimingActivity(mFairy);
         otherGame=new OtherGame(mFairy);
         mFairy.initMatTime();
         list.clear();
    }
     public void main() throws Exception {
         if(!AtFairyConfig.getOption("task_id").equals("")){
             task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
         }
         switch (task_id) {
             case 2783://新
                 singleTask.novice();
                 break;
             case 2785:
                 if (AtFairyConfig.getOption("jiangl").equals("1")){
                     singleTask.reward();
                 }
                 if (AtFairyConfig.getOption("zmrw").equals("1")){
                     singleTask.zmrw();
                 }
                 if (AtFairyConfig.getOption("zlt").equals("1")){
                     singleTask.zlt();
                 }
                 if (AtFairyConfig.getOption("xblp").equals("1")){
                     singleTask.xblp();
                 }
                 if (AtFairyConfig.getOption("9063").equals("1")){
                     singleTask.yldc();
                 }
                 if (AtFairyConfig.getOption("ylmj").equals("1")){
                     singleTask.ylmj();
                 }
                 if (AtFairyConfig.getOption("yldk").equals("1")){
                     singleTask.yldk();
                 }
                 if (AtFairyConfig.getOption("zmjj").equals("1")){
                     singleTask.zmjj();
                 }
                 if (AtFairyConfig.getOption("9069").equals("1")){
                     singleTask.zkzg();
                 }
                 break;
         }
         mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
         Thread.sleep(2000);
    }

    private int  task_id;
    public void  init() throws Exception {
        task_id=0;
        try {
            JSONObject optionJson = new JSONObject(AtFairyConfig.getUserTaskConfig());
            LtLog.e(mFairy.getLineInfo("选项列表" + optionJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!AtFairyConfig.getOption("task_id").equals("")) {
            task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }
    }

}
