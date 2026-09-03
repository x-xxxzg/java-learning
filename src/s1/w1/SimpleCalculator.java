package s1.w1;

import java.util.Scanner;

public class SimpleCalculator {

    static int add(int a,int b) {return a+b;}
    static int sub(int a,int b) {return a-b;}
    static int mul(int a,int b) {return a*b;}
    static int div(int a,int b) {return a/b;}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine().trim();   // 读整行并.trim()去掉首尾空格
        int idx = -1 ;
        char op = ' ' ;
        for(int i = 0 ; i < expr.length() ; i ++ ){
            char c = expr.charAt(i) ;
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                op = c ;
                idx = i ;
                break ;
            }
        }

        if(idx == -1){
            System.out.println("运算符不规范");
            return;
        }

        int a = Integer.parseInt(expr.substring(0,idx).trim()) ; //.trim()去掉字符串首位空格
        int b = Integer.parseInt(expr.substring(idx+1).trim()) ;

        if(op =='/' && b == 0) {
            System.out.println("除数不能为0");
            return ;
        }
        int ans = switch (op){
            case '+' -> add(a,b) ;
            case '-' -> sub(a,b) ;
            case '*' -> mul(a,b) ;
            case '/' -> div(a,b) ;
            default -> 0 ;
        }; //这里要有‘；’
        System.out.println(ans);
    }
}
