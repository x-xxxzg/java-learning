package s1.w1.d4.regularpractice;

public class Practice6 {
    public static void main(String[] args) {
        System.out.println(avg(70, 80, 90));    // 80.0
        // TODO-1：再补两个调用试试：avg()（不传参数）和 avg(100)
        //         avg() 会抛异常——用 try-catch 接住打印它的 getMessage()
        try{
            System.out.println(avg());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(avg(100));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    // TODO-2：写方法 static double avg(double... nums)
    //         长度为 0 就 throw new IllegalArgumentException("至少传一个数")
    //         否则返回平均分（总和 / nums.length）
    static double avg(double...nums){
        if(nums.length == 0){
            throw new IllegalArgumentException("至少传一个数");
        }else{
            double sum = 0 ;
            for(var v : nums) sum += v ;
            return sum / nums.length ;
        }
    }
}
