package s1.w1.d3;

public class Dog extends Animal implements Pet{
    public Dog(String name){
        super(name);
    }

    @Override
    void shout() {
        System.out.println(name+":汪汪汪");
    }

    @Override
    public void play() {
        System.out.println(name+":在玩飞盘");
    }

}
