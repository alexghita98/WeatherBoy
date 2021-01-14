package ro.mta.se.lab;

import org.junit.Test;
import ro.mta.se.lab.Interfaces.IJsonConverter;
import ro.mta.se.lab.Interfaces.IValuesConverter;
import ro.mta.se.lab.Model.StatisticModel;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class DataCollectorTest {

    @Test
    public void callAPI() {
        IValuesConverter valuesConverter_test = mock(IValuesConverter.class);
        IJsonConverter jsonConverter_test = mock(IJsonConverter.class);

        when(valuesConverter_test.convertTemperature(anyDouble())).thenReturn(20);
        when(valuesConverter_test.convertToDate(anyLong())).thenReturn("14-01-2021 08:07:09");

        when(jsonConverter_test.getCurrentWeather()).thenReturn("Clouds");
        when(jsonConverter_test.getCurrentDate()).thenReturn(1610647629L);
        when(jsonConverter_test.getTemperature()).thenReturn((float) 293.15);
        when(jsonConverter_test.getTemperature_min()).thenReturn((float) 293.15);
        when(jsonConverter_test.getTemperature_max()).thenReturn((float) 293.15);
        when(jsonConverter_test.getHumidity()).thenReturn(95);
        when(jsonConverter_test.getWind()).thenReturn((float)1.5);
        when(jsonConverter_test.getPressure()).thenReturn(1025);

        StatisticModel statisticModel_test = new StatisticModel(valuesConverter_test.convertTemperature(
                jsonConverter_test.getTemperature()),
                valuesConverter_test.convertTemperature(jsonConverter_test.getTemperature_min()),
                valuesConverter_test.convertTemperature(jsonConverter_test.getTemperature_max()),
                jsonConverter_test.getHumidity(), jsonConverter_test.getWind(), jsonConverter_test.getPressure(),
                valuesConverter_test.convertToDate(jsonConverter_test.getCurrentDate()),
                jsonConverter_test.getCurrentWeather());

        assertEquals("Clouds", statisticModel_test.getBaseWeather());
        assertEquals("14-01-2021 08:07:09", statisticModel_test.getCurrentDate());
        assertEquals(20, statisticModel_test.getTemperature());
        assertEquals(20, statisticModel_test.getTemperature_max());
        assertEquals(20, statisticModel_test.getTemperature_min());
        assertEquals(95, statisticModel_test.getHumidity());
        assertEquals(1025, statisticModel_test.getPressure());


    }
}