package courses.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnrollmentDataDTO {



    private Integer id;


    private Timestamp dateOfEnrollment;


    private Timestamp dateofbirth;



    private String address;



    private String gender;



    private String phone;


    private String language;



    private String education;


    private Integer plan;



    private Integer student_id;


    private Integer course_id;

}

