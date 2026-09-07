package s1.w1.d4.regularpractice;


public class Practice2 {
    public static void main(String[] args) {
        String s = "Java 2026 is Fun";

        int upper = 0, lower = 0, digit = 0;
        // TODO-1：把 s 拆成字符数组（toCharArray），增强 for 遍历，
        //        用 Character.isUpperCase / isLowerCase / isDigit 分别计数
        char[] c = s.toCharArray() ;
        for(var v : c){
            if(Character.isUpperCase(v)) upper++;
            if(Character.isLowerCase(v)) lower++;
            if(Character.isDigit(v)) digit++;
        }

        System.out.println("大写=" + upper + " 小写=" + lower + " 数字=" + digit);

        // TODO-2：统计空格出现的次数（用 charAt + 普通下标 for 循环写，练另一种遍历）
        int space = 0;
       for(int i = 0 ; i < s.length() ; i ++){
           if(s.charAt(i) == ' ') space++ ;
       }
        System.out.println("空格数=" + space);
    }
}
