package org.acme.client.Entity;


import lombok.Data;

@Data
public class Student {

  private String userName;

  private String email;

  private String className;

  private String section;

  private String address;

  private Long number;
}
