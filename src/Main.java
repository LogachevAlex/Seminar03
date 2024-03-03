import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Group implements Iterable<Student> {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

    public int getGroupSize() {
        return students.size();
    }
}

class Student {
    private String name;
    private int age;
    private double grade; // Поле для оценки

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                Double.compare(student.grade, grade) == 0 &&
                name.equals(student.name);
    }
}

class GroupComparator implements Comparator<Group> {
    @Override
    public int compare(Group o1, Group o2) {
        return Integer.compare(o1.getGroupSize(), o2.getGroupSize());
    }
}

class GradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getGrade(), s2.getGrade());
    }
}

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Alex", 20, 3.5);
        Student student2 = new Student("Dasha", 22, 4.0);
        Student student3 = new Student("Sergey", 21, 3.8);
        Student student4 = new Student("Dmitry", 20, 3.75);


        Group group1 = new Group();
        group1.addStudent(student1);
        group1.addStudent(student2);

        Group group2 = new Group();
        group2.addStudent(student3);
        group2.addStudent(student4);

        GroupComparator groupComparator = new GroupComparator();
        if (groupComparator.compare(group1, group2) == 0) {System.out.println("В группе одинаковое количество студентов");}
        else if (groupComparator.compare(group1, group2) > 0) {System.out.println("В первой группе больше студентов");}
        else {System.out.println("Во второй группе больше студентов");}


        for (Student s : group1) {
            System.out.println(s);
        }

        GradeComparator gradeComparator = new GradeComparator();
        if (gradeComparator.compare(student1, student2) == 0) {System.out.println("Оценки одинаковые");}
        else if (gradeComparator.compare(student1, student2) > 0) {System.out.println("У первого студента оценка выше");}
        else {System.out.println("У второго студента оценка выше");}
    }
}
