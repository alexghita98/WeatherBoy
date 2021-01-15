package ro.mta.se.lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ro.mta.se.lab.Controller.WeatherController;
import ro.mta.se.lab.Model.CityModel;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

    private final ObservableList<CityModel> cityModels = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    public void initializeCities() {
        try {
            ArrayList<HashMap<String, String>> cityData = LocationFileReader.readFile("locations_input.txt");
            for (HashMap<String, String> data : cityData) {
                cityModels.add(new CityModel(data.get("id"), data.get("name"),
                        Float.parseFloat(data.get("lat")), Float.parseFloat(data.get("lon")), data.get("code")));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();
        try {
            initializeCities();

            loader.setLocation(this.getClass().getResource("/view/weather.fxml"));
            loader.setController(new WeatherController(cityModels));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.setTitle("WeatherBoy");
            primaryStage.getIcons().add(new Image("/images/icon.png"));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}