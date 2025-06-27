import com.registration.model.*;
import com.registration.system.RegistrationSystem;

/**
 * Main class demonstrating the Student Course Registration System
 * and all four pillars of Object-Oriented Programming:
 * 1. Encapsulation - Private fields with validation in setters
 * 2. Inheritance - Student and Instructor extending Person
 * 3. Polymorphism - Overridden displayDetails() methods
 * 4. Abstraction - RegistrationSystem hiding complex operations
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  STUDENT COURSE REGISTRATION SYSTEM");
        System.out.println("========================================");
        
        // Create the registration system
        RegistrationSystem system = new RegistrationSystem();
        
        try {
            // Demonstrate object creation and encapsulation
            System.out.println("\n1. CREATING STUDENTS (Demonstrating Encapsulation)");
            System.out.println("=================================================");
            
            Student student1 = new Student("Alice Johnson", "alice.johnson@email.com", "S001");
            Student student2 = new Student("Bob Smith", "bob.smith@email.com", "S002");
            Student student3 = new Student("Carol Davis", "carol.davis@email.com", "S003");
            
            // Add students to system
            system.addStudent(student1);
            system.addStudent(student2);
            system.addStudent(student3);
            
            System.out.println("\n2. CREATING INSTRUCTORS (Demonstrating Inheritance)");
            System.out.println("==================================================");
            
            Instructor instructor1 = new Instructor("Dr. John Wilson", "john.wilson@university.edu", "I001");
            Instructor instructor2 = new Instructor("Prof. Sarah Brown", "sarah.brown@university.edu", "I002");
            
            // Add instructors to system
            system.addInstructor(instructor1);
            system.addInstructor(instructor2);
            
            System.out.println("\n3. CREATING COURSES (Demonstrating Encapsulation with Validation)");
            System.out.println("================================================================");
            
            Course course1 = new Course("CS101", "Introduction to Computer Science", 30);
            Course course2 = new Course("MATH200", "Calculus II", 25);
            Course course3 = new Course("ENG150", "English Composition", 20);
            
            // Add courses to system
            system.addCourse(course1);
            system.addCourse(course2);
            system.addCourse(course3);
            
            System.out.println("\n4. STUDENT ENROLLMENT (Demonstrating Abstraction)");
            System.out.println("================================================");
            
            // Use high-level abstracted methods
            system.registerStudentToCourse("S001", "CS101");
            system.registerStudentToCourse("S001", "MATH200");
            system.registerStudentToCourse("S002", "CS101");
            system.registerStudentToCourse("S002", "ENG150");
            system.registerStudentToCourse("S003", "MATH200");
            system.registerStudentToCourse("S003", "ENG150");
            
            System.out.println("\n5. INSTRUCTOR ASSIGNMENTS");
            System.out.println("=========================");
            
            system.assignInstructorToCourse("I001", "CS101");
            system.assignInstructorToCourse("I001", "MATH200");
            system.assignInstructorToCourse("I002", "ENG150");
            
            System.out.println("\n6. DEMONSTRATING POLYMORPHISM - displayDetails() Method");
            System.out.println("======================================================");
            
            // Polymorphism: Same method call, different implementations
            Person[] people = {student1, student2, instructor1, instructor2};
            
            for (Person person : people) {
                person.displayDetails(); // Calls overridden method based on actual object type
            }
            
            System.out.println("\n7. COURSE INFORMATION DISPLAY");
            System.out.println("=============================");
            
            // Display course information
            course1.displayCourseInfo();
            course2.displayCourseInfo();
            course3.displayCourseInfo();
            
            System.out.println("\n8. DEMONSTRATING COURSE DROPPING");
            System.out.println("================================");
            
            // Drop some courses
            system.dropStudentFromCourse("S001", "MATH200");
            system.dropStudentFromCourse("S002", "ENG150");
            
            System.out.println("\n9. UPDATED STUDENT INFORMATION (After Dropping)");
            System.out.println("===============================================");
            
            student1.displayDetails();
            student2.displayDetails();
            
            System.out.println("\n10. UPDATED COURSE INFORMATION (After Dropping)");
            System.out.println("===============================================");
            
            course2.displayCourseInfo();
            course3.displayCourseInfo();
            
            System.out.println("\n11. SYSTEM SUMMARY");
            System.out.println("==================");
            
            system.displaySystemSummary();
            
            System.out.println("\n12. DEMONSTRATING ENCAPSULATION - Input Validation");
            System.out.println("==================================================");
            
            try {
                // This will throw an exception due to invalid email
                Student invalidStudent = new Student("Invalid User", "invalid-email", "S999");
            } catch (IllegalArgumentException e) {
                System.out.println("Encapsulation in action - Invalid email caught: " + e.getMessage());
            }
            
            try {
                // This will throw an exception due to invalid course code
                Course invalidCourse = new Course("INVALID", "Invalid Course", 10);
            } catch (IllegalArgumentException e) {
                System.out.println("Encapsulation in action - Invalid course code caught: " + e.getMessage());
            }
            
            System.out.println("\n13. FINAL SYSTEM STATE");
            System.out.println("=====================");
            
            system.displayAllStudents();
            system.displayAllInstructors();
            system.displayAllCourses();
            
            System.out.println("\n========================================");
            System.out.println("    DEMONSTRATION COMPLETED SUCCESSFULLY");
            System.out.println("========================================");
            
            System.out.println("\nOOP CONCEPTS DEMONSTRATED:");
            System.out.println("✓ ENCAPSULATION: Private fields with validation in Person, Student, Instructor, and Course classes");
            System.out.println("✓ INHERITANCE: Student and Instructor classes extend Person class");
            System.out.println("✓ POLYMORPHISM: Overridden displayDetails() methods called through Person references");
            System.out.println("✓ ABSTRACTION: RegistrationSystem provides high-level operations hiding internal complexity");
            
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}