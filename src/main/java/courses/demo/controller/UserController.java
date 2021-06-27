
package courses.demo.controller;
import courses.demo.dto.CoursesResponseDataDTO;
import courses.demo.dto.LoginDTO;
import courses.demo.dto.UserDataDTO;
import courses.demo.dto.UserResponseDTO;
import courses.demo.model.Courses;
import courses.demo.model.Enrollment;
import courses.demo.model.User;

import courses.demo.repository.CourseRepository;
import courses.demo.repository.EnrollmentRepository;
import courses.demo.repository.UserRepository;

import courses.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import courses.demo.dto.ObjectMapperUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Tag(name = "users", description = "users API")
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {


    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private UserService userService;

    @Autowired
    private EnrollmentRepository enrollsStudent;



    @Operation(description = "Get all Courses")
    @ApiResponse(responseCode = "200", description = "ok")
    @GetMapping(value = "/courses", produces = "application/json;charset=utf-8")
    public List<CoursesResponseDataDTO> getAllCourses() {

        List<Courses> allcourses = courseRepo.findAll();
        List<CoursesResponseDataDTO> listCourses = new ArrayList<CoursesResponseDataDTO>();
        listCourses= ObjectMapperUtils.mapAll(allcourses, CoursesResponseDataDTO.class);


        return listCourses;


        // Flux<User> response // return (Flux<User>) userRepo.findAll().collectList().flatMapMany(Flux::just);

    }



    @Operation(description = "Get all Users")
    @ApiResponse(responseCode = "200", description = "ok")
    @GetMapping(value = "/users", produces = "application/json;charset=utf-8")
    public List<UserResponseDTO> getAll() {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        List<User> getAll = userRepo.findAllUsers();
        List<UserResponseDTO> listUsers = new ArrayList<UserResponseDTO>();

        List<UserResponseDTO> entityToDto = modelMapper.map(getAll, new TypeToken<List<UserResponseDTO>>() {
        }.getType());

        return entityToDto;


        // Flux<User> response // return (Flux<User>) userRepo.findAll().collectList().flatMapMany(Flux::just);

    }


    @PostMapping("/users/signin")
    @Operation(method = "${UserController.signin}")
    @ApiResponse(responseCode = "200", description = "ok")
    /*@ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid username/password supplied")})*/
    public String signin(@Parameter(description = "Signin User") @RequestBody LoginDTO user
    ) {
        return userService.signin(user);


    }


    @PostMapping("/users/signup")
    @Operation(method = "${UserController.signup}")

    @ApiResponses(value = {//
            @ApiResponse(responseCode = "400", description = "Something went wrong"), //
            @ApiResponse(responseCode = "403", description = "Access denied"), //
            @ApiResponse(responseCode = "422", description = "Username is already in use")})
    public String signup(@Parameter(description = "Signup User") @RequestBody UserDataDTO user) {
        return userService.signup(modelMapper.map(user, User.class));
    }


    @PostMapping(value = "/{username}/enroll",produces = "application/json;charset=utf-8")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @ApiOperation(value = "${UserController.enroll}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(responseCode = "400", description = "Something went wrong"), //
            @ApiResponse(responseCode = "403", description = "Access denied"), //
            @ApiResponse(responseCode = "404", description = "The user doesn't exist"), //
            @ApiResponse(responseCode = "500", description = "Expired or invalid JWT token")})
    public Enrollment enroll(@Parameter(description = "course_id") @RequestParam Integer course_id, HttpServletRequest req, @Parameter(description = "Enroll enroll") @RequestBody Enrollment enroll) {

        return userService.enrolluser(enroll, req, course_id);

        // return modelMapper.map(userService.search(username), UserResponseDTO.class);
    }


    @GetMapping(value = "/{username}/mycourses",produces = "application/json;charset=utf-8")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
   // @@Operation( method= "${UserController.courses}", responses = {CoursesResponseDataDTO.class}, authorizations = { @Authorization(value="apiKey") })
    //@ApiOperation(value = "${UserController.me}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(responseCode = "400", description = "Something went wrong"), //
            @ApiResponse(responseCode = "403", description = "Access denied"), //
            @ApiResponse(responseCode = "500", description = "Expired or invalid JWT token")})
    public List<CoursesResponseDataDTO> getCourses(HttpServletRequest req, @PathVariable String username) {

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        List<CoursesResponseDataDTO> courses = new ArrayList<CoursesResponseDataDTO>();
       List<Courses>  allcourses=  userService.getCourses(req);

        List<CoursesResponseDataDTO> listOfPostDTO = ObjectMapperUtils.mapAll(allcourses, CoursesResponseDataDTO.class);


        return listOfPostDTO;

    }



}