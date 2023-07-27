package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByName(String name);
    List<Student> findByPhoneNumber(String phone);
    List<Student> findByAddressCity(String city);



}




