package org.naveen.mappers;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.naveen.Dto.StudentVo;
import org.naveen.Entity.Student;


@ApplicationScoped
@Mapper(componentModel = "cdi",
  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {

  StudentVo toStudentVo(Student student);

  Student toStudent(StudentVo studentVo);
}
