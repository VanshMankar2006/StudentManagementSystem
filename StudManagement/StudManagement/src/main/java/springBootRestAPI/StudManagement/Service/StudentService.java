package springBootRestAPI.StudManagement.Service;

import springBootRestAPI.StudManagement.DTO.CreateStudentDTO;
import springBootRestAPI.StudManagement.DTO.StudentDTO;
import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudent();

    StudentDTO getStudentById(Long id);

     StudentDTO createStudent(CreateStudentDTO createStudentDTO);

    void deleteStudent(Long id);

    StudentDTO updateStudent(Long id, CreateStudentDTO createStudentDTO);
}
