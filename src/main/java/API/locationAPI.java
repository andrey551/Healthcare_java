package API;

import Database.LocationTableRemote;
import Database.StoreTableRemote;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/location")
public class locationAPI {
    @EJB
    LocationTableRemote locationTableRemote ;

    @EJB
    StoreTableRemote storeTableRemote;
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("/store")
    public Response getStore(@Context HttpHeaders httpHeaders) {
        return Response.ok().build();
    }
}