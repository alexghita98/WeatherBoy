package ro.mta.se.lab.Model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class StatisticModel {
    FloatProperty temperature;
    FloatProperty temperature_min;
    FloatProperty temperature_max;
    FloatProperty humidity;
    FloatProperty wind;
    FloatProperty pressure;
    
    public StatisticModel(float temperature, float temperature_min, float temperature_max,
                          float humidity, float wind, float pressure) {
        this.temperature = new SimpleFloatProperty(temperature);
        this.temperature_min = new SimpleFloatProperty(temperature_min);
        this.temperature_max = new SimpleFloatProperty(temperature_max);
        this.humidity = new SimpleFloatProperty(humidity);
        this.wind = new SimpleFloatProperty(wind);
        this.pressure = new SimpleFloatProperty(pressure);
    }

    public float getTemperature() {
        return temperature.get();
    }

    public FloatProperty temperatureProperty() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature.set(temperature);
    }

    public float getTemperature_min() {
        return temperature_min.get();
    }

    public FloatProperty temperature_minProperty() {
        return temperature_min;
    }

    public void setTemperature_min(float temperature_min) {
        this.temperature_min.set(temperature_min);
    }

    public float getTemperature_max() {
        return temperature_max.get();
    }

    public FloatProperty temperature_maxProperty() {
        return temperature_max;
    }

    public void setTemperature_max(float temperature_max) {
        this.temperature_max.set(temperature_max);
    }

    public float getHumidity() {
        return humidity.get();
    }

    public FloatProperty humidityProperty() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity.set(humidity);
    }

    public float getWind() {
        return wind.get();
    }

    public FloatProperty windProperty() {
        return wind;
    }

    public void setWind(float wind) {
        this.wind.set(wind);
    }

    public float getPressure() {
        return pressure.get();
    }

    public FloatProperty pressureProperty() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure.set(pressure);
    }
}
