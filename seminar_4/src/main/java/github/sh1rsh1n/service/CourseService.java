package github.sh1rsh1n.service;

import github.sh1rsh1n.entity.Course;
import github.sh1rsh1n.repository.Repository;

import java.util.List;

public class CourseService implements Service<Course> {

    private Repository repository;

    public CourseService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Course course) {
        if (getAll().isEmpty() || !getAll().contains(course)) {
            repository.add(course);
            System.out.printf("Course %s is added successfully\n", course.getTitle());
            return;
        }
        repository.update(course);
        System.out.printf("Course %s is updated successfully\n", course.getTitle());
    }

    @Override
    public void remove(Course course) {

    }

    @Override
    public Course getElementById(Integer integer) {
        return null;
    }

    @Override
    public List<Course> getAll() {
        return repository.getAll();
    }
}