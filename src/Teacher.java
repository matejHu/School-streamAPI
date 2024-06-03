import java.util.ArrayList;
import java.util.List;
public class Teacher extends Person{
    private final List<Subject> subjects;
    public Teacher(String name) {
        super(name);
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        if (this.subjects.contains(subject)){
            System.out.println("Teacher already teach this subject");
        } else {
            this.subjects.add(subject);
        }
    }

}
