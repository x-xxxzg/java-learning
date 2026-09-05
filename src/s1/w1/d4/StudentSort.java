package s1.w1.d4;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {  //相当于你给 Student 贴了个标签——"我这个类的对象知道怎么互相比较大小"。
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() { return score; }

    @Override
    public String toString() { return name + ":" + score; }

    // compareTo 的返回值约定：返回负数 = "我排在你前面"；0 = 相等；正数 = "我排在你后面"
    @Override
    public int compareTo(Student other) {
        // TODO-1：按分数从高到低排（分数大的排前面！）
        //         一行搞定：return other.score - this.score;  ——先自己想 30 秒为什么是减法、为什么倒着减
        //         想通后自己写：如果写成 this.score - other.score 会变成什么顺序？
        return other.score - this.score;
        //因为后面调用的时候应该是遍历别人的成绩，那如果别人的成绩比我高，那我就排在他后面，此时又约定了正数的时候我排在后面
    }
//    排序时，它会对列表里每两个元素调用 a.compareTo(b)，根据返回值决定谁前谁后。你不用写排序算法，只要告诉它"怎么比"，排序它包办。
}

public class StudentSort {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("张三", 72));
        list.add(new Student("李四", 93));
        list.add(new Student("王五", 85));
        list.add(new Student("赵六", 61));

        // TODO-2：调用 Collections.sort(list)，然后增强 for 打印，验证分数从高到低
        Collections.sort(list);
        for(var v : list) System.out.println(v);
    }
}