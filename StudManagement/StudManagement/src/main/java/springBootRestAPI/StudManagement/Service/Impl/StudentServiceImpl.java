package springBootRestAPI.StudManagement.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springBootRestAPI.StudManagement.DTO.CreateStudentDTO;
import springBootRestAPI.StudManagement.DTO.StudentDTO;
import springBootRestAPI.StudManagement.Entity.Student;
import springBootRestAPI.StudManagement.Repository.StudentRepository;
import springBootRestAPI.StudManagement.Service.StudentService;

import java.util.List;
@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService{
    // for requires args constructor we need to make the variable final
    private final StudentRepository studentRepository;
    // we can also use model mapper to convert entity to dto
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudent() {
        return studentRepository.findAll().stream()
                .map(student -> new StudentDTO(
                        student.getStudId(),
                        student.getStudName(),
                        student.getStudEmail(),
                        student.getStudCourse()
                )).toList();
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO createStudent(CreateStudentDTO createStudentDTO) {
        Student student = modelMapper.map(createStudentDTO, Student.class);
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDTO.class);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO updateStudent(Long id, CreateStudentDTO createStudentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        modelMapper.map(createStudentDTO,student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }
}
