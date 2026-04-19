package springBootRestAPI.StudManagement.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateStudentDTO {
    @NotBlank(message = "Student name is required")
    private String studName;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Student email is required")
    private String studEmail;
    private String studCourse;

}
