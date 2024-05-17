package org.naveen.Resources;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.naveen.Dto.StudentVo;
import org.naveen.Entity.Student;
import org.naveen.Service.StudentService;

import java.util.List;

@Path("/student")
public class StudentResource {

  @Inject
  private StudentService studentService;

  @GET
  @Path("/getAll") // Moved the Path annotation inside the method
  @Produces(MediaType.APPLICATION_JSON) // Corrected the typo in "application-json"
  public Response getAllStudents(){
    return studentService.getAllStudents();
  }

  @POST
  @Path("/add")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)

  public Response saveUser(@RequestBody StudentVo studentVo){
    return studentService.addStudent(studentVo);
  }



  @GET
  @Path("/getById/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)

  public List<Student> getStudentById(@PathParam("id") long id){
    return studentService.getStudentById(id);
  }



  @PUT
  @Path("/update/{id}") // Corrected the path parameter
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public Response updateStudent(@PathParam("id") Long id, @Valid StudentVo studentVo){ // Changed @RequestBody to @Valid
    return studentService.updateStudent(id, studentVo);
  }


  @DELETE
  @Path("/delete/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)

  public String deleteStudent(@PathParam("id") long id){
    return studentService.deleteStudent(id);
  }
}
