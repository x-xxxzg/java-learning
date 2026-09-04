package s1.w1.d3;

public class Cat extends Animal {
    public Cat(String name){
        super(name);
    }

    @Override
    void shout() {
        System.out.println(name+":喵喵喵");
    }
}
