package org.naveen.DAO;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.naveen.Entity.Student;

@ApplicationScoped
public class StudentRepo implements PanacheRepository<Student> {
}
