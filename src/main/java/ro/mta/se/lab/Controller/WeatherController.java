package ro.mta.se.lab.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeatherController {
    @FXML
    private ImageView statimg;
    @FXML
    private ImageView locimg;
    @FXML
    private ImageView shortweather;
    @FXML
    private ImageView datepic;

    @FXML
    public void initialize() {
        statimg.setImage(new Image("/images/temperature.png"));
        locimg.setImage(new Image("/images/location.png"));
        shortweather.setImage(new Image("/images/status.png"));
        datepic.setImage(new Image("/images/date.png"));

    }

}
