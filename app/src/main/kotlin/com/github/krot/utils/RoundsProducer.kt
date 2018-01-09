package com.github.krot.utils

import com.github.krot.game.Operation.*
import com.github.krot.game.Operator
import com.github.krot.game.Round
import java.util.*

object RoundsProducer {
    private val rounds: MutableList<Round>

    init {
        rounds = LinkedList()

        // Round 1
        var operators: MutableList<Operator> = LinkedList()
        operators.add(Operator(SUB, 1))
        rounds.add(Round(1, 3f, 2f, operators))

        // Round 2
        operators = LinkedList()
        operators.add(Operator(ADD, 2))
        operators.add(Operator(DIV, 2))
        rounds.add(Round(2, 8f, 6f, operators))

        // Round 3
        operators = LinkedList()
        operators.add(Operator(SUB, 2))
        operators.add(Operator(MULT, 2))
        operators.add(Operator(ADD, 1))
        rounds.add(Round(3, 3f, 5f, operators))

        // Round 4
        operators = LinkedList()
        operators.add(Operator(MULT, 4))
        operators.add(Operator(ADD, 1))
        operators.add(Operator(SUB, 1))
        rounds.add(Round(4, 7f, 25f, operators))

        // Round 5
        operators = LinkedList()
        operators.add(Operator(ADD, 2))
        operators.add(Operator(DIV, 5))
        operators.add(Operator(MULT, 3))
        rounds.add(Round(5, 25f, 17f, operators))

        // Round 6
        operators = LinkedList()
        operators.add(Operator(MULT, 2))
        operators.add(Operator(ADD, 6))
        operators.add(Operator(SUB, 2))
        operators.add(Operator(DIV, 2))
        rounds.add(Round(6, 3f, 5f, operators))

        // Round 7
        operators = LinkedList()
        operators.add(Operator(SUB, 2))
        operators.add(Operator(DIV, 3))
        operators.add(Operator(DIV, 7))
        operators.add(Operator(ADD, 2))
        rounds.add(Round(7, 77f, 5f, operators))

        // Round 8
        operators = LinkedList()
        operators.add(Operator(ADD, 2))
        operators.add(Operator(MULT, 6))
        operators.add(Operator(ADD, 2))
        operators.add(Operator(MULT, 3))
        rounds.add(Round(8, 1f, 60f, operators))

        // Round 9
        operators = LinkedList()
        operators.add(Operator(ADD, 2))
        operators.add(Operator(DIV, 2))
        operators.add(Operator(SUB, 4))
        operators.add(Operator(SUB, 1))
        rounds.add(Round(9, 17f, 5f, operators))

        // Round 10
        operators = LinkedList()
        operators.add(Operator(ADD, 1))
        operators.add(Operator(SUB, 1))
        operators.add(Operator(MULT, 2))
        operators.add(Operator(DIV, 2))
        operators.add(Operator(SUB, 2))
        rounds.add(Round(10, 23f, 19f, operators))

        // Round 11
        operators = LinkedList()
        operators.add(Operator(ROOT))
        rounds.add(Round(11, 9f, 3f, operators))

        // Round 12
        operators = LinkedList()
        operators.add(Operator(ADD, 1))
        operators.add(Operator(ROOT))
        rounds.add(Round(12, 4f, 3f, operators))

        // Round 13
        operators = LinkedList()
        operators.add(Operator(SUB, 1))
        operators.add(Operator(ROOT))
        operators.add(Operator(ADD, 1))
        rounds.add(Round(13, 17f, 5f, operators))

        // Round 14
        operators = LinkedList()
        operators.add(Operator(SUB, 5))
        operators.add(Operator(ROOT))
        operators.add(Operator(DIV, 5))
        operators.add(Operator(ADD, 3))
        rounds.add(Round(14, 30f, 4f, operators))

        // Round 15
        operators = LinkedList()
        operators.add(Operator(MULT, 2))
        operators.add(Operator(ROOT))
        operators.add(Operator(DIV, 4))
        operators.add(Operator(SUB, 2))
        rounds.add(Round(15, 36f, 4f, operators))

        // Round 16
        operators = LinkedList()
        operators.add(Operator(MULT, 2))
        operators.add(Operator(ROOT))
        operators.add(Operator(ADD, 7))
        operators.add(Operator(SUB, 6))
        operators.add(Operator(DIV, 7))
        rounds.add(Round(16, 13f, 3f, operators))

        // Round 17
        operators = LinkedList()
        operators.add(Operator(SUB, 3))
        operators.add(Operator(ADD, 1))
        operators.add(Operator(ROOT))
        operators.add(Operator(ADD, 1))
        operators.add(Operator(DIV, 2))
        rounds.add(Round(17, 23f, 1f, operators))

        // Round 18
        operators = LinkedList()
        operators.add(Operator(ROOT))
        operators.add(Operator(ADD, 2))
        operators.add(Operator(MULT, 2))
        operators.add(Operator(SUB, 3))
        operators.add(Operator(DIV, 2))
        rounds.add(Round(18, 2f, 0f, operators))

        // Round 19
        operators = LinkedList()
        operators.add(Operator(ADD, 1))
        operators.add(Operator(MULT, 2))
        operators.add(Operator(SUB, 2))
        operators.add(Operator(DIV, 2))
        operators.add(Operator(MULT, 3))
        rounds.add(Round(19, 9f, 3f, operators))

        // Round 20
        operators = LinkedList()
        operators.add(Operator(EXP, 2))
        rounds.add(Round(20, 3f, 9f, operators))

        // Round 21
        operators = LinkedList()
        operators.add(Operator(EXP, 3))
        operators.add(Operator(SUB, 1))
        rounds.add(Round(21, 2f, 7f, operators))

        // Round 22
        operators = LinkedList()
        operators.add(Operator(SUB, 2))
        operators.add(Operator(EXP, 3))
        operators.add(Operator(ROOT))
        rounds.add(Round(22, 3f, 5f, operators))

        // Round 23
        operators = LinkedList()
        operators.add(Operator(SUB, 1))
        operators.add(Operator(EXP, 2))
        operators.add(Operator(ROOT))
        operators.add(Operator(ADD, 8))
        rounds.add(Round(23, 1f, 4f, operators))

        // Round 24
        operators = LinkedList()
        operators.add(Operator(ADD, 1))
        operators.add(Operator(MULT, 4))
        operators.add(Operator(DIV, 4))
        operators.add(Operator(SUB, 1))
        rounds.add(Round(24, 12f, 15f, operators))

        // Round 25
        operators = LinkedList()
        operators.add(Operator(EXP, 2))
        operators.add(Operator(SUB, 1))
        operators.add(Operator(DIV, 4))
        operators.add(Operator(SUB, 17))
        operators.add(Operator(ROOT))
        rounds.add(Round(25, 9f, 1f, operators))

        // Round 26
        operators = LinkedList()
        operators.add(Operator(DIV, 3))
        operators.add(Operator(ADD, 5))
        operators.add(Operator(ROOT))
        operators.add(Operator(EXP, 2))
        operators.add(Operator(SUB, 6))
        rounds.add(Round(26, 4f, 25f, operators))

        // Round 27
        operators = LinkedList()
        operators.add(Operator(DIV, 2))
        operators.add(Operator(ADD, 2))
        operators.add(Operator(MULT, 6))
        operators.add(Operator(ADD, 1))
        operators.add(Operator(SUB, 6))
        rounds.add(Round(27, 3f, 6f, operators))

        // Round 28
        operators = LinkedList()
        operators.add(Operator(SUB, 1))
        operators.add(Operator(SUB, 1))
        operators.add(Operator(ADD, 2))
        operators.add(Operator(MULT, 2))
        operators.add(Operator(EXP, 3))
        rounds.add(Round(28, 0f, 7f, operators))

        // Round 29
        operators = LinkedList()
        operators.add(Operator(ADD, 4))
        operators.add(Operator(MULT, 2))
        operators.add(Operator(DIV, 5))
        operators.add(Operator(SUB, 1))
        operators.add(Operator(MULT, 4))
        rounds.add(Round(29, -5f, 8f, operators))

        // Round 30
        operators = LinkedList()
        operators.add(Operator(NEG))
        rounds.add(Round(30, -7f, 7f, operators))

        // Round 31
        operators = LinkedList()
        operators.add(Operator(SUB, 3))
        operators.add(Operator(NEG))
        rounds.add(Round(31, 2f, 1f, operators))

        // Round 32
        operators = LinkedList()
        operators.add(Operator(SUB, 3))
        operators.add(Operator(NEG))
        operators.add(Operator(ADD, 3))
        rounds.add(Round(32, 5f, 1f, operators))

        // Round 33
        operators = LinkedList()
        operators.add(Operator(ADD, 5))
        operators.add(Operator(SUB, 5))
        operators.add(Operator(ROOT))
        operators.add(Operator(NEG))
        rounds.add(Round(33, 1f, 7f, operators))

        // Round 34
        operators = LinkedList()
        operators.add(Operator(ROOT))
        operators.add(Operator(EXP, 2))
        operators.add(Operator(MULT, 4))
        operators.add(Operator(ADD, 1))
        operators.add(Operator(NEG))
        rounds.add(Round(34, 1f, 3f, operators))

        // Round 35
        operators = LinkedList()
        operators.add(Operator(ADD, 1))
        operators.add(Operator(ROOT))
        operators.add(Operator(MULT, 4))
        operators.add(Operator(DIV, 2))
        operators.add(Operator(ADD, 1))
        rounds.add(Round(35, 15f, 12f, operators))

        // Round 36
        operators = LinkedList()
        operators.add(Operator(MULT, 2))
        operators.add(Operator(DIV, 9))
        operators.add(Operator(ADD, 3))
        operators.add(Operator(ADD, 4))
        operators.add(Operator(SUB, 6))
        rounds.add(Round(36, 33f, 7f, operators))

        // Round 37
        operators = LinkedList()
        operators.add(Operator(ADD, 1))
        operators.add(Operator(SUB, 7))
        operators.add(Operator(DIV, 7))
        operators.add(Operator(ROOT))
        operators.add(Operator(SUB, 6))
        rounds.add(Round(37, 77f, 9f, operators))

        // Round 38
        operators = LinkedList()
        operators.add(Operator(DIV, 2))
        operators.add(Operator(ADD, 4))
        operators.add(Operator(SUB, 1))
        operators.add(Operator(NEG))
        operators.add(Operator(ADD, 5))
        rounds.add(Round(38, 17f, 1f, operators))

        // Round 39
        operators = LinkedList()
        operators.add(Operator(DIV, 3))
        operators.add(Operator(NEG))
        operators.add(Operator(ADD, 5))
        operators.add(Operator(ADD, 4))
        operators.add(Operator(SUB, 1))
        rounds.add(Round(39, 13f, 1f, operators))
    }

    fun getRounds(): List<Round> {
        return rounds
    }
}
