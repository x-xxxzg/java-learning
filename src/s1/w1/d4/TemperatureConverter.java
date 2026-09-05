package s1.w1.d4;

import java.util.Scanner;

public class TemperatureConverter {

    // 重载一：只传一个数，默认当摄氏度，转华氏
    public static double convert(double celsius) {
        // TODO-1：返回 celsius * 9 / 5.0 + 32
        return celsius * 9 / 5.0 + 32;
    }

    // 重载二：传数值 + 单位字符，按单位决定转换方向
    //        'C' 表示传入的是摄氏（转华氏输出），'F' 表示传入的是华氏（转摄氏输出）
    public static double convert(double value, char unit) {
        // TODO-2：unit 为 'C' 就复用上面那个重载；
        //         为 'F' 就返回 (value - 32) * 5 / 9.0
        //         其他字符 → throw new IllegalArgumentException("单位必须是 C 或 F")
        if(unit == 'C'){
            return convert(value);
        }else if(unit == 'F'){
            return (value - 32) * 5/9.0 ;
        }else{
            throw new IllegalArgumentException("单位必须是 C 或 F");
        }
    }

    public static void main(String[] args) {
        System.out.println(convert(100));              // 212.0
        System.out.println(convert(212, 'F'));         // 100.0
        System.out.println(convert(0));                 // 32.0

        // TODO-3：try-catch 调用 convert(50, 'X')，接住异常打印 getMessage()
        try{
            System.out.println(convert(50,'X'));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
