package com.github.krot.utils;

import com.github.krot.game.Operation;
import com.github.krot.game.Operator;
import com.github.krot.game.Round;

import java.util.LinkedList;
import java.util.List;

public class RoundsProducer {

    private List<Round> rounds;

    private static RoundsProducer instance;

    private RoundsProducer() {
        rounds = new LinkedList<>();

        // Round 1
        Round round = new Round(1);
        round.setInitValue(3);
        round.setTargetValue(2);
        List<Operator> operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 1));
        round.setOperators(operators);
        rounds.add(round);

        // Round 2
        round = new Round(2);
        round.setInitValue(8);
        round.setTargetValue(6);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 2));
        operators.add(new Operator(Operation.DIV, 2));
        round.setOperators(operators);
        rounds.add(round);

        // Round 3
        round = new Round(3);
        round.setInitValue(3);
        round.setTargetValue(5);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 2));
        operators.add(new Operator(Operation.MULT, 2));
        operators.add(new Operator(Operation.ADD, 1));
        round.setOperators(operators);
        rounds.add(round);

        // Round 4
        round = new Round(4);
        round.setInitValue(7);
        round.setTargetValue(25);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.MULT, 4));
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.SUB, 1));
        round.setOperators(operators);
        rounds.add(round);

        // Round 5
        round = new Round(5);
        round.setInitValue(25);
        round.setTargetValue(17);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 2));
        operators.add(new Operator(Operation.DIV, 5));
        operators.add(new Operator(Operation.MULT, 3));
        round.setOperators(operators);
        rounds.add(round);

        // Round 6
        round = new Round(6);
        round.setInitValue(3);
        round.setTargetValue(5);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.MULT, 2));
        operators.add(new Operator(Operation.ADD, 6));
        operators.add(new Operator(Operation.SUB, 2));
        operators.add(new Operator(Operation.DIV, 2));
        round.setOperators(operators);
        rounds.add(round);

        // Round 7
        round = new Round(7);
        round.setInitValue(77);
        round.setTargetValue(5);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 2));
        operators.add(new Operator(Operation.DIV, 3));
        operators.add(new Operator(Operation.DIV, 7));
        operators.add(new Operator(Operation.ADD, 2));
        round.setOperators(operators);
        rounds.add(round);

        // Round 8
        round = new Round(8);
        round.setInitValue(1);
        round.setTargetValue(60);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 2));
        operators.add(new Operator(Operation.MULT, 6));
        operators.add(new Operator(Operation.ADD, 2));
        operators.add(new Operator(Operation.MULT, 3));
        round.setOperators(operators);
        rounds.add(round);

        // Round 9
        round = new Round(9);
        round.setInitValue(17);
        round.setTargetValue(5);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 2));
        operators.add(new Operator(Operation.DIV, 2));
        operators.add(new Operator(Operation.SUB, 4));
        operators.add(new Operator(Operation.SUB, 1));
        round.setOperators(operators);
        rounds.add(round);

        // Round 10
        round = new Round(10);
        round.setInitValue(23);
        round.setTargetValue(19);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.SUB, 1));
        operators.add(new Operator(Operation.MULT, 2));
        operators.add(new Operator(Operation.DIV, 2));
        operators.add(new Operator(Operation.SUB, 2));
        round.setOperators(operators);
        rounds.add(round);

        // Round 11
        round = new Round(11);
        round.setInitValue(9);
        round.setTargetValue(3);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ROOT));
        round.setOperators(operators);
        rounds.add(round);

        // Round 12
        round = new Round(12);
        round.setInitValue(4);
        round.setTargetValue(3);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.ROOT));
        round.setOperators(operators);
        rounds.add(round);

        // Round 13
        round = new Round(13);
        round.setInitValue(17);
        round.setTargetValue(5);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 1));
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.ADD, 1));
        round.setOperators(operators);
        rounds.add(round);

        // Round 14
        round = new Round(14);
        round.setInitValue(30);
        round.setTargetValue(4);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 5));
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.DIV, 5));
        operators.add(new Operator(Operation.ADD, 3));
        round.setOperators(operators);
        rounds.add(round);

        // Round 15
        round = new Round(15);
        round.setInitValue(36);
        round.setTargetValue(4);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.MULT, 2));
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.DIV, 4));
        operators.add(new Operator(Operation.SUB, 2));
        round.setOperators(operators);
        rounds.add(round);

        // Round 16
        round = new Round(16);
        round.setInitValue(13);
        round.setTargetValue(3);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.MULT, 2));
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.ADD, 7));
        operators.add(new Operator(Operation.SUB, 6));
        operators.add(new Operator(Operation.DIV, 7));
        round.setOperators(operators);
        rounds.add(round);

        // Round 17
        round = new Round(17);
        round.setInitValue(23);
        round.setTargetValue(1);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 3));
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.DIV, 2));
        round.setOperators(operators);
        rounds.add(round);

        // Round 18
        round = new Round(18);
        round.setInitValue(2);
        round.setTargetValue(0);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.ADD, 2));
        operators.add(new Operator(Operation.MULT, 2));
        operators.add(new Operator(Operation.SUB, 3));
        operators.add(new Operator(Operation.DIV, 2));
        round.setOperators(operators);
        rounds.add(round);

        // Round 19
        round = new Round(19);
        round.setInitValue(9);
        round.setTargetValue(3);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.MULT, 2));
        operators.add(new Operator(Operation.SUB, 2));
        operators.add(new Operator(Operation.DIV, 2));
        operators.add(new Operator(Operation.MULT, 3));
        round.setOperators(operators);
        rounds.add(round);

        // Round 20
        round = new Round(20);
        round.setInitValue(3);
        round.setTargetValue(9);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.EXP, 2));
        round.setOperators(operators);
        rounds.add(round);

        // Round 21
        round = new Round(21);
        round.setInitValue(2);
        round.setTargetValue(7);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.EXP, 3));
        operators.add(new Operator(Operation.SUB, 1));
        round.setOperators(operators);
        rounds.add(round);

        // Round 22
        round = new Round(22);
        round.setInitValue(3);
        round.setTargetValue(5);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 2));
        operators.add(new Operator(Operation.EXP, 3));
        operators.add(new Operator(Operation.ROOT));
        round.setOperators(operators);
        rounds.add(round);

        // Round 23
        round = new Round(23);
        round.setInitValue(1);
        round.setTargetValue(4);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 1));
        operators.add(new Operator(Operation.EXP, 2));
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.ADD, 8));
        round.setOperators(operators);
        rounds.add(round);

        // Round 24
        round = new Round(24);
        round.setInitValue(12);
        round.setTargetValue(15);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.MULT, 4));
        operators.add(new Operator(Operation.DIV, 4));
        operators.add(new Operator(Operation.SUB, 1));
        round.setOperators(operators);
        rounds.add(round);

        // Round 25
        round = new Round(25);
        round.setInitValue(9);
        round.setTargetValue(1);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.EXP, 2));
        operators.add(new Operator(Operation.SUB, 1));
        operators.add(new Operator(Operation.DIV, 4));
        operators.add(new Operator(Operation.SUB, 17));
        operators.add(new Operator(Operation.ROOT));
        round.setOperators(operators);
        rounds.add(round);

        // Round 26
        round = new Round(26);
        round.setInitValue(4);
        round.setTargetValue(25);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.DIV, 3));
        operators.add(new Operator(Operation.ADD, 5));
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.EXP, 2));
        operators.add(new Operator(Operation.SUB, 6));
        round.setOperators(operators);
        rounds.add(round);

        // Round 27
        round = new Round(27);
        round.setInitValue(3);
        round.setTargetValue(6);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.DIV, 2));
        operators.add(new Operator(Operation.ADD, 2));
        operators.add(new Operator(Operation.MULT, 6));
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.SUB, 6));
        round.setOperators(operators);
        rounds.add(round);

        // Round 28
        round = new Round(28);
        round.setInitValue(0);
        round.setTargetValue(7);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 1));
        operators.add(new Operator(Operation.SUB, 1));
        operators.add(new Operator(Operation.ADD, 2));
        operators.add(new Operator(Operation.MULT, 2));
        operators.add(new Operator(Operation.EXP, 3));
        round.setOperators(operators);
        rounds.add(round);

        // Round 29
        round = new Round(29);
        round.setInitValue(-5);
        round.setTargetValue(8);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 4));
        operators.add(new Operator(Operation.MULT, 2));
        operators.add(new Operator(Operation.DIV, 5));
        operators.add(new Operator(Operation.SUB, 1));
        operators.add(new Operator(Operation.MULT, 4));
        round.setOperators(operators);
        rounds.add(round);

        // Round 30
        round = new Round(30);
        round.setInitValue(-7);
        round.setTargetValue(7);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.NEG));
        round.setOperators(operators);
        rounds.add(round);

        // Round 31
        round = new Round(31);
        round.setInitValue(2);
        round.setTargetValue(1);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 3));
        operators.add(new Operator(Operation.NEG));
        round.setOperators(operators);
        rounds.add(round);

        // Round 32
        round = new Round(32);
        round.setInitValue(5);
        round.setTargetValue(1);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.SUB, 3));
        operators.add(new Operator(Operation.NEG));
        operators.add(new Operator(Operation.ADD, 3));
        round.setOperators(operators);
        rounds.add(round);

        // Round 33
        round = new Round(33);
        round.setInitValue(1);
        round.setTargetValue(7);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 5));
        operators.add(new Operator(Operation.SUB, 5));
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.NEG));
        round.setOperators(operators);
        rounds.add(round);

        // Round 34
        round = new Round(34);
        round.setInitValue(1);
        round.setTargetValue(3);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.EXP, 2));
        operators.add(new Operator(Operation.MULT, 4));
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.NEG));
        round.setOperators(operators);
        rounds.add(round);

        // Round 35
        round = new Round(35);
        round.setInitValue(15);
        round.setTargetValue(12);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.MULT, 4));
        operators.add(new Operator(Operation.DIV, 2));
        operators.add(new Operator(Operation.ADD, 1));
        round.setOperators(operators);
        rounds.add(round);

        // Round 36
        round = new Round(36);
        round.setInitValue(33);
        round.setTargetValue(7);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.MULT, 2));
        operators.add(new Operator(Operation.DIV, 9));
        operators.add(new Operator(Operation.ADD, 3));
        operators.add(new Operator(Operation.ADD, 4));
        operators.add(new Operator(Operation.SUB, 6));
        round.setOperators(operators);
        rounds.add(round);

        // Round 37
        round = new Round(37);
        round.setInitValue(77);
        round.setTargetValue(9);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.ADD, 1));
        operators.add(new Operator(Operation.SUB, 7));
        operators.add(new Operator(Operation.DIV, 7));
        operators.add(new Operator(Operation.ROOT));
        operators.add(new Operator(Operation.SUB, 6));
        round.setOperators(operators);
        rounds.add(round);

        // Round 38
        round = new Round(38);
        round.setInitValue(17);
        round.setTargetValue(1);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.DIV, 2));
        operators.add(new Operator(Operation.ADD, 4));
        operators.add(new Operator(Operation.SUB, 1));
        operators.add(new Operator(Operation.NEG));
        operators.add(new Operator(Operation.ADD, 5));
        round.setOperators(operators);
        rounds.add(round);

        // Round 39
        round = new Round(39);
        round.setInitValue(13);
        round.setTargetValue(1);
        operators = new LinkedList<>();
        operators.add(new Operator(Operation.DIV, 3));
        operators.add(new Operator(Operation.NEG));
        operators.add(new Operator(Operation.ADD, 5));
        operators.add(new Operator(Operation.ADD, 4));
        operators.add(new Operator(Operation.SUB, 1));
        round.setOperators(operators);
        rounds.add(round);
    }

    public static RoundsProducer getInstance() {
        if (instance == null) {
            instance = new RoundsProducer();
        }
        return instance;
    }

    public List<Round> getRounds() {
        return rounds;
    }
}
