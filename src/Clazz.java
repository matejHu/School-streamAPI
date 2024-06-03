import Exceptions.ClassHasNoPrimaryTeacherException;
import Exceptions.NotEnoughStudentsException;

import java.util.Optional;
import java.util.HashSet;
import java.util.Set;

public class Clazz {
    private final char name;
    private final int year;
    private Teacher primaryTeacher;
    private final Set<Student> students;

    public Clazz(char name, int year, Teacher primaryTeacher) {
        this.name = name;
        this.year = year;
        this.primaryTeacher = primaryTeacher;
        this.students = new HashSet<>();
    }
    public String getName() {
        return this.year + "." + this.name;
    }

    public void checkForPrimaryTeacher() {
        if (this.primaryTeacher == null) {
            throw new ClassHasNoPrimaryTeacherException("Class does not have a primary teacher assigned.");
        } else {
            System.out.println(this.getPrimaryTeacher());
        }
    }
    public void checkForEnoughStudents() {
        if (students.size() < 3) {
            throw new NotEnoughStudentsException("Class does not have enough students. Minimum required is 3.");
        } else {
            System.out.println("This class has " + this.students.size() + " students");
        }
    }

    public Teacher getPrimaryTeacher() {
        return primaryTeacher;
    }

    public Optional<String> setPrimaryTeacher(Teacher primaryTeacher) {
        if (this.primaryTeacher != null) {
            return Optional.of("This class already has a primary teacher assigned.");
        } else {
            this.primaryTeacher = primaryTeacher;
            return Optional.empty();
        }
    }

    public Set<Student> getStudents() {
        if (students.isEmpty()) {
            System.out.println("Class is empty");
        }
        return students;
    }

    public Optional<String> addStudent(Student student) {
        if (students.contains(student)) {
            return Optional.of("Student is already in the class.");
        }
        this.students.add(student);
        return Optional.empty();
    }

    @Override
    public String toString() {
        return getName();
    }

}
