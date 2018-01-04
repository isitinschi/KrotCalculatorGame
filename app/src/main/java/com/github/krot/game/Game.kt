package com.github.krot.game

import com.github.krot.sqlite.helper.DatabaseHelper
import com.github.krot.utils.SystemProperties

object Game {
    fun nextRound(): Round {
        val nextRoundId = SystemProperties.NEXT_ROUND
        return DatabaseHelper.getHelper().findRoundById(nextRoundId)
    }
}
