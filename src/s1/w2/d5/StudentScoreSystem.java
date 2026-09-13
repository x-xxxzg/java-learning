package s1.w2.d5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #13 学生成绩系统 v2：用 Map<Integer, Student> 管理
 *
 * 老知识（Map 的用法）已写满；今天唯一的新知识点 = 排序（Comparator），
 * 只留 sortByScoreDesc 一个 TODO。
 *
 * 为什么用 Map 而不是 List？学号天然是「键」：
 *   按学号查 = O(1)（HashMap 直接定位），List 得挨个找 O(n)。
 */
public class StudentScoreSystem {

    private final Map<Integer, Student> store = new HashMap<>();

    /** 添加学生。同 id 再 add 会覆盖旧记录（Map 同 key 覆盖——老知识）。 */
    public void add(Student s) {
        store.put(s.getId(), s);
    }

    /** 按学号查，查不到返回 null（调用方要防 NPE）。 */
    public Student findById(int id) {
        return store.get(id);
    }

    /** 系统里几个人。 */
    public int size() {
        return store.size();
    }

    /**
     * TODO（今天唯一的填空，核心逻辑必须手写）：
     * 返回按成绩【从高到低】排好的学生列表。
     *
     * 三步提示：
     * 1. List<Student> list = new ArrayList<>(store.values());  // 把 values 拷成 List
     * 2. 排序：list.sort(...);  —— 二选一：
     *      lambda 版：list.sort((a, b) -> b.getScore() - a.getScore());
     *      Comparator 版：list.sort(Comparator.comparingInt(Student::getScore).reversed());
     *    （b - a 是降序，a - b 是升序——想想为什么）
     * 3. return list;
     *
     * 填完后问自己：这段离开 AI 我能默写吗？（#14 全手写日马上要用到排序）
     */
    public List<Student> sortByScoreDesc() {
        List <Student> list = new ArrayList<>(store.values());  //这里的store是一个map,有id和成绩，我们只需要提取出他的成绩，依据成绩排序，所以复制成绩
        list.sort((a,b) -> b.getScore() - a.getScore());
        return list;
    }

}
