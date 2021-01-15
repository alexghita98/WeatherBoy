package ro.mta.se.lab.Controller;

import com.sun.javafx.beans.event.AbstractNotifyListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ro.mta.se.lab.DataCollector;
import ro.mta.se.lab.Model.CityModel;
import ro.mta.se.lab.Model.StatisticModel;

public class WeatherController {

    private final ObservableList<CityModel> cityModels;
    private final DataCollector dataCollector = DataCollector.createInstance("784f7d874251a432cde4f2d6a2439499");

    @FXML
    private ImageView statimg;
    @FXML
    private ImageView locimg;
    @FXML
    private ImageView shortweather;
    @FXML
    private ImageView datepic;
    @FXML
    private ComboBox<String> citychoice;
    @FXML
    private Button showButton;
    @FXML
    private Label locationLabel;
    @FXML
    private Label baseWeatherLabel;
    @FXML
    private Label currentDateLabel;
    @FXML
    private Label temperatureLabel;
    @FXML
    private Label temperatureminLabel;
    @FXML
    private Label temperaturemaxLabel;
    @FXML
    private Label humidityLabel;
    @FXML
    private Label windLabel;
    @FXML
    private Label pressureLabel;


    public WeatherController(ObservableList<CityModel> cityModels) {
        this.cityModels = cityModels;
    }

    @FXML
    public void initialize() {
        statimg.setImage(new Image("/images/temperature.png"));
        locimg.setImage(new Image("/images/location.png"));
        shortweather.setImage(new Image("/images/status.png"));
        datepic.setImage(new Image("/images/date.png"));

        ObservableList<String> data = FXCollections.observableArrayList();

        for (CityModel model : cityModels) {
            data.add(model.getCityName() + " " + model.getCountryCode());
        }

        citychoice.setItems(data);
    }

    @FXML
    private void handleStatistics() {
        String citychoiceValue = citychoice.getValue();
        locationLabel.setText(citychoiceValue);
        String[] tokens = citychoiceValue.split(" ");
        StatisticModel statisticModel = dataCollector.callAPI(tokens[0], tokens[1]);
        baseWeatherLabel.setText(statisticModel.getBaseWeather());
        currentDateLabel.setText(statisticModel.getCurrentDate());
        temperatureLabel.setText("" + statisticModel.getTemperature());
        temperatureminLabel.setText("" + statisticModel.getTemperature_min());
        temperaturemaxLabel.setText("" + statisticModel.getTemperature_max());
        humidityLabel.setText("" + statisticModel.getHumidity());
        windLabel.setText("" + statisticModel.getWind());
        pressureLabel.setText("" + statisticModel.getPressure());

    }

}
