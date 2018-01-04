package com.github.krot.game;

import com.github.krot.sqlite.helper.DatabaseHelper;
import com.github.krot.utils.SystemProperties;

public class Game {

    private static Game instance;

    private Game() {
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Round nextRound() {
        int nextRoundId = SystemProperties.NEXT_ROUND;
        return DatabaseHelper.getHelper().findRoundById(nextRoundId);
    }
}
