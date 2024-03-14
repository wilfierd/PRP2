package student;

import student.StudentManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  test extends StudentManage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<String> firstNames = new ArrayList<>();
        List<String> lastNames = new ArrayList<>();
        enterStudentNames(firstNames, lastNames);
        for (int i = 0; i < firstNames.size(); i++) {
            students.add(new Student(firstNames.get(i), lastNames.get(i), 7));
        }
        exportImportedList(students);

        List<Student> randomStudents = generateRandomStudents(firstNames, lastNames, 4);
        exportRandomList(randomStudents, 4);

        sortAndExportDescending(students);

        System.out.print("Enter full name to delete: ");
        String fullNameToDelete = scanner.nextLine();
        findAndDeleteFullName(students, fullNameToDelete);
        exportImportedList(students);

        double averageGrade = calculateAverageGrade(students);
        System.out.println("Average grade: " + averageGrade);

        System.out.print("Enter threshold: ");
        double threshold = scanner.nextDouble();
        findStudentsAboveThreshold(students, threshold);

        findStudentWithHighestGrade(students);

        sortStudentsByAverageGrade(students);
        exportImportedList(students);

        saveListToTextFile(students, "students.txt");
    }
}