package courses.demo.repository;

import courses.demo.model.Courses;
import courses.demo.model.Enrollment;
import courses.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

  boolean existsByUsername(String username);

  User findByUsername(String username);

  @Query("SELECT r.coursesList FROM Enrollment r where r.student_id = :id")
  List<Courses> findAllCourses(@Param("id") Integer id);

  @Transactional
  void deleteByUsername(String username);

  @Query("SELECT u FROM User u")
  List<User> findAllUsers();

  @Query("SELECT r FROM Enrollment r where r.studentEnrollment.id = :id  AND  r.coursesList.id = :courseid")
  Enrollment findAllByEnrollment(@Param("id") Integer id, @Param("courseid") Integer courseid);

  /*@Query("SELECT r.enrollments FROM User r where r.enrollments = :id")
  Enrollment findAllByEnrollment(@Param("id") Integer id);
*/

}
