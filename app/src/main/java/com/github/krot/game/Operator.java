package com.github.krot.game;

import android.text.Html;
import android.text.Spanned;

public class Operator {

    private Operation operation;
    private int operand;

    public Operator() {

    }

    public Operator(Operation operation) {
        this.operation = operation;
    }

    public Operator(Operation operation, int operand) {
        this.operation = operation;
        this.operand = operand;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getOperand() {
        return operand;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }

    public Spanned getFormattedString() {
        String htmlCode;

        switch (operation) {
            case ADD: htmlCode = "+ " + operand;break;
            case SUB: htmlCode = "- " + operand;break;
            case MULT: htmlCode = "* " + operand;break;
            case DIV: htmlCode = "/ " + operand;break;
            case ROOT: htmlCode = "&radic;x";break;
            case EXP: htmlCode = "x<sup>" + operand + "</sup>";break;
            case NEG: htmlCode = "- x";break;
            default: htmlCode = "Unknown";
        }

        return Html.fromHtml(htmlCode);
    }

    public float apply(float value) {
        switch (operation) {
            case ADD:   return value + operand;
            case SUB:   return value - operand;
            case MULT:  return value * operand;
            case DIV:   return value / operand;
            case ROOT:  if (value > 0) {
                            return Double.valueOf(Math.pow(value, 0.5f)).floatValue();
                        } else {
                            return value;
                        }
            case EXP:   return Double.valueOf(Math.pow(value, operand)).floatValue();
            case NEG:   return -1 * value;
            default:    return value;
        }
    }
}
