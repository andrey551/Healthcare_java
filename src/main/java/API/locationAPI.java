package API;

import Database.LocationTable;
import Database.LocationTableRemote;
import Database.UserTableRemote;
import Database.VisitedTableRemote;
import Model.Location;
import Model.Record;
import Model.User;
import Raw.RawAccount;
import Raw.RawLocation;
import Raw.RawLocationReq;
import Utils.JSONBuilder;
import Utils.jwtHandler;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ejb.EJB;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static Utils.JSONBuilder.locationsJson;

@Path("/location")
public class locationAPI {
    @EJB
    LocationTableRemote locationTableRemote ;


    @EJB
    UserTableRemote userTableRemote;
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("/filter")
    public Response getLoc(@Context HttpHeaders httpHeaders, RawLocationReq req) {
        List<String> headerList = httpHeaders.getRequestHeader("Authorization");
        if(headerList.isEmpty()) {
            return Response.status(401).build();
        }

        RawAccount ret = jwtHandler.verify(headerList.get(0));
        if(ret == null)
            return Response.status(400).entity("Session timeout!").build();
        User user = userTableRemote.getUserByAccountId(ret.getId());
        if(user != null) {
            List<Location> list = locationTableRemote.getLocs(req.getType());
            System.out.println(list.toString());
            return Response.status(200).entity(locationsJson(list)).build();
        }
        return Response.status(403).build();
    }
}