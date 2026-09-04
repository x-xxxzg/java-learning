package s1.w1.d3;

public class EmployeeDemo {
    public static void main(String[] args) {
        // 接口类型数组装两种员工（接口也能多态！）
        Payable[] staff = {
                new FullTimeEmployee("张三", 8000),
                new PartTimeEmployee("李四", 25, 80),
                new PartTimeEmployee("王五", 30, 60)
        };

        double total = 0;
        for (Payable p : staff) {
            System.out.println("发工资...");
            total += p.getPay();
        }
        System.out.printf("本月总薪资支出 = %.1f 元%n", total);
    }
}
