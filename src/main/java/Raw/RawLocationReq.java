package Raw;

public class RawLocationReq {
    private String type;
    private String target;

    public RawLocationReq(String type,
                          String target) {
        this.type = type;
        this.target = target;
    }

    public RawLocationReq() {

    }

    public String getTarget() {
        return target;
    }

    public String getType() {
        return type;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RawLocationReq{" +
                "type='" + type + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
