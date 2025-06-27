package com.registration.system;

import com.registration.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 * RegistrationSystem class that orchestrates the entire registration process.
 * Demonstrates abstraction by exposing high-level operations while hiding internal complexity.
 */
public class RegistrationSystem {
    private List<Student> students;
    private List<Instructor> instructors;
    private List<Course> courses;
    
    /**
     * Constructor for RegistrationSystem
     */
    public RegistrationSystem() {
        this.students = new ArrayList<>();
        this.instructors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    
    // Student Management Methods
    
    /**
     * Add a new student to the system
     * @param student The student to add
     * @return true if added successfully, false if student already exists
     */
    public boolean addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        
        if (students.contains(student)) {
            System.out.println("Student with ID " + student.getId() + " already exists");
            return false;
        }
        
        students.add(student);
        System.out.println("Student " + student.getName() + " added to the system");
        return true;
    }
    
    /**
     * Find student by ID
     * @param studentId The student ID to search for
     * @return Student object if found, null otherwise
     */
    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
    
    // Instructor Management Methods
    
    /**
     * Add a new instructor to the system
     * @param instructor The instructor to add
     * @return true if added successfully, false if instructor already exists
     */
    public boolean addInstructor(Instructor instructor) {
        if (instructor == null) {
            throw new IllegalArgumentException("Instructor cannot be null");
        }
        
        if (instructors.contains(instructor)) {
            System.out.println("Instructor with ID " + instructor.getId() + " already exists");
            return false;
        }
        
        instructors.add(instructor);
        System.out.println("Instructor " + instructor.getName() + " added to the system");
        return true;
    }
    
    /**
     * Find instructor by ID
     * @param instructorId The instructor ID to search for
     * @return Instructor object if found, null otherwise
     */
    public Instructor findInstructorById(String instructorId) {
        for (Instructor instructor : instructors) {
            if (instructor.getId().equals(instructorId)) {
                return instructor;
            }
        }
        return null;
    }
    
    // Course Management Methods
    
    /**
     * Add a new course to the system
     * @param course The course to add
     * @return true if added successfully, false if course already exists
     */
    public boolean addCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        
        if (courses.contains(course)) {
            System.out.println("Course with code " + course.getCourseCode() + " already exists");
            return false;
        }
        
        courses.add(course);
        System.out.println("Course " + course.getCourseCode() + " added to the system");
        return true;
    }
    
    /**
     * Find course by course code
     * @param courseCode The course code to search for
     * @return Course object if found, null otherwise
     */
    public Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
    
    // High-level Registration Operations (Abstraction)
    
    /**
     * Register a student to a course by their IDs
     * @param studentId The student's ID
     * @param courseCode The course code
     * @return true if registration successful, false otherwise
     */
    public boolean registerStudentToCourse(String studentId, String courseCode) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found");
            return false;
        }
        
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course with code " + courseCode + " not found");
            return false;
        }
        
        return student.enrollInCourse(course);
    }
    
    /**
     * Drop a student from a course by their IDs
     * @param studentId The student's ID
     * @param courseCode The course code
     * @return true if drop successful, false otherwise
     */
    public boolean dropStudentFromCourse(String studentId, String courseCode) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found");
            return false;
        }
        
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course with code " + courseCode + " not found");
            return false;
        }
        
        return student.dropCourse(course);
    }
    
    /**
     * Assign an instructor to a course by their IDs
     * @param instructorId The instructor's ID
     * @param courseCode The course code
     * @return true if assignment successful, false otherwise
     */
    public boolean assignInstructorToCourse(String instructorId, String courseCode) {
        Instructor instructor = findInstructorById(instructorId);
        if (instructor == null) {
            System.out.println("Instructor with ID " + instructorId + " not found");
            return false;
        }
        
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course with code " + courseCode + " not found");
            return false;
        }
        
        return instructor.assignCourse(course);
    }
    
    // Display Methods
    
    /**
     * Display all students and their details
     */
    public void displayAllStudents() {
        System.out.println("\n========== ALL STUDENTS ==========");
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            for (Student student : students) {
                student.displayDetails();
            }
        }
        System.out.println("==================================");
    }
    
    /**
     * Display all instructors and their details
     */
    public void displayAllInstructors() {
        System.out.println("\n========== ALL INSTRUCTORS ==========");
        if (instructors.isEmpty()) {
            System.out.println("No instructors in the system.");
        } else {
            for (Instructor instructor : instructors) {
                instructor.displayDetails();
            }
        }
        System.out.println("=====================================");
    }
    
    /**
     * Display all courses and their information
     */
    public void displayAllCourses() {
        System.out.println("\n========== ALL COURSES ==========");
        if (courses.isEmpty()) {
            System.out.println("No courses in the system.");
        } else {
            for (Course course : courses) {
                course.displayCourseInfo();
            }
        }
        System.out.println("=================================");
    }
    
    /**
     * Display complete system summary
     */
    public void displaySystemSummary() {
        System.out.println("\n========== SYSTEM SUMMARY ==========");
        System.out.println("Total Students: " + students.size());
        System.out.println("Total Instructors: " + instructors.size());
        System.out.println("Total Courses: " + courses.size());
        
        int totalEnrollments = 0;
        for (Course course : courses) {
            totalEnrollments += course.getCurrentEnrollment();
        }
        System.out.println("Total Enrollments: " + totalEnrollments);
        System.out.println("====================================");
    }
    
    // Getters for lists (returning copies for encapsulation)
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    public List<Instructor> getAllInstructors() {
        return new ArrayList<>(instructors);
    }
    
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }
}