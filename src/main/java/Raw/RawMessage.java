package Raw;

import java.sql.Time;

public class RawMessage {
    private Time time;
    private String text;

    private String from;

    private String to;

    public RawMessage(Time time,
                      String text,
                      String from,
                      String to) {
        this.time = time;
        this.text = text;
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    public Time getTime() {
        return time;
    }
}
