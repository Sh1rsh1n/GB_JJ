package github.sh1rsh1n.repository;

import java.sql.SQLException;
import java.util.Properties;

import github.sh1rsh1n.entity.Course;

public class CourseRepositoryImpl implements Repository<Course>{

    
    @Override
    public boolean add(Course course){

    }

    private SessionFactory connect() {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()){
                    return sessionFactory;
                }
        catch (SQLException exception){
            throw new RuntimeException();
        }
    }
}