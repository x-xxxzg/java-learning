package s1.w1.d3;

public class FullTimeEmployee implements Payable{
    String name;
    double monthlySalary;

    public FullTimeEmployee(String name,double monthlySalary){
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double getPay() {
        return monthlySalary;
    }
}
