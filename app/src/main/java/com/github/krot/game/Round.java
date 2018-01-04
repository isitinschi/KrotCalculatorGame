package com.github.krot.game;

import java.util.List;

public class Round {
    private int id;
    private float initValue;
    private float targetValue;
    private List<Operator> operators;

    public Round(int id) {
        this.id = id;
    }

    public float getInitValue() {
        return initValue;
    }

    public void setInitValue(float initValue) {
        this.initValue = initValue;
    }

    public float getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(float targetValue) {
        this.targetValue = targetValue;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
