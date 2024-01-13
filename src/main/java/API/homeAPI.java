package API;

import Database.AccountTableRemote;
import Database.LocationTableRemote;
import Database.RecordTableRemote;
import Database.UserTableRemote;
import Model.Location;
import Model.Record;
import Model.User;
import Raw.RawAccount;
import Raw.RawRecord;
import Utils.JSONBuilder;
import Utils.jwtHandler;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Timestamp;
import java.util.List;

@Path("/home")
public class homeAPI {
    @EJB
    private AccountTableRemote accountTableRemote;
    @EJB
    private UserTableRemote userTableRemote;

    @EJB
    private LocationTableRemote locationTableRemote;

    @EJB
    private RecordTableRemote recordTableRemote;

    @GET
    @Produces("text/plain")
    @Path("/getUser")
    public Response getUser(@Context HttpHeaders httpHeaders) {
        List<String> headerList = httpHeaders.getRequestHeader("Authorization");
        if(headerList.isEmpty()) {
            return Response.status(401).build();
        }

        RawAccount ret = jwtHandler.verify(headerList.get(0));
        if(ret == null)
            return Response.status(400).entity("Session timeout!").build();

        User user = userTableRemote.getUserByAccountId(ret.getId());
        System.out.println(user);
        if(user != null) {
            return Response
                    .status(200)
                    .entity(JSONBuilder
                            .UserJson(user))
                    .build();
        }
        return Response.status(403).build();
    }

    @GET
    @Produces("text/plain")
    @Path("/getRecord")
    public Response getRecords(@Context HttpHeaders httpHeaders) {
        List<String> headerList = httpHeaders.getRequestHeader("Authorization");
        if(headerList.isEmpty()) {
            return Response.status(401).build();
        }

        RawAccount ret = jwtHandler.verify(headerList.get(0));
        if(ret == null)
            return Response.status(400).entity("Session timeout!").build();
        User user = userTableRemote.getUserByAccountId(ret.getId());
        if(user != null) {
            List<Record> records = recordTableRemote.getRecordByUserId(user.getId());
            return Response
                    .status(200)
                    .entity(JSONBuilder
                            .recordsJson(records))
                    .build();
        }
        return Response.status(403).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("/deleteRecord")
    public Response deleteRecord(@Context HttpHeaders httpHeaders, String time) {
        System.out.println(time);
        List<String> headerList = httpHeaders.getRequestHeader("Authorization");
        if(headerList.isEmpty()) {
            return Response.status(401).build();
        }

        RawAccount ret = jwtHandler.verify(headerList.get(0));
        if(ret == null)
            return Response.status(400).entity("Session timeout!").build();
        User user = userTableRemote.getUserByAccountId(ret.getId());
        if(user != null) {
            Long re = recordTableRemote.deleteRecordByTime(user.getId(), Timestamp.valueOf(time.substring(1, time.length() - 1)));
            if(re > 0) return Response.status(200).build();
        }
        return Response.status(403).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("addRecord")
    public Response addRecord(@Context HttpHeaders httpHeaders, RawRecord raw) {
        List<String> headerList = httpHeaders.getRequestHeader("Authorization");
        if(headerList.isEmpty()) {
            return Response.status(401).build();
        }

        RawAccount ret = jwtHandler.verify(headerList.get(0));
        if(ret == null)
            return Response.status(400).entity("Session timeout!").build();

        User user = userTableRemote.getUserByAccountId(ret.getId());
        if(user != null) {
            Record record = new Record(
                    raw.getHeart_beat(),
                    raw.getBlood_pressure(),
                    raw.getCholesterol(),
                    raw.getWeight(),
                    raw.getHeight(),
                    ret.getId());
            recordTableRemote.addRecord(record);
            return Response.status(200).build();
        }
        return Response.status(403).build();
    }

}

