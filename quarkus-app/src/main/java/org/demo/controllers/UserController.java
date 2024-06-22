package org.demo.controllers;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.demo.entities.User;
import org.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/api/v1/users")
public class UserController {
    List<Map<String, Object>> users = new ArrayList<>();

    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUser(){

        return Response.ok(userService.getAllUser()).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user){
        User savedUser = userService.createUser(user);
        return Response.ok(savedUser).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") long id, User user){
       userService.updateUserById(id, user);
        return Response.ok(user).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUser(@PathParam("id") long id){
        userService.deleteUserById(id);
        return Response.ok("User deleted successfully").build();
    }

    @GET
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id){
        return Response.ok(userService.getUserById(id)).build();
    }

}
