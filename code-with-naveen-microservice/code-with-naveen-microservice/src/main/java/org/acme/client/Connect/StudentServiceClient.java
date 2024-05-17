package org.acme.client.Connect;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.client.Entity.Student;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient
public interface StudentServiceClient {

  @GET
  @Path("/getAll")
  @Produces(MediaType.APPLICATION_JSON)
  List<Student> getALlStudent();

  @GET
  @Path("/getByUserName/{userName}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)

  Student getByUserName(@PathParam("userName") String userName);
}
