package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask extends TaskContent {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    GameUtil gameUtil;
    OtherGame otherGame;

    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        mFairy1 = ypFairy;
        otherGame = new OtherGame(mFairy);
    }




}


