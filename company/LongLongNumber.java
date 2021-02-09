package com.company;

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
            inputNumber();
        }
    }
    public LongLongNumber(int maxSizeRandomValue) {
        createRandomLongLongNumber(maxSizeRandomValue);
    }
    public LongLongNumber() {
        inputNumber();
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
    public LongLongNumber MinAbs(LongLongNumber otherLongNumber) {

        if (this.value.size() < otherLongNumber.getValue().size()) return this;
        else if (this.value.size() > otherLongNumber.getValue().size()) return otherLongNumber;
        else {
            for (int i = 0; i < this.value.size(); i++) {
                if (this.value.get(i) < otherLongNumber.getValue().get(i)) return this;
                else if (this.value.get(i) > otherLongNumber.getValue().get(i)) return otherLongNumber;
            }
        }
        return this;

    }

    public LongLongNumber MaxAbs(LongLongNumber otherLongNumber) {
        if (this.value.size() < otherLongNumber.getValue().size()) return otherLongNumber;
        else if (this.value.size() > otherLongNumber.getValue().size()) return this;
        else {
            for (int i = 0; i < this.value.size(); i++) {
                if (this.value.get(i) < otherLongNumber.getValue().get(i)) return otherLongNumber;
                else if (this.value.get(i) > otherLongNumber.getValue().get(i)) return this;
            }
        }
        return otherLongNumber;
    }

    public LongLongNumber Min(LongLongNumber otherLongNumber, boolean considerMinus) {
        if (!considerMinus) return MinAbs(otherLongNumber); //если учитывать минус не надо, тосравниваем по модулю
        if (this.minus && !otherLongNumber.getMinus() && considerMinus) return this; //а отрицательно, б положительное значит а меньше
        else if(!this.minus && otherLongNumber.getMinus() && considerMinus) return otherLongNumber; //а положительное, б отрицательно значит б меньше
        else {
            //если оба числа отрицательные
            if (this.minus && otherLongNumber.getMinus()) {
                //если длина числа а меньше длины числа б, тогда б меньше
                if (this.value.size() < otherLongNumber.getValue().size()) return otherLongNumber;
                    //если длина числа а больше длины числа б, толгда а меньше
                else if (this.value.size() > otherLongNumber.getValue().size()) return this;
                    //если их длины равны, то сравниваем поразрядно (начиная со старшего разряда)
                else {
                    for (int i = 0; i < this.value.size(); i++) {
                        //если разряд числа а меньше чем разряд числа б, тогда б меньше
                        if (this.value.get(i) < otherLongNumber.getValue().get(i)) return otherLongNumber;
                            //если разряд числа б меньше чем разряд числа а, тогда а меньше
                        else if (this.value.get(i) > otherLongNumber.getValue().get(i)) return this;
                    }
                }
            }
            //если оба положительные, тогда смотрим по модулю
            else {
                return MinAbs(otherLongNumber);
            }
        }
        //если они равны, то возвращаем число а
        return this;
    }

    public LongLongNumber Max(LongLongNumber otherLongNumber, boolean considerMinus) {
        if (!considerMinus) return MaxAbs(otherLongNumber);
        if (this.minus && !otherLongNumber.getMinus() && considerMinus) return otherLongNumber; //если число а отрицательное, а число б положительное, тогда б больше
        else if(!this.minus && otherLongNumber.getMinus() && considerMinus) return this; //если числа а положительное, а число б положительное, тогда а больше
        else {
            //если оба числа отрицательные
            if (this.minus && otherLongNumber.getMinus()) {
                //если длина числа а меньше длины числа б, тогда а больше
                if (this.value.size() < otherLongNumber.getValue().size()) return this;
                    //если длина числа а больше длины числа б, тогда б больше
                else if (this.value.size() > otherLongNumber.getValue().size()) return otherLongNumber;
                    //если их длины равны, то сравниваем поразрядно (начиная со старшего разряда)
                else {
                    for (int i = 0; i < this.value.size(); i++) {
                        //если разряд числа а меньше разряда числа б, тогда число а больше
                        if (this.value.get(i) < otherLongNumber.getValue().get(i)) return this;
                            //если разряд числа а больше разряда числа б, тогда число б больше
                        else if (this.value.get(i) > otherLongNumber.getValue().get(i)) return otherLongNumber;
                    }
                }
            }
            //если оба числа положительные
            else {
                return MaxAbs(otherLongNumber);
            }
        }
        //если они равны, возвращаем число б
        return otherLongNumber;
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
    private void inputNumber() {
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
                    inputNumber();
                    break;
                }
            }
        }
    }
    private void createRandomLongLongNumber(int maxSize) {
        Random rnd = new Random();
        int rndSize = rnd.nextInt(maxSize - 1) + 1;
        for (int i = 0; i < rndSize; i++) {
            int digit = i == 0 ? (rnd.nextInt(9) + 1) : rnd.nextInt(10);
            value.add((byte)digit);
        }
        minus = rnd.nextBoolean();
    }

}
