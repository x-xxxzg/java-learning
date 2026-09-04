package s1.w1.d3;

public class Cow extends Animal{
    public Cow(String name){
        super(name);
    }

    @Override
    void shout() {
        System.out.println(name+":哞哞哞");
    }
}
