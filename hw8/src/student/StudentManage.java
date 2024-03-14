package student;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Student {
    private String firstName;
    private String lastName;
    private double grade;

    public Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getGrade() {
        return grade;
    }
}

public class StudentManage {
    public static void enterStudentNames(List<String> firstNames, List<String> lastNames) {
        firstNames.add("Nguyen");
        lastNames.add("Hieu");

        firstNames.add("Dong");
        lastNames.add("Quang");

    }

    public static void exportImportedList(List<Student> students) {
        System.out.println("Imported list:");
        for (Student student : students) {
            System.out.println(student.getFullName() + " - Grade: " + student.getGrade());
        }
    }

    public static List<Student> generateRandomStudents(List<String> firstNames, List<String> lastNames, int size) {
        List<Student> randomStudents = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomIndex = (int) (Math.random() * firstNames.size());
            randomStudents.add(new Student(firstNames.get(randomIndex), lastNames.get(randomIndex), Math.random() * 11));
        }
        return randomStudents;
    }

    public static void exportRandomList(List<Student> students, int size) {
        System.out.println("Random list:");
        for (Student student : students) {
            System.out.println(student.getFullName() + " - Grade: " + student.getGrade());
        }
    }

    public static void sortAndExportDescending(List<Student> students) {
        Collections.sort(students, (s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()));
        System.out.println("Sorted descending list:");
        for (Student student : students) {
            System.out.println(student.getFullName() + " - Grade: " + student.getGrade());
        }
    }

    public static void findAndDeleteFullName(List<Student> students, String fullName) {
        students.removeIf(student -> student.getFullName().equalsIgnoreCase(fullName));
    }

    public static double calculateAverageGrade(List<Student> students) {
        double totalGrade = 0;
        for (Student student : students) {
            totalGrade += student.getGrade();
        }
        return totalGrade / students.size();
    }

    public static void findStudentsAboveThreshold(List<Student> students, double threshold) {
        System.out.println("Students above threshold " + threshold + ":");
        for (Student student : students) {
            if (student.getGrade() > threshold) {
                System.out.println(student.getFullName() + " - Grade: " + student.getGrade());
            }
        }
    }

    public static void findStudentWithHighestGrade(List<Student> students) {
        Student highestGradeStudent = Collections.max(students, (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade()));
        System.out.println("Student with highest grade:");
        System.out.println(highestGradeStudent.getFullName() + " - Grade: " + highestGradeStudent.getGrade());
    }

    public static void sortStudentsByAverageGrade(List<Student> students) {
        Collections.sort(students, (s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()));
    }

    public static void saveListToTextFile(List<Student> students, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.getFullName() + " - Grade: " + student.getGrade() + "\n");
            }
            System.out.println("Student list saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error occurred while saving to file: " + e.getMessage());
        }
    }
}
