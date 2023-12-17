package github.sh1rsh1n.repository;

import java.util.List;
import java.util.Optional;

import github.sh1rsh1n.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CourseRepositoryImpl implements Repository<Course, Integer> {
    private final SessionFactory sessionFactory;
    private Session session;

    public CourseRepositoryImpl() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

    @Override
    public boolean add(Course course) {

        try {
            session = sessionFactory.getCurrentSession();
            if (course != null) {
                session.beginTransaction();
                session.save(course);
                session.getTransaction().commit();
                return true;
            }
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Course course) {
        Optional<Course> optionalCourse = getAll().stream().filter(c -> c.getId() == course.getId()).findFirst();
        if (optionalCourse.isPresent()) {
            session.beginTransaction();
            session.update(optionalCourse.get());
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

        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            List<Course> courses = session.createQuery("from Course").getResultList();
            session.getTransaction().commit();

            return courses;
        } finally {
            session.close();
        }
    }
}
