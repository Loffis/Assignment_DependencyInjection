package se.ecutb.loffe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.ecutb.loffe.config.ComponentScanConfig;
import se.ecutb.loffe.data_access.StudentDao;
import se.ecutb.loffe.models.Student;
import se.ecutb.loffe.service.StudentManagementConsoleImpl;
import se.ecutb.loffe.util.UserInputService;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService = context.getBean(UserInputService.class);

        StudentManagementConsoleImpl management = context.getBean(StudentManagementConsoleImpl.class);

        Student s1 = new Student(1, "Loffe");
        Student s2 = new Student(2, "Oscar");
        Student s3 = new Student(3, "Erik");

        studentDao.save(s1);
        studentDao.save(s2);
        studentDao.save(s3);

        System.out.println(studentDao.findAll());

        Student s4 = management.create();
        management.save(s4);
        management.edit(s2);

        System.out.println(management.findAll());
    }
}
