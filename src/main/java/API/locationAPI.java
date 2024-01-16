package API;

import Database.*;
import Model.*;
import Model.Record;
import Raw.*;
import Utils.JSONBuilder;
import Utils.jwtHandler;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ejb.EJB;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static Utils.JSONBuilder.SpecsJson;
import static Utils.JSONBuilder.locationsJson;

@Path("/location")
public class locationAPI {
    @EJB
    LocationTableRemote locationTableRemote ;


    @EJB
    UserTableRemote userTableRemote;

    @EJB
    CommentTableRemote commentTableRemote;

    @EJB
    SpecializationTableRemote specializationTableRemote;
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

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("/getComment")
    public Response getComment(@Context HttpHeaders httpHeaders, coordinate coor) {
        List<String> headerList = httpHeaders.getRequestHeader("Authorization");
        if(headerList.isEmpty()) {
            return Response.status(401).build();
        }

        RawAccount ret = jwtHandler.verify(headerList.get(0));
        if(ret == null)
            return Response.status(400).entity("Session timeout!").build();
        Long locationId = locationTableRemote.getIdByCoordinate(coor);
        if(locationId != null) {
            List<RawComment> listComment = commentTableRemote.getCommentsByHospitalId(locationId);
            return Response
                    .status(200)
                    .entity(JSONBuilder.commentsJson(listComment))
                    .build();
        }

        return Response.status(403).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("/addComment")
    public Response addComment(@Context HttpHeaders httpHeaders, WrapComment wrap) {
        coordinate coor = wrap.getCoor();
        Comment comment = wrap.getComment();
        System.out.println(coor.toString());
        System.out.println(comment.toString());
        List<String> headerList = httpHeaders.getRequestHeader("Authorization");
        if(headerList.isEmpty()) {
            return Response.status(401).build();
        }

        RawAccount ret = jwtHandler.verify(headerList.get(0));
        if(ret == null)
            return Response.status(400).entity("Session timeout!").build();
        Long locationId = locationTableRemote.getIdByCoordinate(coor);
        if(locationId != null) {
            comment.setUser_id(ret.getId());
            comment.setLocation_id(locationId);
            if(commentTableRemote.addComment(comment))
                return Response.status(200).build();
        }
        return Response.status(403).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("/getDepartment")
    public Response getDepartment(@Context HttpHeaders httpHeaders, coordinate coor) {
        List<String> headerList = httpHeaders.getRequestHeader("Authorization");
        if(headerList.isEmpty()) {
            return Response.status(401).build();
        }

        RawAccount ret = jwtHandler.verify(headerList.get(0));
        if(ret == null)
            return Response.status(400).entity("Session timeout!").build();
        Long locationId = locationTableRemote.getIdByCoordinate(coor);
        if(locationId != null) {
            List<Specialization> listSpec = specializationTableRemote.getSpecializationsByHospitalId(locationId);
            return Response.status(200).entity(SpecsJson(listSpec)).build();
        }
        return Response.status(403).build();
    }
}