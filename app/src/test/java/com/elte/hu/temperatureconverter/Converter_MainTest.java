package com.elte.hu.temperatureconverter;

import com.elte.hu.temperatureconverter.Converter_Main;

import org.junit.Test;

import static org.junit.Assert.*;

public class Converter_MainTest {

    @Test
    public void convertFahrenheitToCelsiusTest1() {
        double input=212;
        double output;
        double expected=100;
        double delta=.1;

        Converter_Main converter_main=new Converter_Main();
        output =converter_main.convertFahrenheitToCelsius(input);
        assertEquals(expected,output,delta);


    }


    @Test
    public void convertFahrenheitToCelsiusTest2() {
        double input=68;
        double output;
        double expected=20;
        double delta=.1;

        Converter_Main converter_main=new Converter_Main();
        output =converter_main.convertFahrenheitToCelsius(input);
        assertEquals(expected,output,delta);


    }

    @Test
    public void convertCelsiusToFahrenheitTest1() {
        double input=100;
        double output;
        double expected=212;
        double delta=.1;

        Converter_Main converter_main=new Converter_Main();
        output =converter_main.convertCelsiusToFahrenheit(input);
        assertEquals(expected,output,delta);
    }

    @Test
    public void convertCelsiusToFahrenheitTest2() {
        double input=20;
        double output;
        double expected=68;
        double delta=.1;

        Converter_Main converter_main=new Converter_Main();
        output =converter_main.convertCelsiusToFahrenheit(input);
        assertEquals(expected,output,delta);
    }
}