package ro.mta.se.lab;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import ro.mta.se.lab.Interfaces.IValuesConverter;
import ro.mta.se.lab.Model.StatisticModel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class DataCollector {
    private final String personalKey;
    private static DataCollector data_instance = null;
    private IValuesConverter valuesConverter = new ValuesConverter();

    private DataCollector(String personalKey) {
        this.personalKey = personalKey;
    }

    public static DataCollector getInstance() {
        return data_instance;
    }

    public static DataCollector createInstance(String personalKey) {
        if (data_instance == null) {
            data_instance = new DataCollector(personalKey);
        }

        return data_instance;
    }

    public StatisticModel callAPI(String cityName, String countryCode) {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "," + countryCode +
                    "&appid=" + this.personalKey);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int response_code = conn.getResponseCode();

            if (response_code != 200) {
                throw new RuntimeException("HttpResponseCode: " + response_code);
            } else {

                StringBuilder inline = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }
                JsonObject object = Json.parse(inline.toString()).asObject();
                scanner.close();

                String mainWeather;
                long currentDate;
                float temperature;
                float temperature_min;
                float temperature_max;
                int humidity;
                float wind;
                int pressure;

                mainWeather = object.get("weather").asArray().get(0).asObject().getString("main",
                        "empty");
                currentDate = object.get("dt").asLong();
                temperature = object.get("main").asObject().getFloat("temp",
                        0);
                temperature_min = object.get("main").asObject().getFloat("temp_min",
                        0);
                temperature_max = object.get("main").asObject().getFloat("temp_max",
                        0);
                pressure = object.get("main").asObject().getInt("pressure",
                        0);
                humidity = object.get("main").asObject().getInt("humidity",
                        0);
                wind = object.get("wind").asObject().getFloat("speed",
                        0);

                return new StatisticModel(valuesConverter.convertTemperature(temperature),
                        valuesConverter.convertTemperature(temperature_min),
                        valuesConverter.convertTemperature(temperature_max), humidity, wind, pressure,
                        valuesConverter.convertToDate(currentDate), mainWeather);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
