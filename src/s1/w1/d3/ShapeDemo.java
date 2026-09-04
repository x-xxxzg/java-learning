package s1.w1.d3;

public class ShapeDemo {
    public static void main(String[] args) {
        // 父类数组装三种子类对象（向上转型 + 多态）
        Shape[] shapes = {
                new Circle(1),
                new Rectangle(3, 4),
                new Triangle(3, 4, 5)
        };

        String[] names = {"圆", "矩形", "三角形"};

        double total = 0;
        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("%s 面积 = %.2f%n", names[i], shapes[i].area());
            total += shapes[i].area();
        }
        System.out.printf("总面积 = %.2f%n", total);
    }
}
