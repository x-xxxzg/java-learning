package s1.w1.D3Regularpractice;

public class Student extends Person {
    int score ;
    public void study(){System.out.println(name+"正在学习");}

    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Tom";
        s.age = 18 ;
        s.score = 90;
        s.sayHello();
        s.study();
    }
}
