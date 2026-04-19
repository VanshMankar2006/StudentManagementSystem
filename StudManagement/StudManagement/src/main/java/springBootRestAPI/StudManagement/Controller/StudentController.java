package springBootRestAPI.StudManagement.Controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBootRestAPI.StudManagement.DTO.CreateStudentDTO;
import springBootRestAPI.StudManagement.DTO.StudentDTO;
import springBootRestAPI.StudManagement.Service.StudentService;

import java.util.List;
// we never want repository and entity in controller because it will break
// the separation of concern and also it will make the code tightly coupled

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

// instead of it i can also use required args constructor and remove this constructor
    public StudentController( StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudent() {
        return ResponseEntity.ok(studentService.getAllStudent()) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent( @RequestBody @Valid CreateStudentDTO createStudentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(createStudentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody CreateStudentDTO createStudentDTO) {
        return ResponseEntity.ok(studentService.updateStudent(id, createStudentDTO));
    }
}
