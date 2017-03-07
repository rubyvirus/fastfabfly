package tk.mybatis.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.mapper.StudentMapper;
import tk.mybatis.springboot.model.Student;

import java.util.List;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-5.
 */

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;


    public List<Student> findAllStudent(){
        return studentMapper.selectAll();
    }

    public Student findStudentById(int id){
        return studentMapper.findStudentById(id);
    }
}
