package playground;

public class Location {
    public long latitude;
    public long longtitude;

    public Location(long lat, long lo) {
        this.latitude = lat;
        this.longtitude = lo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longtitude=" + longtitude +
                '}';
    }
}
