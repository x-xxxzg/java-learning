package s1.w1;
import java.util.ArrayList;
import java.util.Scanner;


public class ScoreStat {

    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        int sum = 0 , maxx = 0 , cnt = 0 , exl = 0 , hg = 0 , bhg = 0;
        while(score != -1){
            list.add(score) ;
            score = sc.nextInt();
        }
        for(int v : list){
            if(v >= 90 ) exl ++ ;
            else if(v >= 60) hg ++ ;
            else bhg ++ ;
            if( v > maxx) maxx = v ;
            sum += v ;
        }
        double esocre = (double) sum/list.size();
        System.out.println("平均分："+esocre);
        System.out.println("最高分："+maxx);
        System.out.println("优秀："+exl);
        System.out.println("合格："+hg);
        System.out.println("不合格："+bhg);
    }
}
