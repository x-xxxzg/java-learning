package s1.w1.d4.regularpractice;

import java.util.Arrays;

public class Practice1 {
    public static void main(String[] args) {
        int[] scores = {72, 88, 45, 93, 61, 88, 77};

        // TODO-1：用 Arrays.sort 给 scores 排序（注意：会改原数组，下面 1-2 用的就是排好的）
        Arrays.sort(scores); //sort是从小到达排序
        // TODO-2：复制出"前 3 名"（排完序后最后 3 个才是最大的——用 copyOfRange 取）
        int[] top3 = Arrays.copyOfRange(scores,scores.length-3,scores.length);
        System.out.println("前3名：" + Arrays.toString(top3));

        // TODO-3：用增强 for 求总分和平均分
        int sum = 0;
        for(var v : scores){
            sum += v ;
        }
        System.out.println("总分=" + sum + "，平均分=" + sum / (double) scores.length);

        // TODO-4：统计有几个 88 分（用循环数，别用眼睛数）
        int count = 0;
        for(var v : scores){
            if(v == 88) count ++ ;
        }
        System.out.println("88分的人数：" + count);
    }
}
