package courses.demo.service;

//import courses.demo.exception.CustomException;
import courses.demo.dto.LoginDTO;
import courses.demo.exception.CustomException;
import courses.demo.model.Courses;
import courses.demo.model.Enrollment;
import courses.demo.model.User;
import courses.demo.repository.CourseRepository;
import courses.demo.repository.EnrollmentRepository;
import courses.demo.repository.UserRepository;
//import courses.demo.security.JwtTokenProvider;
import courses.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnrollmentRepository enrollRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(LoginDTO user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword() ));
            return jwtTokenProvider.createToken(user.getUsername(), userRepository.findByUsername(user.getUsername()).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    public String updateprofile(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.saveAndFlush(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }



    public Enrollment enrolluser(Enrollment enroll, HttpServletRequest req, Integer course_id) {


        User actual = userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
        Integer cs_id = actual.getId();
        Courses ctms = courseRepo.getOne(course_id);
        //CoursesEntity cop = actual.getEnrollments().
        final int[] flag = {0};
        List<Enrollment> enrollments = userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req))).getEnrollments();

        for (Enrollment cts : enrollments) {

            System.out.println(cts.getCourse_id());
            if (cts.getCourse_id() == course_id) {
                flag[0] = 1;
            }

        }

        if (flag[0] != 1) {
            enroll.setStudentEnrollment(actual);
            enroll.setCoursesList(ctms);
            enrollRepo.save(enroll);
            return enroll;
        } else {
            throw new CustomException("Cant enroll the same course", HttpStatus.CONFLICT);
        }


    }


    public String unenroll( HttpServletRequest req, Integer course_id) {


        User actual = userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
        Integer cs_id = actual.getId();
        Courses ctms = courseRepo.getOne(course_id);

        Enrollment enrollment = userRepository.findAllByEnrollment(actual.getId(),course_id);

        enrollRepo.delete(enrollment);

        return "Unenrolled";
    }


    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public List<Courses> getCourses(HttpServletRequest req) {
        User actual = userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));

        //ystem.console(userRepository.findAllCourses(actual.getId()));
        return userRepository.findAllCourses(actual.getId());
    }



    public User search(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }



    public User whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
    }



}




