package s1.w1.d4.regularpractice;

public class CrashDemo {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(a[5]);   // 只有 3 个格子，要第 6 个 → 必炸
        System.out.println("这行不会被打印");  // 炸了之后后面的代码不执行
    }
}
//抛出异常Exception
//异常类型java.lang.ArrayIndexOutOfBoundsException 越界
//哪里越界Index 5 out of bounds for length 3
//代码错误的地方CrashDemo.java:6 第六行