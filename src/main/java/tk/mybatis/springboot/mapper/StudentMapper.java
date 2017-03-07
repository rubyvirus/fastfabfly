package tk.mybatis.springboot.mapper;

import tk.mybatis.springboot.model.Student;
import tk.mybatis.springboot.util.MyMapper;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-5.
 */

public interface StudentMapper extends MyMapper<Student> {

    public Student findStudentById(int id);
}
