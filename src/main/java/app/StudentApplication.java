package app;

import domain.Address;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.StudentRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class StudentApplication implements CommandLineRunner {


    @Autowired
    StudentRepository studentRepository;



    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("----------- Add 5 Students  ----------------");

        Address add1 = Address.builder()
                .street("1000 N, 4th St")
                .city("fairfield")
                .zip("52557")
                .build();

        Student st = Student.builder()
                .name("John")
                .email("john@gmail.com")
                .address(add1)
                .phoneNumber("123456789")
                .build();

        Address add2 = Address.builder()
                .street("800 N, 4th St")
                .city("fairfield")
                .zip("55666")
                .build();

        Student st2 = Student.builder()
                .name("Jack")
                .email("jack@gmail.com")
                .address(add2)
                .phoneNumber("3456782")
                .build();

        Address add3 = Address.builder()
                .street("8000 N, 4th St")
                .city("ottoumwa")
                .zip("52066")
                .build();

        Student st3 = Student.builder()
                .name("mike")
                .email("mike@gmail.com")
                .address(add3)
                .phoneNumber("8765429378")
                .build();

        Address add4 = Address.builder()
                .street("700 N, 4th St")
                .city("austin")
                .zip("55556")
                .build();

        Student st4 = Student.builder()
                .name("maggie")
                .email("maggie@gmail.com")
                .address(add4)
                .phoneNumber("2223456782")
                .build();

        Address add5 = Address.builder()
                .street("800 N, 4th St")
                .city("dalton")
                .zip("24556")
                .build();

        Student st5 = Student.builder()
                .name("henna")
                .email("henna@gmail.com")
                .address(add5)
                .phoneNumber("378729456782")
                .build();


        studentRepository.save(st);
        studentRepository.save(st2);
        studentRepository.save(st3);
        studentRepository.save(st4);
        studentRepository.save(st5);

        System.out.println("-------- find all students");
        System.out.println(studentRepository.findAll());
        System.out.println("-------- find student by name: John");
        System.out.println(studentRepository.findByName("John"));
        System.out.println("-------- find student by PhoneNumber: 8765429378");
        System.out.println(studentRepository.findByPhoneNumber("8765429378"));
        System.out.println("-------- find student by City: Fairfield");
        System.out.println(studentRepository.findByAddressCity("fairfield"));


    }

}
