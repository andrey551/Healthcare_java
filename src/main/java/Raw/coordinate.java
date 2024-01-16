package Raw;

public class coordinate {
    private Float longitude;
    private Float latitude;

    public coordinate(Float lon, Float lat) {
        this.longitude = lon;
        this.latitude = lat;
    }

    public coordinate() {}

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
