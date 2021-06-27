package courses.demo.dto;

import courses.demo.model.Enrollment;
import courses.demo.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDTO {
  
//  @ApiModelProperty(position = 0)

  private String username;
  //@ApiModelProperty(position = 1)
  private String fullname;
//  @ApiModelProperty(position = 2)
  private String country;
 // @ApiModelProperty(position = 3)
  private String email;
 // @ApiModelProperty(position = 4)
  private String password;
  //@ApiModelProperty(position = 5)
  List<Role> roles;

  private List<Enrollment> enrollments = new ArrayList<>();



  public   List<Enrollment> getEnrollments(){

        return enrollments;

    }

//  @ApiModelProperty(position = 6)
  /*private List<Enrollment> enrollments = new ArrayList<>();

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

}
