package playground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AirportSearch {
    public static void main(String[] args) {
        List<Airport> airports = new ArrayList<>();
        airports.add(new Airport("Montreal", "Canada", "YMX"));
        airports.add(new Airport("Lagos", "Nigeria", "LOS"));
        airports.add(new Airport("Essen", "Germany", "ESS"));
        airports.add(new Airport("Chicago", "USA", "ORD"));
        airports.add(new Airport("Beijing", "China", "PEK"));
        airports.add(new Airport("Sydney", "Australia", "SYD"));

        Collections.sort(airports);
        System.out.println(airports);
    }

    public static Airport findAirport(String toFind, Airport[] airports) {
        for(Airport a : airports) {
            String aName = a.getCity();
            if(toFind.equals(aName))
                return a;
        }
        return null;
    }

    public static Airport findAirportBS(String toFind, Airport[] airports) {
        int low = 0;
        int high = airports.length;
        int mid;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            int compare = toFind.compareTo(airports[mid].getCity());
            if (compare < 0) {
                high = mid - 1;
            }
            else if (compare > 0) {
                low = mid + 1;
            }
            else return airports[mid];
        }
        return null;
    }
}
