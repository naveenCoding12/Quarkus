package org.acme.client.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.acme.client.Entity.Student;
import org.acme.client.Connect.StudentServiceClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class StudentService {

  @Inject
  @RestClient
  StudentServiceClient studentServiceClient;

  public Response getAllStudents() {

    List<Student> students=studentServiceClient.getALlStudent();

    return Response.ok(students).build();

  }

  public Response getByUserName(String userName) {

    Student student=studentServiceClient.getByUserName(userName);

    return Response.ok(student).build();
  }
}
