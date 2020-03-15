package module3;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LifeExpectancy extends PApplet {
    UnfoldingMap map;

    Map<String, Float> lifeExpByCountry;
    List<Feature> countries;
    List<Marker> countryMarkers;

    public void setup() {
        size(800, 600, OPENGL);
        map = new UnfoldingMap(this, 50, 50, 700, 500,
                new Google.GoogleMapProvider());
        MapUtils.createDefaultEventDispatcher(this, map); // allows user to interact with map

        lifeExpByCountry = loadFileExpectancyFromCSV("data/LifeExpectancyWorldBankModule3.csv");

        countries = GeoJSONReader.loadData(this, "data/countries.geo.json");
        countryMarkers = MapUtils.createSimpleMarkers(countries);

        map.addMarkers(countryMarkers);
        shadeCountries();

    }

    public void draw() {
        map.draw();

    }

    private Map<String, Float> loadFileExpectancyFromCSV(String fileName) {
        Map<String, Float> lifeExpMap = new HashMap<>();
        String[] rows = loadStrings(fileName); // provided by PApplet

        for (String row : rows) {
            String[] columns = row.split(",");
            try {
                if (columns.length > 5) {
                    float value = Float.parseFloat(columns[5]);
                    lifeExpMap.put(columns[4], value);
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a float: " + columns[5]);
            }
        }
        return lifeExpMap;
    }

    private void shadeCountries() {
        for (Marker marker : countryMarkers) {
            String countryID = marker.getId();

            if(lifeExpByCountry.containsKey(countryID)) {
                float lifeExp = lifeExpByCountry.get(countryID);
                int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
                marker.setColor(color(255-colorLevel, 100, colorLevel));
            } else {
                marker.setColor(color(150,150,150));
            }

        }

    }
}
