package ro.mta.se.lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValuesConverterTest {

    ValuesConverter vc = new ValuesConverter();

    @Test
    public void convertTemperature() {
        assertEquals(20, vc.convertTemperature(293.15));
    }

    @Test
    public void convertToDate() {
        assertEquals("14-01-2021 08:07:09", vc.convertToDate(1610647629));
    }
}