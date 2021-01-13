package ro.mta.se.lab.Model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CityModel {
    StringProperty cityID;
    StringProperty cityName;
    FloatProperty cityLatitude;
    FloatProperty cityLongitude;
    StringProperty countryCode;

    public CityModel(String cityID, String cityName, float cityLatitude,
                     float cityLongitude, String countryCode) {
        this.cityID = new SimpleStringProperty(cityID);
        this.cityName = new SimpleStringProperty(cityName);
        this.cityLatitude = new SimpleFloatProperty(cityLatitude);
        this.cityLongitude = new SimpleFloatProperty(cityLongitude);
        this.countryCode = new SimpleStringProperty(countryCode);
    }

    public String getCityID() {
        return cityID.get();
    }

    public StringProperty cityIDProperty() {
        return cityID;
    }

    public String getCityName() {
        return cityName.get();
    }

    public StringProperty cityNameProperty() {
        return cityName;
    }

    public float getCityLatitude() {
        return cityLatitude.get();
    }

    public FloatProperty cityLatitudeProperty() {
        return cityLatitude;
    }

    public float getCityLongitude() {
        return cityLongitude.get();
    }

    public FloatProperty cityLongitudeProperty() {
        return cityLongitude;
    }

    public String getCountryCode() {
        return countryCode.get();
    }

    public StringProperty countryCodeProperty() {
        return countryCode;
    }
}
