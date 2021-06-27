package courses.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import courses.demo.model.User;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enrollment", schema = "enrolla", catalog = "students")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_of_enrollment", nullable = true)
    private Timestamp dateOfEnrollment;

    @Column(name = "dateofbirth", nullable = true)
    private Timestamp dateofbirth;

    @Column(name = "address", nullable = true, length = 40)
    private String address;


    @Column(name = "gender", nullable = true, length = 40)
    private String gender;


    @Column(name = "phone", nullable = true, length = 40)
    private String phone;

    @Column(name = "language", nullable = true, length = 40)
    private String language;


    @Column(name = "education", nullable = true, length = 40)
    private String education;

    @Column(name = "plan", nullable = true, length = 40)
    private Integer plan;


    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer student_id;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer course_id;

 //   private CoursesEntity coursesByCourseId;
 @ManyToOne
 @JoinColumn(name = "course_id", referencedColumnName = "id")
 private Courses coursesList;

 @ManyToOne
 @JoinColumn(name = "student_id", referencedColumnName = "id")
 private  courses.demo.model.User studentEnrollment;



    public void setStudent_id(Integer student_id ){
        this.student_id= student_id;
    }

    public void setCourse_id(Integer course_id ){
        this.course_id= course_id;
    }

    public Courses getCoursesList() {
        return coursesList;
    }

    //@JoinColumn(name = "student_id", referencedColumnName = "id")

    /*@ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private  User studentEnrollment;*/


  /*  @Access(AccessType.PROPERTY)
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")*/
   // private  User studentEnrollment;
   /* @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private  UserEntity studentEnrollment;
*/
  /*  @Basic
    @Column(name = "date_of_enrollment", nullable = true)
    public Timestamp getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(Timestamp dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    @Basic
    @Column(name = "dateofbirth", nullable = true)
    public Timestamp getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Timestamp dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    @Basic
    @Column(name = "address", nullable = true, length = -1)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = -1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = -1)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "language", nullable = true, length = -1)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "education", nullable = true, length = -1)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "plan", nullable = true)
    public Integer getPlan() {
        return plan;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnrollmentEntity that = (EnrollmentEntity) o;

        if (id != that.id) return false;
        if (dateOfEnrollment != null ? !dateOfEnrollment.equals(that.dateOfEnrollment) : that.dateOfEnrollment != null)
            return false;
        if (dateofbirth != null ? !dateofbirth.equals(that.dateofbirth) : that.dateofbirth != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (plan != null ? !plan.equals(that.plan) : that.plan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dateOfEnrollment != null ? dateOfEnrollment.hashCode() : 0;
        result = 31 * result + (dateofbirth != null ? dateofbirth.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (plan != null ? plan.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    public CoursesEntity getCoursesByCourseId() {
        return coursesByCourseId;
    }




    public void setCoursesByCourseId(CoursesEntity coursesByCourseId) {
        this.coursesByCourseId = coursesByCourseId;
    }


 /*   @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public User getUsersById() {
        return studentEnrollment;
    }

    public void setUsersById(User studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

*/
}
