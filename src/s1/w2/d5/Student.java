package s1.w2.d5;

/**
 * 学生类：#13 的数据载体
 * （老知识：封装 + 构造器 + getter + toString，已写满，直接用）
 */
public class Student {
    private final int id;      // 学号（final：创建后不许改）
    private final String name;
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId()        { return id; }
    public String getName()   { return name; }
    public int getScore()     { return score; }

    @Override
    public String toString() {
        return id + "-" + name + "-" + score;
    }
}
