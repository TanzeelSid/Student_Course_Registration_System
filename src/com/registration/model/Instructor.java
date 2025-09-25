package com.registration.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Instructor class extending Person.
 * Demonstrates inheritance and polymorphism through method overriding.
 */
public class Instructor extends Person {
    private List<Course> assignedCourses;
    
    /**
     * Constructor for Instructor
     * @param name The instructor's name
     * @param email The instructor's email
     * @param id The instructor's ID
     */
    public Instructor(String name, String email, String id) {
        super(name, email, id);
        this.assignedCourses = new ArrayList<>();
    }
    
    /**
     * Get list of assigned courses
     * @return Copy of assigned courses list for encapsulation
     */
    public List<Course> getAssignedCourses() {
        return new ArrayList<>(assignedCourses);
    }
    
    /**
     * Assign a course to the instructor
     * @param course The course to assign
     * @return true if assignment successful, false otherwise
     */
    public boolean assignCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        
        if (assignedCourses.contains(course)) {
            System.out.println("Instructor " + getName() + " is already assigned to " + course.getCourseCode());
            return false;
        }
        
        assignedCourses.add(course);
        System.out.println("Instructor " + getName() + " successfully assigned to " + course.getCourseCode());
        return true;
    }
    
    /**
     * Remove course assignment from instructor
     * @param course The course to unassign
     * @return true if removal successful, false otherwise
     */
    public boolean unassignCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        
        if (assignedCourses.remove(course)) {
            System.out.println("Instructor " + getName() + " unassigned from " + course.getCourseCode());
            return true;
        } else {
            System.out.println("Instructor " + getName() + " is not assigned to " + course.getCourseCode());
            return false;
        }
    }
    
    /**
     * Get number of assigned courses
     * @return Number of courses assigned
     */
    public int getAssignedCoursesCount() {
        return assignedCourses.size();
    }
    
    /**
     * Override displayDetails to show instructor-specific information
     * Demonstrates polymorphism
     */
    @Override
    public void displayDetails() {
        System.out.println("\n=== Instructor Details ===");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Instructor ID: " + getId());
        System.out.println("Assigned Courses: " + assignedCourses.size());
        
        if (assignedCourses.isEmpty()) {
            System.out.println("No courses assigned.");
        } else {
            System.out.println("Course Assignments:");
            for (Course course : assignedCourses) {
                System.out.println("  - " + course.getCourseCode() + ": " + course.getCourseName() + 
                                " (" + course.getCurrentEnrollment() + "/" + course.getMaxStudents() + " students)");
            }
        }
        System.out.println("=========================");
    }
    
    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", assignedCourses=" + assignedCourses.size() +
                '}';
    }
}