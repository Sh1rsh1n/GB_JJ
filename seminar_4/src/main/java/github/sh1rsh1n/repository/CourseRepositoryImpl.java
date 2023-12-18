package github.sh1rsh1n.repository;

import github.sh1rsh1n.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CourseRepositoryImpl implements Repository<Course> {
    private final SessionFactory sessionFactory;
    private Session session;

    public CourseRepositoryImpl() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

    @Override
    public boolean save(Course course) {

        try {
            session = sessionFactory.getCurrentSession();
            if (course != null) {
                session.beginTransaction();
                session.saveOrUpdate(course);
                session.getTransaction().commit();
                return true;
            }
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            session = sessionFactory.getCurrentSession();
            if (id > 0) {
                session.beginTransaction();
                String query = "delete from Course where id=:param";
                session.createQuery(query).setParameter("param", id).executeUpdate();
                session.getTransaction().commit();
                return true;
            }
            return false;
        } finally {
            session.close();
        }

    }

    @Override
    public Course getElementById(Integer integer) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Course course = session.get(Course.class, integer);
            session.getTransaction().commit();
            return course;
        } finally {
            session.close();
        }
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
