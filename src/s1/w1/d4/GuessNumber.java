package s1.w1.d4;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int answer = random.nextInt(100) + 1;    // 1~100 的随机数
        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        System.out.println("我想好了一个 1~100 的数，猜猜看：");

        while (true) {
            System.out.print("你的猜测：");
            String line = sc.nextLine();        // 先按字符串读！

            // TODO-1：try 把 line 转成 int；catch NumberFormatException 打印"请输入数字"并 continue
            int guess;
            try {
                guess = Integer.parseInt(line); //这个parseInt()老记不住，老用错
            }catch (NumberFormatException e){
                System.out.println("请输入数字");
                continue;
            }
            // TODO-2：猜的数字超出 1~100，提示"要在 1~100 之间"，continue
            if (guess < 1 || guess > 100){
                System.out.println("要在 1~100 之间");
                continue;
            }

            attempts++;
            // TODO-3：比 answer 大 → "大了"；小 → "小了"；相等 → 打印"猜对了！用了 N 次"并 break
            if(guess > answer){
                System.out.println("大了");
                continue;
            }else if(guess == answer){
                System.out.println("猜对了！用了 "+attempts+" 次");
                break;
            }else{
                System.out.println("小了");
                continue;
            }
        }
        sc.close();
    }
}
