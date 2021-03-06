package ro.mta.se.lab.Model;

import javafx.beans.property.*;

public class StatisticModel {
    IntegerProperty temperature;
    IntegerProperty temperature_min;
    IntegerProperty temperature_max;
    IntegerProperty humidity;
    FloatProperty wind;
    IntegerProperty pressure;
    StringProperty currentDate;
    StringProperty baseWeather;
    
    public StatisticModel(int temperature, int temperature_min, int temperature_max,
                          int humidity, float wind, int pressure, String currentDate, String baseWeather) {
        this.temperature = new SimpleIntegerProperty(temperature);
        this.temperature_min = new SimpleIntegerProperty(temperature_min);
        this.temperature_max = new SimpleIntegerProperty(temperature_max);
        this.humidity = new SimpleIntegerProperty(humidity);
        this.wind = new SimpleFloatProperty(wind);
        this.pressure = new SimpleIntegerProperty(pressure);
        this.currentDate = new SimpleStringProperty(currentDate);
        this.baseWeather = new SimpleStringProperty(baseWeather);
    }

    public int getTemperature() {
        return temperature.get();
    }

    public IntegerProperty temperatureProperty() {
        return temperature;
    }

    public int getTemperature_min() {
        return temperature_min.get();
    }

    public IntegerProperty temperature_minProperty() {
        return temperature_min;
    }

    public int getTemperature_max() {
        return temperature_max.get();
    }

    public IntegerProperty temperature_maxProperty() {
        return temperature_max;
    }

    public int getHumidity() {
        return humidity.get();
    }

    public IntegerProperty humidityProperty() {
        return humidity;
    }

    public float getWind() {
        return wind.get();
    }

    public FloatProperty windProperty() {
        return wind;
    }

    public int getPressure() {
        return pressure.get();
    }

    public IntegerProperty pressureProperty() {
        return pressure;
    }

    public String getCurrentDate() {
        return currentDate.get();
    }

    public StringProperty currentDateProperty() {
        return currentDate;
    }

    public String getBaseWeather() {
        return baseWeather.get();
    }

    public StringProperty baseWeatherProperty() {
        return baseWeather;
    }

}
