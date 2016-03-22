package controllers;

import dao.ForumDAO;
import dao.UserDAO;
import dao.impl.ForumDAOimpl;
import dao.impl.UserDAOimpl;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Singleton;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.*;
import java.util.Collection;

/**
 * Created by a.serebrennikova
 */
@Singleton
@Path("/user")
public class UserController {
    private Connection connection;
    private ObjectMapper mapper;
    private final UserDAO userDAO;

    public UserController(Connection connection) {
        this.connection = connection;
        mapper = new ObjectMapper();
        userDAO = new UserDAOimpl(connection);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("details")
    public Response details(@QueryParam("user") String email) throws IOException {
        CustomResponse response = userDAO.details(email);
        String json = mapper.writeValueAsString(response);
        return Response.ok().entity(json).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("create")
    public Response create(String userString) throws IOException {
        CustomResponse response = userDAO.create(userString);
        String json = mapper.writeValueAsString(response);
        return Response.ok().entity(json).build();
    }

}