import Exceptions.NotEnoughClassesException;

import java.util.*;
import java.util.stream.Collectors;

public class School {
    private final List<Clazz> classes;
    public School() {
        this.classes = new ArrayList<>();
    }

    public void addClass(Clazz clazz) {
        this.classes.add(clazz);
    }

    public void printClasses() {
        System.out.println("School has these classes:");
        for (Clazz clazz : classes) {
            System.out.println(clazz.getName());
        }
    }
    public void checkForEnoughClasses() {
        if (classes.size() < 2) {
            throw new NotEnoughClassesException("School does not have enough classes. Minimum required is 2.");
        }
    }

    public void addRandomGradesToStudents(List<Student> students, List<Subject> subjects) {
        students.forEach(student ->
                subjects.forEach(subject -> {
                            for (int i = 0; i < 3; i++) {
                                student.addGrade(subject, new Random().nextInt(5) + 1);
                            }
                        }
                )
        );
    }
    public void printStudentsByAverageGrade() {
        Map<Student, Double> studentAverages = classes.stream()
                .flatMap(clazz -> clazz.getStudents().stream())
                .peek(student -> {
                    student.checkGrades();
                    student.checkStudiedSubjects();
                })
                .map(student -> new AbstractMap.SimpleEntry<>(student, student.getAverageGrade()))
                .filter(entry -> entry.getValue().isPresent())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().getAsDouble()
                ));
        System.out.println("Sorted students by their average grades:");
        studentAverages.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " - " + MathUtils.roundToDecimalPlace(entry.getValue(), 1)));
    }

    public void printSubjectsByAverageGrade() {
        Map<Subject, Double> subjectAverages = classes.stream()
                .flatMap(clazz -> clazz.getStudents().stream())
                .flatMap(student -> student.getGrades().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(
                                entry -> entry.getValue().stream().mapToDouble(Integer::doubleValue).boxed(),
                                Collectors.averagingDouble(Double::doubleValue)
                        )
                ));

        List<Map.Entry<Subject, Double>> sortedSubjects = subjectAverages.entrySet().stream()
                .sorted(Map.Entry.<Subject, Double>comparingByValue().reversed())
                .toList();

        System.out.println("Sorted subjects by average of grades given to students:");
        for (Map.Entry<Subject, Double> entry : sortedSubjects) {
            System.out.println(entry.getKey() + " - " + MathUtils.roundToDecimalPlace(entry.getValue(), 1));
        }
    }

    public void printClassesByAverageGrade() {
        checkForEnoughClasses();
        Map<Clazz, Double> classAverages = classes.stream()
                .collect(Collectors.toMap(
                        clazz -> clazz,
                        clazz -> clazz.getStudents().stream()
                                .mapToDouble(student -> student.getAverageGrade().orElse(0))
                                .average().orElse(0)
                ));

        List<Map.Entry<Clazz, Double>> sortedClasses = classAverages.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();

        System.out.println("Sorted classes by average of grades given to students:");
        for (Map.Entry<Clazz, Double> entry : sortedClasses) {
            System.out.println(entry.getKey() + " - " + MathUtils.roundToDecimalPlace(entry.getValue(), 1));
        }
    }
}
