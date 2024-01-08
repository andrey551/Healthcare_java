package Raw;

public class RawRecord {
    private Long weight;
    private Long height;
    private Long heart_beat;
    private Long blood_pressure;
    private Long cholesterol;

    public RawRecord(Long weight,
                     Long height,
                     Long heart_beat,
                     Long blood_pressure,
                     Long cholesterol) {
        this.weight = weight;
        this.height = height;
        this.blood_pressure = blood_pressure;
        this.cholesterol = cholesterol;
        this.heart_beat = heart_beat;
    }

    public RawRecord() {

    }

    public Long getWeight() {
        return weight;
    }

    public Long getHeight() {
        return height;
    }

    public Long getBlood_pressure() {
        return blood_pressure;
    }

    public Long getCholesterol() {
        return cholesterol;
    }

    public Long getHeart_beat() {
        return heart_beat;
    }
}
