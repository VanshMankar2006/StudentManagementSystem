package springBootRestAPI.StudManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBootRestAPI.StudManagement.Entity.Student;

// this will intermediate layer between controller and Entity(database)
// it will use JPA repository to interact with database,
// it will provide basic CRUD operations for student entity, we can also add custom query methods if needed
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
