package Utils;

import Model.Location;
import Model.Record;
import Model.User;
import jakarta.json.*;
import jakarta.json.stream.JsonParsingException;
import Raw.RawAccount;
import Raw.RawChat;
import Raw.RawMessage;
import Raw.Token;

import java.io.StringReader;
import java.util.List;

public class JSONBuilder {
    public static String tokenParser(String payload) {
        JsonObject object ;
        try {
            JsonReader reader = Json.createReader(new StringReader(payload));
            object = reader.readObject();
        } catch(JsonParsingException e) {
            return "Unauthorized";
        }
        return object.getString("iss");
    }

    public static String tokenJson(Token token) {
        JsonObject value = Json.createObjectBuilder()
                .add("token", token.getToken())
                .add("state", token.getState())
                .build();

        return value.toString();
    }

    public static String messageJson(RawMessage message) {
        JsonObject value = Json.createObjectBuilder()
                .add("time", message.getTime().toString())
                .add("from", message.getFrom())
                .add("to", message.getTo())
                .add("text", message.getText())
                .build();

        return value.toString();
    }

    public static String chatJson(RawChat chat) {
        JsonArrayBuilder messages = Json.createArrayBuilder();
        for(RawMessage i : chat.getMessages()) {
            messages.add(messageJson(i));
        }

        JsonObject value = Json.createObjectBuilder()
                .add("from", chat.getFrom())
                .add("to", chat.getTo())
                .add("message", messages.toString())
                .build();

        return value.toString();
    }

    public static RawAccount accountParser(String json) {
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject obj = reader.readObject();

        return new RawAccount(obj.getString("username"),
                obj.getString("password"));
    }

    public static String UserJson(User user, Location location) {
        JsonObject ret = Json.createObjectBuilder()
                .add("name", user.getName())
                .add("avatar", user.getAvatar())
                .add("age", user.getAge())
                .add("height", user.getHeight())
                .add("address", location.getAddress())
                .add("longitude", location.getLongitude())
                .add("latitude", location.getLatitude())
                .build();
        return ret.toString();
    }

    public static JsonObject recordJson(Record record) {
        JsonObject ret = Json.createObjectBuilder()
                .add("time", record.getTime().toString())
                .add("weight", record.getWeight())
                .add("height", record.getHeight())
                .add("blood_pressure", record.getBloodPressure())
                .add("cholesterol", record.getCholesterol())
                .add("heart_beat", record.getHeartBeat())
                .build();

        return ret;
    }

    public static String recordsJson(List<Record> records) {
        JsonArrayBuilder ret = Json.createArrayBuilder();
        for(Record i : records) {
            ret.add(recordJson(i));
        }

        return ret.build().toString();

    }

}
