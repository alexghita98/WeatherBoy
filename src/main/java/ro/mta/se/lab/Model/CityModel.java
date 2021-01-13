package ro.mta.se.lab.Model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class CityModel {
    IntegerProperty cityID;
    StringProperty cityName;
    FloatProperty cityLatitude;
    FloatProperty cityLongitude;
    StringProperty countryCode;

    public CityModel(IntegerProperty cityID, StringProperty cityName, FloatProperty cityLatitude,
                     FloatProperty cityLongitude, StringProperty countryCode) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.cityLatitude = cityLatitude;
        this.cityLongitude = cityLongitude;
        this.countryCode = countryCode;
    }

    public int getCityID() {
        return cityID.get();
    }

    public IntegerProperty cityIDProperty() {
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
