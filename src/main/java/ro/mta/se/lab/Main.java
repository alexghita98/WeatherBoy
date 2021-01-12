package ro.mta.se.lab;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ro.mta.se.lab.Model.WeatherModel;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/view/weather.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("WeatherBoy");
        primaryStage.getIcons().add(new Image("/images/icon.png"));
        primaryStage.show();
    }
}