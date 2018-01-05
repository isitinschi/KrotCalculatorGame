package com.github.krot.game

data class Round(
        val id: Int,
        val initValue: Float,
        val targetValue: Float,
        val operators: List<Operator>
)