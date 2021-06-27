package courses.demo.dto;

import courses.demo.model.Enrollment;
import courses.demo.model.Role;
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
public class UserResponseDTO {

 // @ApiModelProperty(position = 0)
  private Integer id;
 // @ApiModelProperty(position = 2)
  private String username;

//  @ApiModelProperty(position = 3)
  private String fullname;
  //@ApiModelProperty(position = 4)
  private String country;

//  @ApiModelProperty(position = 5)
  private String email;



 // @ApiModelProperty(position = 6)
  List<Role> roles;

//  @ApiModelProperty(position = 7)
  private List<Enrollment> enrollments = new ArrayList<>();


  /*public Integer getId() {
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

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }*/

}
