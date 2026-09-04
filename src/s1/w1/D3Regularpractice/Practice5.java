package s1.w1.D3Regularpractice;

class AnimalP5 {
    String name;
    public AnimalP5(String name) { this.name = name; }
    public void shout() { System.out.println("动物叫"); }
}

class DuckP5 extends AnimalP5 {
    public DuckP5(String name) { super(name); }
    @Override
    public void shout() { System.out.println(name + "：嘎嘎嘎"); }
    public void swim() { System.out.println(name + " 在游泳"); }   // 鸭子独有
}

class CowP5 extends AnimalP5 {
    public CowP5(String name) { super(name); }
    @Override
    public void shout() { System.out.println(name + "：哞哞哞"); }
}

public class Practice5 {
    public static void main(String[] args) {
        // 数组里混着鸭和牛（父类数组装子类对象 = 向上转型）
        AnimalP5[] zoo = {
                new DuckP5("唐老鸭"),
                new CowP5("牛夫人")
        };

        // 遍历：都叫一声；是鸭子的额外游一次泳
        for (AnimalP5 a : zoo) {
            // TODO-1：让当前动物叫一声（一行）
            a.shout();

            // TODO-2：判断 a 实际是不是鸭子（用 instanceof）
            if (a instanceof DuckP5) {
                // TODO-3：把 a 向下转型成 DuckP5，存进新变量 d，然后调 d.swim()
                DuckP5 d = (DuckP5) a;
                d.swim();
            }
        }
    }
}