package Raw;

import java.util.List;

public class RawChat {
    private String from;
    private String to;
    List<RawMessage> messages;

    public RawChat(String from,
                   String to,
                   List<RawMessage> messages) {
        this.from = from;
        this.to = to;
        this.messages = messages;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public List<RawMessage> getMessages() {
        return messages;
    }
}
