package API;

import jakarta.ws.rs.*;

@Path("/hello-world")
public class chatAPI {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}