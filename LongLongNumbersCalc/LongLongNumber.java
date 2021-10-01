package com.company;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class LongLongNumber {

    //variables
    private ArrayList<Byte> value = new ArrayList<>();
    private Boolean minus = false;

    //constructor
    public LongLongNumber(boolean empty) {
        if (!empty) {
            InputNumber();
        }
    }
    public LongLongNumber(int maxSizeRandomValue) {
        CreateRandomLongLongNumber(maxSizeRandomValue);
    }
    public LongLongNumber() {
        InputNumber();
    }


    //getters and setters
    public ArrayList<Byte> getValue() {
        return value;
    }
    public ArrayList<Byte> getValueReverse() {
        ArrayList<Byte> intermediateValueResult;
        Collections.reverse(value);
        intermediateValueResult = (ArrayList<Byte>) value.clone();
        Collections.reverse(value);
        return intermediateValueResult;
    }
    public Boolean getMinus() {
        return minus;
    }
    public int getIntValueForTest () {
        return new Integer(this.toString());
    }
    public void setValue(ArrayList<Byte> value) {
        this.value = value;
    }
    public void setMinus(Boolean minus) {
        this.minus = minus;
    }

    //toString
    @Override
    public String toString() {
        String result = minus ? "-" : "";
        for (int i = 0; i < value.size(); i++)
            result = result + value.get(i);
        return result;
    }

    //calc operation
    public LongLongNumber Min(LongLongNumber otherLongNumber, boolean considerMinus) {

        LongLongNumber result = new LongLongNumber(true);
        result.Copy(this);

        //обычное сравнение
        if (considerMinus) {
            //если это число отрицательное, а другое положительное, то это число меньше
            if (this.minus && !otherLongNumber.getMinus()) result.Copy(this);
            //если это число положительно, а другое отрицательное, тога другое число больше
            else if (!this.minus && otherLongNumber.getMinus()) result.Copy(otherLongNumber);
            //если оба числа положительные
            else if (!this.minus && !otherLongNumber.getMinus()) {
                if (this.value.size() > otherLongNumber.getValue().size()) result.Copy(otherLongNumber);
                else if (this.value.size() < otherLongNumber.getValue().size()) result.Copy(this);
                else if (this.value.size() == otherLongNumber.getValue().size()) {
                    for (int i = 0; i < this.value.size(); i++) {
                        if (this.value.get(i) > otherLongNumber.getValue().get(i)) {
                            result.Copy(otherLongNumber);
                            break;
                        }
                        else if(this.value.get(i) < otherLongNumber.getValue().get(i)) {
                            result.Copy(this);
                            break;
                        }
                    }
                }
            }
            //если оба числа отрицательные
            else if (this.minus && otherLongNumber.getMinus()) {
                if (this.value.size() > otherLongNumber.getValue().size()) result.Copy(this);
                else if (this.value.size() < otherLongNumber.getValue().size()) result.Copy(otherLongNumber);
                else if (this.value.size() == otherLongNumber.getValue().size()) {
                    for (int i = 0; i < this.value.size(); i++) {
                        if (this.value.get(i) > otherLongNumber.getValue().get(i)) {
                            result.Copy(this);
                            break;
                        }
                        else if(this.value.get(i) < otherLongNumber.getValue().get(i)) {
                            result.Copy(otherLongNumber);
                            break;
                        }
                    }
                }
            }
        }
        //сравнение по модулю (возвращает значение со знаком исходного значения)
        else {
            if (this.value.size() > otherLongNumber.getValue().size()) result.Copy(otherLongNumber);
            else if (this.value.size() < otherLongNumber.getValue().size()) result.Copy(this);
            else if (this.value.size() == otherLongNumber.getValue().size()) {
                for (int i = 0; i < this.value.size(); i++) {
                    if (this.value.get(i) > otherLongNumber.getValue().get(i)) {
                        result.Copy(otherLongNumber);
                        break;
                    }
                    else if (this.value.get(i) < otherLongNumber.getValue().get(i)) {
                        result.Copy(this);
                        break;
                    }
                }
            }
        }

        return result;
    }
    public LongLongNumber Max(LongLongNumber otherLongNumber, boolean considerMinus) {

        LongLongNumber result = new LongLongNumber(true);
        result.Copy(this);

        //обычное сравнение
        if (considerMinus) {
            //если это число отрицательное, а другое положительное, то это число меньше
            if (this.minus && !otherLongNumber.getMinus()) result.Copy(otherLongNumber);
                //если это число положительно, а другое отрицательное, тога другое число больше
            else if (!this.minus && otherLongNumber.getMinus()) result.Copy(this);
                //если оба числа положительные
            else if (!this.minus && !otherLongNumber.getMinus()) {
                if (this.value.size() > otherLongNumber.getValue().size()) result.Copy(this);
                else if (this.value.size() < otherLongNumber.getValue().size()) result.Copy(otherLongNumber);
                else if (this.value.size() == otherLongNumber.getValue().size()) {
                    for (int i = 0; i < this.value.size(); i++) {
                        if (this.value.get(i) > otherLongNumber.getValue().get(i)) {
                            result.Copy(this);
                            break;
                        }
                        else if(this.value.get(i) < otherLongNumber.getValue().get(i)) {
                            result.Copy(otherLongNumber);
                            break;
                        }
                    }
                }
            }
            //если оба числа отрицательные
            else if (this.minus && otherLongNumber.getMinus()) {
                if (this.value.size() > otherLongNumber.getValue().size()) result.Copy(otherLongNumber);
                else if (this.value.size() < otherLongNumber.getValue().size()) result.Copy(this);
                else if (this.value.size() == otherLongNumber.getValue().size()) {
                    for (int i = 0; i < this.value.size(); i++) {
                        if (this.value.get(i) > otherLongNumber.getValue().get(i)) {
                            result.Copy(otherLongNumber);
                            break;
                        }
                        else if(this.value.get(i) < otherLongNumber.getValue().get(i)) {
                            result.Copy(this);
                            break;
                        }
                    }
                }
            }
        }
        //сравнение по модулю (возвращает значение со знаком исходного значения)
        else {
            if (this.value.size() > otherLongNumber.getValue().size()) result.Copy(this);
            else if (this.value.size() < otherLongNumber.getValue().size()) result.Copy(otherLongNumber);
            else if (this.value.size() == otherLongNumber.getValue().size()) {
                for (int i = 0; i < this.value.size(); i++) {
                    if (this.value.get(i) > otherLongNumber.getValue().get(i)) {
                        result.Copy(this);
                        break;
                    }
                    else if (this.value.get(i) < otherLongNumber.getValue().get(i)) {
                        result.Copy(otherLongNumber);
                        break;
                    }
                }
            }
        }

        return result;

    }
    public LongLongNumber Sum(LongLongNumber otherLongNumber) {

        LongLongNumber result = new LongLongNumber(true);
        ArrayList<Byte> intermediateValueResult = new ArrayList<Byte>();
        boolean isSub = false;

        if (this.minus == otherLongNumber.getMinus()) {

            ArrayList<Byte> intermediateValueA = this.getValueReverse();
            ArrayList<Byte> intermediateValueB = otherLongNumber.getValueReverse();
            boolean extraUnit = false;

            int digitA;
            int digitB;
            int digitResult;


            int MaxSize = Max(otherLongNumber, false).getValue().size();
            for (int i = 0; i < MaxSize; i++) {

                try {digitA = intermediateValueA.get(i);} catch (IndexOutOfBoundsException e) {digitA = 0;}
                try {digitB = intermediateValueB.get(i);} catch (IndexOutOfBoundsException e) {digitB = 0;}
                digitResult = digitA + digitB;

                digitResult = extraUnit ? digitResult + 1 : digitResult;
                extraUnit = false;

                if (digitResult > 9) {
                    extraUnit = true;
                    digitResult = digitResult - 10;
                }

                intermediateValueResult.add((byte)digitResult);
            }

            if (extraUnit) intermediateValueResult.add((byte)1);

        } else {
            result = Sub(otherLongNumber, true);
            isSub = true;
        }

        if (!isSub) {
            Collections.reverse(intermediateValueResult);
            result.setValue(intermediateValueResult);
            result.setMinus(this.minus);
        }

        return result;
    }
    public LongLongNumber Sub(LongLongNumber otherLongNumber, boolean isReCall) {

        LongLongNumber result = new LongLongNumber(true);
        ArrayList<Byte> intermediateValueResult = new ArrayList<Byte>();
        boolean isSum = false;

        if (!isReCall) otherLongNumber.setMinus(!otherLongNumber.getMinus());

        if (this.minus == otherLongNumber.getMinus()) {

            result = Sum(otherLongNumber);
            isSum = true;


        } else {

            ArrayList<Byte> intermediateValueA = Max(otherLongNumber, false).getValueReverse();
            ArrayList<Byte> intermediateValueB = Min(otherLongNumber, false).getValueReverse();
            boolean extraUnit = false;

            int digitA;
            int digitB;
            int digitResult;

            int MaxSize = Max(otherLongNumber, false).getValue().size();
            for (int i = 0; i < MaxSize; i++) {

                try {digitA = intermediateValueA.get(i);} catch (IndexOutOfBoundsException e) {digitA = 0;}
                try {digitB = intermediateValueB.get(i);} catch (IndexOutOfBoundsException e) {digitB = 0;}
                digitResult = digitA - digitB;

                digitResult = extraUnit ? digitResult - 1 : digitResult;
                extraUnit = false;

                if (digitResult < 0) {
                    extraUnit = true;
                    digitResult = digitResult + 10;
                }

                intermediateValueResult.add((byte)digitResult);
            }

        }

        if (!isSum) {
            Collections.reverse(intermediateValueResult);
            result.setValue(intermediateValueResult);
            result.setMinus(Max(otherLongNumber, false).getMinus());
        }

        if (!isReCall) otherLongNumber.setMinus(!otherLongNumber.getMinus());

        return result;
    }

    //other
    private void InputNumber() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Print long long number: ");
        String stringLongLongNumber = scaner.nextLine();

        for (int i = 0; i < stringLongLongNumber.length(); i++) {
            if (stringLongLongNumber.charAt(i) == '-' && i == 0)
                minus = true;
            else {
                char symbol = stringLongLongNumber.charAt(i);
                String stringSymbol = "" + symbol;
                try {
                    byte symbolByte = Byte.parseByte(stringSymbol);
                    value.add(symbolByte);
                }
                catch (Exception e) {
                    System.out.println("Wrong number. Please try again.");
                    value.clear();
                    InputNumber();
                    break;
                }
            }
        }
    }
    private void CreateRandomLongLongNumber(int maxSize) {
        Random rnd = new Random();
        int rndSize = rnd.nextInt(maxSize - 1) + 1;
        for (int i = 0; i < rndSize; i++) {
            int digit = i == 0 ? (rnd.nextInt(9) + 1) : rnd.nextInt(10);
            value.add((byte)digit);
        }
        minus = rnd.nextBoolean();
    }
    public void Copy(LongLongNumber otherLongNumber) {
        this.setValue(otherLongNumber.value);
        this.setMinus(otherLongNumber.minus);
    }

}