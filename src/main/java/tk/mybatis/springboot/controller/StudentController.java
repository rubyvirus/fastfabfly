package tk.mybatis.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.springboot.model.Student;
import tk.mybatis.springboot.service.StudentService;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-5.
 */

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping
    public void findAllStudent() {
        for (Student student :
                studentService.findAllStudent()) {
            System.out.println(student.toString());
        }
    }

    @RequestMapping(value = "/{id}")
    public void findStudentById(@PathVariable Integer id) {
        System.out.println(studentService.findStudentById(id).toString());
    }
}
