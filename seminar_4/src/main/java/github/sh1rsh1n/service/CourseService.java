package github.sh1rsh1n.service;

import github.sh1rsh1n.repository.CourseRepositoryImpl;

public class CourseService {

    private CourseRepositoryImpl repository;

    public CourseService(CourseRepositoryImpl repository) {
        this.repository = repository;
    }

    public static void saveCourse(Course Course) {


    }

    public static void removeCourse(Course course){
        
    }

}