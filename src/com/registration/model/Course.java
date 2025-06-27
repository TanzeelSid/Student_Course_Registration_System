package com.registration.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Course class representing a course in the registration system.
 * Demonstrates encapsulation through private fields and validation.
 */
public class Course {
    private String courseCode;
    private String courseName;
    private int maxStudents;
    private List<Student> registeredStudents;
    
    // Course code pattern (e.g., CS101, MATH200)
    private static final Pattern COURSE_CODE_PATTERN = 
        Pattern.compile("^[A-Z]{2,4}\\d{3,4}$");
    
    /**
     * Constructor for Course
     * @param courseCode The course code
     * @param courseName The course name
     * @param maxStudents Maximum number of students allowed
     */
    public Course(String courseCode, String courseName, int maxStudents) {
        setCourseCode(courseCode);
        setCourseName(courseName);
        setMaxStudents(maxStudents);
        this.registeredStudents = new ArrayList<>();
    }
    
    // Getters
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public int getMaxStudents() {
        return maxStudents;
    }
    
    public List<Student> getRegisteredStudents() {
        return new ArrayList<>(registeredStudents); // Return copy for encapsulation
    }
    
    public int getCurrentEnrollment() {
        return registeredStudents.size();
    }
    
    // Setters with validation (Encapsulation)
    public void setCourseCode(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty");
        }
        if (!COURSE_CODE_PATTERN.matcher(courseCode.trim().toUpperCase()).matches()) {
            throw new IllegalArgumentException("Invalid course code format. Expected format: CS101, MATH200, etc.");
        }
        this.courseCode = courseCode.trim().toUpperCase();
    }
    
    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty");
        }
        this.courseName = courseName.trim();
    }
    
    public void setMaxStudents(int maxStudents) {
        if (maxStudents <= 0) {
            throw new IllegalArgumentException("Maximum students must be greater than 0");
        }
        this.maxStudents = maxStudents;
    }
    
    /**
     * Register a student to the course
     * @param student The student to register
     * @return true if registration successful, false otherwise
     */
    public boolean registerStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        
        if (registeredStudents.contains(student)) {
            System.out.println("Student " + student.getName() + " is already registered for " + courseCode);
            return false;
        }
        
        if (registeredStudents.size() >= maxStudents) {
            System.out.println("Course " + courseCode + " is full. Cannot register " + student.getName());
            return false;
        }
        
        registeredStudents.add(student);
        System.out.println("Student " + student.getName() + " successfully registered for " + courseCode);
        return true;
    }
    
    /**
     * Remove a student from the course
     * @param student The student to remove
     * @return true if removal successful, false otherwise
     */
    public boolean removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        
        if (registeredStudents.remove(student)) {
            System.out.println("Student " + student.getName() + " successfully removed from " + courseCode);
            return true;
        } else {
            System.out.println("Student " + student.getName() + " is not registered for " + courseCode);
            return false;
        }
    }
    
    /**
     * Display course information including registered students
     */
    public void displayCourseInfo() {
        System.out.println("\n=== Course Information ===");
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Enrollment: " + registeredStudents.size() + "/" + maxStudents);
        
        if (registeredStudents.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            System.out.println("Registered Students:");
            for (Student student : registeredStudents) {
                System.out.println("  - " + student.getName() + " (ID: " + student.getId() + ")");
            }
        }
        System.out.println("=========================");
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return courseCode.equals(course.courseCode);
    }
    
    @Override
    public int hashCode() {
        return courseCode.hashCode();
    }
    
    @Override
    public String toString() {
        return courseCode + " - " + courseName;
    }
}