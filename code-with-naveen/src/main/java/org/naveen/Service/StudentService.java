package org.naveen.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.naveen.DAO.StudentRepo;
import org.naveen.Dto.StudentVo;
import org.naveen.Entity.Student;
import org.naveen.mappers.StudentMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
@Slf4j
public class StudentService {

  private final StudentRepo studentRepo;

//  @Inject
//  StudentMapper studentMapper;

  public StudentService(StudentRepo studentRepo) {
    this.studentRepo = studentRepo;
  }

  @Transactional
  public Response getAllStudents() {
    List<Student> students = studentRepo.listAll(); // Use plural for consistency

//    // Mapping with error handling (assuming toStudentVo throws exceptions)
//    List<StudentVo> studentVos = students.stream()
//      .map(student -> {
//        try {
////          return studentMapper.toStudentVo(student);
//        } catch (Exception e) {
//          // Handle mapping exceptions gracefully (log, return default value)
//          log.error("Error mapping student to StudentVo", e);
//          return new StudentVo(); // Or provide a default StudentVo with minimal values
//        }
//      })
//      .collect(Collectors.toList());

    return Response.ok(students).build();
  }


  @Transactional
  public Response addStudent(StudentVo studentVo) {
    Student student=new Student();

    student.setAddress(studentVo.getAddress());
    student.setEmail(studentVo.getEmail());
    student.setNumber(studentVo.getNumber());
    student.setClassName(studentVo.getClassName());
    student.setUserName(studentVo.getUserName());
    student.setSection(studentVo.getSection());

    studentRepo.persist(student);

    return Response.status(Response.Status.CREATED).entity("user register").build();


  }

  public Response updateStudent(Long id, StudentVo studentVo) {

    try {
      Optional<Student> studentUpadte = Optional.ofNullable(studentRepo.findById(id));
      Student student = studentUpadte.get();

      student.setAddress(studentVo.getAddress());
      student.setSection(studentVo.getSection());
      student.setEmail(studentVo.getEmail());
      student.setNumber(studentVo.getNumber());
      student.setClassName(studentVo.getClassName());
      student.setUserName(studentVo.getUserName());

      studentRepo.persist(student);
      return Response.ok("Updated successfully").build();
    }catch (Exception e){
      return Response.serverError().build();

    }
  }

  public String deleteStudent(long id) {
    studentRepo.deleteById(id);
    return "deleted successfully";
  }

  @Transactional
  public List<Student> getStudentById(long id) {
    return (List<Student>) studentRepo.findById(id);

  }
}
