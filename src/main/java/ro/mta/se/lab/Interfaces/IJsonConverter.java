package ro.mta.se.lab.Interfaces;

public interface IJsonConverter {
    String getCurrentWeather();

    long getCurrentDate();

    float getTemperature();

    float getTemperature_min();

    float getTemperature_max();

    int getHumidity();

    float getWind();

    int getPressure();
}
