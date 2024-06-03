import Exceptions.SubjectHasNoTeacherException;

public class Subject {
    private SubjectName subjectName;
    private Teacher teacher;

    public Subject(SubjectName name, Teacher teacher) {
        this.subjectName = name;
        this.setTeacher(teacher);
    }
    public void checkForTeacher() {
        if (this.teacher == null) {
            throw new SubjectHasNoTeacherException("Subject " + this.subjectName + " has no teacher assigned.");
        } else {
            System.out.println(this.getName());
        }
    }

    public SubjectName getName() {
        return subjectName;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    @Override
    public String toString() {
        return subjectName.getName();
    }

}
