package playground;

public class Student extends Person {
    public Student(String name) {
        super(name);
    }

    public boolean isAsleep(int hr) {
        return 2 < hr && 8 > hr;
    }

    public static void main(String[] args) {
        Person p = new Student("Fero");
        p.status(1);
    }
}
