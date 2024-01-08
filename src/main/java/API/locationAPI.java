package API;

import jakarta.ws.rs.*;

@Path("/location")
public class locationAPI {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}