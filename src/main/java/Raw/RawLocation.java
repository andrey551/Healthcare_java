package Raw;

import java.sql.Time;

public class RawLocation {
    private String name;
    private String address;

    private String avatar;
    private Float longitude;
    private Float latitude;

    private Time open;
    private Time close;

    private Float rating;
    private Long passengers;

    private String type;

    public RawLocation(String name,
                       String address,
                       String avatar,
                       Float longitude,
                       Float latitude,
                       Time open,
                       Time close,
                       Float rating,
                       Long passengers,
                       String type) {
        this.name = name;
        this.address = address;
        this.avatar = avatar;
        this.open = open;
        this.close = close;
        this.rating = rating;
        this.passengers = passengers;
        this.longitude = longitude;
        this.latitude = latitude;
        this.type = type;
    }

    public RawLocation() {

    }

    public Float getRating() {
        return rating;
    }

    public Long getPassengers() {
        return passengers;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Time getClose() {
        return close;
    }

    public Time getOpen() {
        return open;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public void setPassengers(Long passengers) {
        this.passengers = passengers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setClose(Time close) {
        this.close = close;
    }

    public void setOpen(Time open) {
        this.open = open;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
