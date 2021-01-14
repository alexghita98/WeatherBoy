package ro.mta.se.lab;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import ro.mta.se.lab.Interfaces.IJsonConverter;
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

                IJsonConverter jsonConverter = new JsonConverter(object);

                return new StatisticModel(valuesConverter.convertTemperature(jsonConverter.getTemperature()),
                        valuesConverter.convertTemperature(jsonConverter.getTemperature_min()),
                        valuesConverter.convertTemperature(jsonConverter.getTemperature_max()),
                        jsonConverter.getHumidity(), jsonConverter.getWind(), jsonConverter.getPressure(),
                        valuesConverter.convertToDate(jsonConverter.getCurrentDate()),
                        jsonConverter.getCurrentWeather());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
