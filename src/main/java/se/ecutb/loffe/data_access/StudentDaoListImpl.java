package se.ecutb.loffe.data_access;

import org.springframework.stereotype.Component;
import se.ecutb.loffe.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao{
    private List<Student> studentList = new ArrayList<>();

    @Override
    public Student save(Student student) {
        studentList.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        for (Student student : studentList){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void delete(int id) {
        studentList.remove(find(id));
        }

}
