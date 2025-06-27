package com.registration.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Student class extending Person.
 * Demonstrates inheritance and polymorphism through method overriding.
 */
public class Student extends Person {
    private List<Course> enrolledCourses;
    
    /**
     * Constructor for Student
     * @param name The student's name
     * @param email The student's email
     * @param id The student's ID
     */
    public Student(String name, String email, String id) {
        super(name, email, id);
        this.enrolledCourses = new ArrayList<>();
    }
    
    /**
     * Get list of enrolled courses
     * @return Copy of enrolled courses list for encapsulation
     */
    public List<Course> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses);
    }
    
    /**
     * Enroll student in a course
     * @param course The course to enroll in
     * @return true if enrollment successful, false otherwise
     */
    public boolean enrollInCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        
        if (enrolledCourses.contains(course)) {
            System.out.println("Student " + getName() + " is already enrolled in " + course.getCourseCode());
            return false;
        }
        
        // Try to register with the course
        if (course.registerStudent(this)) {
            enrolledCourses.add(course);
            return true;
        }
        
        return false;
    }
    
    /**
     * Drop a course
     * @param course The course to drop
     * @return true if drop successful, false otherwise
     */
    public boolean dropCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        
        if (enrolledCourses.remove(course)) {
            course.removeStudent(this);
            System.out.println("Student " + getName() + " successfully dropped " + course.getCourseCode());
            return true;
        } else {
            System.out.println("Student " + getName() + " is not enrolled in " + course.getCourseCode());
            return false;
        }
    }
    
    /**
     * Get number of enrolled courses
     * @return Number of courses enrolled
     */
    public int getEnrolledCoursesCount() {
        return enrolledCourses.size();
    }
    
    /**
     * Override displayDetails to show student-specific information
     * Demonstrates polymorphism
     */
    @Override
    public void displayDetails() {
        System.out.println("\n=== Student Details ===");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Student ID: " + getId());
        System.out.println("Enrolled Courses: " + enrolledCourses.size());
        
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            System.out.println("Course List:");
            for (Course course : enrolledCourses) {
                System.out.println("  - " + course.getCourseCode() + ": " + course.getCourseName());
            }
        }
        System.out.println("======================");
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", enrolledCourses=" + enrolledCourses.size() +
                '}';
    }
}