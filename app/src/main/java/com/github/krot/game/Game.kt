package com.github.krot.game

import com.github.krot.utils.RoundsProducer
import com.github.krot.utils.SystemProperties

object Game {
    var curValue = 0f
    var targetValue = 0f
    private val roundIdToRound = RoundsProducer.getRounds().map { it.id to it }.toMap()

    fun nextRound() = roundIdToRound[SystemProperties.NEXT_ROUND]
}
