package s1.w1.d4.regularpractice;

import java.util.Scanner;

public class Practice4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 目标：反复要求输入年龄，直到输入的是 0~150 之间的合法数字才结束
        while (true) {
            System.out.print("请输入年龄：");
            String line = sc.nextLine();     // 先当字符串读进来
            int age = -1 ;

            // TODO-1：try 里把 line 转成 int（会炸的代码放 try 里）
            try{
                age = Integer.parseInt(line) ;
            }

            // TODO-2：catch NumberFormatException，打印"不是数字，重新输入"，然后 continue 回去重来
            catch (NumberFormatException e){
                System.out.println("不是数字，重新输入");
                continue;
            }

            // TODO-3：转成功后判断范围 0~150，合法就打印"年龄已记录：xx"并 break；
            //         不合法打印"范围不对"（不 break，继续循环）
            if(age >= 0 && age <= 150 ){
                System.out.println("年龄已记录："+age);
                break;
            }
            else{
                System.out.println("范围不对");
                continue;
            }
        }
        System.out.println("程序结束");
    }
}
