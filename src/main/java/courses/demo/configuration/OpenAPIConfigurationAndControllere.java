package courses.demo.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@SecurityScheme(
        name = "basicAuth", // can be set to anything
        type = SecuritySchemeType.HTTP,
        scheme = "Basic"
)
@OpenAPIDefinition(
        info = @Info(title = "Sample API", version = "v3")
)
class DocsConfiguration {

}

// Controller usage example
@Tag(name = "Transactions")
@RestController
@RequestMapping("/api/users/")
class TransactionsController {

    @GetMapping()
    public String getLogs() {
        return "";
    }

    // name refereces value defined in the line 3
    @Operation(security = @SecurityRequirement(name = "Bearer"))
    @GetMapping("/mycourses")
    public String getHealth() {
        return "Ok";
    }
}