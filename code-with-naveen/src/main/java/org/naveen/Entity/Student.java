package org.naveen.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String userName;

  private String email;

  private String className;

  private String section;

  private String address;

  private Long number;


}
