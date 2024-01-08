package API;

import jakarta.ws.rs.*;

@Path("/profile")
public class profileAPI {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}