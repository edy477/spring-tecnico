package courses.demo.dto;

import courses.demo.model.Enrollment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoursesResponseDataDTO {

   // @ApiModelProperty(position = 0)
    private Integer id;

   // @ApiModelProperty(position = 1)
    private String courseName;

  //  @ApiModelProperty(position = 2)
    private String created;

  //  @ApiModelProperty(position = 3)
    private String category;

  //  @ApiModelProperty(position = 4)
    private Timestamp startDate;

    private String duration;

    //  @ApiModelProperty(position = 5)
    private String description;


  //  @ApiModelProperty(position = 6)
//    private List<Enrollment> enrollments = new ArrayList<>();

}
