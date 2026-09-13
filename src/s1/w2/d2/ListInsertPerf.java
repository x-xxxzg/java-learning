package s1.w2.d2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 练习 #11：ArrayList vs LinkedList 头部插入 10 万次耗时对比实验（跑通后 commit）
 *
 * 考点：底层结构（数组 vs 双向链表）如何决定同一个操作的快慢
 * —— ArrayList（数组列表）头插：后面所有元素集体后挪一位，O(n)
 * —— LinkedList（链表）头插：只改 first 和新节点两个引用，O(1)
 *
 * 计时三步曲（今天的核心技能，必须自己写）：
 *   long start = System.currentTimeMillis();   // 开跑前看表
 *   ...干活...
 *   long cost = System.currentTimeMillis() - start;   // 干完再看表，相减 = 毫秒
 */
public class ListInsertPerf {

    /** 实验次数：10 万。数字里的下划线 100_000 只是分隔符，方便数零，值就是 100000 */
    static final int N = 100_000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // ---------- 第一回合：头部插入（头插写法 list.add(0, i)，0 = 插到下标 0 的位置） ----------

        // TODO 1: 给 arrayList 计时：头插 N 个整数，打印耗时
        //   模板（计时三步曲，照抄后自己填干活部分）：
        //   long start = System.currentTimeMillis();
        //   for (int i = 0; i < N; i++) {
        //       arrayList.add(0, i);      // 头插
        //   }
        //   long cost = System.currentTimeMillis() - start;
        //   System.out.println("ArrayList  头插 " + N + " 次耗时: " + cost + " ms");

        long start1 = System.currentTimeMillis();
        for(int i = 0 ; i <= N ; i ++ ) arrayList.addFirst(i);
        long cost1 = System.currentTimeMillis() - start1 ;
        System.out.println(cost1);

        // TODO 2: 同样给 linkedList 计时头插 N 次，打印耗时
        long start2 = System.currentTimeMillis();
        for(int i = 0 ; i <= N ; i ++ ) linkedList.addFirst(i);
        long cost2 = System.currentTimeMillis() - start2 ;
        System.out.println(cost2);
        // ---------- 第二回合：尾部插入（普通 add(i) 就是尾插） ----------

        // TODO 3: 先在注释里写下你的预测（谁快？大概差几倍？），然后：
        //   arrayList.clear(); linkedList.clear();
        //   两边各尾插 N 次，分别计时打印
        //数值多的时候应该是linkedList快，因为arraylist要扩内存，每次扩内存都要复制
        start1 = System.currentTimeMillis();
        for(int i = 0 ; i <= N ; i ++ ) arrayList.add(i);
        cost1 = System.currentTimeMillis() - start1 ;
        System.out.println(cost1);

        start2 = System.currentTimeMillis();
        for(int i = 0 ; i <= N ; i ++ ) linkedList.add(i);
        cost2 = System.currentTimeMillis() - start2 ;
        System.out.println(cost2);
        // ---------- 收尾（笔头，答案写成注释再 commit） ----------
        // Q1: ArrayList 头插慢——每次插入时，它内部数组里的旧元素发生了什么？
        //全部元素往后移动
        //     10 万次头插，平均每次要挪多少个元素？
        //(1+100000)*500000
        // Q2: LinkedList 头插快——它一共只改了哪几个「引用」？
        //只改了头指针的引用，插入数的前一个数与后一个数的引用，第一个数的前一个数的引用
        // Q3: 尾插的结果和你预测一致吗？为什么 ArrayList 尾插也很快
        //     （提示：尾巴后面是空的，不用挪任何元素，顶多碰上扩容搬家）？
        //不一致。可能是还不需要扩容太多次吧。
    }
}
