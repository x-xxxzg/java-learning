package s1.w2.d5;

import java.util.List;

/**
 * #13 演示入口（已写满，跑通后对照预期输出）
 */
public class ScoreSystemDemo {

    public static void main(String[] args) {
        StudentScoreSystem sys = new StudentScoreSystem();

        sys.add(new Student(1001, "小明", 85));
        sys.add(new Student(1002, "小红", 92));
        sys.add(new Student(1003, "小刚", 78));
        sys.add(new Student(1004, "小美", 92));

        // 同学号再 add 一次 → 覆盖旧成绩（Map 同 key 覆盖）
        sys.add(new Student(1001, "小明", 90));

        System.out.println("系统人数 = " + sys.size());        // 4（1001 被覆盖，没变多）
        System.out.println("查 1003 = " + sys.findById(1003)); // 1003-小刚-78
        System.out.println("查 9999 = " + sys.findById(9999)); // null

        List<Student> ranked = sys.sortByScoreDesc();
        System.out.println("---- 成绩排行榜 ----");
        for (Student s : ranked) {
            System.out.println(s);
        }
        // 预期（92 分并列，先后不保证——HashMap 本身无序）：
        // 1002-小红-92
        // 1004-小美-92
        // 1001-小明-90
        // 1003-小刚-78
    }
}
