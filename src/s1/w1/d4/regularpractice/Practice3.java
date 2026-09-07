package s1.w1.d4.regularpractice;


public class Practice3 {
    public static void main(String[] args) {
        String sentence = "hello java world";

        // 目标：输出 "world java hello"（单词顺序反转，单词内部不变）

        // TODO-1：用 split(" ") 把句子拆成单词数组
        String[] words = sentence.split(" ");

        // TODO-2：new 一个 StringBuilder，倒着遍历 words（从最后一个下标到 0），
        //        每个单词 append 进去，单词之间 append 一个空格
        StringBuilder sb = new StringBuilder();
        for(int i = words.length-1 ; i >= 0 ; i --){
            sb.append(words[i]).append(' ');
        }

        // TODO-3：如果结果开头或结尾有多余空格，用 trim() 处理后输出
        String result = sb.toString() ;
        System.out.println(result.trim());
    }
}
