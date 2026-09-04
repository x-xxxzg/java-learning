package s1.w1.d3;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal[] zoo = {
                new Dog("旺财"),
                new Cat("咪咪"),
                new Cow("牛大")
        };

        // 多态：一行管所有叫声
        for (Animal a : zoo) {
            a.shout();
        }

        // 只有宠物会玩：instanceof 判断能力，再向下转型调 play()
        for (Animal a : zoo) {
            if (a instanceof Pet) {
                Pet p = (Pet) a;      // 注意：这里转成了接口类型！
                p.play();
            }
        }
    }
}
