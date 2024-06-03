import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        final School school1 = new School();
        final Teacher teacher1 = new Teacher("Mr. Popadinec");
        final Teacher teacher2 = new Teacher("Ms. Miksatkova");
        final Teacher teacher3 = new Teacher("Mr. Horvath");
        final Teacher teacher4 = new Teacher("Ms. Prusova");

        final Subject Math = new Subject(SubjectName.MATHEMATICS, teacher1);
        final Subject English = new Subject(SubjectName.ENGLISH, teacher2);
        final Subject Science = new Subject(SubjectName.SCIENCE, teacher3);
        final Subject History = new Subject(SubjectName.HISTORY, teacher4);
        final Subject Geography = new Subject(SubjectName.GEOGRAPHY, teacher1);
        final Subject Chemistry = new Subject(SubjectName.CHEMISTRY, teacher2);
        final Subject Art = new Subject(SubjectName.ART, teacher3);
        final Subject Music = new Subject(SubjectName.MUSIC, teacher4);

        final Clazz clazz1 = new Clazz('A', 1, teacher1);
        final Clazz clazz2 = new Clazz('B', 2, teacher2);

        school1.addClass(clazz1);
        school1.addClass(clazz2);

        final Student student1 = new Student("Jiří", clazz1);
        final Student student2 = new Student("Jan", clazz1);
        final Student student3 = new Student("Petr", clazz1);
        final Student student4 = new Student("Pavel", clazz1);
        final Student student5 = new Student("Martin", clazz1);
        final Student student6 = new Student("Tomáš", clazz2);
        final Student student7 = new Student("Jakub", clazz2);
        final Student student8 = new Student("Lukáš", clazz2);
        final Student student9 = new Student("Ondřej", clazz2);
        final Student student10 = new Student("Václav", clazz2);

        List<Subject> subjectList = List.of(Math, English, Science, History, Geography, Chemistry, Art, Music);
        List<Student> studentList = new ArrayList<>(
                Arrays.asList(student1, student2, student3, student4, student5,
                student6, student7, student8, student9,student10));

        school1.addRandomGradesToStudents(studentList, subjectList);

        System.out.println("----------------------");
        school1.printStudentsByAverageGrade();
        System.out.println("----------------------");
        school1.printSubjectsByAverageGrade();
        System.out.println("----------------------");
        school1.printClassesByAverageGrade();

    }
}