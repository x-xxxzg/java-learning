package s1.w2.d3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 练习 #12：单词频率统计器（W2 唯一 Map 实战，今日唯一 commit 项）
 *
 * 考点：HashMap 计数 + entrySet 导出 + Comparator 排序
 * 手写程度：骨架+填码——两个 TODO 是本练习的灵魂，必须自己写
 *
 * 流程：读一段英文 → 全部转小写 → 按非字母字符切分成单词
 *      → HashMap 统计每个单词出现次数
 *      → 按次数从高到低排序（次数相同按单词字典序）
 *      → 输出排行榜
 */
public class WordFreqCounter {

    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog "
                + "the dog barks and the fox runs away the end";

        // ---------- 第一步：分词（骨架已给，看懂即可） ----------
        // toLowerCase：全部转小写，让 "The" 和 "the" 算同一个词
        // split("\\W+")：按"连续的非字母数字字符"切开（\W = 非单词字符）
        String[] words = text.toLowerCase().split("\\W+");
        System.out.println("共切出 " + words.length + " 个单词（含重复）");

        // ---------- 第二步：统计词频（核心！自己写） ----------
        // TODO-1：遍历 words，把每个单词的计数存进 freq
        // 提示（两种写法任选，写完另一种也试一遍）：
        //   写法A：Integer old = freq.get(word);
        //          freq.put(word, old == null ? 1 : old + 1);
        //   写法B：freq.put(word, freq.getOrDefault(word, 0) + 1);
        // 注意：写法A 里那个三目运算符的"判空"，就是昨天 Practice1
        //       "get 不存在的 key 返回 null" 的实战应用
        // TODO: 写你的代码
        Map<String, Integer> freq = new HashMap<>();
        for(var v : words) freq.merge(v,1,Integer::sum) ;

        // ---------- 第三步：排序（核心！自己写） ----------
        // 把 entrySet 倒进 List，才能用 sort
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());

        // TODO-2：排序——次数降序；次数相同，按单词字典序升序
        // 提示：list.sort((a, b) -> ...);
        //   先比次数：b.getValue() - a.getValue()（降序就反着减）
        //   次数相同再比单词：a.getKey().compareTo(b.getKey())
        //   组合写法：
        //   int d = b.getValue() - a.getValue();
        //   return d != 0 ? d : a.getKey().compareTo(b.getKey());
        // TODO: 写你的代码
        list.sort((a,b) -> {
            int d = b.getValue() - a.getValue() ;
            return d != 0 ? d : a.getKey().compareTo(b.getKey()) ;
        });
        //list.sort() 要求传入Comparator（比较器接口）
        //返回 负数：表示 a 排在 b 前面（a < b）。
        //返回 正数：表示 a 排在 b 后面（a > b）。
        //返回 0：表示它俩相等，顺序无所谓
        //意思就是d是两个数次数差，次数差为正，交换位置，次数差为负保持。所以这个方法的排序就是降序
        //而当d等于0的时候就会用到比较器。比较器比较的就是二者key的字母序排序，因为字母序按升序，所以是a比较b
        // ---------- 第四步：输出排行榜（骨架已给） ----------
        System.out.println("---- 词频排行榜 ----");
        int rank = 1;
        for (Map.Entry<String, Integer> e : list) {
            System.out.println(rank + ". " + e.getKey() + " × " + e.getValue());
            rank++;
        }
        System.out.println("不同单词数 = " + freq.size());
    }
}

/*
 * ============ 预期输出 ============
 *
 * 共切出 19 个单词（含重复）
 * ---- 词频排行榜 ----
 * 1. the × 5
 * 2. dog × 2
 * 3. fox × 2
 * 4. and × 1
 * 5. away × 1
 * 6. barks × 1
 * 7. brown × 1
 * 8. end × 1
 * 9. jumps × 1
 * 10. lazy × 1
 * 11. over × 1
 * 12. quick × 1
 * 13. runs × 1
 * 不同单词数 = 13
 *
 * 观察记录（填完跑通后，把答案写成注释再 commit）：
 * Q1：dog 和 fox 都是 2 次，为什么 dog 排在 fox 前面？
 * 因为比较器比较的是a与b比较，返回负值的话就会保持顺序，所以就是升序排列，而fox的字典序比dog大
 *     （答案就在 TODO-2 的排序规则里）
 * Q2：如果把 TODO-1 换成另一种写法（三目 vs getOrDefault），
 *     输出会变吗？为什么？
 *  三目写法：Integer old = freq.get(word);
    freq.put(word, old == null ? 1 : old + 1);
    输出不会变，因为他的意思都是一样的，就是先获取这个单词有没有出现过，如果没出现过为空，那就给他赋值为1，如果有出现过就在原有基础上加一
    freq.put(word, freq.getOrDefault(word, 0) + 1);
    这个也不会变，这个的意思就是如果取到值的话就直接返回，取不到就返回0，然后加一就是次数
 * Q3：freq.size() 是 13，words.length 是 19，这两个数字
 *     分别统计的是什么？
 *  freq.szie()是那串字符串有多少个不重复的单词，words.length是总共有多少个单词。
 * ==================================
 */
