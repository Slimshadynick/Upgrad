import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student {
    private String name;
    private double cgpa;
    private int token;
    public Student(String name,double cgpa,int token){
        this.name=name;
        this.cgpa=cgpa;
        this.token=token;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getToken() {
        return token;
    }
}
class StudentSort implements Comparator<Student>{
    public int compare(Student a, Student b)
    {
        if(a.getCgpa()>b.getCgpa())
            return -1;
        else if(a.getCgpa()<b.getCgpa())
            return 1;
        else{
            int temp=a.getName().compareTo(b.getName());
            if(temp<0)
                return -1;
            else if(temp>0)
                return 1;
            else{
                if(a.getToken()>b.getToken())
                    return -1;
                else if(a.getToken()<b.getToken())
                    return 1;
                else return 0;
            }
        }
    }
}
public class Assignment {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int NumberOfEvents = Integer.parseInt(s.nextLine());
        PriorityQueue<Student> students = new PriorityQueue<>(NumberOfEvents, new StudentSort());
        while (NumberOfEvents > 0) {
            NumberOfEvents--;
            String input = s.nextLine();
            String inputArray[] = input.split(" ", 0);
            if (inputArray.length != 1) {
                String name = inputArray[1];
                double cgpa = Double.parseDouble(inputArray[2]);
                int token = Integer.parseInt(inputArray[3]);
                Student student = new Student(name, cgpa, token);
                students.add(student);
            } else {
                students.poll();
            }
        }
        while (!students.isEmpty()) {
            System.out.println(students.poll().getName());
        }
    }
}
