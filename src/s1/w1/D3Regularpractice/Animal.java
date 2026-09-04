package s1.w1.D3Regularpractice;

public class Animal {
    String name;
    public Animal(String name) { this.name = name; }
    @Override
    public String toString() { return "Animal{name='" + name + "'}"; }
    //不重写toString的话就会输出s1.w1.D3Regularpractice.Animal@2f4d3709
    public void shout() { System.out.println("动物叫"); }
}

