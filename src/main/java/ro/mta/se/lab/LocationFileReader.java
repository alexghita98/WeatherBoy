package ro.mta.se.lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LocationFileReader {
    public static ArrayList<HashMap<String, String>> readFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        ArrayList<HashMap<String, String>> allLocations = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            if (tokens.length == 5) {
                HashMap<String, String> locationData = new HashMap<String, String>();

                locationData.put("id", tokens[0]);
                locationData.put("name", tokens[1]);
                locationData.put("lat", tokens[2]);
                locationData.put("lon", tokens[3]);
                locationData.put("code", tokens[4]);

                allLocations.add(locationData);
            }
        }

        return allLocations;
    }
}
