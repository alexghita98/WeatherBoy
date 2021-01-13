package ro.mta.se.lab.Controller;
import com.sun.javafx.beans.event.AbstractNotifyListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ro.mta.se.lab.Model.CityModel;

public class WeatherController {

    private ObservableList<CityModel> cityModels;

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

        for(CityModel model : cityModels) {
            data.add(model.getCityName() + " " + model.getCountryCode());
        }

        citychoice.setItems(data);
    }

}
