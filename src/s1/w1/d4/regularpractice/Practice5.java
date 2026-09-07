package s1.w1.d4.regularpractice;

public class Practice5 {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt("x");   // NumberFormatException
            int[] a = new int[3];
            a[9] = 1;                        // ArrayIndexOutOfBoundsException
        } catch (NumberFormatException e) {  // 再写子类
            System.out.println("数字格式错");
        } catch (Exception e) {              // 先写父类（大网）
            System.out.println("网住了");
        }
        //多个 catch 时，子类必须写在父类前面
    }
}
