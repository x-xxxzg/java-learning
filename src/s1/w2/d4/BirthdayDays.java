package s1.w2.d4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * 练习（commit 项）：生日计算器——LocalDate 实战
 *
 * 功能：输入出生日期，输出 ①活了多少天 ②距离下一个生日多少天。
 *
 * ⤵ 依赖说明：用到 Practice3（regularpractice 包）里的 LocalDate 用法，
 *   先把 Practice3 做完再来写这个。
 */
public class BirthdayDays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入你的生日（格式 2004-05-20）: ");
        LocalDate birthday = LocalDate.parse(sc.nextLine()); // ISO 格式字符串直接解析
        LocalDate today = LocalDate.now();

        // TODO 1: 活了多少天 —— ChronoUnit.DAYS.between(birthday, today)
        //   打印：你已经活了 XXXX 天
        System.out.println("你已经活了"+ChronoUnit.DAYS.between(birthday,today)+"天");
        // TODO 2: 先算「今年的生日」—— birthday.withYear(today.getYear())
        //   存到变量 nextBirthday
        LocalDate nextBirthday = birthday.withYear(today.getYear()); //修改year用with，添加用plus
        // TODO 3: 如果今年的生日已经过了（用 isBefore 或 isAfter 判断），
        //   下一个生日就改成明年的：nextBirthday = nextBirthday.plusYears(1)
        if(today.isAfter(nextBirthday)) nextBirthday = nextBirthday.plusYears(1) ;
        // TODO 4: 打印距离下一个生日多少天 + 那天是星期几（getDayOfWeek）
        System.out.println(ChronoUnit.DAYS.between(today,nextBirthday));
        System.out.println(nextBirthday.getDayOfWeek());

        sc.close();
    }
}

/*
 * ============ 预期输出示例 ============
 * 输入你的生日（格式 2004-05-20）: 2004-05-20
 * 你已经活了 8151 天
 * 距离下一个生日还有 249 天（2027-05-20，THURSDAY）
 * ============================================================
 */
