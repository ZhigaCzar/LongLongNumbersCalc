package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongLongNumberTest {

    @Test
    public void minAbs() {
//        LongLongNumber a = new LongLongNumber(10);
//        LongLongNumber b = new LongLongNumber(10);
//        int expected = Math.min(Math.abs(a.getIntValueForTest()), Math.abs(b.getIntValueForTest()));
//        int actual = a.MinAbs(b).getIntValueForTest();
//        assertEquals("Ошибка при сравнении модулей (минимум)", expected, actual);
    }

    @Test
    public void maxAbs() {
//        LongLongNumber a = new LongLongNumber(10);
//        LongLongNumber b = new LongLongNumber(10);
//        int expected = Math.max(Math.abs(a.getIntValueForTest()), Math.abs(b.getIntValueForTest()));
//        int actual = a.MaxAbs(b).getIntValueForTest();
//        assertEquals("Ошибка при сравнении модулей (максимум)", expected, actual);
    }

    @Test
    public void min() {
        LongLongNumber a = new LongLongNumber(10);
        LongLongNumber b = new LongLongNumber(10);
        int expected = Math.min(a.getIntValueForTest(), b.getIntValueForTest());
        int actual = a.Min(b, true).getIntValueForTest();
        assertEquals("Ошибка при сравнении (минимум)", expected, actual);
    }

    @Test
    public void max() {
        LongLongNumber a = new LongLongNumber(10);
        LongLongNumber b = new LongLongNumber(10);
        int expected = Math.max(a.getIntValueForTest(), b.getIntValueForTest());
        int actual = a.Max(b, true).getIntValueForTest();
        assertEquals("Ошибка при сравнении (максимум)", expected, actual);
    }

    @Test
    public void sum() {
    }

    @Test
    public void sub() {
    }
}