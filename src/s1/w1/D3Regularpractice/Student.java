package s1.w1.D3Regularpractice;

public class Student extends Person {
    int score ;

    public Student(String name,int age,int score){
        super(name, age);
        this.score = score;
    }
    public void study(){
        System.out.println(name+"正在学习");
    }

    public static void main(String[] args) {
        Student s = new Student("Tom",18,90);
        s.sayHello();
        s.study();
    }
}
