package github.sh1rsh1n.service;

import github.sh1rsh1n.entity.Course;
import github.sh1rsh1n.repository.Repository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CourseService implements Service<Course> {

    private Repository<Course> repository;

    public CourseService(Repository<Course> repository) {
        this.repository = repository;
    }

    @Override
    public void save(Course course) {
        repository.save(course);
        System.out.printf("Course %s is save successfully.\n", course.getTitle());
    }

    @Override
    public void remove(int id) {
        if (repository.remove(id)) {
            System.out.println("Course is deleted successfully.\n");
            return;
        }
        System.out.println("Course isn't found.\n");
    }

    @Override
    public Course getElementById(Integer id) {
        Optional<Course> optional = getAll().stream().filter(course -> id.equals(course.getId())).findAny();
        if (!optional.isPresent()) {
            System.out.println("Element not found in DB.");
            return optional.orElse(new Course());
        }
        return repository.getElementById(id);
    }

    @Override
    public List<Course> getAll() {
        List<Course> courses = repository.getAll();
        if (!courses.isEmpty()) {
            return courses;
        }
        return Collections.emptyList();
    }
}