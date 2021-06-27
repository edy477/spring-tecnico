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
public class LoginDTO {

    private String username;
    private String password;
    List<Role> roles;


}