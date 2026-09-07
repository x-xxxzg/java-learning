package s1.w2.d1;
import java.util.*;

/**
 * D1 核心练习：同一批数据，四种容器，观察「顺序」与「去重」的差异
 * 考点：List / Set / Map 的核心特性——有序性、可重复性
 *
 * 运行后对照文末「预期输出」逐行核对，把「观察记录」四个问题写成注释，
 * 再 commit（这是今天唯一需要 commit 的程序）。
 */
public class CollectionDiffDemo {
    public static void main(String[] args) {
        // 同一批购物清单数据：故意有重复
        String[] items = {"香蕉", "苹果", "牛奶", "苹果", "可乐", "香蕉"};

        // ===== 1. ArrayList：有序（按插入顺序）、可重复 =====
        // TODO-1：创建 ArrayList<String>，把 items 全部 add 进去，直接打印整个 list
        List<String> arrayList = new ArrayList<>() ;
        for(var v : items) arrayList.add(v);
        // 提示：List<String> arrayList = new ArrayList<>()

        System.out.println("ArrayList：        " + arrayList);
//        for(var v : arrayList) System.out.println(v);

        // ===== 2. LinkedList：同样有序可重复（今天只看行为，底层结构周二讲）=====
        // TODO-2：把 items 全部放进 LinkedList，打印——和 ArrayList 的输出一样吗？
        List <String> linkedList = new LinkedList<>();
        for(var v : items) linkedList.add(v);
        System.out.println("LinkedList：       " + linkedList);
//        for(var v : linkedList) System.out.println(v);

        // ===== 3. HashSet：去重，但不保证顺序 =====
        // TODO-3：把 items 全部放进 HashSet，打印，并打印 size()
        // 多运行几次程序，看看 HashSet 的打印顺序会变吗？
        Set <String> hashSet = new HashSet<>();
        for(var v : items) hashSet.add(v);

        System.out.println("HashSet：          " + hashSet);

        System.out.println("HashSet.size() =   " + hashSet.size());

        // ===== 4. LinkedHashMap：去重 + 保留插入顺序（key → value）=====
        // TODO-4：创建 LinkedHashMap<String, Integer>，把每个 item 作为 key 放进去
        //   value 记录它出现的次数（第二次遇到就 +1）
        //   提示：map.get(item) 先取出旧次数，null 说明第一次出现
        // 打印整个 map——既去重又有顺序？这就是 LinkedHashMap 的本事
        Map <String,Integer> linkedHashMap = new LinkedHashMap<>();
        for (var v : items) {
            if(linkedHashMap.get(v) != null ) linkedHashMap.put(v,linkedHashMap.get(v)+1) ;
            else linkedHashMap.put(v,1);
        }

        System.out.println("LinkedHashMap：    " + linkedHashMap);

        // ===== 观察记录（跑通后把答案写进这四行注释，随代码一起 commit）=====
        // Q1：ArrayList 和 LinkedList 的打印结果（顺序）相同吗？
        //相同
        // Q2：HashSet 的顺序和插入顺序一样吗？多跑几次会变吗？
        //不同，备注说可能会变，但是我跑了四次都不变
        // Q3：6 个元素进 HashSet / LinkedHashMap 后剩几个？
        //4个因为去重了
        // Q4：想「去重但保持原顺序」，该用今天四种里的哪个？
        //LinkedHashMap

        System.out.println("----- 预期输出 -----");
        System.out.println("ArrayList：        [香蕉, 苹果, 牛奶, 苹果, 可乐, 香蕉]（原样保留，重复也在）");
        System.out.println("LinkedList：       [香蕉, 苹果, 牛奶, 苹果, 可乐, 香蕉]（和 ArrayList 一样）");
        System.out.println("HashSet：          [可乐, 牛奶, 苹果, 香蕉]（去重剩 4 个，顺序随机！每次可能不同）");
        System.out.println("HashSet.size() =   4");
        System.out.println("LinkedHashMap：    {香蕉=2, 苹果=2, 牛奶=1, 可乐=1}（去重 + 保持插入顺序）");
    }
}
