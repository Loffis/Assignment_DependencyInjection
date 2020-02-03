package se.ecutb.loffe.data_access;

import se.ecutb.loffe.models.Student;

import java.util.List;

public interface StudentDao {
    Student save(Student student);
    Student find(int id);
    List<Student> findAll();
    void delete(int id);

}
