package API;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import Database.AccountTableRemote;
import Raw.RawAccount;
import Utils.JSONBuilder;
import Utils.jwtHandler;

@Path("/account")
public class accountAPI {
    @EJB
    private AccountTableRemote accountTableRemote;


    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/login")
    public Response auth(String UserJson) {
        RawAccount rawAccount = JSONBuilder.accountParser(UserJson);
        Long id = accountTableRemote.checkAccount(rawAccount.getUsername(), rawAccount.getPassword());
        if(id != null) {
            String jwt = jwtHandler.createJWT(rawAccount, id);
            return Response.status(200).entity(jwt).build();
        }

        return Response.status(403).build();
    }

    @POST
    @Consumes("text/plain")
    @Path("/checkToken")
    public Response verify(String jwtString) {
        RawAccount ret = jwtHandler.verify(jwtString);
        if(ret == null)
            return Response.status(400).entity("Session timeout!").build();
        Long id = accountTableRemote.checkAccount(ret.getUsername(), ret.getPassword());
        if(id != null) {
            String jwt = jwtHandler.createJWT(ret, id);
            return Response.status(200).entity(jwt).build();
        }
        return Response.status(403).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/register")
    public Response register(String UserJson) {

        RawAccount rawAccount = JSONBuilder.accountParser(UserJson);

        if(!accountTableRemote.checkUsername(rawAccount)) {
            return Response.status(406).build();
        }

        Long id = accountTableRemote.addAccount(rawAccount);
        if(id != null) {
            String jwt = jwtHandler.createJWT(rawAccount, id);
            return Response.status(200).entity(jwt).build();
        }

        return Response.status(400).build();
    }
}