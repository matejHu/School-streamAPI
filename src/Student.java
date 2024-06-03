import Exceptions.NotEnoughGradesException;
import Exceptions.NotEnoughStudiedSubjectsException;
import Exceptions.StudentHasNoClassException;

import java.util.*;

public class Student extends Person{
    private final Map<Subject, List<Integer>> grades;
    private final Clazz clazz;
    public Student(String name, Clazz clazz) {
        super(name);
        this.clazz = clazz;
        clazz.addStudent(this);
        this.grades = new HashMap<>();
    }

    public String getClazz() {
        if (clazz == null) {
            throw new StudentHasNoClassException("Student does not have a class assigned.");
        } else {
            return clazz.getName();
        }
    }

    public void checkStudiedSubjects() {
        if (grades.size() < 3) {
            throw new NotEnoughStudiedSubjectsException("Student is not studying enough subjects. Minimum required is 3.");
        }
    }


    public void checkGrades() {
        for (Map.Entry<Subject, List<Integer>> entry : grades.entrySet()) {
            if (entry.getValue().isEmpty()) {
                throw new NotEnoughGradesException("Not enough grades for subject: " + entry.getKey() + " at student " + this.getName());
            }
        }
    }

    public Map<Subject, List<Integer>> getGrades() {
        checkGrades();
        return grades;
    }

    public void addGrade(Subject subject, int grade) {
        grades.computeIfAbsent(subject, k -> new ArrayList<>()).add(grade);
    }

    public OptionalDouble getAverageGrade() {
        checkGrades();
        return grades.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Integer::intValue)
                .average();
    }

}
