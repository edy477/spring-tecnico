package courses.demo.repository;

import courses.demo.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Courses, Integer>{

    //CoursesEntity findById(Integer id);
    /*boolean existsByUsername(String username);

    User findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);*/

}




