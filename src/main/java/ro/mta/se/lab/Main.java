package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void initializeCities()
    {

    }

    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();
        try {

            loader.setLocation(this.getClass().getResource("/view/weather.fxml"));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.setTitle("WeatherBoy");
            primaryStage.getIcons().add(new Image("/images/icon.png"));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}