package courses.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import courses.demo.model.Enrollment;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "enrolla", catalog = "students")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
  @Column(unique = true, nullable = false)
  private String username;

  @Column(unique = true, nullable = false)
  private String email;

  @Size(min = 8, message = "Minimum password length: 8 characters")
  private String password;

  @ElementCollection(fetch = FetchType.EAGER)
  List<Role> roles;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentEnrollment")
  private List<Enrollment> enrollments = new ArrayList<>();
/*
  @OneToMany(targetEntity=EnrollmentEntity.class, mappedBy="studentEnrollment",
          fetch=FetchType.EAGER)
  private List<EnrollmentEntity> enrollments = new ArrayList<>();*/

  private String  fullname;

  private String country;

  public   List<Enrollment> getEnrollments(){

    return enrollments;

  }
}

 // @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentEnrollment")
 //@OneToMany(targetEntity=EnrollmentEntity.class, mappedBy="studentEnrollment",
      //  fetch=FetchType.EAGER)
 ////@ElementCollection(fetch = FetchType.EAGER)
 /*@OneToMany(targetEntity=EnrollmentEntity.class, mappedBy="studentEnrollment",
         fetch=FetchType.EAGER)
  private List<EnrollmentEntity> enrollments = new ArrayList<>();
*/
/*
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }*/


