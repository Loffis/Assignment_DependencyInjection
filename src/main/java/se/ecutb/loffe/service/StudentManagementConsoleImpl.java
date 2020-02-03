package se.ecutb.loffe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.ecutb.loffe.data_access.StudentDao;
import se.ecutb.loffe.models.Student;
import se.ecutb.loffe.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement{

    private UserInputService scannerService;
    private StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        return studentDao.save(new Student (scannerService.getInt(), scannerService.getString()));
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student student = studentDao.find(id);
        studentDao.delete(student.getId());
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        student.setName(scannerService.getString());
        return student;
    }
}
