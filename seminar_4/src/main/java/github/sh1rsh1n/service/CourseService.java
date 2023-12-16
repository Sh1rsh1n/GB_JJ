package github.sh1rsh1n.service;

import github.sh1rsh1n.entity.Course;
import github.sh1rsh1n.repository.CourseRepositoryImpl;

public class CourseService {

    private CourseRepositoryImpl repository;

    public CourseService(CourseRepositoryImpl repository) {
        this.repository = repository;
    }

    public void saveCourse(Course course) {


    }

    public void removeCourse(Course course){
        
    }
}