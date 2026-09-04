package s1.w1.d3;

public class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width,double height){
        this.width = width;
        this.height =height;
    }

    @Override
    double area() {
        return width*height;
    }
}
