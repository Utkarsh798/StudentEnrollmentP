package com.example.EnrollmentNew.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    StudentRepository studentRepository;


//    {
//        "id": 1,
//            "name": "Utkarsh Amin",
//            "email": "aminUtkarsh@gmail.com",
//            "dob": "1998-07-19",
//            "major": "ComputerScience"
//    }

//    private List<Student> student= new ArrayList<>(Arrays.asList(
//               new Student(1,
//                       "Utkarsh Amin",
//                       "aminUtkarsh@gmail.com",
//                       LocalDate.of(1998, Month.JULY, 19),
//                       "ComputerScience"),
//               new Student(1,
//                    "Raj Mihir",
//                    "rajMihir@gmail.com",
//                    LocalDate.of(1994, Month.MAY, 16),
//                    "ComputerScience"),
//               new Student(1,
//                    "Raj Prinja;",
//                    "rajPrinjal@gmail.com",
//                    LocalDate.of(1998, Month.JULY, 19),
//                    "Exercise Science ")
//            ));

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudent(Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student,Integer id){
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }

}
