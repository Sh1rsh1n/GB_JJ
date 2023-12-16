package github.sh1rsh1n.repository;

import java.util.ArrayList;
import java.util.List;

import github.sh1rsh1n.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CourseRepositoryImpl implements Repository<Course, Integer> {

    private final Session session;

    public CourseRepositoryImpl() {
        this.session = connectionConfig();
    }

    @Override
    public boolean add(Course course) {
        if  (course != null) {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Course course) {
        if  (course != null) {
            session.beginTransaction();
            session.saveOrUpdate(course);
            session.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Course course) {
        boolean checkCourse = getAll().stream().anyMatch(c -> c.getId() == course.getId());
        if (checkCourse) {
            session.beginTransaction();
            session.remove(course);
            session.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Course getElementById(Integer integer) {

        session.beginTransaction();
        Course course = session.get(Course.class, integer);
        session.getTransaction().commit();

        return course;
    }

    @Override
    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();

        session.beginTransaction();
        session.get()
        session.getTransaction().commit();

        return null;
    }

    private Session connectionConfig() {
        try (SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory())
        {
            return sf.getCurrentSession();
        }
    }

}