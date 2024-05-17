package org.acme.client.Resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.client.Service.StudentService;

@Path("/student-client")
public class MicroServiceResource {


  @Inject
  StudentService studentService;


  @GET
  @Path("/fetchAll")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllStudentList(){
    return studentService.getAllStudents();
  }

  @GET
  @Path("/fetchByUserName/{userName}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)

  public Response getByUserName(@PathParam("userName") String userName){
    return studentService.getByUserName(userName);
  }



}
