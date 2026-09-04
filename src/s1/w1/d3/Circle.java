package s1.w1.d3;

public class Circle extends Shape {
    double radius;

    public Circle(double radius){
        this.radius = radius ;
    }

    @Override
    double area() {
        return Math.PI*radius*radius;
    }//重写抽象类


}
