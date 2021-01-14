package ro.mta.se.lab;

import com.eclipsesource.json.JsonObject;
import ro.mta.se.lab.Interfaces.IJsonConverter;

public class JsonConverter implements IJsonConverter {

    private final JsonObject object;

    public JsonConverter(JsonObject object) {
        this.object = object;
    }

    @Override
    public String getCurrentWeather() {
        return object.get("weather").asArray().get(0).asObject().getString("main",
                "empty");
    }

    @Override
    public long getCurrentDate() {
        return object.get("dt").asLong();
    }

    @Override
    public float getTemperature() {
        return object.get("main").asObject().getFloat("temp",
                0);
    }

    @Override
    public float getTemperature_min() {
        return object.get("main").asObject().getFloat("temp_min",
                0);
    }

    @Override
    public float getTemperature_max() {
        return object.get("main").asObject().getFloat("temp_max",
                0);
    }

    @Override
    public int getHumidity() {
        return object.get("main").asObject().getInt("humidity",
                0);
    }

    @Override
    public float getWind() {
        return object.get("wind").asObject().getFloat("speed",
                0);
    }

    @Override
    public int getPressure() {
        return object.get("main").asObject().getInt("pressure",
                0);
    }
}
