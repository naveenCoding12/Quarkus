package org.naveen.DAO;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.naveen.Entity.Student;

import java.util.List;

@ApplicationScoped
public class StudentRepo implements PanacheRepository<Student> {

  @Inject
  EntityManager entityManager;


  public Student findByUserName(String userName) {
    return find("userName", userName).firstResult();
  }





  public List<Student> findByAge(int age) {
    Query query = entityManager.createNativeQuery("SELECT * FROM Student WHERE age = :age", Student.class);
    query.setParameter("age", age);
    return query.getResultList();
  }
}
