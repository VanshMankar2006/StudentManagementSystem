package springBootRestAPI.StudManagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {
    Long studId;
    String studName;
    String studEmail;
    String studCourse;
}
