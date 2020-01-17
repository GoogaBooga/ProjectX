package com.intellias.px.calc;

import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleCalculatorTest {

    private Calculator calculator;

    @Before
    public void setUpEnvironment(){
        calculator = new SimpleCalculator();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void shouldMultiplyNumbers(){
        int product = calculator.multiply(0, 5);
        assertEquals(0, product);
    }

    @Test
    public void shouldMultiplyNoneZeroNumbers() {
        int product = calculator.multiply(5, 5);
        assertEquals(25, product);
    }

    @Test
    public void shouldMultiplyNoneZeroDifferentNumbers() {
        int product = calculator.multiply(5, 6);
        assertEquals(30, product);
    }

    @Test
    public void shouldMultiplyNegativeNumbers() {
        int product = calculator.multiply(5, -6);
        assertEquals(-30, product);
    }

//    @Test
//    @Parameters()
//    public void shouldMultiply() {
//
//    }
}
