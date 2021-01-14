package ro.mta.se.lab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValuesConverterTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("Method called!");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Call ended!");
    }

    @Test
    public void convertTemperature() {
        assertEquals(20, ValuesConverter.convertTemperature(293.15));
    }

    @Test
    public void convertToDate() {
        assertEquals("14-01-2021 08:07:09", ValuesConverter.convertToDate(1610647629));
    }
}