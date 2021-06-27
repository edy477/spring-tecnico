package courses.demo.repository;

import courses.demo.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {



}
