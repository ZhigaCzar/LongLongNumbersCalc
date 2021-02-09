package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongLongNumberTest {

    @Test
    public void minAbs() {
        LongLongNumber a = new LongLongNumber(6);
        LongLongNumber b = new LongLongNumber(6);
        int expected = Math.abs(a.getIntValueForTest()) > Math.abs(b.getIntValueForTest()) ? b.getIntValueForTest() : a.getIntValueForTest();
        int actual = a.Min(b, false).getIntValueForTest();
        assertEquals("Ошибка при сравнении модуля (минимум). val1 = " + a + " val2 = " + b, expected, actual);
    }

    @Test
    public void min() {
        LongLongNumber a = new LongLongNumber(6);
        LongLongNumber b = new LongLongNumber(6);
        int expected = Math.min(a.getIntValueForTest(), b.getIntValueForTest());
        int actual = a.Min(b, true).getIntValueForTest();
        assertEquals("Ошибка при сравнении (минимум). val1 = " + a + " val2 = " + b, expected, actual);
    }

    @Test
    public void maxAbs() {
        LongLongNumber a = new LongLongNumber(6);
        LongLongNumber b = new LongLongNumber(6);
        int expected = Math.abs(a.getIntValueForTest()) < Math.abs(b.getIntValueForTest()) ? b.getIntValueForTest() : a.getIntValueForTest();;
        int actual = a.Max(b, false).getIntValueForTest();
        assertEquals("Ошибка при сравнении модуля (максимум). val1 = " + a + " val2 = " + b, expected, actual);
    }

    @Test
    public void max() {
        LongLongNumber a = new LongLongNumber(6);
        LongLongNumber b = new LongLongNumber(6);
        int expected = Math.max(a.getIntValueForTest(), b.getIntValueForTest());
        int actual = a.Max(b, true).getIntValueForTest();
        assertEquals("Ошибка при сравнении (максимум). val1 = " + a + " val2 = " + b, expected, actual);
    }

    @Test
    public void sum() {
        LongLongNumber a = new LongLongNumber(6);
        LongLongNumber b = new LongLongNumber(6);
        int expected = a.getIntValueForTest() + b.getIntValueForTest();
        int actual = a.Sum(b).getIntValueForTest();
        assertEquals("Ошибка при сложении. val1 = " + a + " val2 = " + b , expected, actual);
    }

    @Test
    public void sub() {
        LongLongNumber a = new LongLongNumber(6);
        LongLongNumber b = new LongLongNumber(6);
        int expected = a.getIntValueForTest() - b.getIntValueForTest();
        int actual = a.Sub(b, false).getIntValueForTest();
        assertEquals("Ошибка при вычетании. val1 = " + a + " val2 = " + b, expected, actual);
    }
}