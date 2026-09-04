package s1.w1.D3Regularpractice;

// ===== 下面这些类都给好了，只有 Cat / Cow 的叫声留给你 =====

class AnimalP4 {
    String name;
    public AnimalP4(String name) { this.name = name; }
    public void shout() { System.out.println("动物叫"); }
}

class DogP4 extends AnimalP4 {
    public DogP4(String name) { super(name); }
    @Override
    public void shout() { System.out.println(name + "：汪汪汪"); }
}

class CatP4 extends AnimalP4 {
    public CatP4(String name) { super(name); }
    @Override
    public void shout() {
        System.out.println(name + ":喵喵喵");
    }
}

class CowP4 extends AnimalP4 {
    public CowP4(String name) { super(name); }
    @Override
    public void shout() {
        System.out.println(name + ":哞哞哞");
    } //实例方法：跟着对象走。每个对象一份，必须要new一个对象
}

// ===== 从这开始是重点 =====

public class Practice4 {

    public static void main(String[] args) {
        // TODO-1：建一个能装 3 个动物的数组，三格分别放 Dog、Cat、Cow
        AnimalP4[] arr = new AnimalP4[3];     // 长度填几？
        arr[0] = new DogP4("dog");     // 放一只狗，名字随便起
        arr[1] = new CatP4("cat");         // 放一只猫
        arr[2] = new CowP4("cow");         // 放一头牛

        // TODO-2：用增强 for 遍历数组，对每个元素调用 shout()
        for (AnimalP4 a : arr) {
            a.shout();             // 就一行，调 shout()
        }

        System.out.println("--- 下面换成调用方法 ---");
        makeAllShout(arr);
    }

    // TODO-3：写一个静态方法，把上面那个循环搬进来
    // 提示：参数类型是 AnimalP4[]（父类类型！），方法体直接抄 TODO-2 的循环
    public static void makeAllShout(AnimalP4[] arr) { //参数放父类的原因是，我想让鱼群动物叫。所以传进来的参数必须包括所有动物
        for (AnimalP4 a : arr) {
            a.shout();             // 就一行，调 shout()
        }
    }//静态方法：跟着类走
}
